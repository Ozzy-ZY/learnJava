package main;
import java.util.Random;
public class Feistel{
    /**
     * @param length the length of the generated key
     * @return a random String "key"
     */
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

    /**
     * simply read the name
     * @param a the block
     * @param b the key
     * @return the new encrypted string
     */
    private static String xorStrings(String a, String b){
        StringBuilder str = new StringBuilder();
        for(int i =0;i<a.length();i++){
            str.append((char) (a.charAt(i)^(b.charAt(i))));
        }
        return str.toString();
    }

    /**
     *this is the f function in the Feistel algorithm
     *takes one half of the block to encrypt it using simple xor then return it
     * @param block
     * @return the Xored half of the Feistel's block
     */
    public static String func(String block){
        String key = keyInit(block.length());
        return xorStrings(block,key); //the result of Xoring with the key
    }

    /**
     * @param block look up Feistel networks
     * @param numOfRounds
     * @return the encrypted block
     */
    public static String encrypt(String block, int numOfRounds){
        String left = block.substring(0,block.length()/2);
        String right =  block.substring(block.length()/2);
        for(int i= 0;i<numOfRounds;i++){
            String temp = right;
            right = xorStrings(left,func(right));
            left = temp;
        }
        return right+left;
    }

}