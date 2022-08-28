package com.javarush.echo.nikolaymelnikov.project03;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Block {
    private String id;
    private String text;
    private Answer[] next;

    public String prepareForHtml() {
        return text.replace("\n\n", "<br>");
    }

    public String showAnswers() {
        StringBuilder sb = new StringBuilder();
        Arrays.asList(next).forEach(answer -> sb.append("<p><input type=\"radio\" name=\"id\" value=" + answer.getId() + ">" + answer.getText() + "</p><br>"));
        sb.append("<p><input type=\"submit\"></p>");
        return sb.toString();
    }
}
