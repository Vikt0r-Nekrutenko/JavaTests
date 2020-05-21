import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyStorePage {
    private final WebDriver webDriver;

    public MyStorePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(className = "login")
    private WebElement signInButton;

    public LoginMyStorePage signIn() {
        signInButton.click();
        return new LoginMyStorePage(webDriver);
    }

    public boolean phoneNumberInFooterIsExist() {
        List<WebElement> spans = webDriver.findElements(By.tagName("span"));
        for (WebElement span : spans) {
            if (span.getText().equals("(347) 466-7432")) {
                return true;
            }
        }
        return false;
    }

    public boolean emailInFooterIsExist() {
        WebElement spans = webDriver.findElement(By.linkText("support@seleniumframework.com"));
        return spans != null;
    }
}
