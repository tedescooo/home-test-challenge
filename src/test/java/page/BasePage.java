package page;

import common.Categories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {
    private static long WAIT_TIMEOUT = 30;

    private WebDriver driver;
    WebDriverWait wait;

    private @FindBy(id = "keyboard_action_button")
    WebElement actionButton;

    private @FindBy(id = "textViewNote")
    WebElement noteField;

    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    }

    void enterAmount(String amount) {
        amount.chars().forEach(c -> tapAmount((char) c));
    }

    void tapActionButton() {
        actionButton.click();
    }

    void selectCategory(Categories category) {
        By categoryLocator = By.xpath("//android.widget.TextView[@text='" + category.getText() + "']");
        tapActionButton();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(categoryLocator)));
        driver.findElement(categoryLocator).click();
    }

    void enterNote(String note) {
        noteField.sendKeys(note);
    }

    private void tapAmount(Character amount) {
        String amountKeyLocatorTemplate = "buttonKeyboard%s";

        wait.until(ExpectedConditions.visibilityOf(actionButton));

        if (amount == '.') {
            driver.findElement(By.id(String.format(amountKeyLocatorTemplate, "Dot"))).click();
        } else {
            driver.findElement(By.id(String.format(amountKeyLocatorTemplate, amount))).click();
        }
    }
}
