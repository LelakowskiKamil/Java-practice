package com.company;

public class BankomatFasada implements BankomatFasadaInterfejs {
    private BankSystem bankSystem;
    private BankLogin bankLogin;

    public BankomatFasada() {
        bankLogin = new BankLogin();
        bankSystem = new BankSystem();
    }


    @Override
    public boolean autoryzacja(long nrKarty, int pin) {
        boolean correct = false;
        correct = bankLogin.autoryzacja(nrKarty, pin);

        return correct;
    }

    @Override
    public float sprawdzStanKonta(long nrKarty) {
        float stanKonta = 0.0f;
        stanKonta = bankSystem.sprawdzStanKonta(nrKarty);
        return stanKonta;
    }
}

