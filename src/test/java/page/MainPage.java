package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    @FindBy(id = "expense_button")
    private WebElement expenseButton;

    @FindBy(id = "income_button")
    private WebElement incomeButton;

    @FindBy(id = "balance_amount")
    private WebElement balanceButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openNewExpense() {
        expenseButton.click();
    }

    public void openNewIncome() {
        incomeButton.click();
    }

    public void openBalancePage() {
        balanceButton.click();
    }

    public String getBalance() {
        return balanceButton.getText().split(" ")[1];
    }
}
