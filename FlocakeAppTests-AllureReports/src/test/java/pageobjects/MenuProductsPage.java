package pageobjects;

import framework.Helper;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class MenuProductsPage {

    WebDriver driver;
    Helper elementHelper;
    By priceFilter = By.id("price_filter");
    By productPrices = By.xpath("//div[@class='tt-price']");
    By moreProducts = By.id("more_products");

    public MenuProductsPage(WebDriver driver) {
        this.driver = driver;
        this.elementHelper = new Helper(driver);
    }

    @Step("Sorting By High To Low")
    public void SortByHighToLow() throws InterruptedException {
        Allure.step("Sorting By High To Low");

        Select fruits = new Select(this.elementHelper.findElement(this.priceFilter));
        fruits.selectByVisibleText("Bahadan Ucuza");
        elementHelper.waitForAjax();
        elementHelper.ScrollToElement(moreProducts);
    }

    @Step("I Should See Products List From Expensive To Cheap")
    public void IShouldSeeProductsListFromExpensiveToCheap() {
        Allure.step("I Should See Products List From Expensive To Cheap");

        List<WebElement> products = elementHelper.findElements(productPrices);

        Integer[] PriceArray = new Integer[11];

        for (int j = 1; j <= 10; j++) {
            PriceArray[j] = Integer.valueOf((products.get(j).getText().replace("AZN", "").replace(" ", "")));
        }

        for (int i = 1; i < 10; i++) {
            Assert.assertTrue(PriceArray[i] > PriceArray[i + 1]);
        }
    }
}
