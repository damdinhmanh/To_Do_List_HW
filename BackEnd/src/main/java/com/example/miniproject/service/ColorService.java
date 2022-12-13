package com.example.miniproject.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ColorService {
    public String randomColor(int type) {
        return switch (type) {
            case 1 -> randomColorName();
            case 2 -> randomHexColor();
            case 3 -> randomRGBColor();
            default -> throw new RuntimeException("Type not supported");
        };
    }

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

    public String randomColorName() {
        List<String> colors = List.of("black", "blue", "green", "white");
        int id = getRandomNumber(0, colors.size());

        return colors.get(id);
    }

    public String randomHexColor() {
        List<String> colors = List.of("#f44336", "#2196f3", "#607d8b");
        int id = getRandomNumber(0, colors.size());

        return colors.get(id);
    }

    public String randomRGBColor() {
        Random rd = new Random();
        int r = rd.nextInt(256);
        int g = rd.nextInt(256);
        int b = rd.nextInt(256);
        return "rgb(" + r + "," + g + "," + b +")";
    }
}
