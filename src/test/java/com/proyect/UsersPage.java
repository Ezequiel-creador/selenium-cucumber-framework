package com.proyect;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UsersPage {
    WebDriverWait wait;
    WebDriver driver;
    
    private By titulo = By.tagName("h2");
    private By tabla = By.tagName("table");
    private By usernames = By.xpath("//table//tr/td[2]");

    private By btnCrearUsuario = By.linkText("Crear Usuario");
    private By inputUsername = By.name("username");
    private By inputPassword = By.name("password");
    private By btnGuardar = By.xpath("//button[@type='submit']");
    private By btnEditar(String username){ return By.xpath(String.format("//tr[td[2][text()='%s']]//a[contains(text(),'Editar')]",username));}
   
    
    public UsersPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void esperarCarga(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tabla));
    }

    public boolean validarRedireccion(String url){
        return driver.getCurrentUrl().contains(url);
    }
    
    public boolean validarTitulo(){
    return driver.findElement(titulo)
                .getText()
                .contains("Lista de Usuarios");
    }

    public boolean validarUsuarioEnLaLista(String username){
      return driver.findElements(usernames)
              .stream()
              .anyMatch(td-> td.getText().trim().equals(username));
              
    }

    public boolean validarTabla(){
    return driver.findElement(tabla).isDisplayed();
    }

    public int cantidadUsuarios(){
    return driver.findElements(usernames).size();
    }

    //Creación de usuario//

    public void clickCrearUsuario(){
        driver.findElement(btnCrearUsuario).click();
    }

    public void crearUsuario(String username, String password){
        driver.findElement(inputUsername).sendKeys(username);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(btnGuardar).click();
    }

    public void esperarFormulario(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputUsername));
    }

    //Eliminar usuario//

    public void eliminarUsuario(String username){
    By btnEliminar = By.xpath( String.format("//table//tr[td[2][text()='%s']]//button[contains(text(),'Eliminar')]",username)); 
    driver.findElement(btnEliminar).click();
    try{
        driver.switchTo().alert().accept();
    } catch (NoAlertPresentException e){
        }
    }
    
    public boolean validarUsuarioEliminado(String username){
    return driver.findElements(usernames)
              .stream()
              .noneMatch(td-> td.getText().trim().equals(username));
             }

    public void esperarUsuarioEliminado(String username){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[text()='"+ username +"']")));
    }


    //Editar usuario//

    public void editarUsuario(String username, String newUsername, String newPassword){
        driver.findElement(btnEditar(username)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputUsername));
        driver.findElement(inputUsername).clear();
        driver.findElement(inputUsername).sendKeys(newUsername);
        driver.findElement(inputPassword).clear();
        driver.findElement(inputPassword).sendKeys(newPassword);
        driver.findElement(btnGuardar).click();
    }

    


}
