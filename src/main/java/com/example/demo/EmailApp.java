package com.example.demo;

public class EmailApp {
    public static class Main {
        public static void main(String[] args) {
            Email email = new Email("Mariam","Mohamed");
            email.setAlternateEmail("MariamAboBakr@gmail.com");
            System.out.println(email.showInfo());
        }
    }
}
