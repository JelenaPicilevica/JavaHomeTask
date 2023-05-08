package com.seb.task2;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordCountServiceTest {

    WordCountService wordCountService = new WordCountService();
    FileReader fileReader = new FileReader();



    //1. COUNTING DICTIONARY WORDS

    //1.1. Counting vocabulary words in text and return number of words (Case-sensitive)
    @Test
    void numberOfFoundWordsShoulBeEqual2() throws IOException {

        List<String> wordsFoundInText = wordCountService.findWordsInText("ThISggabfdftest", true, fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt"));
        assertEquals( 2, wordsFoundInText.size());
    }


    //1.2. Counting vocabulary words in text and return number of words (Ignore case)
    @Test
    void numberOfFoundWordsShoulBeEqual3() throws IOException {

        List<String> wordsFoundInText = wordCountService.findWordsInText("ThISggabfdftest", false, fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt"));
        assertEquals (3, wordsFoundInText.size());
    }


    //1.3. Counting vocabulary words in text and return 0 when NO words found due to case-sensitivity (!)
    @Test
    void numberOfFoundWordsShoulBeEqual0DueToCase() throws IOException {

        List<String> wordsFoundInText = wordCountService.findWordsInText("XyZtqAhTEsT", true, fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt"));
        assertEquals(0, wordsFoundInText.size());
    }


    //1.4. Counting vocabulary words in text and return 0 when NO words found at all (ignore case)
    @Test
    void numberOfFoundWordsShoulBeEqual0NotCaseSensitive() throws IOException {

        List<String> wordsFoundInText = wordCountService.findWordsInText("XyZtqhThsTs", false,  fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt"));
        assertEquals( 0, wordsFoundInText.size());
    }


    //1.5. Counting vocabulary words in text when user input text contains 3 words, but actually
    // only 2 should be returned due to taking of a substring with found word (CASE-SENSITIVE)
    // (In file: sun, glass, sunglasses)

    @Test
    void numberOfFoundWordsShoulBeEqual2DueToSubstringExtraction() throws IOException {

        List<String> wordsFoundInText = wordCountService.findWordsInText("sunglasses", true, fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting3.txt"));

        assertEquals(2, wordsFoundInText.size());
    }


    //1.6. Counting vocabulary words in text when user input text contains 3 words, but actually
    // only 2 should be returned due to taking of a substring with found word (NOT CASE-SENSITIVE)
    // (In file: sun, glass, sunglasses)

    @Test
    void numberOfFoundWordsShoulBeEqual2DueToSubstringExtractionIgnoreCase() throws IOException {

        List<String> wordsFoundInText = wordCountService.findWordsInText("SUNglasses", false, fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting3.txt"));

        assertEquals(2, wordsFoundInText.size());
    }



    //2. FINDING DICTIONARY WORDS IN TEXT (THAT ARE INCLUDED IN OUR COUNT)


    //2.1 Finding words in text an putting them into the list (CASE IS IGNORED)
    @Test
    void wordsThisTestFromInputFileShouldBeFoundInTextAndAddedToTheList() throws IOException {

        List<String> vocabularyWords = new ArrayList<>();
        vocabularyWords.add("This");
        vocabularyWords.add("test");

        assertEquals(vocabularyWords,wordCountService.findWordsInText( "htrhyerTHISfrgTeSt", false, fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt")));
    }


    //2.2 Finding words in text and putting them into the list (CASE SENSITIVE)

    @Test
    void wordTestFromInputFileShouldBeFoundInTextAndAddedToTheList() throws IOException {

        List<String> vocabularyWords = new ArrayList<>();
        vocabularyWords.add("test");

        assertEquals(vocabularyWords, wordCountService.findWordsInText( "htrhyerTHISfrgtestqeeq", true, fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt")));
    }


    // 2.3. Finding vocabulary words in text when user input contains NO vocabulary words due to
    // case-sensitivity (result => empty List)
    @Test
    void noWordsFromInputFileShouldBeFoundInTextAndAddedToTheListDueToCase() throws IOException {

        List<String> vocabularyWords = new ArrayList<>();
        assertEquals(vocabularyWords, wordCountService.findWordsInText( "ThIsIsATEsTnhyhTHIs", true, fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt")));
    }


    // 2.4. Finding vocabulary words in text when user input contains NO vocabulary words at all
    // (result => empty List)
    @Test
    void noWordsFromInputFileShouldBeFoundInTextAndAddedToTheList() throws IOException {

        List<String> vocabularyWords = new ArrayList<>();
        assertEquals(vocabularyWords, wordCountService.findWordsInText( "xYzAfhdrqRyi", true, fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt")));
    }


    //2.5. Finding vocabulary words in text when user input text contains 3 words, but actually
    // only 2 should be returned due to taking of a substring with found word  (CASE-SENSITIVE)
    // (In file: sun, glass, sunglasses)

    @Test
    void wordsSunGlassFromInputFileShouldBeFoundInTextAndAddedToTheList() throws IOException {

        List<String> vocabularyWords = new ArrayList<>();
        vocabularyWords.add("sun");
        vocabularyWords.add("glass");

        assertEquals(vocabularyWords, wordCountService.findWordsInText( "sunglasses", true, fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting3.txt")));
    }

    //2.6. Finding vocabulary words in text when user input text contains 3 words, but actually
    // only 2 should be returned due to taking of a substring with found word  (NOT CASE-SENSITIVE)
    // (In file: sun, glass, sunglasses)

    @Test
    void wordsSunGlassFromInputFileShouldBeFoundInTextAndAddedToTheList2() throws IOException {

        List<String> vocabularyWords = new ArrayList<>();
        vocabularyWords.add("sun");
        vocabularyWords.add("glass");

        assertEquals(vocabularyWords, wordCountService.findWordsInText( "SUNglasses", false, fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting3.txt")));
    }




}