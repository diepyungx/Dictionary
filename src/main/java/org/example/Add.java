package org.example;


import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Add extends JFrame {
    JButton exit;
    JButton addButon;
    JTextField word;
    JTextField meaning;

    JLabel error;
    JLabel exist;
    JLabel success;

    public Add() {

        setTitle("ADD");
        getContentPane().setBackground(new Color(254,	235,	208));
        setBounds(350, 100, 500, 630);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        exit = new JButton("Exit");
        exit.setForeground(new Color(0, 0, 0));
        exit.setBounds(5, 5, 70, 40);
        add(exit);

        JLabel enterWord = new JLabel("Enter the word here: ");
        enterWord.setFont(new Font("Arial", 1, 16));
        enterWord.setBounds(10, 60, 400, 40);
        add(enterWord);

        word = new JTextField(12);
        word.setFont(new Font("Arial", 1, 16));
        word.setBounds(10, 120, 400, 40);
        word.setEditable(true);
        add(word);

        JLabel EnterMean = new JLabel("Enter the Meaning Here: ");
        EnterMean.setBounds(10, 190, 400, 30);
        EnterMean.setFont(new Font("Arial", 1, 16));
        EnterMean.setLayout(new BorderLayout());
        add(EnterMean);

        meaning = new JTextField(12);
        meaning.setFont(new Font("Arial", 1, 16));
        meaning.setBounds(10, 250, 400, 40);
        meaning.setEditable(true);
        add(meaning);

        addButon = new JButton("Add");
        addButon.setBounds(190, 330, 100, 40);
        add(addButon);
        addButon.setVisible(true);



        error = new JLabel("Error!");
        error.setFont(new Font("Arial", 1, 30));
        error.setBounds(200, 250, 300, 100);
        add(error);
        error.setVisible(false);

        JLabel exist = new JLabel("This word's already existed!");
        exist.setFont(new Font("Arial", 1, 30));
        exist.setBounds(100, 230, 500, 100);
        add(exist);
        exist.setVisible(false);

        success = new JLabel("Add Success!!");
        success.setFont(new Font("Arial", 1, 25));
        success.setBounds(350, 150, 320, 100);
        success.setLayout(new BorderLayout());
        add(success,BorderLayout.CENTER);
        success.setVisible(false);



        addButon.addActionListener(e -> {
            addButon.setVisible(false);
            //w.setVisible(false);
            //m.setVisible(false);
            exit.setVisible(true);
        });

        exit.addActionListener(e -> {
            error.setVisible(false);
            exist.setVisible(false);
            success.setVisible(false);
            //w.setVisible(false);
            //m.setVisible(true);
        });

    }
}
