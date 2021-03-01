package page;

import common.BalanceEntry;
import common.Categories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BalancePage extends BasePage {
    private WebDriver driver;
    private By balanceCategoryTextLocator = By.id("textViewCategoryName");
    private List<BalanceEntry> balanceEntries;

    public BalancePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public List<BalanceEntry> getBalanceList() {
        balanceEntries = new ArrayList<>();
        String balanceEntriesLocator = "//*[@resource-id='com.monefy.app.lite:id/textViewTransactionDate']/..";

        for (WebElement element : driver.findElements(balanceCategoryTextLocator)) {
            Categories category = Categories.fromString(element.getText());
            element.click();

            driver.findElements(By.xpath(balanceEntriesLocator))
                    .forEach(balanceEntry -> extractBalance(balanceEntry, category));
        }

        return balanceEntries;
    }

    private void extractBalance(WebElement entry, Categories category) {
        By amountLocator = By.id("textViewTransactionAmount");
        By noteLocator = By.id("textViewTransactionNote");
        By dateLocator = By.id("textViewTransactionDate");

        BalanceEntry balanceEntry = new BalanceEntry(
                entry.findElement(amountLocator).getText(),
                entry.findElement(noteLocator).getText(),
                entry.findElement(dateLocator).getText(),
                category);

        if (balanceEntries.stream().noneMatch(b -> b.getAmount().equals(balanceEntry.getAmount()))) {
            balanceEntries.add(balanceEntry);
        }
    }
}
