package com.example.semana14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private String userText;
    private Button ingresar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        ingresar = findViewById(R.id.IngresarBtn);



        ingresar.setOnClickListener((v) ->{
            userText = username.getText().toString();
            if(userText.equals("")){
                Toast.makeText(this,"por favor ponga un nombre de usuario",Toast.LENGTH_SHORT).show();
            } else{

                SharedPreferences p = getSharedPreferences("preferencias",MODE_PRIVATE);
                p.edit().putString("nombre",userText).apply();

                Log.e("object",userText);

                Intent i = new Intent(this, TareasActivity.class);
                startActivity(i);


            }



        } );

    }
}