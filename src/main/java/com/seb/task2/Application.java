package com.seb.task2;

import java.io.IOException;
import java.util.List;

    /*
    MY INTERPRETATION OF TASK (interpreted in such way according to the given example):
    - We read vocabulary words from the file and put them into the list.
    - If word from the list is found in user input => counting it as found word and taking
      out this word (substring) from User input String


    HINT:
    - Try to enter this text for case-sensitive and ignore case search to see the difference:
      AfeSEBgrisdgreAtrsdvPlAcE
    - To read from the example file, please change file name to input.txt in line 28 (path is the same)
     */

public class Application {

    public static void main(String[] args) throws IOException {

        UserInputService userInputService = new UserInputService();
        String userText = userInputService.getUserText();
        boolean caseSensitivity = userInputService.caseSensitivityCheck();

        FileReader fileReader = new FileReader();
        List<String> vocabularyWords = fileReader.readFileAndAddWordsToTheList("src/main/resources/input2.txt");
        System.out.println("\nList of words from vocabulary: " + vocabularyWords);

        WordCountService wordCountService = new WordCountService();
        List<String> foundWords = wordCountService.findWordsInText(userText, caseSensitivity, vocabularyWords);
        System.out.println("Words found: " + foundWords);
        System.out.println("Number of words found: " + foundWords.size());

    }

}