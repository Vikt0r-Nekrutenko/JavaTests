import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginMyStorePage {
    private final WebDriver webDriver;

    public LoginMyStorePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement submitButton;

    public void authorization() {
        email.sendKeys("18fi.v.nekrutenko@std.npu.edu.ua");
        password.sendKeys("nekrutya");
        submitButton.click();
    }
}
