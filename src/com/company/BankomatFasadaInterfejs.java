package com.company;

public interface BankomatFasadaInterfejs {
     boolean autoryzacja(long nrKarty, int pin);

     float sprawdzStanKonta(long nrKarty);

}
