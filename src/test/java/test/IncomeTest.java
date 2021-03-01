package test;

import common.BalanceEntry;
import common.Categories;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IncomeTest extends BaseTest {

    @Before
    public void setup() {
        mainPage.openNewIncome();
    }

    @Test
    public void addNewIncome() {
        incomePage.enterIncome("22.99", Categories.SALARY);

        Assert.assertEquals("$22.99", mainPage.getBalance());
    }

    @Test
    public void checkIncomesBalance() {
        BalanceEntry expected1 = new BalanceEntry("$33.77", "Test Deposit", getCurrentDateString(), Categories.DEPOSITS);
        BalanceEntry expected2 = new BalanceEntry("$11.11", "", getCurrentDateString(), Categories.SALARY);

        incomePage.enterIncome("33.77", "Test Deposit", Categories.DEPOSITS);
        mainPage.openNewIncome();
        incomePage.enterIncome("11.11", "", Categories.SALARY);
        mainPage.openBalancePage();

        List<BalanceEntry> balanceEntries = balancePage.getBalanceList();

        Assert.assertTrue(isBalanceEntryPresent(balanceEntries, expected1));
        Assert.assertTrue(isBalanceEntryPresent(balanceEntries, expected2));
        Assert.assertEquals("$44.88", mainPage.getBalance());
    }

    @Test
    public void checkMixedBalance() {
        BalanceEntry expected1 = new BalanceEntry("$33.77", "Test Deposit", getCurrentDateString(), Categories.DEPOSITS);
        BalanceEntry expected2 = new BalanceEntry("$11.11", "", getCurrentDateString(), Categories.BILLS);

        incomePage.enterIncome("33.77", "Test Deposit", Categories.DEPOSITS);
        mainPage.openNewExpense();
        expensePage.enterExpense("11.11", "", Categories.BILLS);
        mainPage.openBalancePage();

        List<BalanceEntry> balanceEntries = balancePage.getBalanceList();

        Assert.assertTrue(isBalanceEntryPresent(balanceEntries, expected1));
        Assert.assertTrue(isBalanceEntryPresent(balanceEntries, expected2));
        Assert.assertEquals("$22.66", mainPage.getBalance());
    }
}
