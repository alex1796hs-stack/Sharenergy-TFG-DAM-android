package com.example.sharenergy;
   //Gestion de las dos powerbanks en propiedad
public class PowerbankManager {
    private static PowerbankManager instance;
    public Powerbank pb1 = new Powerbank("PB-001");
    public Powerbank pb2 = new Powerbank("PB-002");
    private PowerbankManager() {}
    public static PowerbankManager getInstance() {
        if (instance == null) {
            instance = new PowerbankManager();
        }
        return instance;
    }
}
