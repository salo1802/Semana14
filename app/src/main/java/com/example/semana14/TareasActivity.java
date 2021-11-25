package com.example.semana14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TareasActivity extends AppCompatActivity {
    private EditText nombreT, descrip;
    private Button add;
    private String time,user;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);
        nombreT = findViewById(R.id.nombreTarea);
        descrip = findViewById(R.id.descripcion);
        add = findViewById(R.id.agregarBtn);
        db = FirebaseDatabase.getInstance();


        SharedPreferences p = getSharedPreferences("preferencias",MODE_PRIVATE);
       user = p.getString("nombre", "noName");
        new Thread(()->{
           while (true){
               Calendar hora = Calendar.getInstance();
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm aaa");
               time = sdf.format(hora.getTime());
           }
        }).start();

        add.setOnClickListener((v)->{
            //Toast.makeText(this,time,Toast.LENGTH_SHORT).show();
            String tareaName = nombreT.getText().toString();
            if(nombreT.getText().toString().equals("")||descrip.getText().toString().equals("")){
               Toast.makeText(this, "por favor rellene todos los campos",Toast.LENGTH_SHORT).show();;

            }else{
                user = p.getString("nombre", "noName");
                DatabaseReference reference = db.getReference().child("Users").child(user).child("Tareas").child(tareaName);
                Tarea tarea = new Tarea(tareaName,time,descrip.getText().toString(),false);
                reference.setValue(tarea);
            }
        });
    }
}