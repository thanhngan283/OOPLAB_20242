package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import java.util.List;

import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame {
    private static Store store = new Store();
    private Container cp = getContentPane();
    private JPanel centerPanel;

    public StoreManagerScreen() {
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        centerPanel = createViewStore();
        cp.add(centerPanel);

        setTitle("AIMS Management");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createOptionsMenuBar());
        north.add(createHeader("AIMS"));
        return north;
    }

    private JPanel createHeader(String text) {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JTextField headerText = new JTextField(text);
        headerText.setEditable(false);
        headerText.setFocusable(false);

        headerText.setForeground(Color.CYAN);
        headerText.setFont(new Font(headerText.getFont().getName(), Font.PLAIN, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(headerText);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    private JPanel createViewStore() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        var mediaStore = store.getItemsInStore();
        for (Media media : mediaStore) {
            JPanel mediaPanel = new JPanel();
            mediaPanel.setLayout(new BoxLayout(mediaPanel, BoxLayout.Y_AXIS));

            JLabel titleLabel = new JLabel(media.getTitle());
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            mediaPanel.add(Box.createVerticalGlue());
            mediaPanel.add(titleLabel);
            mediaPanel.add(Box.createVerticalGlue());

            JLabel costLabel = new JLabel(media.getCost() + "$");
            costLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            mediaPanel.add(costLabel);
            mediaPanel.add(Box.createVerticalGlue());
            if (media instanceof Playable) {
                JButton playButton = new JButton("Play");
                playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                playButton.addActionListener(e -> {
                    JOptionPane.showMessageDialog(cp, "Playing " + media.toString());
                });
                mediaPanel.add(playButton);
            }

            mediaPanel.add(Box.createVerticalGlue());
            mediaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            center.add(mediaPanel);
        }
        return center;
    }

    private JMenuBar createOptionsMenuBar() {
        JMenu menu = new JMenu("Options");
        var viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> {
            removeComponent(centerPanel);
            centerPanel = createViewStore();
            cp.add(centerPanel, BorderLayout.CENTER);
        });
        menu.add(viewStore);

        JMenu updateMenu = new JMenu("Update Store");

        var addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            removeComponent(centerPanel);
            centerPanel = createAddCD();
            cp.add(centerPanel, BorderLayout.CENTER);
        });
        updateMenu.add(addCD);

        var addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            removeComponent(centerPanel);
            centerPanel = createAddBook();
            cp.add(centerPanel, BorderLayout.CENTER);
        });
        updateMenu.add(addBook);

        var addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            removeComponent(centerPanel);
            centerPanel = createAddDVD();
            cp.add(centerPanel, BorderLayout.CENTER);
        });
        updateMenu.add(addDVD);

        menu.add(updateMenu);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private JPanel createAddCD() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2, 10, 10));

        panel.add(new JLabel("Title: "));
        JTextField title = new JTextField(10);
        panel.add(title);

        panel.add(new JLabel("Category: "));
        JTextField category = new JTextField(10);
        panel.add(category);

        panel.add(new JLabel("Director: "));
        JTextField director = new JTextField(10);
        panel.add(director);

        panel.add(new JLabel("Artist: "));
        JTextField artist = new JTextField(10);
        panel.add(artist);

        panel.add(new JLabel("Cost: "));
        JTextField cost = new JTextField(10);
        panel.add(cost);

        panel.add(new JLabel("Length: "));
        JTextField length = new JTextField(10);
        panel.add(length);

        JButton btn = new JButton("Add CD");
        panel.add(btn);
        btn.addActionListener(e -> {
            String titleStr = title.getText();
            String categoryStr = category.getText();
            String directorStr = director.getText();
            String artistStr = artist.getText();
            Float costStr = Float.parseFloat(cost.getText());
            Integer lengthStr = Integer.parseInt(length.getText());
            CompactDisc cd = new CompactDisc(titleStr, categoryStr, directorStr, artistStr, lengthStr, costStr);
            store.addMedia(cd);

            title.setText("");
            category.setText("");
            director.setText("");
            artist.setText("");
            length.setText("");
            cost.setText("");
            JOptionPane.showMessageDialog(cp, "CD added successfully");
        });

        return panel;
    }

    private JPanel createAddBook() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));

        panel.add(new JLabel("Title: "));
        JTextField title = new JTextField(10);
        panel.add(title);

        panel.add(new JLabel("Category: "));
        JTextField category = new JTextField(10);
        panel.add(category);

        panel.add(new JLabel("Authors: "));
        JTextField authors = new JTextField(10);
        panel.add(authors);

        panel.add(new JLabel("Cost: "));
        JTextField cost = new JTextField(10);
        panel.add(cost);

        JButton btn = new JButton("Add Book");
        panel.add(btn);
        btn.addActionListener(e -> {
            String titleStr = title.getText();
            String categoryStr = category.getText();
            ArrayList<String> authorStr = new ArrayList<String>(List.of(authors.getText().split(",")));
            Float costStr = Float.parseFloat(cost.getText());
            Book book = new Book(titleStr, categoryStr, costStr, authorStr);
            store.addMedia(book);

            title.setText("");
            category.setText("");
            authors.setText("");
            cost.setText("");
            JOptionPane.showMessageDialog(cp, "Book added successfully");
        });

        return panel;
    }

    private JPanel createAddDVD() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2, 10, 10));

        panel.add(new JLabel("Title: "));
        JTextField title = new JTextField(10);
        panel.add(title);

        panel.add(new JLabel("Category: "));
        JTextField category = new JTextField(10);
        panel.add(category);

        panel.add(new JLabel("Director: "));
        JTextField director = new JTextField(10);
        panel.add(director);

        panel.add(new JLabel("Cost: "));
        JTextField cost = new JTextField(10);
        panel.add(cost);

        panel.add(new JLabel("Length: "));
        JTextField length = new JTextField(10);
        panel.add(length);

        JButton btn = new JButton("Add DVD");
        panel.add(btn);
        btn.addActionListener(e -> {
            String titleStr = title.getText();
            String categoryStr = category.getText();
            String directorStr = director.getText();
            Float costStr = Float.parseFloat(cost.getText());
            Integer lengthStr = Integer.parseInt(length.getText());
            DigitalVideoDisc dvd = new DigitalVideoDisc(titleStr, categoryStr, directorStr, lengthStr, costStr);
            store.addMedia(dvd);

            title.setText("");
            category.setText("");
            director.setText("");
            length.setText("");
            cost.setText("");
            JOptionPane.showMessageDialog(cp, "DVD added successfully");
        });

        return panel;
    }

    private void removeComponent(Component c) {
        cp.remove(c);
        cp.revalidate();
        cp.repaint();
    }

    public static void main(String[] args) {
        // Initialize store and some media
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Annabelle", "Horror", "Unknown", 108, 29.95f);
        Book book1 = new Book("Atomic Habits", "Self Help", 19.95f);
        book1.addAuthor("James Clear");
        CompactDisc cd1 = new CompactDisc("The Best of Mozart", "Classic", "Mozart", 15.99f);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(cd1);
        store.addMedia(book1);

        new StoreManagerScreen();
    }
}
