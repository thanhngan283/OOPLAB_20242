package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.disc.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;

   
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

 
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(new ButtonListener());
        menu.add(viewStore);

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(new ButtonListener());
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(new ButtonListener());
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(new ButtonListener());
        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

   
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        int size = mediaInStore.size(); // Kiểm tra số lượng phần tử
        for (int i = 0; i < size; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("View store")) {
                
                new StoreManagerScreen(store); 
            } else if (button.equals("Add DVD")) {
                
                new AddDigitalVideoDiscToStoreScreen(store); 
            } else if (button.equals("Add CD")) {
                
                new AddCompactDiscToStoreScreen(store); 
            } else if (button.equals("Add Book")) {
                
                new AddBookToStoreScreen(store); 
            }
        }
    }

  
    public static void main(String[] args) {
        Store storeTest = new Store();

        // Thêm một số sản phẩm mẫu vào cửa hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1101, "Cinderella", "Cartoon", 3, 10, "Disney");
        storeTest.addMedia(dvd1);

     
        new StoreManagerScreen(storeTest);
    }
}