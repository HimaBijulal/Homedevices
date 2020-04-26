package com.example.homedevices;
import com.google.common.truth.Truth.assertThat;
import org.junit.Test;
public class TestClass  {
    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertThat(EmailValidator.isValidEmail("name@email.com")).isTrue();
    }
}
