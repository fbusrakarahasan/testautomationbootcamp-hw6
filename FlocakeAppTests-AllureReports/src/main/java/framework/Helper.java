package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


//Element helpers for whole project
public class Helper {

    WebDriver driver;
    public WebDriverWait wait;

    public Helper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public WebElement findElement(By elementName) {
        wait.until(ExpectedConditions.elementToBeClickable(elementName));
        WebElement element = driver.findElement(elementName);
        highLighterMethod(element);
        return driver.findElement(elementName);
    }

    public List<WebElement> findElements(By elementName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementName));
        return driver.findElements(elementName);
    }

    public void ScrollToElement(By by)
    {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void click(By elementName) {
        findElement(elementName).click();
    }

    public void sendKey(By elementName, String text) {
        findElement(elementName).sendKeys(text);
    }

    public void checkElementVisible(By elementName) {
        wait.until(ExpectedConditions.visibilityOf(findElement(elementName)));
    }

    public String getText(By elementName) {
        return findElement(elementName).getText();
    }

    public WebElement presenceElement(By key) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    public void isAssertTrue(By actualValue, String exceptedValue) {
        String actualText = findElement(actualValue).getText();
        assertEquals(actualText, exceptedValue);

    }

    public void typeForInput(String kw, WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getTagName(), "input");
        element.sendKeys(kw);
    }

    public void clickForWebElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clickForWebElementWithWait(WebElement element, int timeout) {
        this.wait = new WebDriverWait(driver, timeout);
        element.click();
    }
    public void waitForAjax() throws InterruptedException{
        while (true)
        {
            Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
            if (ajaxIsComplete){
                break;
            }
            Thread.sleep(150);
        }
    }
    public void hoverMover(WebElement to) {
        Actions action = new Actions(driver);
        action.moveToElement(to).perform();
    }
    public void scrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,-250)");
    }
    public void highLighterMethod(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

}