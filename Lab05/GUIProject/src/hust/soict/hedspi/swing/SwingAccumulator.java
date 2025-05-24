package hust.soict.hedspi.swing;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2, 0, 50));
        cp.add(new JLabel("Enter an integer: "));
        tfInput = new JTextField(10);
        tfInput.addActionListener(e -> {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        });
        cp.add(tfInput);
        cp.add(new JLabel("The Accumulated Sum is: "));
        tfOutput = new JTextField(10);
        cp.add(tfOutput);
        tfOutput.setEditable(false);
        setTitle("Swing Accumulator");
        setVisible(true);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }

}
