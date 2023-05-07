package com.seb.task2;

import java.util.ArrayList;
import java.util.List;

public class WordCountService {

    public List<String> findWordsInText(String text, boolean caseSensitivity,
                                        List<String> vocabularyWords) {

        List<String> wordsFoundInText = new ArrayList<>();

        if (caseSensitivity) {
            for (int i = 0; i < vocabularyWords.size(); i++) {
                if (text.contains(vocabularyWords.get(i))) {
                    wordsFoundInText.add(vocabularyWords.get(i));
                    text = text.replaceFirst(vocabularyWords.get(i), "");
                    //System.out.println("Input change when word '" + vocabularyWords.get(i) + "' was found: " + text);
                }
            }
        } else {
            for (int i = 0; i < vocabularyWords.size(); i++) {
                if (text.toLowerCase().contains(vocabularyWords.get(i).toLowerCase())) {
                    wordsFoundInText.add(vocabularyWords.get(i));
                    text = text.toLowerCase().replaceFirst(vocabularyWords.get(i).toLowerCase(), "");
                    //System.out.println("Input change when word '" + vocabularyWords.get(i) + "' was found: " + text);
                }
            }
        }
        return wordsFoundInText;
    }

}
