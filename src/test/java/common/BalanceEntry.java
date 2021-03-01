package common;

public class BalanceEntry {
    private String note;
    private String amount;
    private String date;
    private Categories category;

    public BalanceEntry(String amount, String note, String date, Categories category) {
        this.amount = amount;
        this.note = note;
        this.date = date;
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public boolean equals(BalanceEntry balanceEntry) {
        return this.amount.equals(balanceEntry.getAmount())
                && this.note.equals(balanceEntry.getNote())
                && this.date.equals(balanceEntry.getDate())
                && this.category.equals(balanceEntry.getCategory());
    }
}
