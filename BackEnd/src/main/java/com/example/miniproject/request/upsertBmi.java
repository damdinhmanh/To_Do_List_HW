package com.example.miniproject.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class upsertBmi {
    private int height;
    private int weight;
}
