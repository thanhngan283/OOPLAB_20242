import javax.swing.JOptionPane;
public class secondOrderEq {
    public static void main(String[] args) {
        String strNum1, strNum2, strNum3;
        double a, b, c, x1, x2, delta;
        strNum1 = JOptionPane.showInputDialog(null,"Please input the parameter a: ", "Input parameter", JOptionPane.INFORMATION_MESSAGE);
        a = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null,"Please input the parameter b: ", "Input parameter", JOptionPane.INFORMATION_MESSAGE);
        b = Double.parseDouble(strNum2);
        strNum3 = JOptionPane.showInputDialog(null,"Please input the parameter c: ", "Input parameter", JOptionPane.INFORMATION_MESSAGE);
        c = Double.parseDouble(strNum3);
        if (a == 0) {
            JOptionPane.showMessageDialog(null,"Invalid coefficient (a = 0)!", "Show result", JOptionPane.INFORMATION_MESSAGE);
        } else {
        delta = b*b - 4*a*c;
        if (delta < 0)  {
            JOptionPane.showMessageDialog(null,"Equation has no solution!", "Show result", JOptionPane.INFORMATION_MESSAGE);    
        } 
        else if (delta == 0) {
            x1 = (-b)/(2*a);
            JOptionPane.showMessageDialog(null,"Equation has one solution: \nx = " + x1 ,"Show result" , JOptionPane.INFORMATION_MESSAGE);
        } else {
            x1 = (-b + Math.sqrt(delta))/(2*a);
            x2 = (-b - Math.sqrt(delta))/(2*a);
            JOptionPane.showMessageDialog(null, "Equation has two solutions: \nx1 = " + x1 + "\nx2 = " + x2,"Show result" ,JOptionPane.INFORMATION_MESSAGE);
        }      
        }
        System.exit(0);
        }
}