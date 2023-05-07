package com.seb.task1;

import java.io.IOException;
import java.util.List;

/*
  MY INTERPRETATION OF TASK (interpreted in such way according to the given example):
  - We read vocabulary words from the file and put them into the list.
  - If word from the list is found in user input => counting it as found word and taking
    out this word (substring) from User input String

  HINT:
  - Try to enter this text (it will be case-sensitive search):
    afeSEBgrisdgreatrsdvPlAcE
  - To read from the example file, please change file name to input.txt in line 26 (path is the same)
 */

public class Application1 {

    public static void main(String[] args) throws IOException {

        UserInputService1 userInput = new UserInputService1();
        String userText = userInput.getUserText();

        FileReader1 fileReader = new FileReader1();
        List<String> vocabularyWords = fileReader.readFileAndAddWordsToTheList("src/main/resources/input2.txt");
        System.out.println("\nList of words from vocabulary: " + vocabularyWords);

        WordCountService1 wordCountService = new WordCountService1();
        List<String> foundWords = wordCountService.findWordsInText(userText, vocabularyWords);
        System.out.println("Words found: " + foundWords);
        System.out.println("Number of words found: " + foundWords.size());


    }
}