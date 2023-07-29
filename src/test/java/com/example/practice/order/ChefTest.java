package com.example.practice.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ChefTest {

    @DisplayName("메뉴에 해당하는 음식을 만든다.")
    @Test
    void cookingTest() {
        Cooking cooking = new Cooking();
        MenuItem menuItem = new MenuItem("돈까스", 5000);
        Cook cook = cooking.cook(menuItem);

        assertThat(cook).isEqualTo(new Cook("돈까스", 5000));
    }

}
