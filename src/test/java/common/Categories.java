package common;

public enum Categories {
    BILLS("Bills"),
    CAR("Car"),
    CLOTHES("Clothes"),
    DEPOSITS("Deposits"),
    SALARY("Salary");

    private String text;

    Categories(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Categories fromString(String text) {
        for (Categories b : Categories.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
