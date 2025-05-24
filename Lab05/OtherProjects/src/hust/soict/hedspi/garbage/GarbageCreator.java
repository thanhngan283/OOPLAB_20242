package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "C:/Users/Lenovo/Dev/OOP_lab/OtherProjects/src/hust/soict/globalict/garbage/test.exe";
        byte[] inputBytes = { 0 };
        long start, end;
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String outputString = "";
        start = System.currentTimeMillis();
        for (var b : inputBytes) {
            outputString += (char) b;
        }
        end = System.currentTimeMillis();
        System.out.println("Time taken to concatenate using + operator: " + (end - start) + "ms");

    }
}
