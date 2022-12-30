package ru.yandex.praktikum;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.xpath;


// Класс главной страницы
class HomePageMesto {

    private WebDriver driver;

    // локатор для кнопки в поп-апе cookie
    private By agreeButton = By.id("rcc-confirm-button");
    //локатор для стрелочки 0
    private By arrowButton0 = By.id("accordion__heading-0");
    //локатор для стрелочки 1
    private By arrowButton1 = By.id("accordion__heading-1");
    //локатор для стрелочки 2
    private By arrowButton2 = By.id("accordion__heading-2");
    //локатор для стрелочки 3
    private By arrowButton3 = By.id("accordion__heading-3");
    //локатор для стрелочки 4
    private By arrowButton4 = By.id("accordion__heading-4");
    //локатор для стрелочки 5
    private By arrowButton5 = By.id("accordion__heading-5");
    //локатор для стрелочки 6
    private By arrowButton6 = By.id("accordion__heading-6");
    //локатор для стрелочки 7
    private By arrowButton7 = By.id("accordion__heading-7");

    // локатор для текста поля под стрелочкой
    private By textArrowButton0 = By.id("accordion__panel-0");
    private By textArrowButton1 = By.id("accordion__panel-1");
    private By textArrowButton2 = By.id("accordion__panel-2");
    private By textArrowButton3 = By.id("accordion__panel-3");
    private By textArrowButton4 = By.id("accordion__panel-4");
    private By textArrowButton5 = By.id("accordion__panel-5");
    private By textArrowButton6 = By.id("accordion__panel-6");
    private By textArrowButton7 = By.id("accordion__panel-7");

    // локатор для кнопки "Заказать" в хэдере
    private By orderButtonH = By.className("Button_Button__ra12g");

    // локатор для кнопки "Заказать" в центре страницы
    private By orderButtonM = By.className("Button_Middle__1CSJM");

    public HomePageMesto(WebDriver driver) {
        this.driver = driver;
    }

    // метод для нажатия на кнопку в поп-апе cookie
    public void clickCookie() {
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
    public void clickArrow(int number) {

        //driver.findElement(arrowButton).click();
        if (number == 0) {
            driver.findElement(arrowButton0).click();
        } else if (number == 1) {
            driver.findElement(arrowButton1).click();
        } else if (number == 2) {
            driver.findElement(arrowButton2).click();
        } else if (number == 3) {
            driver.findElement(arrowButton3).click();
        } else if (number == 4) {
            driver.findElement(arrowButton4).click();
        } else if (number == 5) {
            driver.findElement(arrowButton5).click();
        } else if (number == 6) {
            driver.findElement(arrowButton6).click();
        } else if (number == 7) {
            driver.findElement(arrowButton7).click();
        }
    }

    // метод ожидания прогрузки поп-апа cookie
    public void waitForLoadCookie() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(agreeButton).getText() != null
               && !driver.findElement(agreeButton).getText().isEmpty()
        ));



    }


    // метод для получения текста элемента
    public String textInArrow(int number) {

        if (number == 0) {
            return driver.findElement(textArrowButton0).getText();
        } else if (number == 1) {
            return driver.findElement(textArrowButton1).getText();
        } else if (number == 2) {
            return driver.findElement(textArrowButton2).getText();
        } else if (number == 3) {
            return driver.findElement(textArrowButton3).getText();
        } else if (number == 4) {
            return driver.findElement(textArrowButton4).getText();
        } else if (number == 5) {
            return driver.findElement(textArrowButton5).getText();
        } else if (number == 6) {
            return driver.findElement(textArrowButton6).getText();
        } else if (number == 7) {
            return driver.findElement(textArrowButton7).getText();
        } else return "нет такого номера вопроса";
    }


}


