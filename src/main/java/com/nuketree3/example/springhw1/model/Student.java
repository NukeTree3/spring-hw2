package com.nuketree3.example.springhw1.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Student {

    private Long id;

    private String name;

    private String groupName;

    @JsonCreator
    public Student(Long id, String name, String groupName) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
    }
}
