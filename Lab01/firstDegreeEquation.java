import javax.swing.JOptionPane;
public class firstDegreeEquation {
    public static void main(String[] args) {
        String strNum1, strNum2;
        double num1, num2, solution;
        strNum1 = JOptionPane.showInputDialog(null,"Please input the first parameter a: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        num1 = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null,"Please input the second parameter b: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        num2 = Double.parseDouble(strNum2);
        solution = (-num2)/num1;
        if (num1 == 0)  {
            JOptionPane.showMessageDialog(null,"Invalid input for the parameter!", "Show warnning", JOptionPane.INFORMATION_MESSAGE);    
        } 
        else JOptionPane.showMessageDialog(null,"The solution is: " + solution,"Show solution" ,JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}