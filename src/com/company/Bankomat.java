package com.company;

import java.util.Scanner;

public class Bankomat {
    private BankomatFasada bankomatFasada = new BankomatFasada();
    private static Bankomat bankomat = new Bankomat();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        bankomat.startBankomat();
    }

    private void podajPin() {
        System.out.println("================");
        System.out.println("====BANKOMAT====");
        System.out.println("====PODAJ PIN===");
        System.out.println("================");
    }

    private void podajNrKarty() {
        System.out.println("================");
        System.out.println("====BANKOMAT====");
        System.out.println("=PODAJ NR KARTY=");
        System.out.println("================");
    }

    private void startBankomat() {
        int pin = 0;
        long nrKarty = 0;
        boolean autoryzacja = false;
        podajNrKarty();
        nrKarty = scanner.nextLong();

        podajPin();
        pin = scanner.nextInt();
        System.out.println("Autoryzacja...\n");

        autoryzacja = bankomatFasada.autoryzacja(nrKarty, pin);
        if (autoryzacja) {
            System.out.println("Autoryzacja powiodla sie");
            menu(nrKarty);
        } else {
            System.out.println("Autoryzacja nie powiodla sie");
            exitBankomat();
        }

    }

    private void exitBankomat() {
        System.exit(0);
    }

    private void menu(long nrKarty) {
        System.out.println("Co chcesz zrobić?");
        System.out.println("1. Sprawdz stan konta");
        System.out.println("2. Exit");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println(bankomatFasada.sprawdzStanKonta(nrKarty));
            bankomat.menu(nrKarty);
        } else if (choice == 2) {
            exitBankomat();
        } else {
            System.out.println("podales liczba spoza zakresu");
            menu(nrKarty);
        }

    }
}
