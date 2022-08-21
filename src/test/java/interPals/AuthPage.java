package interPals;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AuthPage {
    private final SelenideElement signInButton = $x("//span[@id='signin-link']");
    private final SelenideElement emailField = $x("//input[@name='username']");
    private final SelenideElement passwordField = $x("//input[@name='password']");
    private final SelenideElement authButton = $(By.id("signin-btn"));
    private final SelenideElement msgError = $x("//div[@class='msg_error']//li[1]");

    public AuthPage() {
        Selenide.open("https://interpals.net/");
    }

    public ProfilePage auth(String email, String password) {
        signInButton.click();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        authButton.click();
        return new ProfilePage();
    }
    public String getErrorMessage(){
        return msgError.getText();
    }
}

