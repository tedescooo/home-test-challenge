package page;

import common.Categories;
import org.openqa.selenium.WebDriver;

public class ExpensePage extends BasePage {
    private WebDriver driver;

    public ExpensePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterExpense(String amount, Categories category) {
        enterAmount(amount);
        selectCategory(category);
    }

    public void enterExpense(String amount, String note, Categories category) {
        enterAmount(amount);
        enterNote(note);
        selectCategory(category);
    }
}
