public class RDAccount extends Account {

    private int noOfMonths;
    private double monthlyAmount;
    private int ageOfACHolder;

    public RDAccount(double monthlyAmount, int noOfMonths, int ageOfACHolder) {
        super(monthlyAmount);
        this.monthlyAmount = monthlyAmount;
        this.noOfMonths = noOfMonths;
        this.ageOfACHolder = ageOfACHolder;
    }

    @Override
    public double calculateInterest() {

        if (ageOfACHolder >= 60) {

            switch (noOfMonths) {
                case 6:
                    interestRate = 8.0;
                    break;
                case 9:
                    interestRate = 8.25;
                    break;
                case 12:
                    interestRate = 8.5;
                    break;
                case 15:
                    interestRate = 8.75;
                    break;
                case 18:
                    interestRate = 9.0;
                    break;
                case 21:
                    interestRate = 9.25;
                    break;
                default:
                    interestRate = 0;
            }

        } else {

            switch (noOfMonths) {
                case 6:
                    interestRate = 7.5;
                    break;
                case 9:
                    interestRate = 7.75;
                    break;
                case 12:
                    interestRate = 8.0;
                    break;
                case 15:
                    interestRate = 8.25;
                    break;
                case 18:
                    interestRate = 8.5;
                    break;
                case 21:
                    interestRate = 8.75;
                    break;
                default:
                    interestRate = 0;
            }
        }

        return (monthlyAmount * noOfMonths * interestRate) / 100;
    }
}