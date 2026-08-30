public abstract class Account {

    protected double interestRate;
    protected double amount;

    public Account() {
    }

    public Account(double amount) {
        this.amount = amount;
    }

    public abstract double calculateInterest();
}