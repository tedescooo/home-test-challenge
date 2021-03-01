package test;

import common.BalanceEntry;
import common.Categories;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ExpenseTest extends BaseTest {

    @Before
    public void setup() {
        mainPage.openNewExpense();
    }

    @Test
    public void addNewExpense() {
        expensePage.enterExpense("11.11", Categories.CAR);

        Assert.assertEquals("-$11.11", mainPage.getBalance());
    }

    @Test
    public void checkExpensesBalance() {
        BalanceEntry expected1 = new BalanceEntry("$22.33", "Test Expense", getCurrentDateString(), Categories.CLOTHES);
        BalanceEntry expected2 = new BalanceEntry("$11.11", "", getCurrentDateString(), Categories.BILLS);

        expensePage.enterExpense("22.33", "Test Expense", Categories.CLOTHES);
        mainPage.openNewExpense();
        expensePage.enterExpense("11.11", Categories.BILLS);
        mainPage.openBalancePage();

        List<BalanceEntry> balanceEntries = balancePage.getBalanceList();

        Assert.assertTrue(isBalanceEntryPresent(balanceEntries, expected1));
        Assert.assertTrue(isBalanceEntryPresent(balanceEntries, expected2));
        Assert.assertEquals("-$33.44", mainPage.getBalance());
    }
}
