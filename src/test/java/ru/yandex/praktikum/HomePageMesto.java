package ru.yandex.praktikum;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;




// Класс главной страницы
class HomePageMesto {

    private  WebDriver driver;

    // локатор для кнопки в поп-апе cookie
    private  By agreeButton = By.id("rcc-confirm-button");
    // локатор для стрелочки
    private By arrowButton = By.className("accordion__heading");

    // локатор для текста поля под стрелочкой
    private By textArrowButton = By.className("accordion__panel");


    // локатор для кнопки "Заказать" в хэдере
    private By orderButtonH = By.className("Button_Button__ra12g");

    // локатор для кнопки "Заказать" в центре страницы
    private By orderButtonM = By.className("Button_Middle__1CSJM");

    public HomePageMesto(WebDriver driver) {
        this.driver = driver;
    }

    // метод для нажатия на кнопку в поп-апе cookie
    public void clickCookie(){
        driver.findElement(agreeButton).click();
    }
    // метод для нажатия на кнопку "Заказать" в хэдере

    public void clickOrder(String button) {
        if (button.equals("header")) {
            driver.findElement(orderButtonH).click();
        } else if (button.equals("middle")) {
            driver.findElement(orderButtonM).click();
        }
    }

    // метод для нажатия на стрелку
    public void clickArrow (){

        driver.findElement(arrowButton).click();
    }
    // метод ожидания прогрузки поп-апа cookie
    public void waitForLoadCookie() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(agreeButton).getText() != null
                && !driver.findElement(agreeButton).getText().isEmpty()
        ));
    }
    // метод ожидания прогрузки данных
    public void waitForLoadData() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(textArrowButton).getText() != null
                && !driver.findElement(textArrowButton).getText().isEmpty()
        ));
    }
    // метод для получения текста элемента
    public String textInArrow(){

        return driver.findElement(textArrowButton).getText();
    }

}


