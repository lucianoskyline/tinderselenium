package com.tinderselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by luciano on 09/12/2019.
 */
public class Principal {

    public static void main(String args[]){
        System.setProperty("webdriver.chrome.driver","/Users/luciano/Downloads/chromedriver");

        try{
            ChromeDriver chromeDriver=new ChromeDriver();
            chromeDriver.get("https://tinder.com");

            TimeUnit.SECONDS.sleep(4);

            WebElement btnLogin=chromeDriver.findElement(By.xpath(".//button[@aria-label='Iniciar sesión con nº de teléfono']"));
            btnLogin.click();

            TimeUnit.SECONDS.sleep(2);

            WebElement txtCelular=chromeDriver.findElementByName("phone_number");
            txtCelular.sendKeys("seu_numero");

            btnLogin=chromeDriver.findElement(By.xpath(".//button[span='Continuar']"));
            btnLogin.click();

            TimeUnit.SECONDS.sleep(30);

            WebElement btnNotificacoes=chromeDriver.findElement(By.xpath(".//button[@aria-label='Permitir']"));
            btnNotificacoes.click();

            TimeUnit.SECONDS.sleep(2);

            btnNotificacoes=chromeDriver.findElement(By.xpath(".//button[@aria-label='No me interesa']"));
            btnNotificacoes.click();

            WebElement btnConfirmar=chromeDriver.findElement(By.xpath(".//button[@aria-label='Me gusta']"));
            btnConfirmar.click();

            while(btnConfirmar.isDisplayed()){
                TimeUnit.SECONDS.sleep(3);
                btnConfirmar=chromeDriver.findElement(By.xpath(".//button[@aria-label='"+(new Random().nextBoolean()?"Me gusta":"Nope")+"']"));
                btnConfirmar.click();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
