import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private Customer customer;
    private List<Service> serviceList;
    private double totalAmount;

    public Invoice(Customer customer){
        this.customer = customer;
        this.serviceList = new ArrayList<>();
        this.totalAmount =0;
    }

    public void addServices(Service service){
        serviceList.add(service);
        totalAmount+=service.getPrice();
    }

    public void printInvoice(){
        System.out.println("---------- Invoice ----------");
        System.out.println("Customer: "+customer.getName()+" | Phone: "+customer.getPhone());
        System.out.println("Car Number: "+customer.getCar().getCarNumber()+" | Car Model: "+customer.getCar().getModel());
        System.out.println("Services: ");
        for(Service service : serviceList){
            System.out.println("# "+service.getServiceName()+": $"+service.getPrice());
        }
        System.out.println("Total Amount: "+totalAmount);

    }
}
