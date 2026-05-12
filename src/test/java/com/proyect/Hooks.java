package com.proyect;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;




import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void beforeScenario(){
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
        try {
            String path = "target/screenshots/" + scenario.getName().replaceAll(" ", "_") + ".png";

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // también lo adjuntás a Cucumber (opcional)
            byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(bytes, "image/png", "error");

        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        driver.quit();
    }

}
