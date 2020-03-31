package com.company;

public class BankLogin {

    public boolean autoryzacja(long nrKarty, int pin) {
        if (nrKarty == 123456789 && pin == 1234) {
            return true;
        } else {
            return false;
        }
    }
}

