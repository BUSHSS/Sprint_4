package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;



public class OrderPageStep1 {

    private WebDriver driver;

    // локатор для поля "Имя"
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");

    // локатор для поля "Фамилия"
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");

    // локатор для поля "Адрес"
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // локатор для поля "Станция метро"
    private By subwayField = By.xpath(".//input[@placeholder='* Станция метро']");

    // локатор для поля "Телефон"
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // локатор для кнопки "Далее"
    private  By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");


    public OrderPageStep1(WebDriver driver) {
        this.driver = driver;
    }
    // метод для ввода имени
    public void setName (String name){
        driver.findElement(nameField).sendKeys(name);
    }
    // метод для ввода фамилии
    public void setSurname (String surname){
        driver.findElement(surnameField).sendKeys(surname);
    }
    // метод для ввода адреса
    public void setAddress (String address){
        driver.findElement(addressField).sendKeys(address);
    }
    // метод для выбора станции метро
    public void setSubway (){
        driver.findElement(subwayField).click();
        driver.findElement(subwayField).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    }
    // метод для ввода телефона
    public void setPhone (String phone){
        driver.findElement(phoneField).sendKeys(phone);
    }

    // метод для нажатия на кнопку "Далее"
    public void clickNext (){
        driver.findElement(nextButton).click();
    }

    // метод для заполнения 1 шага на странице офрмления заказа
    public void setOrderStep1(String name,String surname, String address,String phone){
        setName(name);
        setSurname(surname);
        setAddress(address);
        setSubway();
        setPhone(phone);
        clickNext();
    }

}
