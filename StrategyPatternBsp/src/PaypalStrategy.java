public class PaypalStrategy implements PaymentStrategy {
    private String email;

    public  PaypalStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        double roundedAmount = (double) Math.round(amount * 100) /100;
        System.out.println("Paying " + roundedAmount + "€ from Email: " + email);
    }
}
