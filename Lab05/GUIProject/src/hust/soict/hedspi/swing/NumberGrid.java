package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;

public class NumberGrid extends JFrame {
    private JButton[] numberBtns = new JButton[10];
    private JButton resetBtn, delBtn;
    private JTextField displayText;

    public NumberGrid() {
        displayText = new JTextField();
        JPanel NumberPanel = new JPanel();
        NumberPanel.setLayout(new GridLayout(4, 3));
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(displayText, BorderLayout.NORTH);
        addNumberBtn(NumberPanel);
        cp.add(NumberPanel, BorderLayout.CENTER);

        setVisible(true);
        setSize(400, 400);
        setTitle("Number grid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void addNumberBtn(JPanel panel) {
        for (int i = 1; i < 10; i++) {
            numberBtns[i] = new JButton(i + "");
            panel.add(numberBtns[i]);
            numberBtns[i].addActionListener(e -> {
                displayText.setText(displayText.getText() + e.getActionCommand());
            });
        }
        delBtn = new JButton("DEL");
        panel.add(delBtn);
        delBtn.addActionListener(e -> {
            displayText.setText(displayText.getText().substring(0, displayText.getText().length() - 1));
        });

        numberBtns[0] = new JButton("0");
        panel.add(numberBtns[0]);
        numberBtns[0].addActionListener(e -> {
            displayText.setText(displayText.getText() + e.getActionCommand());
        });

        resetBtn = new JButton("C");
        panel.add(resetBtn);
        resetBtn.addActionListener(e -> {
            displayText.setText("");
        });
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}
