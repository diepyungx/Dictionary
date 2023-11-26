package org.example;

import org.example.Dictionary;
import org.example.DictionaryManagement;
import org.example.Word;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommanline {
    public DictionaryManagement dic = new DictionaryManagement();

    public DictionaryCommanline() {

    }

    /**
     * showAllWords.
     */
    public String showAllWords() throws FileNotFoundException {

        int count = 1;
        String d = "No\t|\t" + "English\t|\tVietnamese";
        for (int i = 0; i < dic.dic.wordList.size() ; i++) {
            Word word = dic.dic.wordList.get(i);
            d += "\n" + count + "\t|\t" + word.getWord_target()
                    + "\t\t|\t\t" + word.getWord_explain();
            count++;
        }

        System.out.println(d);
        dic.insertFromFile();
        return d;
    }

    /**
     * dictionaryBasic.
     */
    public void dictionaryBasic() throws FileNotFoundException {
        DictionaryManagement w = new DictionaryManagement();
        System.out.println("1 - insertFromCommandline");
        System.out.println("2 - showAllWords");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            w.insertFromCommandline();
        } else if (n == 2) {
            showAllWords();
        } else {
            System.out.println("Đăng xuất");
            return;
        }
        dictionaryBasic();
    }

    /**
     * dictionaryAdvanced
     */
    public void dictionaryAdvanced () throws IOException {
        System.out.println("0 - thoát ứng dụng ");
        System.out.println("1 - thêm từ ");
        System.out.println("2 - xóa từ ");
        System.out.println("3 - sửa từ ");
        System.out.println("4 - hiển thị danh sách các từ ");
        System.out.println("5 - tra cứu ");
        System.out.println("6 - tìm kiếm");
        System.out.println("7 - truy cập phần game");
        System.out.println("8 - nhập danh sách từ vựng từ tệp");
        System.out.println("9 - xuất danh sách từ vựng từ tệp");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println("Đăng xuất");
        }
        else if (n == 1) {
            dic.addNewWord("","");
        }
        else if (n == 2) {
            dic.removeWord("");
        }
        else if (n == 3) {
            dic.editWord("","", "", "");
        }
        else if (n == 4) {
            showAllWords();
        }
        else if (n == 5) {
            dic.dictionaryLookup("");
        }
        else if (n == 6) {
            dic.dictionarySearcher("");
        }
        else if (n == 7) {
            System.out.println("truy cập phần game");
        }
        else if (n == 8) {
            dic.insertFromFile();
        }
        else if (n == 9) {
            dic.dictionaryExportToFile("C:\\Users\\Admin\\IdeaProjects\\Hi\\src\\main\\java\\org\\example\\dictionaries.txt");
        } else {
            System.out.println("“Action not supported");
            return;
        }
        dictionaryAdvanced();
    }
}
