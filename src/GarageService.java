import java.util.*;

public class GarageService {

    private Map<String, Customer> customerMap;
    private List<Service> availableServices;

    public GarageService(){
        this.customerMap = new HashMap<>();
        this.availableServices = new ArrayList<>();
        loadServices();
    }

    public void loadServices(){
        availableServices.add(new Service("Car Wash", 500));
        availableServices.add(new Service("Oil Change", 700));
        availableServices.add(new Service("Wheel Alignment", 300));
        availableServices.add(new Service("Tyre Replacement", 3000));
        availableServices.add(new Service("Puncture", 50));
    }

    public void addCustomer(String name, String phone, String carNumber, String model){
        Car car = new Car(carNumber, model);
        Customer customer = new Customer(name, phone, car);
        customerMap.put(carNumber,customer);
        System.out.println("Customer added successfully...");
    }

    public void createInvoice(String carNumber){
        if(!customerMap.containsKey(carNumber)){
            System.out.println("No Customer found with car number: "+ carNumber);
            return;
        }
        Scanner sc = new Scanner(System.in);
        Customer customer = customerMap.get(carNumber);
        Invoice invoice = new Invoice(customer);
        System.out.println("Available Services: ");
        for(int i=0; i<availableServices.size(); i++){
            System.out.println((i+1)+". "+availableServices.get(i).getServiceName()+" - $: "+availableServices.get(i).getPrice());
        }

        while (true){
            System.out.println("Enter the Service number to add or 0 to finish: ");

            int choice = sc.nextInt();
            if(choice == 0){
                break;
            }
            if(choice > 0 && choice <= availableServices.size()){
                invoice.addServices(availableServices.get(choice-1));
                System.out.println("service done...");
            }
            else {
                System.out.println("Invalid choice!!!");
            }
        }
        invoice.printInvoice();
    }
}
