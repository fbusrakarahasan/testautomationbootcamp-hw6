package pageobjects;

import framework.Helper;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;

public class HomePage {

    WebDriver driver;
    Helper elementHelper;
    By searchInput = By.id("search-input");
    By searchIcon = By.cssSelector("button[type=submit]");
    By wishListIcon = By.cssSelector("a[data-tooltip=\"Add to Wishlist\"]");
    By imageBox = By.cssSelector(".tt-image-box");
    By favorites = By.cssSelector("div[data-tooltip=\"Favorites\"]");
    By titleOfWish = By.xpath("//*/h2[@class='tt-title']");
    By titleOfResWish = By.xpath("//*/h2[@class='tt-title']");
    By myAccounts = By.xpath("//button[@class='tt-dropdown-toggle']");
    By signInIcon = By.xpath("(//i[@class='icon-f-76'])[1]");
    By signOutIcon = By.xpath("(//i[@class='icon-f-77'])[1]");
    By flowersPage = By.xpath("(//a[text()='FLOWERS'])[3]");
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper=new Helper(driver);
    }

    @Step("Go to the SignIn page")
    public void GoToSignInPage(){
        Allure.step("Go to the SignIn page");
        this.elementHelper.findElement(myAccounts).click();
        this.elementHelper.findElement(signInIcon).click();
    }

    @Step("I should see the sign out button")
    public void IShouldSeeTheSignOutButton(){
        Allure.step("I should see the sign out button");
        this.elementHelper.findElement(myAccounts).click();
        Assert.assertTrue(this.elementHelper.findElement(this.signOutIcon).isDisplayed());
    }

    @Step("Search product")
    public void SearchProduct(String productName){
        Allure.step("Search product");
        this.elementHelper.findElement(searchInput).sendKeys(productName);
        this.elementHelper.findElement(searchIcon).click();
    }

    public void ClickFlowersMenu(){
        this.elementHelper.findElement(flowersPage).click();
    }
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
