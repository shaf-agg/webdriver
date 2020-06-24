package com.wipro;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileWriter;
import java.io.IOException;



public class FirstTest {

    public static void main(String[] args) throws InterruptedException {
        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://demo.opencart.com/";
        String expectedTitle = "Your Store";
        String actualTitle = "";

        // launch browser and direct it to the Base URL
        driver.manage().window().maximize();
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        // Step 1 , 2 , 3
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'dropdown-menu-right')]//a[text()='Login']")).click();
        driver.findElement(By.id("input-email")).sendKeys("first1last1@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("first1last1");
        driver.findElement(By.cssSelector("[type='submit']")).click();

        // Step 4
        driver.findElement(By.xpath("//*[@name='search']")).click();
        driver.findElement(By.xpath("//*[@name='search']")).sendKeys("iPhone");
        driver.findElement(By.xpath("//*[@name='search']")).sendKeys(Keys.ENTER);

        // Step 5, 6
        driver.findElement(By.xpath("//a[text()='Components']")).click();
        driver.findElement(By.xpath("//a[text()='Monitors (2)']")).click();
        driver.findElement(By.xpath("//a[text()='Phones & PDAs (3)']")).click();

        // Step 7
        Select select = new Select(driver.findElement(By.id("input-sort")));
        select.selectByVisibleText("Price (High > Low)");

        // Step 8
        driver.findElement(By.cssSelector(".product-layout:nth-of-type(1)  div > div[class='button-group']:nth-of-type(2) > button:nth-of-type(3)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".product-layout:nth-of-type(2)  div > div[class='button-group']:nth-of-type(2) > button:nth-of-type(3)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".product-layout:nth-of-type(3)  div > div[class='button-group']:nth-of-type(2) > button:nth-of-type(3)")).click();
        Thread.sleep(2000);

        // Step 9
        driver.findElement(By.xpath("//*[@id='compare-total']")).click();

        // Step 10
        driver.findElement(By.xpath("//strong[text()='Palm Treo Pro']")).click();

        // Step 11
        String text = driver.findElement(By.cssSelector("#tab-description > ul > li:nth-of-type(5)")).getText();
        try {
            FileWriter fileWriter = new FileWriter("src/test/resources/output.txt");
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 12
        driver.findElement(By.xpath("//*[@id='button-cart']")).click();

        Thread.sleep(3000);

        // Step 13
        driver.findElement(By.xpath("//a[text()='shopping cart']")).click();

        // Step 14
        driver.findElement(By.xpath("//span[text()='Checkout']")).click();


        // Step 15
        driver.findElement(By.xpath("//a[text()='Checkout']")).click();

        // Step 16


        // Step 18
        driver.navigate().back();

        // Step 19
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'dropdown-menu-right')]//a[text()='Order History']")).click();

        // Step 20

        // Step 21
        driver.findElement(By.xpath("//a[text()='Specials']")).click();

        // Step 22
        driver.findElement(By.xpath("//*[contains(@class, 'fa-th-list')]")).click();

        // Step 23
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        //close browser
        driver.close();
        driver.quit();

    }

}
