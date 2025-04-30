package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(createNorth(), BorderLayout.NORTH);
        container.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setLocationRelativeTo(null);
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    JPanel createNorth() {
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(createMenuBar());
        northPanel.add(createHeader());
        return northPanel;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Option");
        JMenu updateStoreSubMenu = new JMenu("Update Store");

        ButtonListener btnListener = new ButtonListener();

        JMenuItem addBookMenuItem = new JMenuItem("Add Book");
        addBookMenuItem.addActionListener(btnListener);
        updateStoreSubMenu.add(addBookMenuItem);

        JMenuItem addDVDMenuItem = new JMenuItem("Add DVD");
        addDVDMenuItem.addActionListener(btnListener);
        updateStoreSubMenu.add(addDVDMenuItem);

        JMenuItem addCDMenuItem = new JMenuItem("Add CD");
        addCDMenuItem.addActionListener(btnListener);
        updateStoreSubMenu.add(addCDMenuItem);

        menu.add(updateStoreSubMenu);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));

        JLabel titleLabel = new JLabel("AIMS");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 50));
        titleLabel.setForeground(Color.CYAN);

        headerPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        headerPanel.add(titleLabel);
        headerPanel.add(Box.createHorizontalGlue());
        headerPanel.add(Box.createRigidArea(new Dimension(10, 10)));

        return headerPanel;
    }

    public abstract JPanel createCenter();

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonCommand = e.getActionCommand();
            if (buttonCommand.equals("View Store")) {
                dispose();
                new StoreManagerScreen(store);
            } else if (buttonCommand.equals("Add DVD")) {
                dispose();
                new AddDigitalVideoDiscToStoreScreen(store);
            } else if (buttonCommand.equals("Add CD")) {
                dispose();
                new AddCompactDiscToStoreScreen(store);
            } else if (buttonCommand.equals("Add Book")) {
                dispose();
                new AddBookToStoreScreen(store);
            }
        }
    }
}
