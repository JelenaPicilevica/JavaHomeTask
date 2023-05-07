package com.seb.task2;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    FileReader fileReader = new FileReader();


    //1. Reading from file (where several words are located in one line) and putting words into the list
    @Test
    void wordsThisIsATestFromInputFileShouldBeAddedToTheListAndReturned() throws IOException {

        List<String> vocabularyWords = new ArrayList<>();
        vocabularyWords.add("This");
        vocabularyWords.add("is");
        vocabularyWords.add("a");
        vocabularyWords.add("test");

        assertEquals(vocabularyWords, fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt"));
    }


    //2. Reading from file where each word/letter is located on a separate line and putting words into the list
    @Test
    void abcFromInputFileShouldBeAddedToTheListAndReturned() throws IOException {

        List<String> vocabularyWords = new ArrayList<>();
        vocabularyWords.add("a");
        vocabularyWords.add("b");
        vocabularyWords.add("c");

        assertEquals(vocabularyWords,fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting2.txt"));
    }

    //3. Reading non-existing file
    @Test
    void nonExistingFileShouldReturnFileNotFoundException(){

        assertThrows(IOException.class, () ->
        {
            fileReader.readFileAndAddWordsToTheList("src/test/java/resources/nonExistingFile.txt");
        });
    }


}