package com.proyect;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class LoginPage {

WebDriver driver;

public LoginPage (WebDriver driver){
    this.driver = driver;
}
 
public void traerPagina (){
 driver.get("http://localhost:8081/login");
}

public void ingresarUsuario(String user){
    driver.findElement(By.name("username")).sendKeys(user);
}

public void ingresarPass(String pass){
    driver.findElement(By.name("password")).sendKeys(pass);
}

public void clickLogin(){
    driver.findElement(By.tagName("button")).click();
}

public void login(String user, String pass){
    ingresarUsuario(user);
    ingresarPass(pass);
    clickLogin();
}

}
