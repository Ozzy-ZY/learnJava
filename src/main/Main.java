package main;

import java.util.Scanner;
public class Main {
    public static void  main(String[] args){
        Vigenere.setKey("rock");
        PlayfairCipher.setKey("roll");
        System.out.println(Vigenere.encrypt("I've been through the desert on a horse with no name "));
        System.out.println(PlayfairCipher.encrypt("In the desert, you can't remember your name"));
        System.out.println(Vigenere.decrypt(Vigenere.encrypt("Cause there ain't no one for to give you no pain")));
        System.out.println(Feistel.encrypt("let's go get some shit done",16));
    }
}