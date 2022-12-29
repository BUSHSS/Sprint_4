package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ConfirmOrderPopUp {
    private WebDriver driver;

    // локатор для кнопки "Да"
    private By confirmButton=By.xpath(".//*[text()='Да']");

    public ConfirmOrderPopUp(WebDriver driver){
        this.driver=driver;
    }

    // метод для нажатия на кнопку "Да"
    public void clickConfirmButton(){
        driver.findElement(confirmButton).click();
    }
}
