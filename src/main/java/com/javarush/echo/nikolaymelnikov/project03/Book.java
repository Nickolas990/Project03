package com.javarush.echo.nikolaymelnikov.project03;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.sampled.AudioFormat;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

@Getter
@Setter
public class Book implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger("rollingFile");
    private String title;
    private Block[] blocks;

    public static Book initialize(String journey) {
        ObjectMapper objectMapper = new ObjectMapper();
        Book book = null;
        try {
            book = objectMapper.readValue(new BufferedReader(new InputStreamReader(getFileFromResource("books/" + journey), StandardCharsets.UTF_8)), Book.class);
        } catch (IOException | URISyntaxException e) {
            logger.error(e + " There was a problem with the *.json file. Check that it is in the settings root directory and matches the your class");
            new RuntimeException(e + " There was a problem with the *.json file. Check that it is in the settings root directory and matches the your class");
        }
        return book;
    }

    public Block getBlockById(String id) {
        for (Block block : blocks) {
            if (block.getId().equals(id)){
                return block;
            }
        }

        throw new IllegalArgumentException("No such block found");
    }

    public void showAnswersById(String id) {
        Answer[] answers = getBlockById(id).getNext();
    }
    private static InputStream getFileFromResource(String filename) throws URISyntaxException {
        InputStream resource = Book.class.getClassLoader().getResourceAsStream(filename);
        if (resource == null) {
            throw new IllegalArgumentException("File LiftToNowhere.json not found");
        } else {
            return resource;
        }
    }
}