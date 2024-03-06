package main;

public class PlayfairCipher {
    private static char[][] keySquare; //O Z
                                      //Z Y
    public static void setKey(String key) {
        keySquare = generateKeySquare(key);
    }
    /**
     * returns a matrix of the key and the rest of the alphabet
     */
    private static char[][] generateKeySquare(String key) {
        char[][] keySquare = new char[5][5];
        String keyString = key + "abcdefghiklmnopqrstuvwxyz";

        for (int i = 0, k = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boolean letterFound = false;
                while (!letterFound) {
                    char letter = keyString.charAt(k++);
                    if (keySquareContains(keySquare, letter)) {
                        continue;
                    }
                    keySquare[i][j] = letter;
                    letterFound = true;
                }
            }
        }
        return keySquare;
    }
    private static boolean keySquareContains(char[][] keySquare, char letter) {
        if (letter == 'j') letter = 'i';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keySquare[i][j] == letter) {
                    return true;
                }
            }
        }
        return false;
    }
    public static String encrypt(String text) {

        if (text.length() % 2 != 0) {
            text += 'X';
        }

        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            char firstChar = text.charAt(i);
            char secondChar = text.charAt(i + 1);

            int[] firstCharPos = getPosition(keySquare, firstChar);
            int[] secondCharPos = getPosition(keySquare, secondChar);

            if (firstCharPos[0] == secondCharPos[0]) {
                cipherText.append(keySquare[firstCharPos[0]][(firstCharPos[1] + 1) % 5]); //check for
                cipherText.append(keySquare[secondCharPos[0]][(secondCharPos[1] + 1) % 5]);//the rows
            } else if (firstCharPos[1] == secondCharPos[1]) {
                cipherText.append(keySquare[(firstCharPos[0] + 1) % 5][firstCharPos[1]]); //check for
                cipherText.append(keySquare[(secondCharPos[0] + 1) % 5][secondCharPos[1]]);// the columns
            } else {
                cipherText.append(keySquare[firstCharPos[0]][secondCharPos[1]]);
                cipherText.append(keySquare[secondCharPos[0]][firstCharPos[1]]);
            }
        }
        return cipherText.toString();
    }

    private static int[] getPosition(char[][] keySquare, char letter) {
        int[] pos = new int[2];
        if (letter == 'j') letter = 'i';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keySquare[i][j] == letter) {
                    pos[0] = i;
                    pos[1] = j;
                    break;
                }
            }
        }
        return pos;
    }
}
