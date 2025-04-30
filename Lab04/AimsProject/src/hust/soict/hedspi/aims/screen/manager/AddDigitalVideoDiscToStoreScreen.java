package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfId;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfLength;
    private JTextField tfDirector;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    public JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(7, 2));

        ButtonListener btnListener = new ButtonListener();

        JLabel inputTitle = new JLabel("Enter the title of the DVD:", SwingConstants.CENTER);
        inputTitle.setFont(new Font(inputTitle.getFont().getName(), Font.PLAIN, 15));
        inputTitle.setAlignmentX(CENTER_ALIGNMENT);
        center.add(inputTitle);
        tfTitle = new JTextField(50);
        center.add(tfTitle);

        JLabel inputId = new JLabel("ID:", SwingConstants.CENTER);
        inputId.setFont(new Font(inputId.getFont().getName(), Font.PLAIN, 15));
        inputId.setAlignmentX(CENTER_ALIGNMENT);
        center.add(inputId);
        tfId = new JTextField(10);
        center.add(tfId);

        JLabel inputCat = new JLabel("Category:", SwingConstants.CENTER);
        inputCat.setFont(new Font(inputCat.getFont().getName(), Font.PLAIN, 15));
        inputCat.setAlignmentX(CENTER_ALIGNMENT);
        center.add(inputCat);
        tfCategory = new JTextField(50);
        center.add(tfCategory);

        JLabel inputCost = new JLabel("Cost:", SwingConstants.CENTER);
        inputCost.setFont(new Font(inputCost.getFont().getName(), Font.PLAIN, 15));
        inputCost.setAlignmentX(CENTER_ALIGNMENT);
        center.add(inputCost);
        tfCost = new JTextField(50);
        center.add(tfCost);

        JLabel inputLength = new JLabel("Length:", SwingConstants.CENTER);
        inputLength.setFont(new Font(inputLength.getFont().getName(), Font.PLAIN, 15));
        inputLength.setAlignmentX(CENTER_ALIGNMENT);
        center.add(inputLength);
        tfLength = new JTextField(50);
        center.add(tfLength);

        JLabel inputDirector = new JLabel("Director:", SwingConstants.CENTER);
        inputDirector.setFont(new Font(inputDirector.getFont().getName(), Font.PLAIN, 15));
        inputDirector.setAlignmentX(CENTER_ALIGNMENT);
        center.add(inputDirector);
        tfDirector = new JTextField(50);
        center.add(tfDirector);

        center.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(btnListener);
        container.add(confirmButton);

        center.add(Box.createVerticalGlue());
        center.add(container);

        return center;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("Confirm")) {
                String title = tfTitle.getText().trim();
                String idText = tfId.getText().trim();
                String category = tfCategory.getText().trim();
                String costText = tfCost.getText().trim();
                String lengthText = tfLength.getText().trim();
                String director = tfDirector.getText().trim();

                if (title.isEmpty() || idText.isEmpty() || category.isEmpty() || costText.isEmpty() ||
                    lengthText.isEmpty() || director.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields must be filled out", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int id = Integer.parseInt(idText);
                float cost = Float.parseFloat(costText);
                int length = Integer.parseInt(lengthText);

                DigitalVideoDisc newDVD = new DigitalVideoDisc(id, title, category, cost, length, director);
                store.addMedia(newDVD);

                JOptionPane.showMessageDialog(null, "DVD added successfully");
                dispose();
                // Clear input fields after adding
                tfTitle.setText("");
                tfId.setText("");
                tfCategory.setText("");
                tfCost.setText("");
                tfLength.setText("");
                tfDirector.setText("");
            }
        }
    }
}