
import framework.ConfigReader;
import framework.DriverSetup;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.MenuProductsPage;
import pageobjects.SearchPage;
import pageobjects.SignInPage;

import java.io.ByteArrayInputStream;

public class FlocakeTests {
    static WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    SearchPage searchPage;
    MenuProductsPage menuProductsPage;

    @BeforeClass
    public void setup() {
        driver = DriverSetup.initialize_Driver(ConfigReader.initialize_Properties().get("browser").toString());
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        searchPage = new SearchPage(driver);
        menuProductsPage = new MenuProductsPage(driver);
    }

    @Test(priority = 1)
    public void SuccessfulLogin() {
        homePage.GoToSignInPage();
        signInPage.typeEmail(ConfigReader.initialize_Properties().get("email").toString());
        signInPage.typePassword(ConfigReader.initialize_Properties().get("password").toString());
        signInPage.clickLoginBtn();

        homePage.IShouldSeeTheSignOutButton();
        Allure.addAttachment("I Should See The Sign Out Button", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Test(priority = 2)
    public void FaultyProductSearch() {
        homePage.SearchProduct("wrongproductname");

        searchPage.IShouldSeeThatPageCantBeFoundAlert();
        Allure.addAttachment("I Should See That Page Cant Be Found Alert", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Test(priority = 3)
    public void First10ProductSortingControl() throws InterruptedException {
        homePage.ClickFlowersMenu();
        menuProductsPage.SortByHighToLow();

        menuProductsPage.IShouldSeeProductsListFromExpensiveToCheap();
        Allure.addAttachment("I Should See Products List From Expensive To Cheap", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
