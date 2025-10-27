import java.util.InputMismatchException;
import java.util.Scanner;

public class GarageBillingApp {
    public static void main(String[] args) {

        GarageService garageService = new GarageService();

        System.out.println("========== Bharati Car Service Center ==========");

        try(Scanner sc = new Scanner(System.in);) {

            while (true) {
                try {
                    System.out.println("1) Add Customer");
                    System.out.println("2) Display Services");
                    System.out.println("3) Exit");
                    System.out.println("4) Display Customer Details");

                    System.out.print("Enter your Choice: ");
                    int choice = sc.nextInt();
                    System.out.println();

                    switch (choice) {

                        case 1:
                            System.out.print("Enter Customer Name: ");
                            sc.nextLine();
                            String name = sc.nextLine();
                            System.out.print("Enter Customer Phone Number: ");
                            String number = sc.next();
                            System.out.print("Enter Car Number: ");
                            sc.nextLine();
                            String carNumber = sc.nextLine();
                            System.out.print("Enter Car Model: ");
                            String carModel = sc.next();
                            sc.nextLine();
                            garageService.addCustomer(name, number, carNumber, carModel);
                            System.out.println();
                            break;

                        case 2:
                            System.out.println("Enter the Car Number: ");
                            sc.nextLine();
                            String carNo = sc.nextLine();
                            garageService.createInvoice(carNo);
                            System.out.println();
                            break;

                        case 3:
                            System.out.println("Exiting....");
                            return;

                        default:
                            System.out.println("Invalid choice! Try again....");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Invalid input, please enter the number. " + e.getMessage());
                    sc.nextLine();
                    System.out.println();
                }
            }
        }
        finally {
            System.out.println("---------- Thank You ----------");
        }
    }
}
