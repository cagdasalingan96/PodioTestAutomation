package Pages;

import Base.BaseLibrary;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends BaseLibrary {

    public HomePage menu(){
        driver.findElement(By.xpath("//*[@id=\"header-global\"]/nav/div[1]/div/div[1]")).click();
        screenshot();
        return this;
    }

    public HomePage menuSearch(String text){
        driver.findElement(By.xpath("//*[@id=\"header-global\"]/nav/div[1]/div/div[1]/div[2]/input")).sendKeys(text);
        screenshot();
        return this;
    }

    public HomePage menuSearchingClick(){
        driver.findElement(By.cssSelector("[class='result-title']")).click();
        screenshot();
        return this;
    }

    public HomePage navBarSearchButton(){
        driver.findElement(By.xpath("//*[@id=\"header-global\"]/nav/div[2]/ul[2]/li[2]/a")).click();
        screenshot();
        return this;
    }

    public HomePage navBarSearchInput(String text){
        driver.findElement(By.cssSelector("[name='query']")).sendKeys(text);
        screenshot();
        return this;
    }

    public HomePage contentControl(){
        String value = String.valueOf(driver.findElement(By.xpath("/html/body/div[6]/ul/li[1]/div")).isDisplayed());
        Assert.assertEquals("true",value);
        screenshot();
        return this;
    }

    public HomePage accountImote(){
        driver.findElement(By.cssSelector("[class='icon tooltip tooltip-delayed']")).click();
        screenshot();
        return this;
    }

    public HomePage settings(){
        driver.findElement(By.xpath("//*[@id=\"topbar_my-account_dropdown\"]/div[2]/ul/li[2]/a")).click();
        screenshot();
        return this;
    }

    public HomePage mailVerified(){
        String value = String.valueOf(driver.findElement(By.xpath("//*[@id=\"edit_user_mails\"]/div/span")).isDisplayed());
        Assert.assertEquals("true",value);
        screenshot();
        return this;
    }

    public HomePage logOut(){
        driver.findElement(By.xpath("//*[@id=\"topbar_my-account_dropdown\"]/div[5]/ul/li/div[2]/a")).click();
        screenshot();
        return this;
    }

}
