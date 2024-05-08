package com.devmadhurendra.keyword_driven_tut.scenerios;

import com.devmadhurendra.keyword_driven_tut.KeyWordEngine;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {

    public KeyWordEngine keywordEngine;

    @Test
    public void loginTest() throws IOException {
        keywordEngine = new KeyWordEngine();
        keywordEngine.startExecution("login");
    }
}
