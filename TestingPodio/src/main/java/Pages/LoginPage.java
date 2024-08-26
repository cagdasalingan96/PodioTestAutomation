package Pages;

import Base.BaseLibrary;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BaseLibrary {

    public LoginPage emailDoldur(String email){
        driver.findElement(By.name("email")).sendKeys(email);
        return this;
    }

    public LoginPage passwordDoldur(String password){
        driver.findElement(By.name("password")).sendKeys(password);
        return this;
    }

    public LoginPage loginTikla(){
        driver.findElement(By.xpath("//*[@id=\"loginFormSignInButton\"]")).submit();
        return this;
    }

    public LoginPage hataMesajiKontrolu(String text){
        String value = driver.findElement(By.cssSelector("[class='text-bold']")).getText();
        Assert.assertEquals(text, value);
        screenshot();
        return this;
    }

    public LoginPage bosHataMesajiKontrolu( String text){
        String value = driver.findElement(By.cssSelector("[class='login-form-component__input-fields__row__input invalid-field']")).getText();
        Assert.assertEquals(text, value);
        screenshot();
        return this;
    }

    public LoginPage logoKontrol(){
        driver.findElement(By.cssSelector("[class='logged-out-container__logo__link']")).click();
        screenshot();
        return this;
    }
}
