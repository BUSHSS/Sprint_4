package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class OrderPageStep2 {

    private WebDriver driver;

    // Локаторы для второго шага оформления заказа

    // локатор для поля "Когда привезти самокат"
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // локатор для поля "Срок аренды"
    private By periodField=By.className("Dropdown-placeholder");

    // локатор для чекбокса "черный жемчуг"
    private By blackColor=By.xpath(".//input[@id='black']");

    // локатор для чекбокс "серая безысходность"
    private By greyColor=By.xpath(".//input[@id='grey']");

    // локатор для поля "комментарий для курьера"
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // локатор для кнопки "Заказать"
    private  By makeOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    // локатор для выпадающего списка в поле "Срок аренды"
    private By period_day=By.xpath(".//*[@class='Dropdown-option'][1]");

    public OrderPageStep2(WebDriver driver) {
        this.driver = driver;
    }

    // метод для ввода даты в поле "Когда привезти самокат"
    public void setDate (String date){
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(dateField).sendKeys(Keys.ENTER);
    }

    // метод для указания срока аренды
    public void setPeriod(){

        driver.findElement(periodField).click();
        driver.findElement(period_day).click();
    }

    // метод для выбора цвета
    public void chooseColor(String newColor) {
        if (newColor.equals("black")) {
            driver.findElement(blackColor).click();
        } else if (newColor.equals("grey")) {
            driver.findElement(greyColor).click();
        }
    }
    // метод для ввода комментария
    public void setComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }

    // метод для нажатия на кнопку "Далее"
    public void clickNext(){
        driver.findElement(makeOrderButton).click();
    }

    // метод для заполнения 2 шага на странице офрмления заказа
    public void fillOrderPage2(String date, String color,String comment){
        setDate(date);
        setPeriod();
        chooseColor(color);
        setComment(comment);
        clickNext();
    }
}
