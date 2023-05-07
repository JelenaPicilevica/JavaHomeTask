package com.seb.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public List<String> readFileAndAddWordsToTheList(String path) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(path));
        List<String> vocabularyWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                .collect(Collectors.toList());
        lines.close();

        return vocabularyWords;
    }

}
