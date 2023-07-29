package com.example.practice.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MenuItemTest {

    @DisplayName("메뉴 항목을 생성한다.")
    @Test
    void createMenuItem() {
        assertThatCode(() -> new MenuItem("만두", 5000))
                .doesNotThrowAnyException();
    }

}
