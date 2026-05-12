package com.proyect.Steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import com.proyect.Hooks;
import com.proyect.LoginPage;
import com.proyect.UsersPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersSteps {
    WebDriver driver;
    LoginPage loginPage;
    UsersPage usersPage;

    String username;
    String password;
    String newUsername;
    String newPassword;
  
    

    @Given ("estoy logueado")
    public void abrirPaginaUsuarios(){
        driver = Hooks.driver;
        loginPage = new LoginPage(driver);
        loginPage.traerPagina();
        loginPage.login("admin","1234");
    }

    @When ("ingreso a la página de usuarios")
    public void ingresarPaginaUsuarios(){
        usersPage = new UsersPage(driver);
    }

    @Then ("deberia ver la lista de usuarios")
    public void validarListaUsuarios(){
        usersPage.esperarCarga();
        assertTrue(usersPage.validarRedireccion("/users"));
        assertTrue (usersPage.validarTitulo());
        assertTrue(usersPage.validarTabla());
        assertTrue (usersPage.validarUsuarioEnLaLista("admin"));
    }

    @Then("hay al menos {int} usuarios")
    public void hayUsuarios(int cantidad){
        usersPage.esperarCarga();
        assertTrue(usersPage.cantidadUsuarios()>=cantidad);
    }


    @Given("estoy en la página de usuarios")
    public void estoyEnPaginaUsuarios(){
        abrirPaginaUsuarios();
        ingresarPaginaUsuarios();
    }

    @When("creo un nuevo usuario")
    public void creoNuevoUsuario(){
        usersPage.esperarCarga();
        usersPage.clickCrearUsuario();
        usersPage.esperarFormulario();
        String username = "testuser" + System.currentTimeMillis();
        String password = "testpass" + System.currentTimeMillis();
        usersPage.crearUsuario(username, password);
        this.username = username;
    }

    @Then("deberia ver el nuevo usuario en la lista")
    public void validarNuevoUsuarioEnLista(){
     usersPage.esperarCarga();
     assertTrue(usersPage.validarUsuarioEnLaLista(username));
    }


    @When ("elimino el usuario creado")
    public void eliminoUsuario(){
        usersPage.eliminarUsuario(username);
    }
     
    @Then ("el usuario deberia haber sido eliminado")
    public void validarUsuarioEliminado(){
        usersPage.esperarUsuarioEliminado(username);
        assertTrue(usersPage.validarUsuarioEliminado(username));
    }

    @When ("edito el nuevo usuario creado")
    public void actualizoUsuario(){
        newUsername = "testUser" + System.currentTimeMillis();
        newPassword = "testPass" + System.currentTimeMillis();
        usersPage.editarUsuario(username, newUsername, newPassword);
    }

    @Then ("el usuario deberia haber sido editado")
    public void usuarioEditado(){
        usersPage.esperarCarga();
        assertTrue(usersPage.validarUsuarioEnLaLista(newUsername));
        assertTrue(usersPage.validarUsuarioEliminado(username));
    }




}
