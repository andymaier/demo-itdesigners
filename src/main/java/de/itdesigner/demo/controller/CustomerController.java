package de.itdesigner.demo.controller;

import static org.mockito.Mockito.description;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.itdesigner.demo.domain.Customer;
import de.itdesigner.demo.repo.CustomerRepo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("customer")
@OpenAPIDefinition(info = @Info(title = "CustomerController", description = "Customers abrufen und verändern", version = "1.0"))
public class CustomerController {

    @Autowired
    CustomerRepo repo;

    @GetMapping
    public List<Customer> get() {
        return repo.findAll();
    }

    @PostMapping("{count}")
    public ResponseEntity<List<Customer>> create(@PathVariable int count) {

        List<Customer> list = new ArrayList<Customer>();
        for (int i = 1; i < count; i++) {
            Customer c = new Customer();
            c.setName("name_" + i);
            c.setVorname("vorname_" +i);
            c.setAdresse("adresse_" + i);
            //..
            list.add(repo.save(c));
        }
        return ResponseEntity.ok(list);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description= "alles gut", content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "401", description = "du darfst nicht"),
        @ApiResponse(responseCode = "403", description = "verboten"),
    })
    @GetMapping("byVorname/{vorname}")
    public ResponseEntity<List<Customer>> getByVorname(@PathVariable String vorname) {
        return ResponseEntity.ok(repo.findAllCustomerByVornameContaining(vorname));
    }

}
