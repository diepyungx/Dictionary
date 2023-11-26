package org.example;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static DictionaryCommanline dictionaryCommanline = new DictionaryCommanline();
    static DictionaryManagement dictionaryManagement = new DictionaryManagement();
    static Dictionary dictionary = new Dictionary();


    public static void main(String[] args) throws IOException {
        String s = "C:\\Users\\Admin\\IdeaProjects\\Hi\\src\\main\\java\\org\\example\\dictionaries.txt";

        dictionaryManagement.insertFromFile();
        DictionaryApplication frame = new DictionaryApplication();
        Add add = new Add();
        Delete delete = new Delete();
        Library library = new Library();
        Search search = new Search();
        Export export = new Export();
        Edit edit = new Edit();

        frame.setVisible(true);


        frame.add.addActionListener(e -> {
            frame.setVisible(false);
            add.setVisible(true);
            export.setVisible(false);

            add.addButon.addActionListener(e1 -> {
                String target = add.word.getText();
                String explain= add.meaning.getText();
                target = target.toLowerCase();
                explain = explain.toLowerCase();
                try {
                    dictionaryManagement.insertFromFile();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
                }

                if(target.isEmpty() || explain.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Error!", "Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(dictionaryManagement.wordExists(target))
                {
                    JOptionPane.showMessageDialog(null,"This word is not in dictionary","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    dictionaryManagement.addNewWord(target,explain);
                    JOptionPane.showMessageDialog(null, "The word added!");

                    try
                    {
                        File file=new File(s);
                        FileWriter fw= new FileWriter(file);

                        for(int i=0; i < dictionary.wordList.size();i++)
                        {
                            fw.write(dictionary.wordList.get(i).getWord_target() + "\t" + dictionary.wordList.get(i).getWord_explain() + "\n");
                        }
                        fw.close();
                    }
                    catch(Exception ex){
                        System.out.println("Error: " +ex);
                    }
                }
            });
        });
        add.exit.addActionListener(e -> {
            frame.setVisible(true);
            add.setVisible(false);
        });
        frame.add.addActionListener(e->{
            add.setVisible(true);
            frame.setVisible(false);
        });


        frame.edit.addActionListener(e -> {
            frame.setVisible(false);
            edit.setVisible(true);
            export.setVisible(false);

            edit.editButon.addActionListener(e1 -> {
                String target = edit.target1.getText();
                String word= edit.wordEdit.getText();
                String mean= edit.meaning.getText();

                target = target.toLowerCase();
                word = word.toLowerCase();
                mean = mean.toLowerCase();

                try {
                    dictionaryManagement.insertFromFile();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Edit.class.getName()).log(Level.SEVERE, null, ex);
                }

                if(target.isEmpty() || word.isEmpty() || mean.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Error!!!", "Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(!dictionaryManagement.wordExists(target))
                {
                    JOptionPane.showMessageDialog(null,"This word is not in dictionary","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    for(int i=0 ;i < dictionary.wordList.size() ;i++){
                        Word w = dictionary.wordList.get(i);
                        if(target.equals(w.getWord_target()))
                        {

                            w.setWord_target(word);
                            w.setWord_explain(mean);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Edited successfully!");
                    if (dictionary != null && dictionary.wordList != null) {
                        try {
                            File file = new File(s);
                            FileWriter fw = new FileWriter(file);

                            for (int i = 0; i < dictionary.wordList.size(); i++) {
                                fw.write(dictionary.wordList.get(i).getWord_target() + "\t" + dictionary.wordList.get(i).getWord_explain() + "\n");
                            }

                            fw.close();
                        } catch (Exception ex) {
                            System.out.println("Error: " + ex);
                        }
                    } else {
                        System.out.println("Dictionary or wordList is null.");
                    }


                }
            });

        });
        edit.exit.addActionListener(e -> {
            frame.setVisible(true);
            edit.setVisible(false);
        });
        frame.edit.addActionListener(e->{
            frame.setVisible(false);
            edit.setVisible(true);
        });





        frame.delete.addActionListener(e->{
            delete.setVisible(true);
            frame.setVisible(false);

        });
        delete.exit.addActionListener(e -> {
            frame.setVisible(true);
            delete.setVisible(false);
        });
        delete.deleteButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String removeword = delete.wordtoDelete.getText();
                removeword = removeword.toLowerCase();

                try {
                    dictionaryManagement.insertFromFile();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
                }

                if(removeword.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Error!!!", "Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(!dictionaryManagement.wordExists(removeword))
                {
                    JOptionPane.showMessageDialog(null,"This word is not in dictionary","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    try
                    {
                        for(int i = 0; i < dictionary.wordList.size(); i++){
                            Word element = dictionary.wordList.get(i);
                            if (element.getWord_target().equals(removeword)) {
                                dictionary.wordList.remove(dictionary.wordList.indexOf(element));
                            }
                        }
                    }
                    catch (Exception ex){}
                    JOptionPane.showMessageDialog(null, "Removed successfully!");

                    try
                    {
                        File file=new File("C:\\Users\\Admin\\IdeaProjects\\Hi\\src\\main\\java\\org\\example\\dictionaries.txt");
                        FileWriter fw= new FileWriter(file);

                        for(int i = 0 ; i < dictionary.wordList.size(); i++)
                        {
                            Word element = dictionary.wordList.get(i);
                            fw.write(element.getWord_target() + "\t" + element.getWord_explain() + "\n");
                        }
                        fw.close();
                    }
                    catch(Exception ex){
                        System.out.println("Error: " +ex);
                    }
                }
            }
        });




        //dictionaryManagement.dictionaryExportToFile("C:\\Users\\Admin\\IdeaProjects\\Hi\\src\\main\\java\\org\\example\\dictionaries.txt");
        dictionaryManagement.insertFromFile();
        frame.library.addActionListener(e->{
            frame.setVisible(false);
            export.setVisible(false);
            library.setVisible(true);

            try {
                library.txt.setText(dictionaryCommanline.showAllWords());
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        library.library.addActionListener(e->{
            frame.setVisible(true);
            library.setVisible(false);
        });


        dictionaryManagement.insertFromFile();
        frame.search.addActionListener(e->{
            frame.setVisible(false);
            search.setVisible(true);
        });

        search.exit.addActionListener(e -> {
            search.meaning.getText();
            search.search.getText();
            frame.setVisible(true);
            search.setVisible(false);

        });
        search.search.addActionListener(e -> {
            search.meaning.setText(dictionaryManagement.dictionaryLookup(search.search.getText()));
        });


        frame.export.addActionListener(e -> {
            export.setVisible(true);
            frame.setVisible(false);
        });

        export.exit.addActionListener(e->{

            export.setVisible(false);
            frame.setVisible(true);
        });
        export.save.addActionListener(e->{
            export.filetxt += export.file.getText() + ".txt";
            try {
                dictionaryManagement.dictionaryExportToFile(export.filetxt);
            } catch (IOException exception){
                throw new RuntimeException(exception);
            }
        });






    }



}