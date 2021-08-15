package com.practica.pokerest.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Pokemon implements Serializable {

    private String name;
    private String url;
}
