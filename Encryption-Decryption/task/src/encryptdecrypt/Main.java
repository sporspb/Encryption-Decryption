package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        String mode = getMode(args);
        String fileName = getNameOutputFile(args);
        String alg = getAlg(args);
        char[] text = getData(args).toCharArray();
        int key = getKey(args);
        Cipher cipher = new Cipher();

        if (alg.equals("unicode")) {
            cipher.setCipher(new UnicodeCipher());
        } else if (alg.equals("shift")) {
            cipher.setCipher(new CesarCipher());
        } else {
            outputResult("Wrong algorithm", fileName);
        }

        if (mode.equals("enc")) {
            outputResult(cipher.doEnc(text, key), fileName);
        } else if (mode.equals("dec")) {
            outputResult(cipher.doDec(text, key), fileName);
        } else {
            outputResult("Wrong mode", fileName);
        }
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

    static String getAlg(String[] array) {
        int pos = getPos(array, "-alg");
        if (pos >= 0) {
            return array[pos + 1];
        } else return "shift";
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

    public static void outputResult(String text, String fileName) throws IOException {
        if (fileName.isEmpty()) {
            System.out.println(text);
        } else writeToFile(text, fileName);
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
