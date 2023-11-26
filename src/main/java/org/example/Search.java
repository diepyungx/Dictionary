package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import Data.ConnectToDatabase;
import Data.ListWordDatabase;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class Search extends JFrame {
    JTextField search;
    JButton exit;
    JButton ok;
    JTextArea meaning;

    public Search() {
        setTitle("SEARCH");
        getContentPane().setBackground(new Color(252	,218,	213));
        setBounds(350, 100, 500, 630);

        JLabel tieude = new JLabel("Search :");
        tieude.setForeground(new Color(0,0,0));
        tieude.setBounds(30, 50,100,100);
        tieude.setFont(new Font("Arial",1,18));
        add(tieude);

        ok = new JButton("OK");
        ok.setBounds(300,140,70,40);
        ok.setFont(new Font("Arial",1,16));
        add(ok);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchKeyword = search.getText();
                ConnectToDatabase connectToDatabase = new ConnectToDatabase();
                List<Object[]> searchResult = connectToDatabase.performSearch(searchKeyword);
                SwingUtilities.invokeLater(() -> new ListWordDatabase(searchResult));
            }
        });

        exit = new JButton("Exit");
        exit.setBounds(5,5,70,30);
        add(exit);

        search = new JTextField();
        search.setBounds(50,140,300,40);
        search.setFont(new Font("Arial",1,16));
        add(search);

        JLabel meanHere = new JLabel("Meaning");
        meanHere.setBounds(30,180,200,50);
        meanHere.setFont(new Font("Arial",1,16));
        add(meanHere);

        meaning = new JTextArea();
        meaning.setFont(new Font("Arial",1,16));
        meaning.setBounds(50,280,200,80);



        add(meaning);

        meaning.setWrapStyleWord(true);
        meaning.setEditable(false);
        meaning.setLineWrap(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SearchWord(new ArrayList<>());
    }
    public void SearchWord(ArrayList<String> wordList) {
        search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                EventQueue.invokeLater(() -> {
                    String word = search.getText();
                    if (word.length() == 0) {
                        // Clear suggestions if the search field is empty
                        // You might want to handle this case based on your requirements
                    } else {
                        ArrayList<String> suggestedWords = getSuggestedWords(word, wordList);
                        updateSuggestionList(suggestedWords);
                    }
                });
            }
        });
    }

    private ArrayList<String> getSuggestedWords(String prefix, ArrayList<String> wordList) {
        ArrayList<String> suggestions = new ArrayList<>();
        for (String word : wordList) {
            if (word.toLowerCase().startsWith(prefix.toLowerCase())) {
                suggestions.add(word);
            }
        }
        return suggestions;
    }

    private void updateSuggestionList(ArrayList<String> suggestions) {

    }


}
