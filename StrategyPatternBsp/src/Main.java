public class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Item item1 = new Item("Monster Ultra White", 1.69);
        Item item2 = new Item("Leberkassemmel", 2.50);

        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        shoppingCart.pay(new CreditCardStrategy("1234-5678-9012-3456"));
        shoppingCart.pay(new PaypalStrategy("myemail@example.com"));
        shoppingCart.pay(new BitcoinStrategy("mywalletaddress"));
    }
}
