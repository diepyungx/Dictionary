package org.example;

import javax.swing.*;
import java.awt.*;

public class Export extends JFrame {
    String filetxt = "C:\\Users\\Admin\\IdeaProjects\\Hi\\src\\main\\java\\org\\example\\dictionaries.txt";
    JLabel nhapFile;
    JLabel file;

    JButton exit;
    JButton save;
    public Export() {
        JTextField file1 = new JTextField();

        setTitle("EXPORT");
        getContentPane().setBackground(new Color(254	,235	,208));
        setBounds(300,120,500,700);
        setVisible(true);

        nhapFile = new JLabel("Save as: ");
        nhapFile.setFont(new Font("Arial",1,16));
        nhapFile.setBounds(30,60,300,30);
        add(nhapFile);
        nhapFile.setVisible(false);

        file = new JLabel(filetxt);
        file.setFont(new Font("Arial",1,16));
        file.setBounds(30,130,400,30);
        add(file);
        file.setVisible(false);

        JLabel name = new JLabel("File name ?");
        name.setBounds(110,100,300,30);
        name.setFont(new Font("Arial",1,16));
        add(name);
        name.setVisible(false);

        exit = new JButton("exit");
        exit.setBounds(5,5,70,30);
        add(exit);

        file1.setFont(new Font("Arial",1,16));
        file1.setBounds(130,150,120,30);
        add(file1);
        file1.setVisible(true);

        /**save = new JButton("Save");
        save.setBounds(190,180,50,40);
        save.setLayout(new BorderLayout());
        add(save,BorderLayout.CENTER);

        save.addActionListener(e -> {
            file.setText(file.getText() + file1 + ".txt");
            file.setVisible(true);
            nhapFile.setVisible(true);
            name.setVisible(true);
            save.setVisible(true);
            exit.setVisible(false);
        });*/
    }
}
