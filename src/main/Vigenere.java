package main;

public class Vigenere{
    private static String key; //ozzy
    public static void setKey(String k){
        key = k;
    }
    private static StringBuilder generateUpdatedKey(int keyLength){
        StringBuilder updatedKey = new StringBuilder();
        updatedKey.append(key);
        int i = 0;
        if(updatedKey.length()>= keyLength){
            return updatedKey;
        }
        while(updatedKey.length()!=keyLength){
            if(i>= key.length()){
                i = 0;
            }
            updatedKey.append(key.charAt(i));
            i++;
        }
        return updatedKey;
    }
    public static String encrypt(String text){
        StringBuilder updatedKey = generateUpdatedKey(text.length());
        StringBuilder cipherText = new StringBuilder();
        String strUpdatedKey = updatedKey.toString().toLowerCase();
        text = text.toLowerCase();
        if(text.contains(" ")){
            text.replace(' ','a');
        }
        for(int j =0;j<text.length();j++){
            int keyNum = strUpdatedKey.toCharArray()[j] - 'a';
            cipherText.append((char)(((text.toCharArray()[j] -'a') + keyNum) % 26 +'a'));
        }
        return cipherText.toString();
    }
    public static String decrypt(String text){
        StringBuilder updatedKey = new StringBuilder();
        StringBuilder plainText = new StringBuilder();
        updatedKey.append(key);
        int i = 0;
        while(updatedKey.length()!=text.length()){
            if(i>= key.length()){
                i = 0;
            }
            updatedKey.append(key.toCharArray()[i]);
            i++;
        }
        String strUpdatedKey = updatedKey.toString().toLowerCase();
        text = text.toLowerCase();
        for(int j =0;j<text.length();j++){
            int keyNum = strUpdatedKey.toCharArray()[j] - 'a';
            plainText.append((char)((text.toCharArray()[j] -'a' - keyNum + 26) % 26 +'a'));
        }
        return plainText.toString();
    }
}
