package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class DictionaryManagement {
    public Dictionary dic = new Dictionary();
    Word word = new Word();

    /**
     * insertFromCommandline.
     */
    public void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng từ vựng muốn thêm: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < n ;i ++) {
            System.out.println("Nhập từ vựng tiếng anh: ");
            String english = scanner.nextLine();
            System.out.println("Nhập nghĩa tiếng việt: ");
            String vietnamese = scanner.nextLine();
            Word word = new Word(english, vietnamese); //tạo đối tượng word
            dic.wordList.add(word);
        }
    }

    /**
     * insertFromFile.
     */
    public void insertFromFile() throws FileNotFoundException {
        Scanner file = new Scanner(new File("C:\\Users\\Admin\\Favorites\\Downloads\\Hi\\src\\main\\java\\org\\example\\dictionaries.txt"));
        while (file.hasNext()) {
         String w = file.nextLine();
         Scanner s = new Scanner(w).useDelimiter("\t\t");
            Word word_ = new Word();
            word_.setWord_target(file.nextLine());
            word_.setWord_explain(file.nextLine());
            dic.wordList.add(word_);
        }

    }

    public void updateWord(String word, String mean) {
        String s = "";
        int indexToUpdate = -1;
        for (int i = 0; i < dic.wordList.size(); i++) {
            if (word.equals(dic.wordList.get(i).getWord_target())) {
                indexToUpdate = i;
                break;
            }
        }

        if (indexToUpdate != -1) {
            if (!word.isEmpty()) {
                dic.wordList.get(indexToUpdate).setWord_target(word);
            }

            if (!s.isEmpty()) {
                dic.wordList.get(indexToUpdate).setWord_explain(
                        dic.wordList.get(indexToUpdate).getWord_explain() + "/   " + s
                );
            }
        } else {
            System.out.println("Word not found in the dictionary.");
        }
    }


    /**
     * ExportToFile.
     */
     public void dictionaryExportToFile(String s) throws IOException {
         File file = new File(s);
         if(!file.exists()){
             try {
                 file.createNewFile();
             } catch (IOException ex) {
                 throw new RuntimeException(ex);
             }
         }
         if (file.createNewFile()) {
             System.out.println("File is created!");
         } else {
             System.out.println("File already exists.");
         }
         FileWriter writer = new FileWriter(file);

         for (int i = 0; i < dic.wordList.size(); i++) {
             String d = i+1 + "  " + dic.wordList.get(i).getWord_target()
                     + "   " + dic.wordList.get(i).getWord_explain() + "\n";
             writer.write(d);
         }
         writer.close();

     }

    /**
     * addNewWord.
     */
    public boolean addNewWord(String target, String explain) {
        boolean check = false;

        for (int i = 0; i < dic.wordList.size(); i++) {
            if (target.equals(dic.wordList.get(i).getWord_target()) && explain.equals(dic.wordList.get(i).getWord_explain())) {
                check = true;
            }
        }
        if (!check) {
            Word newWord = new Word();
            newWord.setWord_target(target);
            newWord.setWord_explain(explain);
            dic.wordList.add(newWord);

        }


        System.out.println(check);
        return check;
    }


    /**
     * removeWord
     */
    public void removeWord(String wordToDelete) {

        for (int i = 0; i < dic.wordList.size(); i++) {
            if (wordToDelete.equals(dic.wordList.get(i).getWord_target())) {
                dic.wordList.remove(i);
                return;
            }
        }
        System.out.println("Không tồn tại từ cần xóa!!");
    }

    /**
     * editWord
     */

    public void editWord(String eword, String emeaning, String editedWord, String editedMeaning) {
        for (int i = 0; i < dic.wordList.size(); i++) {
            Word word = dic.wordList.get(i);
            if (word.getWord_target().equals(eword) && word.getWord_explain().equals(emeaning)) {
                word.setWord_target(editedWord);
                word.setWord_explain(editedMeaning);
                break;
            }
        }
        Word editedList = new Word(editedWord, editedMeaning);
        dic.wordList.add(editedList);
        System.out.println("Sửa từ thành công!!!");
    }



    /**
     * dictionaryLookup.
     */
    public String dictionaryLookup(String lookup) {
        boolean check = true;
        for (int i = 0; i < dic.wordList.size(); i++) {
            String word = dic.wordList.get(i).getWord_target();
            String mean = dic.wordList.get(i).getWord_explain();
            if (word.contains(lookup) || mean.contains(lookup)) {
                check = false;
                return word + "\t\t|\t\t" + mean;
            }
        }
        if (check) {
            return "Từ bạn cần tra không tồn tại!!!";
        }
        return lookup;
    }

    /** . */
    public void dictionarySearcher(String prefix) {
        dic.getWordList();
        List<String> searchWords = new ArrayList<>();
        for (int i = 0; i < searchWords.size(); i++) {
            String word = searchWords.get(i);
            if (word.startsWith(prefix)) {
                searchWords.add(prefix);
            }
        }
        for (int i = 0; i < searchWords.size(); i++) {
            String word = searchWords.get(i);
            System.out.println("Các từ cần tìm la : \n");
            System.out.println(word);
        }
    }

    /**
     * dictionaryAdvanced.
     */
    public void dictionaryAdvanced() throws IOException {
        insertFromFile();
        dictionaryLookup("");
    }

    public boolean wordExists(String target) {
        for (Word word : dic.wordList) {
            if (word.getWord_target().equalsIgnoreCase(target)) {
                return true;
            }
        }
        return false;
    }
}
