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
import org.openqa.selenium.firefox.FirefoxDriver;


@RunWith(Parameterized.class)
public class CheckCorrectTextAnswer {
    private WebDriver driver;
    @Before
    public void initialize() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebDriverManager.chromedriver().setup();
    }

    private final String text;
    private final int number;
    public CheckCorrectTextAnswer(int number, String text) {
        this.number = number;
        this.text = text;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
                {0, "Негативный тест"},
        };
    }


    // Класс с автотестом




    @Test
    public void CheckCorrectText() {


        // создай объект класса страницы главной страницы приложения
        HomePageMesto objHomePage = new HomePageMesto(driver);

        //ожидание отображения поп-ап окна cookie
        objHomePage.waitForLoadCookie();
        // кликни на кнопку в поп-апе cookie
        objHomePage.clickCookie();
        // кликни на стрелку
        objHomePage.clickArrow(number);
        // получи текст элемента
        String s = objHomePage.textInArrow(number);
        // сделай проверку, что полученное значение совпадает с тестовыми данными
        MatcherAssert.assertThat(s, CoreMatchers.is(text));
    }



    @After
    public void teardown() {
        //Закрой браузер
        driver.quit();
    }
}

