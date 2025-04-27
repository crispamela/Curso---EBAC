package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // Locators
    By searchInput = By.id("search"); // Ajuste conforme o ID real
    By searchButton = By.id("searchButton"); // Ajuste conforme o botão real
    By resultTitle = By.cssSelector(".movie-title"); // Ajuste conforme o HTML real
    By errorMessage = By.cssSelector(".error-message"); // Ajuste conforme o HTML real

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterMovieName(String movieName) {
        driver.findElement(searchInput).sendKeys(movieName);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public String getResultTitle() {
        return driver.findElement(resultTitle).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
