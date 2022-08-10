package pageobjects;

import framework.Helper;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchPage {

    WebDriver driver;
    Helper elementHelper;
    By AlertMessage = By.xpath("//h1[@class='tt-title']");

    public SearchPage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper=new Helper(driver);
    }

    @Step("I Should See That Page Cant Be Found Alert")
    public void IShouldSeeThatPageCantBeFoundAlert()
    {
        Allure.step("I Should See That Page Cant Be Found Alert");
        Assert.assertTrue(elementHelper.findElement(AlertMessage).isDisplayed());
    }

}
