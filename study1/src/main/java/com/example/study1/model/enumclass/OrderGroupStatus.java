package com.example.study1.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderGroupStatus {

    REGISTERED(0,"등록","등록 상태"),
    UNREGISTERED(1, "해지","해지 상태")
    ;

    private Integer id;
    private String title;
    private String description;
}
