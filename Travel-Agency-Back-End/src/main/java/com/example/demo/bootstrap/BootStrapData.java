package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Division socal = new Division(49L, "Socal");
        socal.setCountry_id(1L);
        divisionRepository.save(socal);

        //Add seed data only once, when the application first runs with its single default customer
        if(customerRepository.count() == 1) {

            Customer Chris = new Customer("Chris", "Brock", "317 Old Jennings Rd.", "32003", "9045375170");
            Chris.setDivision(socal);
            customerRepository.save(Chris);

            Customer Danielle = new Customer("Danielle", "Purdy", "33171 Madera De Playa", "92592", "9998675309");
            Danielle.setDivision(socal);
            customerRepository.save(Danielle);

            Customer Jennifer = new Customer("Jennifer", "Munster", "1300 Towncenter Pkwy", "92592", "9042150552");
            Jennifer.setDivision(socal);
            customerRepository.save(Jennifer);

            Customer James = new Customer("Jim", "Radford", "1687 Harbor Lake Dr.", "99991", "9871234567");
            James.setDivision(socal);
            customerRepository.save(James);

            Customer Hillary = new Customer("Hillary", "Dion", "2255 Stern Way", "92336", "9048666488");
            Hillary.setDivision(socal);
            customerRepository.save(Hillary);
        }

    }
}
