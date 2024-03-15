package main;
import java.util.Random;
public class Feistel{
    private static String keyInit(int length){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder str = new StringBuilder(length);
        for(int i = 0;i<length;i++){
            int randomIndex = random.nextInt(chars.length());
            str.append(chars.charAt(randomIndex));
        }
        return str.toString();
    }
    private static String xorStrings(String a, String b){
        StringBuilder str = new StringBuilder();
        for(int i =0;i<a.length();i++){
            str.append((char) (a.charAt(i)^(b.charAt(i))));
        }
        return str.toString();
    }

}