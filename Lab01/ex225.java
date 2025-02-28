import javax.swing.JOptionPane;
public class ex225 {
    public static void main(String[] args) {
        String strNum1, strNum2;
        double num1, num2, sum, diff, pro, div;
        String strNotification = "You've just entered: ";
        strNum1 = JOptionPane.showInputDialog(null,"Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        num1 = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null,"Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        num2 = Double.parseDouble(strNum2);
        sum = num1 + num2;
        diff = Math.abs(num1 - num2);
        pro = num1*num2;
        div = num1/num2;
        JOptionPane.showMessageDialog(null,"Sum of numbers: " + sum + "\n" + "Difference of numbers: " + diff + "\n" + "Product of numbers: " + pro + "\n" + "Division of numbers: " + div,"Show sum: ", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}