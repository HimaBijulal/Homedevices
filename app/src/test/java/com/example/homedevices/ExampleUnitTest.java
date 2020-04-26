package com.example.homedevices;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void Name_isCorrect() {
        assertFalse(User.isValidName("abcabcabvabksjhhahdashdkashdkshdjshkahdahshdhkhkhhashasjhdaksjdhshkashdksdhjhkahdkajhakjhjdh"));
        assertFalse(User.isValidName("abc3"));
        assertTrue(User.isValidName("Jim Smith"));

    }
    @Test
    public void ID_isCorrect() {
        assertFalse(User.isValidID("12345"));
        assertFalse(User.isValidID("123456789123456"));
        assertFalse(User.isValidID("12345678912345a"));
        assertTrue(User.isValidID("12345678912345"));

    }
    @Test
    public void Phone_isCorrect() {
        assertFalse(User.isValidPhoneNum("12345"));
        assertFalse(User.isValidPhoneNum("123456789a"));
        assertTrue(User.isValidPhoneNum("1234567899"));

    }
    @Test
    public void Email_isCorrect(){
        assertFalse(User.isValidEmail("ajkk.com"));
        assertFalse(User.isValidEmail("ajk@gmail"));
        assertTrue(User.isValidEmail("ajk@gmail.com"));
    }
    @Test
    public void Username_isCorrect(){
        assertFalse(User.isValidUsername("jjkkskskskskskskskskskskskskskskssksksksksksksksksksksksksksdksdkjdjkkjdkjdkdkjd345"));
        assertFalse(User.isValidUsername("12345678912345$$6"));
        assertFalse(User.isValidUsername("12345678912asd345a"));
        assertTrue(User.isValidUsername("123456789cxvx12345"));
    }
    @Test
    public void Password_isCorrect(){
        assertFalse(User.isValidPassword("ajkkco"));
        assertFalse(User.isValidPassword("ajk312345lsdkdksjflskdfj34987928742jdfhhf928ur8jbskjbfkjfbkjsdbfdfsdfdsfsfdsl"));
        assertTrue(User.isValidPassword("ajk3gmailrt$"));

    }






}