import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestMyStorage {
    WebDriver webDriver;

    public TestMyStorage() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/grhin0/IdeaProjects/geckodriver.exe");
        webDriver = new FirefoxDriver();
    }

    @Test
    public void testCaseOne() {
        webDriver.get("http://automationpractice.com");
        MyStorePage myStorePage = new MyStorePage(webDriver);
        myStorePage.signIn().authorization();

        WomenMyStorePage womenMyStorePage = new WomenMyStorePage(webDriver);
        womenMyStorePage.open();

        Assert.assertEquals(7, womenMyStorePage.unitCount());
        Assert.assertEquals(3, womenMyStorePage.yellowUnitCount());

        womenMyStorePage.gridToListView();
        Assert.assertEquals(true, womenMyStorePage.checkProductDescription());
    }

    @Test
    public  void testCaseTwo() {
        webDriver.get("http://automationpractice.com");
        MyStorePage myStorePage = new MyStorePage(webDriver);
        myStorePage.signIn().authorization();

        WomenMyStorePage womenMyStorePage = new WomenMyStorePage(webDriver);
        womenMyStorePage.open();

        BlouseMyStorePage blouseMyStorePage = womenMyStorePage.unit("Faded Short Sleeve T-shirts").open();
        blouseMyStorePage.sendToFriendClick();
        Assert.assertTrue(blouseMyStorePage.friendNameFieldIsExist());
    }

    @Test
    public void testCaseThree() {
        webDriver.get("http://automationpractice.com");
        MyStorePage myStorePage = new MyStorePage(webDriver);
        myStorePage.signIn().authorization();

        WomenMyStorePage womenMyStorePage = new WomenMyStorePage(webDriver);
        womenMyStorePage.open();

        BlouseMyStorePage blouseMyStorePage = womenMyStorePage.unit("Faded Short Sleeve T-shirts").open();
        OrderMyStorePage orderMyStorePage = blouseMyStorePage.addToCart().proceedToCheckoutClick();
        Assert.assertTrue(orderMyStorePage.imageIsExist());

        Assert.assertTrue(myStorePage.emailInFooterIsExist());
        Assert.assertTrue(myStorePage.phoneNumberInFooterIsExist());
    }
}
