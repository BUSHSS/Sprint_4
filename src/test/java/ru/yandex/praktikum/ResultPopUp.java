package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ResultPopUp {
    private WebDriver driver;
    //Сообщение "Заказ оформлен"
    private By resultMessage=By.className("Order_ModalHeader__3FDaJ");

    public ResultPopUp(WebDriver driver){
        this.driver=driver;
    }

    public String getResultMessage(){
        return driver.findElement(resultMessage).getText();
    }
}
