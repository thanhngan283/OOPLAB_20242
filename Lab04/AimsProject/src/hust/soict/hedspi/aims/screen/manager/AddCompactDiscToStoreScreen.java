package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfId;
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfLength;
    private JTextField tfDirector;
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        this.setTitle("Add Compact Disc to Store");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel center = createCenter();
        this.add(center, BorderLayout.CENTER);
    }

    @Override
    public JPanel createCenter() {
        JPanel center = new JPanel();
        // Changed to 2 columns and sufficient rows
        center.setLayout(new GridLayout(8, 2, 10, 10));

        ButtonListener btnListener = new ButtonListener();

        // Adding labels and text fields for input
        JLabel inputTitle = new JLabel("Enter the Title of the CD:", SwingConstants.CENTER);
        inputTitle.setFont(new Font(inputTitle.getFont().getName(), Font.PLAIN, 15));
        center.add(inputTitle);
        tfTitle = new JTextField(50);
        center.add(tfTitle);

        JLabel inputId = new JLabel("ID:", SwingConstants.CENTER);
        inputId.setFont(new Font(inputId.getFont().getName(), Font.PLAIN, 15));
        center.add(inputId);
        tfId = new JTextField(10);
        center.add(tfId);

        JLabel inputCat = new JLabel("Category:", SwingConstants.CENTER);
        inputCat.setFont(new Font(inputCat.getFont().getName(), Font.PLAIN, 15));
        center.add(inputCat);
        tfCategory = new JTextField(50);
        center.add(tfCategory);

        JLabel inputCost = new JLabel("Cost:", SwingConstants.CENTER);
        inputCost.setFont(new Font(inputCost.getFont().getName(), Font.PLAIN, 15));
        center.add(inputCost);
        tfCost = new JTextField(50);
        center.add(tfCost);

        JLabel inputLength = new JLabel("Length:", SwingConstants.CENTER);
        inputLength.setFont(new Font(inputLength.getFont().getName(), Font.PLAIN, 15));
        center.add(inputLength);
        tfLength = new JTextField(50);
        center.add(tfLength);

        JLabel inputDirector = new JLabel("Director:", SwingConstants.CENTER);
        inputDirector.setFont(new Font(inputDirector.getFont().getName(), Font.PLAIN, 15));
        center.add(inputDirector);
        tfDirector = new JTextField(50);
        center.add(tfDirector);

        JLabel inputArtist = new JLabel("Artist:", SwingConstants.CENTER);
        inputArtist.setFont(new Font(inputArtist.getFont().getName(), Font.PLAIN, 15));
        center.add(inputArtist);
        tfArtist = new JTextField(50);
        center.add(tfArtist);

        // Container for the Confirm button
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(btnListener);
        container.add(confirmButton);

        center.add(new JLabel()); // Placeholder for alignment
        center.add(container);

        center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        return center;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("Confirm")) {
                String title = tfTitle.getText();
                int id = Integer.parseInt(tfId.getText());
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());
                int length = Integer.parseInt(tfLength.getText());
                String director = tfDirector.getText();
                String artist = tfArtist.getText();

                CompactDisc newCD = new CompactDisc(id, title, category, cost, length, director, artist);
                store.addMedia(newCD);

                JOptionPane.showMessageDialog(null, "CD added successfully");
                dispose();

                // Clear the input fields after adding
                tfTitle.setText("");
                tfId.setText("");
                tfCategory.setText("");
                tfCost.setText("");
                tfLength.setText("");
                tfDirector.setText("");
                tfArtist.setText("");
            }
        }
    }
}