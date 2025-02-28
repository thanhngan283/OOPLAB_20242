import java.util.Scanner;
public class printstar {
    public static int i, j;
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of lines: ");
        int numLine = keyboard.nextInt();
        for (i = 1; i <= numLine; i++) {
            for (j = 1; j <= numLine -i; j++) System.out.print(" ");
            for (j = 1; j <= 2*i -1; j++)  System.out.print("*");
            System.out.println();
        }
        System.exit(0);
    }
}
