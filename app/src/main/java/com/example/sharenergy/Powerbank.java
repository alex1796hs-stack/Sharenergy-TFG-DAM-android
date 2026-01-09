package com.example.sharenergy;

public class Powerbank {

    public String id;
    private boolean enUso = false;
    private long tiempoRecargaFin = 0;

    public Powerbank(String id) {
        this.id = id;
    }

    // En uso
    public boolean estaEnUso() {
        return enUso;
    }

    // En recarga
    public boolean estaRecargando() {
        return !enUso && tiempoRecargaFin > System.currentTimeMillis();
    }

    // alquilar disponible
    public boolean estaDisponible() {
        return !enUso && tiempoRecargaFin <= System.currentTimeMillis();
    }

    // Inicio del alquiler
    public void iniciarUso() {
        enUso = true;
        tiempoRecargaFin = 0;
    }

    // Fin del alquiler inicia recarga simulada
    public void finalizarUso() {
        enUso = false;
        tiempoRecargaFin = System.currentTimeMillis() + 30_000;
    }
}
