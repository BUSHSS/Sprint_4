package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




@RunWith(Parameterized.class)
public class TestClass {
    private final String text;

    public TestClass(String text) {
        this.text = text;
    }
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"тест"},
        };
    }


    // Класс с автотестом


    private WebDriver driver;

    @Test
    public void checkActivity() {
        // драйвер для браузера Chrome

        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // создай объект класса страницы главной страницы приложения
        HomePageMesto objHomePage = new HomePageMesto(driver);

        //ожидание отображения поп-ап окна cookie
        objHomePage.waitForLoadCookie();
        // кликни на кнопку в поп-апе cookie
        objHomePage.clickCookie();
        // кликни на стрелку
        objHomePage.clickArrow();
        //ожидание отображения текста
        objHomePage.waitForLoadData();
        // получи текст элемента
        String s = objHomePage.textInArrow();
        // сделай проверку, что полученное значение совпадает с тестовыми данными
        MatcherAssert.assertThat(s, CoreMatchers.is(text));
    }



    @After
    public void teardown() {
        //Закрой браузер
        driver.quit();
    }
}

