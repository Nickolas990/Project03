package com.javarush.echo.nikolaymelnikov.project03;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Block {
    private String id;
    private String text;
    private Answer[] next;
}
