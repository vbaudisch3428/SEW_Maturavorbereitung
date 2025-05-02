public class BitcoinStrategy implements PaymentStrategy {
    private String walletAddress;

    public BitcoinStrategy(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        double roundedAmount = (double) Math.round(amount * 100) /100;
        System.out.println("Paying " + roundedAmount + "€ from Wallet: " + walletAddress);
    }
}