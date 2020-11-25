package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String mode = getMode(args);
        String fileName = getNameOutputFile(args);
        char[] text = getData(args).toCharArray();
        int key = getKey(args);
        int startPos = 32;
        int endPos = 126;

        if (mode.equals("enc")) {
            try {
                outputResult(doEncrypt(text, key, startPos, endPos), fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (mode.equals("dec")) {
            try {
                outputResult(doDecrypt(text, key, startPos, endPos), fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                outputResult("wrong mode", fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void outputResult(String text, String fileName) throws IOException {
        if (fileName.isEmpty()) {
            System.out.println(text);
        } else writeToFile(text, fileName);
    }


    static String doEncrypt(char[] message, int key, int startPos, int endPos) {
        for (int i = 0; i < message.length; i++) {
            char letter = message[i];
            if (letter >= startPos && letter <= endPos) {
                int pos = (letter + key - startPos) % (endPos - startPos + 1);
                message[i] = (char) (startPos + pos);
            }
        }
        return new String(message);
    }

    static String doDecrypt(char[] message, int key, int startPos, int endPos) {
        for (int i = 0; i < message.length; i++) {
            char letter = message[i];
            if (letter - key < startPos) {
                int pos = endPos - (letter - startPos - key);
                message[i] = (char) (startPos + pos);
            } else {
                int pos = (letter - key);
                message[i] = (char) pos;
            }
        }
        return new String(message);
    }

    static int getPos(String[] array, String s) {
        return Arrays.asList(array).indexOf(s);
    }

    static String getMode(String[] array) {
        int pos = getPos(array, "-mode");
        if (pos >= 0) {
            return array[pos + 1];
        } else return "enc";
    }

    static String getData(String[] array) {
        int pos = getPos(array, "-data");
        if (pos >= 0) {
            return array[pos + 1];
        } else {
            pos = getPos(array, "-in");
            if (pos >= 0) {
                String path = array[pos + 1];
                try {
                    return readFileAsString(path);
                } catch (IOException e) {
                    System.out.println("Cannot read file: " + e.getMessage());
                }
            }
        }
        return "";
    }

    static int getKey(String[] array) {
        int pos = getPos(array, "-key");
        if (pos >= 0) {
            return Integer.parseInt(array[pos + 1]);
        } else return 0;
    }

    static String getNameOutputFile(String[] array) {
        int pos = getPos(array, "-out");
        if (pos >= 0) {
            return array[pos + 1];
        } else return "";
    }

    static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    static void writeToFile(String text, String fileName) throws IOException {
        File file = new File(fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(text);
        }
    }
}
