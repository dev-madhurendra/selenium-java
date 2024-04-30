package com.devmadhurendra.utils;

public interface SeleniumConstants {
    String URL = "https://leetcode.com/";
    String LOGIN_ELEMENT = "a[href='/accounts/login/']";
    String LOGIN_EMAIL_INPUT_FIELD = "input[name='login']";
    String LOGIN_PASSWORD_INPUT_FIELD = "input[name='password']";
    String LOGIN_EMAIL_INPUT_FIELD_VALUE = "dev-madhurendra";
    String LOGIN_PASSWORD_INPUT_FIELD_VALUE = "Madhu#786";
    String SIGN_IN_BUTTON_CLASS_NAME = "//*[@id='signin_btn']";
    String PROFILE_ELEMENT = "navbar_user_avatar";
    String USER_NAME_ELEMENT = "a[href='/dev-madhurendra']";
    String LEETCODE_PROBLEM_SET = "a[href='/problemset']";
    String PICK_ONE = "//*[@id='__next']/div[1]/div[4]/div[2]/div[1]/div[4]/div[1]/div/div[5]/div[3]/span[2]";
    String SOLUTIONS_HREF = "//*[@id='solutions_tab']/div[2]";
    String CPP_SOLUTION = "(//span[normalize-space()='C++'])[1]";
    String SOLUTION_1 = "(//div[@class='group flex w-full cursor-pointer flex-col gap-1.5 px-4 pt-3'])[2]";
    String SOLUTION_CODE = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/pre[1]";
    String CODE_AREA = "(//div[contains(@role,'presentation')])[9]";
    String SUBMIT_BUTTON_ELEMENT = "button[data-e2e-locator=\"console-submit-button\"]";
    String SEARCH_QUES = "input[placeholder='Search questions']";
    String PROBLEM_URL = "//a[@href='/problems/lowest-common-ancestor-of-deepest-leaves'])";
}
