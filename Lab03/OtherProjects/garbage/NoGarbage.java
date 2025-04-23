
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "myFile.exe";
        byte[] inputBytes = { 0 };
        long startTime;
        long endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        startTime = System.currentTimeMillis();
        String outputString = "";
        
        StringBuilder sb = new StringBuilder(outputString);
        for (byte b: inputBytes) {
            sb.append(b);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
