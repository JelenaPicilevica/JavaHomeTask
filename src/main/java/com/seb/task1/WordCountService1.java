package com.seb.task1;

import java.util.ArrayList;
import java.util.List;

    public class WordCountService1 {

        public List<String> findWordsInText(String text, List<String> vocabularyWords) {

            List<String> wordsFoundInText = new ArrayList<>();

            for (int i = 0; i < vocabularyWords.size(); i++) {

                if (text.contains(vocabularyWords.get(i))) {
                    wordsFoundInText.add(vocabularyWords.get(i));

                    text = text.replaceFirst(vocabularyWords.get(i), "");
                    //System.out.println("Input change when word '" + vocabularyWords.get(i) + "' was found: " + text);
                }
            }

            return wordsFoundInText;
        }

    }
