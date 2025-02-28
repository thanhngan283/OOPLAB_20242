import java.util.Scanner;
import java.util.Arrays;
public class addMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row, col, i, j;
        System.out.print("Enter the number of rows: ");
        row = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        col = sc.nextInt();
        double[][] arrMa1 = new double[row][col];
        double[][] arrMa2 = new double[row][col];
        System.out.println("Enter the first matrix: ");
        for (i = 0; i < row; i++) {
            System.out.print("\tEnter the " + (i + 1)+ " line: ");
            for (j = 0; j < col; j++) {
                arrMa1[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Enter the second matrix: ");
        for (i = 0; i < row; i++) {
            System.out.print("\tEnter the " + ( i + 1) + " line: ");
            for (j = 0; j < col; j++) {
                arrMa2[i][j] = sc.nextDouble();
            }
        }
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                arrMa2[i][j] += arrMa1[i][j];
            }
        }
        System.out.print("\nThe array after sum: \n");
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                System.out.print("\t" + arrMa2[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
