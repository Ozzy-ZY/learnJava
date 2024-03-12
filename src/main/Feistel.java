package main;
public class Feistel {
    private static String block;

    public static void setBlock(String block) {
        Feistel.block = block;
    }

    public static String getBlock() {
        return block;
    }

    private static String VigThenXor(String left, String right, String key) {
        String newLeft = right;
        String newRight = Vigenere.encrypt(right);
        char[] newRightChars = new char[left.length()];
        for (int i = 0;i<left.length();i++){
            newRightChars[i]= (char) (left.charAt(i)^ newRight.charAt(i));
        }
        newRight = new String(newRightChars);
        StringBuilder newBlock = new StringBuilder();
        newBlock.append(newLeft);
        newBlock.append(newRight);
        return newBlock.toString();
    }
    private static String FlipString(String finalBlock){
        StringBuilder newBlock = new StringBuilder();
        newBlock.append(finalBlock.substring(finalBlock.length()/2));
        newBlock.append(finalBlock.substring(0,finalBlock.length()/2));
        return newBlock.toString();
    }

    public static String encrypt(String text, int numOfRounds, String key) {
        String left = block.substring(0, block.length() / 2);
        String right = block.substring(block.length() / 2);
        return key;
    }
}
