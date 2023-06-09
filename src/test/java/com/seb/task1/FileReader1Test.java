package com.seb.task1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReader1Test {

    FileReader1 fileReader = new FileReader1();


    //1. Reading from file (where several words are located in one line) and putting words into the list
    @Test
    void wordsThisIsATestFromInputFileShouldBeAddedToTheListAndReturned() throws IOException {

        List<String> vocabularyWords = List.of("This", "is", "a", "test");
        assertEquals(vocabularyWords, fileReader.readFileAndAddWordsToTheList("src/test/resources/fileForTesting.txt"));
    }


    //2. Reading from file where each word/letter is located on a separate line and putting words into the list
    @Test
    void abcFromInputFileShouldBeAddedToTheListAndReturned() throws IOException {

        List<String> vocabularyWords = List.of("a", "b", "c");
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