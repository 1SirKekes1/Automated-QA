package interPals;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    private SelenideElement profileUsernameText = $x("//div[@id='acctTopWelcomeThumbLink']/a");

    public String getUsernameText (){
        return profileUsernameText.getText();
    }
}
