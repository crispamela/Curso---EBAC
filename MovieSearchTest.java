package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import static org.junit.Assert.assertEquals;

public class MovieSearchTest {
    WebDriver driver;
    HomePage homePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "caminho/do/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seusitefilmes.com"); // Trocar pelo site real

        homePage = new HomePage(driver);
    }

    @Test
    public void testSearchExistingMovie() {
        homePage.enterMovieName("Inception");
        homePage.clickSearch();

        String title = homePage.getResultTitle();
        assertEquals("Inception", title);
    }

    @Test
    public void testSearchNonExistingMovie() {
        homePage.enterMovieName("FilmeInexistente123");
        homePage.clickSearch();

        String error = homePage.getErrorMessage();
        assertEquals("Filme não encontrado.", error);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
