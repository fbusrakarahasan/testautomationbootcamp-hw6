<h1 align="center"> :bookmark_tabs: Enuygun - Test Automation Bootcamp - HW6_2 </h1>
 

> ###  ``` Flocake Senaryoları - Allure Raporu   ``` 
  
 
 ###  👨🏻‍💻 Senaryo-1 : Successful Login
---

```java
@Test(priority = 1)
public void SuccessfulLogin() {
    homePage.GoToSignInPage();
    signInPage.typeEmail(ConfigReader.initialize_Properties().get("email").toString());
    signInPage.typePassword(ConfigReader.initialize_Properties().get("password").toString());
    signInPage.clickLoginBtn();

    homePage.IShouldSeeTheSignOutButton();
    Allure.addAttachment("I Should See The Sign Out Button", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
}
```
![SC1](https://user-images.githubusercontent.com/102550569/183974826-0c0c9501-9664-4f31-8b19-8518fe6b85bf.png)

 
 ###  👨🏻‍💻 Senaryo-2 : Faulty Product Search
---

```java 
@Test(priority = 2)
public void FaultyProductSearch() {
    homePage.SearchProduct("wrongproductname");

    searchPage.IShouldSeeThatPageCantBeFoundAlert();
    Allure.addAttachment("I Should See That Page Cant Be Found Alert", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
}
``` 

![SC2](https://user-images.githubusercontent.com/102550569/183974832-e413f2cd-f0fa-4ab3-959c-051134f6ca6e.png)

 ###  👨🏻‍💻 Senaryo-3 : First 10 Product Sorting Control (Expensive To Cheap)
---

```java 
@Test(priority = 3)
public void First10ProductSortingControl() throws InterruptedException {
    homePage.ClickFlowersMenu();
    menuProductsPage.SortByHighToLow();

    menuProductsPage.IShouldSeeProductsListFromExpensiveToCheap();
    Allure.addAttachment("I Should See Products List From Expensive To Cheap", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
}
``` 
 
![SC3](https://user-images.githubusercontent.com/102550569/183974834-a98a538a-8d65-4a23-9b22-199dfdc6e95d.png)