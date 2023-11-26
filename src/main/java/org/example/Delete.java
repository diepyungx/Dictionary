package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends JFrame {

    /**private static JLabel result;
    static Dictionary dictionary = new Dictionary();
    static DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public static void main() {
        JFrame deleteFrame = new JFrame("Delete Word From Dictionary");
        deleteFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        deleteFrame.getContentPane().setBackground(new Color(245, 255, 255));

        deleteFrame.setLayout(null);
        deleteFrame.setBounds(350, 100, 500, 630);
        deleteFrame.setVisible(true);

        JLabel wordDisplay = new JLabel("Enter the Word Here : ");
        wordDisplay.setFont(new Font("Arial", 1,16));
        wordDisplay.setBounds(40, 60, 400, 25);

        JTextField wordtoDelete = new JTextField();
        wordtoDelete.setBounds(40, 100, 400, 40);

        result = new JLabel();
        result.setBounds(90, 330, 400, 100);
        result.setFont(new Font("Arial", 1, 20));


        JLabel meaning = new JLabel("Enter the Meaning Here : ");
        meaning.setFont(new Font("Arial",1,16));
        meaning.setBounds(40, 150, 400, 30);
        deleteFrame.add(meaning);

        JTextField smeaning = new JTextField();
        smeaning.setBounds(40, 180, 400, 40);
        smeaning.setAutoscrolls(true);
        deleteFrame.add(smeaning);

        JButton delete = new JButton("Delete");
        delete.setFont(new Font("Arial", 1, 16));
        delete.setBounds(200, 250, 100, 40);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String removeword = wordtoDelete.getText();
                removeword = removeword.toLowerCase();

                try {
                    dictionaryManagement.insertFromFile();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DeleteWordFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                if(removeword.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"You must fill correct information!", "Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(!dictionaryManagement.wordExists(removeword))
                {
                    JOptionPane.showMessageDialog(null,"This word is not in dictionary. Please fill in the correct information","Error",JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(null, "The word removed successfully!");

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


        JButton exit5 = new JButton("Exit");
        exit5.setBounds(10, 10, 50, 40);
        exit5.setLayout(new BorderLayout());
        exit5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DictionaryApplication f = new DictionaryApplication();
                deleteFrame.setVisible(false);
                exit5.setVisible(true);
                f.frame.setVisible(true);

            }
        });
        deleteFrame.add(exit5,BorderLayout.SOUTH);

        deleteFrame.add(wordDisplay);
        deleteFrame.add(wordtoDelete);
        deleteFrame.add(delete);
        deleteFrame.add(result);
    }*/

    JButton exit;
    JButton deleteButon;
    JButton yes;
    JButton no;
    JTextField wordtoDelete;
    JLabel enter;
    JLabel sure;
    JLabel error;
    JLabel success;

    public Delete() {
        setTitle("DELETE");
        getContentPane().setBackground(new Color(254	,235	,208));
        setBounds(300,120,500,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        exit = new JButton("exit");
        exit.setForeground(new Color(0,0,0));
        exit.setBounds(10,10,60,30);
        add(exit);

        deleteButon = new JButton("DELETE");
        deleteButon.setBounds(190,250,90,40);
        deleteButon.setFont(new Font("Arial",1,13));
        add(deleteButon);

        enter = new JLabel("Enter the word to delete:");
        enter.setFont(new Font("Arial",1,16));
        enter.setBounds(30,120,300,40);
        add(enter);

        wordtoDelete = new JTextField();
        wordtoDelete.setFont(new Font("Arial",1,16));
        wordtoDelete.setBounds(30,180,430,40);
        add(wordtoDelete);

        /**JLabel sure = new JLabel("Are you sure ?");
        sure.setFont(new Font("Arial",1,16));
        sure.setBounds(200,340,400,40);
        add(sure);
        sure.setVisible(false);*/

        yes = new JButton("Yes");
        yes.setFont(new Font("Arial",1,16));
        yes.setBounds(100,430,120,40);
        yes.setVisible(false);
        add(yes);

        no = new JButton("No");
        no.setBounds(300,430,120,40);
        no.setFont(new Font("Arial",1,16));
        no.setVisible(false);
        add(no);

        error = new JLabel("Error!!");
        error.setBounds(250,200,300,100);
        error.setFont(new Font("Arial",1,16));
        add(error);
        error.setVisible(false);

        success = new JLabel("Delete Success");
        success.setFont(new Font("Arial",1,16));
        success.setBounds(150,200,400,100);
        add(success);
        success.setVisible(false);

        deleteButon.setVisible(true);
        enter.setVisible(true);
        wordtoDelete.setVisible(true);
        exit.setVisible(true);


        deleteButon.addActionListener(e->{
            sure.setVisible(true);
            yes.setVisible(true);
            no.setVisible(true);
            wordtoDelete.setVisible(true);
        });

        /**yes.addActionListener(e -> {
            wordtoDelete.setText("");
            deleteButon.setVisible(false);
            enter.setVisible(false);
            wordtoDelete.setVisible(false);
            exit.setVisible(false);
            yes.setVisible(false);
            no.setVisible(false);
            wordtoDelete.setEditable(true);
        });

        no.addActionListener(e -> {
            sure.setVisible(false);
            yes.setVisible(false);
            no.setVisible(false);
            wordtoDelete.setEditable(true);
        });*/


    }
}

