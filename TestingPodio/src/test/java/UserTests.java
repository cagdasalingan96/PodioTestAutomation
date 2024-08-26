import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;


public class UserTests extends BaseTest {


    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Test(description = "Başarılı Login Kullanıcı Girişi Kontrol")
    public void loginSuccesful() throws InterruptedException {
        sleep(3000);
        loginPage
                .emailDoldur(email)
                .passwordDoldur(password)
                .loginTikla();
    }

    @Test(description = "Hatalı Şifre Girişi Kontrol")
    public void notValidLogin() throws InterruptedException {
        sleep(5000);
        loginPage
                .emailDoldur(email)
                .passwordDoldur("dsfsf12")
                .loginTikla();
        sleep(5000);
        loginPage.hataMesajiKontrolu(hataMesaji);
    }

    @Test(description = "Hatalı E-mail Girişi Kontrol")
    public void notValidEmail() throws InterruptedException {
        sleep(3000);
        loginPage
                .emailDoldur("harlemglobetrott7854ers7@gmail.com")
                .passwordDoldur(password)
                .loginTikla();
        sleep(5000);
        loginPage.hataMesajiKontrolu(hataMesaji);
    }

    @Test(description = "Boş Veri Girişi Kontrol")
    public void requiredBlankControl() throws InterruptedException {
        sleep(3000);
        loginPage
                .emailDoldur("")
                .passwordDoldur("")
                .loginTikla();
        sleep(5000);
        loginPage.bosHataMesajiKontrolu(bosHataMesaji)
                .emailDoldur(email)
                .loginTikla()
                .bosHataMesajiKontrolu(bosHataMesaji);
        sleep(3000);
        loginPage
                 .passwordDoldur(password)
                 .loginTikla();
    }

    @Test(description = "Minimum Kontrol")
    public void minControl() throws InterruptedException {
        sleep(3000);
        loginPage
                .emailDoldur("1")
                .passwordDoldur( "2")
                .loginTikla();
        sleep(5000);
        loginPage
                .hataMesajiKontrolu(hataMesaji)
                .emailDoldur("mail@gmail.com")
                .passwordDoldur("2")
                .loginTikla();
        sleep(5000);
        loginPage.hataMesajiKontrolu(hataMesaji);
    }

    @Test(description = "maksimum Kontrol")
    public void maxControl() throws InterruptedException {
        sleep(3000);
        loginPage
                .emailDoldur("aaaaaaaaaaaaaaa11aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com")
                .passwordDoldur(password)
                .loginTikla();
        sleep(5000);
        loginPage.hataMesajiKontrolu(hataMesaji);


    }

    @Test(description = "Logo Kontrol")
    public void logoControl(){
        loginPage.logoKontrol();
    }

    @Test(description = "(Choose a workspace or app) Kısmı Veri Girişi Kontrol")
    public void navigationInput() throws InterruptedException{
        sleep(3000);
        loginPage
                .emailDoldur(email)
                .passwordDoldur(password)
                .loginTikla();
        sleep(5000);
        homePage
                .menu()
                .menuSearch(ara);
        sleep(3000);
        homePage.menuSearchingClick();
    }

    @Test(description = "Navigation Arama Butonu Kontrol")
    public void searchButton() throws InterruptedException{
        sleep(3000);
        loginPage
                .emailDoldur(email)
                .passwordDoldur(password)
                .loginTikla();
        sleep(5000);
        homePage.navBarSearchButton();
        sleep(3000);
        homePage.navBarSearchInput("a");
        sleep(4000);
        homePage.contentControl();
    }

    @Test(description = "Mail Onayı Kontrol")
    public void accountSettings() throws InterruptedException{
        sleep(3000);
        loginPage
                .emailDoldur(email)
                .passwordDoldur(password)
                .loginTikla();
        sleep(5000);
        homePage.accountImote();
        sleep(5000);
        homePage.settings();
        sleep(5000);
        homePage.mailVerified();

    }

    @Test(description = "Çıkış Kontrol")
    public void exit() throws InterruptedException {
        sleep(3000);
        loginPage
                .emailDoldur(email)
                .passwordDoldur(password)
                .loginTikla();
        sleep(5000);
        homePage.accountImote();
        sleep(5000);
        homePage.logOut();

    }


}
