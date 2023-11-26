package Data;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class ListWordDatabase {
    private List<Object[]> wordList;
    private JFrame frame;
    private JTable table;

    public ListWordDatabase(List<Object[]> wordList) {
        frame = new JFrame("List Of Words");
        frame.getContentPane().setBackground(new Color(254, 235, 208));
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("List Of Words In Dictionary");

        table = new JTable();
        frame.add(new JScrollPane(table));

        if (wordList != null && !wordList.isEmpty()) {
            loadWordListFromData(wordList);
        } else {
            JOptionPane.showMessageDialog(frame, "No results found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }

        frame.setVisible(true);
    }

    public void loadWordListFromData(List<Object[]> wordList) {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("id_words");
        columnNames.add("Words");
        columnNames.add("Meaning");

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Object[] wordData : wordList) {
            int id = (int) wordData[0];
            String word = (String) wordData[1];
            String meaning = (String) wordData[2];

            model.addRow(new Object[]{id, word, meaning});
        }

        table.setModel(model);
    }

    public static void main(List<Object[]> wordList) {
        SwingUtilities.invokeLater(() -> new ListWordDatabase(wordList));
    }
    public static void setWordList(List<Object[]> list) {
    }
    public boolean deleteWord(String wordToDelete) {
        for (Object[] wordData : wordList) {
            String word = (String) wordData[1]; // Assuming index 1 contains the word
            if (word.equals(wordToDelete)) {
                wordList.remove(wordData);
                return true; // Word found and deleted
            }
        }
        return false; // Word not found
    }
}

