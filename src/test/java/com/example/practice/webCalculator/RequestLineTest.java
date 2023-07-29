package com.example.practice.webCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RequestLineTest {

    @Test
    void create() {
        RequestLine requestLine = new RequestLine(
                "GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1"
        );

        assertThat(requestLine)
                .isEqualTo(new RequestLine(
                        "GET",
                        "/calculate",
                        "operand1=11&operator=*&operand2=55"
                ));
    }

}
