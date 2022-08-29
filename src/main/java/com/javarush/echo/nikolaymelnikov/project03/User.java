package com.javarush.echo.nikolaymelnikov.project03;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private String currentID;
    private String lastChoice;
    private int quantityOfTries;
    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}
