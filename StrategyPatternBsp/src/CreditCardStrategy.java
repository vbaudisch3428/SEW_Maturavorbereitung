public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;

    public  CreditCardStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        double roundedAmount = (double) Math.round(amount * 100) /100;
        System.out.println("Paying " + roundedAmount + "€ from Card Number: " + cardNumber);
    }
}
