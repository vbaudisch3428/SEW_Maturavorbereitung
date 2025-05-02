import java.util.Scanner;

public class DesignPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Design Pattern Demo");
        System.out.println("1 = Strategy");
        System.out.println("2 = Observer");
        System.out.println("3 = Composite");
        System.out.print("Choose a demo: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> StrategyDemo.run();
            case 2 -> ObserverDemo.run();
            case 3 -> CompositeDemo.run();
            default -> System.out.println("Invalid choice");
        }
    }
}