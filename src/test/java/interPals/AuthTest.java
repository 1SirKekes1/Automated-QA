package interPals;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthTest {

    private AuthPage authPage = new AuthPage();
    @Test
    public void authTestInvalidCredentials(){
        String errorMessage = "Invalid username/email and password combination.";
        authPage.auth("kinderthancat@gmail.com", "123452111");
        Assertions.assertEquals(errorMessage,authPage.getErrorMessage());
    }
    @Test
    public void authTestSuccess(){
        String myProfileUrl = "https://interpals.net/app/account";
        authPage.auth("kinderthancat@gmail.com", "123456ds");
        Assertions.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(),myProfileUrl);
    }
    @Test
    public void usernameCorrect(){
        Assertions.assertEquals("totallynotbotalexa2", authPage
                .auth("kinderthancat@gmail.com", "123456ds")
                .getUsernameText(), "Wrong username");
    }
    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
