package pageobjects;

import framework.Helper;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

public class SignInPage {

    WebDriver driver;
    Helper elementHelper;
    By email = By.id("loginEmail");
    By password = By.id("loginPass");
    By loginBtn = By.xpath("//button[@class='btn ']");

    public SignInPage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper=new Helper(driver);
    }
    @Step("Filling the e-mail field")
    public void typeEmail(String email)
    {
        Allure.step("Filling the e-mail field");
        this.elementHelper.findElement(this.email).sendKeys(email);
    }

    @Step("Filling the password field")
    public void typePassword(String password)
    {
        Allure.step("Filling the password field");
        this.elementHelper.findElement(this.password).sendKeys(password);
    }

    @Step("Click the login button")
    public void clickLoginBtn()
    {
        Allure.step("Click the login button");
        this.elementHelper.findElement(this.loginBtn).click();
    }

}
