package com.example.miniproject;

import com.example.miniproject.service.ColorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MiniProjectApplicationTests {
    @Autowired
    private ColorService colorService;

    @Test
    void contextLoads() {
    }

    @Test
    void test_randomRgbColor() {
        String rs = colorService.randomRGBColor();

        assertThat(rs).isNotNull();
        assertThat(rs).startsWith("rgb");
    }
}
