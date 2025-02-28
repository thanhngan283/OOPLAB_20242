import javax.swing.JOptionPane;
public class systemFirstDegreeEq {
    public static void main(String[] args) {
        String strNum1, strNum2, strNum3, strNum4, strNum5, strNum6;
        double a1, a2, b1, b2, c1, c2, x, y, delta, delta1, delta2;
        strNum1 = JOptionPane.showInputDialog(null,"Please input the parameter a1: ", "Input parameter", JOptionPane.INFORMATION_MESSAGE);
        a1 = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null,"Please input the parameter b1: ", "Input parameter", JOptionPane.INFORMATION_MESSAGE);
        b1 = Double.parseDouble(strNum2);
        strNum3 = JOptionPane.showInputDialog(null,"Please input the parameter c1: ", "Input parameter", JOptionPane.INFORMATION_MESSAGE);
        c1 = Double.parseDouble(strNum3);
        strNum4 = JOptionPane.showInputDialog(null,"Please input the parameter a2: ", "Input parameter", JOptionPane.INFORMATION_MESSAGE);
        a2 = Double.parseDouble(strNum4);
        strNum5 = JOptionPane.showInputDialog(null,"Please input the parameter b2: ", "Input parameter", JOptionPane.INFORMATION_MESSAGE);
        b2 = Double.parseDouble(strNum5);
        strNum6 = JOptionPane.showInputDialog(null,"Please input the parameter c2: ", "Input parameter", JOptionPane.INFORMATION_MESSAGE);
        c2 = Double.parseDouble(strNum6);
        delta = a1*b2 - a2*b1;
        delta1 = b2*c1 - b1*c2;
        delta2 = c2*a1 - c1*a2;
        if (delta == 0)  {
            if (delta1 == 0 && delta2 == 0) {
                JOptionPane.showMessageDialog(null,"Infinity solutions!", "Show result",JOptionPane.INFORMATION_MESSAGE);    
            }
            else JOptionPane.showMessageDialog(null,"No solution!", "Show result", JOptionPane.INFORMATION_MESSAGE);    
        } 
        else {
            x = delta1/delta;
            y = delta2/delta;
            JOptionPane.showMessageDialog(null,"The solution is: \n" + "x = " + x + "\ny = " + y,"Show solution" , JOptionPane.INFORMATION_MESSAGE);
        }       
        System.exit(0);
    }
}