package com.seb.task1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordCountService1Test {

    //1ST TASK => ONLY CASE-SENSITIVE SEARCH (USER HAS NO OPTION TO CHANGE IT)

    WordCountService1 wordCountService = new WordCountService1();
    FileReader1 fileReader = new FileReader1();


    // 1. COUNTING VOCABULARY WORDS IN TEXT


    //1.1. Counting vocabulary words in text (several) and return number of words
    @Test
    void numberOfFoundWordsShoulBeEqual2() throws IOException {

        List<String> wordsFoundInText = wordCountService.findWordsInText("ThISggabfdftest", fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt"));
        assertEquals( 2, wordsFoundInText.size());
    }


    //1.2. Counting vocabulary words in text (one) and return number of words
    @Test
    void numberOfFoundWordsShouldBeEqual1() throws IOException {

        List<String> wordsFoundInText = wordCountService.findWordsInText("ThISggbfdftest", fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt"));
        assertEquals(1, wordsFoundInText.size());
    }


    //1.3. Counting vocabulary words in text and return number of words when NO words found
    @Test
    void numberOfFoundWordsShoulBeEqual0() throws IOException {

        List<String> wordsFoundInText = wordCountService.findWordsInText("XyZtqAhTEsT", fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt"));
        assertEquals(0,wordsFoundInText.size());
    }


    //1.4. Counting vocabulary words in text when user input text contains 3 words, but actually
    // only 2 should be returned due to taking of a substring with found word
    // (In file: sun, glass, sunglasses)
    @Test
    void numberOfFoundWordsShoulBeEqual2DueToSubstringExtraction() throws IOException {

        List<String> wordsFoundInText = wordCountService.findWordsInText("sunglasses", fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting3.txt"));
        assertEquals(2, wordsFoundInText.size());
    }


    // 2. FINDING VOCABULARY WORDS IN TEXT (INCLUDED IN OUR COUNT)


    //2.1. Finding vocabulary words in text (several) and putting them into the List
    @Test
    void wordsIsTestFromInputFileShouldBeFoundInTextAndAddedToTheList() throws IOException {

        List<String> vocabularyWords = List.of("is", "test");
        assertEquals(vocabularyWords, wordCountService.findWordsInText( "ishtrhyerTHISfrgtestqeeq", fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt")));
    }


    //2.2. Finding vocabulary words in text (one) and putting it into the List
    @Test
    void wordTestFromInputFileShouldBeFoundInTextAndAddedToTheList() throws IOException {

        List<String> vocabularyWords = List.of("test");
        assertEquals(vocabularyWords, wordCountService.findWordsInText( "htrhyerTHISfrgtestqeeq", fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt")));
    }


    // 2.3. Finding vocabulary words in text when user input contains NO vocabulary words (result => empty List)
    @Test
    void noWordsFromInputFileShouldBeFoundInTextAndAddedToTheList() throws IOException {

        List<String> vocabularyWords = new ArrayList<>();
        assertEquals(vocabularyWords, wordCountService.findWordsInText( "fruuytrtTESTnhyhTHIs", fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt")));
    }

    //2.4. Finding vocabulary words in text when user input text contains 3 words, but actually
    // only 2 should be returned due to taking of a substring with found word
    // (In file: sun, glass, sunglasses)

    @Test
    void wordsSunGlassFromInputFileShouldBeFoundInTextAndAddedToTheList() throws IOException {

        List<String> vocabularyWords = List.of("sun", "glass");
        assertEquals(vocabularyWords, wordCountService.findWordsInText( "sunglasses", fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting3.txt")));
    }



}