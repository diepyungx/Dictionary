package org.example;

import javafx.scene.control.Alert;
import org.example.Add;
import org.example.Delete;
import org.example.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.Vector;

/**public class DictionaryApplication extends JFrame {
    public JFrame frame;
    private JList<String> listWord;
    private JButton add1;
    private JTextField info;



    public DictionaryApplication() {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(25, 25, 112));
        frame.setBounds(300, 50, 520, 680);
        frame.setTitle("Dictionary");
        frame.getContentPane().setLayout(null);

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(230, 230, 250));
        frame.setBounds(350, 100, 500, 630); //kich co
        frame.setLayout(null);

        JLabel dic = new JLabel();
        dic.setFont(new java.awt.Font("STCaiyun", 1, 30));
        dic.setBounds(40, 20, 400, 43);
        dic.setHorizontalAlignment(SwingConstants.CENTER);
        dic.setText("Dictionary");
        frame.add(dic);

        JLabel search = new JLabel();
        search.setFont(new Font("STCaiyun", 1, 26));
        search.setBounds(10, 75, 150, 43);
        search.setHorizontalAlignment(SwingConstants.LEFT);
        search.setText("Search:");
        frame.add(search);

        // thanh tim kiem
        JTextArea word = new JTextArea();
        word.setFont(new Font("Arial", 1, 16));
        word.setForeground(new Color(0, 0, 0));
        word.setBackground(new Color(255, 255, 255)); // mau nen
        word.setBounds(110, 75, 360, 40);
        frame.add(word);


        JButton ok = new JButton("OK");
        ok.setFont(new Font("Segoe UI Black", 1, 14));
        ok.setForeground(new Color(0, 0, 0));  // mau cua chu
        ok.setBounds(170, 120, 80, 30);
        frame.add(ok);




        JLabel wordInfo = new JLabel();
        wordInfo.setFont(new java.awt.Font("STCaiyun", 1, 24));
        wordInfo.setBounds(10, 150, 150, 43);
        wordInfo.setHorizontalAlignment(SwingConstants.LEFT);
        wordInfo.setBorder(null);
        wordInfo.setText("Meaning: ");
        frame.add(wordInfo);

        JButton refresh = new JButton("Reset");
        refresh.setFont(new Font("Segoe UI Black", 1, 14));
        refresh.setForeground(new Color(0, 0, 0));
        refresh.setBounds(310, 120, 80, 30);
        frame.add(refresh);
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField info = new JTextField();
                word.setText("");

                info.setText("");
            }
        });


        // information word
        JTextField info = new JTextField();
        info.setFont(new Font("Arial", 1, 16));
        info.setForeground(new Color(0, 0, 0));
        info.setBackground(new Color(255, 255, 255)); // mau nen
        info.setBounds(10, 180, 460, 150);
        frame.add(info);


        JLabel function = new JLabel();
        function.setFont(new Font("STCaiyun", 1, 28)); // NOI18N
        function.setBounds(50, 350, 400, 43);
        function.setHorizontalAlignment(SwingConstants.CENTER);
        function.setText("Other Function : ");
        frame.add(function);

        JButton library = new JButton("Library");
        library.setForeground(new Color(0, 0, 0));
        library.setFont(new Font("Segoe UI Black", 1, 14));
        library.setBounds(190, 390, 120, 40);
        frame.add(library);
        library.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
                library.setVisible(true);
                try {
                    ListWord.main();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        JButton add2 = new JButton("Add");
        add2.setIcon(new ImageIcon("C:\\Users\\Admin\\Project\\Image"));
        add2.setForeground(new Color(0, 0, 0));
        add2.setFont(new Font("Segoe UI Black", 1, 14));
        add2.setBounds(190, 435, 120, 40);
        add2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
                add2.setVisible(true);
                AddWordFrame.main();
            }
        });
        frame.add(add2);


        JButton edit1 = new JButton("Edit");
        edit1.setForeground(new Color(0, 0, 0));
        edit1.setFont(new Font("Segoe UI Black", 1, 14));
        edit1.setBounds(190, 480, 120, 40);
        edit1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EditWordFrame.main();
            }
        });
        frame.add(edit1);
        edit1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
                edit1.setVisible(true);
                EditWordFrame.main();
            }
        });


        JButton delete = new JButton("Delete");
        delete.setForeground(new Color(0, 0, 0));
        delete.setFont(new Font("Segoe UI Black", 1, 14));
        delete.setBounds(190, 525, 120, 40);
        frame.add(delete);
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
                delete.setVisible(true);
                DeleteWordFrame.main();
            }
        });


    }

    public static void main(String[] args) throws FileNotFoundException {
        SwingUtilities.invokeLater(() -> {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                     UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            DictionaryApplication demo = new DictionaryApplication();
            demo.frame.setVisible(true);
        });

    }

}*/
public class DictionaryApplication extends JFrame {
    JLabel tieude;
    JButton add;
    JButton library;
    JButton edit;
    JButton delete;
    JButton export;
    JButton search;
    public DictionaryApplication() {
        setTitle("Dictionary Application");
        getContentPane().setBackground(new Color(230	,241,	216));
        setBounds(300,120,500,600);
        setLayout(null);

        JLabel tieude = new JLabel("English Dictionary ");
        tieude.setBounds(100,10,300,100);
        tieude.setFont(new Font("STCaiyun", 1, 30));
        tieude.setHorizontalAlignment(SwingConstants.CENTER);
        tieude.setForeground(new Color(0,0,0));
        getContentPane().add(tieude);



        edit = new JButton("Edit");
        edit.setFont(new Font("Arial",1,16));
        edit.setBounds(30,330,430,40);
        add(edit);


        add = new JButton("Add");
        add.setFont(new Font("Arial",1,16));
        add.setBounds(30,260,430,40);
        add(add);

        search = new JButton("Search");
        search.setFont(new Font("Arial",1,16));
        search.setBounds(30,190,430,40);
        add(search);


        delete = new JButton("Delete");
        delete.setFont(new Font("Arial",1,16));
        delete.setBounds(30,400,430,40);
        add(delete);

        library = new JButton("Library");
        library.setFont(new Font("Arial",1,16));
        library.setBounds(30,120,430,40);

        add(library);

        export = new JButton("Export");
        export.setFont(new Font("Arial",1,16));
        export.setBounds(30,470,430,40);
        add(export);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}