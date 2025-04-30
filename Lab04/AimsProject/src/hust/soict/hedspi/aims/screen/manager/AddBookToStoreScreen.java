package hust.soict.hedspi.aims.screen.manager;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfId;
    private JTextField tfTitle;
    private JTextField tfAuthor;
    private JTextField tfCategory;
    private JTextField tfCost;

    public AddBookToStoreScreen(Store store) {
        super(store);
        this.setTitle("Add Book to Store");
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
        center.setLayout(new GridLayout(6, 2, 10, 10));
        
        ButtonListener btnListener = new ButtonListener();
        
        JLabel inputTitle = new JLabel("Enter the Title of the Book:", SwingConstants.CENTER);
        inputTitle.setFont(new Font(inputTitle.getFont().getName(), Font.PLAIN, 15));
        center.add(inputTitle);
        tfTitle = new JTextField(50);
        center.add(tfTitle);
        
        JLabel inputId = new JLabel("ID:", SwingConstants.CENTER);
        inputId.setFont(new Font(inputId.getFont().getName(), Font.PLAIN, 15));
        center.add(inputId);
        tfId = new JTextField(10);
        center.add(tfId);
        
        JLabel inputAuthor = new JLabel("Author(s): ", SwingConstants.CENTER);
        inputAuthor.setFont(new Font(inputAuthor.getFont().getName(), Font.PLAIN, 15));
        center.add(inputAuthor);
        tfAuthor = new JTextField(50);
        center.add(tfAuthor);
        
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
        
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(btnListener);
        container.add(confirmButton);
        
        center.add(new JLabel()); // Placeholder
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
                List<String> authors = new ArrayList<>();
                authors.add(tfAuthor.getText());
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());
                
                Book newBook = new Book(id, title, category, cost, authors);
                
                store.addMedia(newBook);
                
                JOptionPane.showMessageDialog(null, "Book added successfully");
                
                // Clear the input fields after adding
                tfTitle.setText("");
                tfId.setText("");
                tfAuthor.setText("");
                tfCategory.setText("");
                tfCost.setText("");
            }
        }
    }
}
