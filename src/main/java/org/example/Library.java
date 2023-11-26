package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

public class Library extends JFrame {
    static DictionaryCommanline dic = new DictionaryCommanline();

    JButton library;

    JTextArea txt = new JTextArea();
    public Library() throws FileNotFoundException {
        setBounds(350,120,500,700);

        setTitle("Dictionary Application");
        txt.setBackground(new Color(254	,235	,208));


        library = new JButton("EXIT");
        library.setBounds(50,50,100,50);
        setLayout(new BorderLayout());

        txt.setFont(new Font("Arial",1,16));
        txt.setEditable(false);
        String text = txt.getText();
        txt.setCaretPosition(text!=null? text.length() : 0);
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(txt);
        add(library, BorderLayout.SOUTH);
        add(pane, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            dic.dic.insertFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        showAll();
        setVisible(false);
    }
    public void showAll() throws FileNotFoundException {
        JTextArea txt = new JTextArea();
        txt.setBounds(0,0,500,600);
        txt.setFont(new Font("Arial",1,16));

        txt.setText(dic.showAllWords());
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(txt);
        add(pane,BorderLayout.CENTER);

    }
 }
