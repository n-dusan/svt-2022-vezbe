package rs.ac.uns.ftn.svtvezbe02.primer01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication // Same as @Configuration @EnableAutoConfiguration @ComponentScan
public class PurchaseApplication01 implements CommandLineRunner {

    @Autowired
    private Purchase purchase;

    public static void main(String[] args) {
        SpringApplication.run(PurchaseApplication01.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            CreditCard card = new CreditCard("4111 1111 1111 1111", 1, 2021, "John Doe");
            Order order = new Order(new Date(), card, new ArrayList<>(), new ArrayList<>(), new BigDecimal(200));

            boolean status = purchase.processOrder(order);
            System.out.println(status ?
                    "Order processed." :
                    "Order rejected.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
