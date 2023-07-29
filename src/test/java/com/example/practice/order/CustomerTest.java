package com.example.practice.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CustomerTest {

    @DisplayName("메뉴 이름에 해당하는 요리를 주문한다.")
    @Test
    void orderTest() {
        Customer customer = new Customer();
        Menu menu = new Menu(
                List.of(new MenuItem("돈까스", 5000),
                        new MenuItem("냉면", 7000))
        );
        Chef chef = new Chef();

        assertThatCode(() -> customer.order("돈까스", menu, chef))
                .doesNotThrowAnyException();
    }

}
