package hust.soict.hedspi.swing;

import java.awt.*;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;

    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2, 0, 50));
        add(new Label("Enter an integer: "));
        tfInput = new TextField(10);
        tfInput.addActionListener(e -> {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        });
        add(tfInput);
        add(new Label("The Accumulated Sum is: "));
        tfOutput = new TextField(10);
        add(tfOutput);
        tfOutput.setEditable(false);
        setTitle("AWT Accumulator");
        setVisible(true);
        setSize(300, 200);
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }
}
