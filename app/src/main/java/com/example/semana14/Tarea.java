package com.example.semana14;

public class Tarea {
    private String tarea, hora, descrip;
    private boolean estado;

    public Tarea() {
    }

    public Tarea(String tarea, String hora, String descrip, boolean estado) {
        this.tarea = tarea;
        this.hora = hora;
        this.descrip = descrip;
        this.estado = estado;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
