package com.example.mvcPractice;

import com.example.practice.PasswordValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PasswordValidatorTest {

    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 정상 실행된다.")
    @Test
    void validatePasswordTest_success() {
        assertThatCode(() -> PasswordValidator.validate("passwooord"))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자를 초과하는 경우 예외가 발생한다.")
    @Test
    void validatePasswordTest_throw_exception() {
        assertThatCode(() -> PasswordValidator.validate("pwd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 8자 이상 12자 이하여야 합니다.");
    }
}
