package com.example.practice.password;

import com.example.practice.password.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("비밀번호를 초기화한다.")
    @Test
    void initializePassword() {
        // given
        User user = new User();

        // when
        user.initPassword(() -> "abcdefgh");

        // then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("비밀번호가 요구 사항에 부합하지 않아 초기화에 실패한다.")
    @Test
    void failToInitializePassword() {
        // given
        User user = new User();

        // when
        user.initPassword(() -> "abcdefg");

        // then
        assertThat(user.getPassword()).isNull();
    }

}