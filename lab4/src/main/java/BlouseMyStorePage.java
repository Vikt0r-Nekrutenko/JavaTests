import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlouseMyStorePage {
    private final WebDriver webDriver;
    private final String path;

    @FindBy(id = "send_friend_button")
    private WebElement sendFriendButton;

    public BlouseMyStorePage(WebDriver driver, String pathTo){
        PageFactory.initElements(driver, this);
        webDriver = driver;
        this.path = pathTo;
    }

    public BlouseMyStorePage open() {
        webDriver.navigate().to(path);
        return this;
    }

    public void sendToFriendClick() {
        sendFriendButton.click();
    }

    public boolean friendNameFieldIsExist() {
        return webDriver.findElement(By.xpath("//label[contains(@for,'friend_name')]")).getText().length() > 0;
    }

    public OrderMyStorePage addToCart() {
        webDriver.findElement(By.xpath("//button[contains(@name,'Submit')]")).click();
        return new OrderMyStorePage(webDriver);
    }
}
