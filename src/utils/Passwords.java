package utils;

public class Passwords {
    private String plaintext;
    private String cipher;
    private int key;
    public void setPlaintext(String text){
        this.plaintext = text;
    }
    public void setKey(int key){
        this.key = key;
    }
    public String getPlaintext(){
        return plaintext;
    }
    public int getKey(){
        return key;
    }
    public String encrypt() { //Ceaser cipher
    StringBuilder cipherBuilder = new StringBuilder();
    for (char c : plaintext.toLowerCase().toCharArray()) {
        if (Character.isLetter(c)) {
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            cipherBuilder.append((char) ((c - base + key) % 26 + base));
        } else {
            cipherBuilder.append(c);
        }
    }
    cipher = cipherBuilder.toString();
    return cipher;
}
}
