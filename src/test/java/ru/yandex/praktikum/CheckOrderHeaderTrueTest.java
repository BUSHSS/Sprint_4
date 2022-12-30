package ru.yandex.praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@RunWith(Parameterized.class)
public class CheckOrderHeaderTrueTest {
    private WebDriver driver;
@Before
public void initialize() {
    System.setProperty("webdriver.gecko.driver", "C:/Program Files/Git/geckodriver/geckodriver.exe");

    // драйвер для браузера Chrome
    //driver = new ChromeDriver();
    // драйвер для браузера Firefox
    driver = new FirefoxDriver();
    // переход на страницу тестового приложения
    driver.get("https://qa-scooter.praktikum-services.ru/");
}
    private final String name;
    private final String surname;
    private final String address;
    private final String button;
    private final String phone;
    private final String date;
    private final String color;
    private final String comment;

    public CheckOrderHeaderTrueTest(String button, String name, String surname, String address, String phone, String date, String color, String comment){
        this.button=button;
        this.name=name;
        this.surname=surname;
        this.address=address;
        this.phone=phone;
        this.date=date;
        this.color=color;
        this.comment=comment;
    }



    @Parameterized.Parameters
    public static Object[][] newOrderData(){
        return new Object[][] {
                {"header","Сергей","Бушмакин","Москва", "+79001234567","02.11.1995","grey","Не кладите кинзу"},
                {"middle","Елена","Иванова","Чебоксары", "+79169520000","02.06.2022","black","Побыстрее"},
        };
    }


    @Test
    public void Order(){

        HomePageMesto objHomePage = new HomePageMesto(driver);
        //ожидание отображения поп-ап окна cookie
        objHomePage.waitForLoadCookie();
        // кликни на кнопку в поп-апе cookie
        objHomePage.clickCookie();

        //нажать кнопку Заказа сверху
        objHomePage.clickOrder(button);

        //Заполнить стр.1
        OrderPageStep1 step1 = new OrderPageStep1(driver);
        step1.setOrderStep1(name, surname, address, phone);

        //Заполнить стр.2
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        OrderPageStep2 step2 = new OrderPageStep2(driver);
        step2.fillOrderPage2(date, color, comment);

        //Заполнить стр.3
        ConfirmOrderPopUp step3 = new ConfirmOrderPopUp(driver);
        step3.clickConfirmButton();

        //Проверить, что появилось сообщение об успешном создании заказа
        ResultPopUp objResultPage = new ResultPopUp(driver);
        MatcherAssert.assertThat("Текст должен содержать 'Заказ оформлен'",objResultPage.getResultMessage().contains("Заказ оформлен"));
    }

    @After
    public void teardown() {
        driver.quit();
    }


}
