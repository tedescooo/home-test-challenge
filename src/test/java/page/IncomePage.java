package page;

import common.Categories;
import org.openqa.selenium.WebDriver;

public class IncomePage extends BasePage {
    private WebDriver driver;

    public IncomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterIncome(String amount, Categories category) {
        enterAmount(amount);
        selectCategory(category);
    }

    public void enterIncome(String amount, String note, Categories category) {
        enterAmount(amount);
        enterNote(note);
        selectCategory(category);
    }
}
