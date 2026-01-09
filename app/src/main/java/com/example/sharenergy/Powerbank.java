package com.example.sharenergy;

public class Powerbank {
    public String id;
    public boolean disponible = true;
    public long tiempoRecargaFin = 0;
    public Powerbank(String id) {
        this.id = id;
    }
    //Distintos tipos de estados de una powerbank.
    public boolean estaDisponible() {
        if (!disponible && tiempoRecargaFin > 0 &&
                System.currentTimeMillis() > tiempoRecargaFin) {
            disponible = true;
            tiempoRecargaFin = 0;
        }
        return disponible;
    }
    public boolean estaRecargando() {
        return !disponible && tiempoRecargaFin > System.currentTimeMillis();
    }
    public boolean estaEnUso() {
        return !disponible && tiempoRecargaFin == 0;
    }
}
