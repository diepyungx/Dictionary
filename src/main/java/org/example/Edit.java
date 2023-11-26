package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Edit extends JFrame {
    JButton exit;
    JButton editButon;
    JTextField target1;
    JTextField meaning;

    JLabel error;
    JTextField wordEdit;
    JLabel exist;
    JLabel success;

    public Edit() {

        setTitle("EDIT");
        getContentPane().setBackground(new Color(254	,235	,208));
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

        target1 = new JTextField(12);
        target1.setFont(new Font("Arial", 1, 16));
        target1.setBounds(10, 120, 400, 40);
        target1.setEditable(true);
        add(target1);

        JLabel EnterMean = new JLabel("Edit to Word Here: ");
        EnterMean.setBounds(10, 190, 400, 30);
        EnterMean.setFont(new Font("Arial", 1, 16));
        EnterMean.setLayout(new BorderLayout());
        add(EnterMean);

        meaning = new JTextField(12);
        meaning.setFont(new Font("Arial", 1, 16));
        meaning.setBounds(10, 320, 400, 40);
        meaning.setEditable(true);
        add(meaning);

        wordEdit = new JTextField(12);
        wordEdit.setFont(new Font("Arial", 1, 16));
        wordEdit.setBounds(10, 250, 400, 40);
        wordEdit.setEditable(true);
        add(wordEdit);

        editButon = new JButton("Edit");
        editButon.setBounds(190, 390, 100, 40);
        add(editButon);


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



        editButon.addActionListener(e -> {
            editButon.setVisible(false);

            exit.setVisible(true);
        });

        exit.addActionListener(e -> {
            error.setVisible(false);
            exist.setVisible(false);
            success.setVisible(false);

        });

    }

}