package com.proyect.Steps;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.proyect.DriverFactory;
import com.proyect.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginSteps {
 
WebDriver driver;
LoginPage loginPage;


@Given ("estoy en la pagina de login")
public void abrirLogin(){
    driver = DriverFactory.getDriver();
    loginPage = new LoginPage(driver);
    loginPage.traerPagina();
}

@When ("ingreso al usuario {string} contraseña {string}")
public void ingresarCredenciales(String user, String pass){
  loginPage.login(user,pass);
}

@Then ("deberia redirigir a {string}")
public void validarLogin(String url){
    WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
    
    wait.until(ExpectedConditions.urlContains(url));
    assertTrue(driver.getCurrentUrl().contains(url));
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
    assertTrue(driver.findElement(By.tagName("h2"))
               .getText()
               .contains("Lista de Usuarios"));
    driver.quit();
}
}
