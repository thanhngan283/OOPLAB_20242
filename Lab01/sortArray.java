import java.util.Arrays;
import java.util.Scanner;
public class sortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arrInt = new int[n];
        int i;
        double sum = 0;
        for (i = 0; i < n; i++) {
            arrInt[i] = sc.nextInt();
            sum += arrInt[i];
        }
        Arrays.sort(arrInt);
        System.out.print("Arrays after sort: ");
        for (i = 0; i < n; i++) {
            System.out.print(arrInt[i] + " ");
        }       
        System.out.print("\nThe average: " + (sum/n));
    }
    
}
