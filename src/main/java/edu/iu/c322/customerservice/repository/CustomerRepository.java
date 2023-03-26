package edu.iu.c322.customerservice.repository;

import java.util.ArrayList;
import java.util.List;

import edu.iu.c322.customerservice.model.Customer;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerRepository
{
    List<Customer> customers = new ArrayList<>();

    public List<Customer> findAll()
    {
        return customers;
    }

    public int create(Customer customer)
    {
        int id = customers.size() + 1;
        customer.setId(id);
        customers.add(customer);
        return id;
    }

    public void update(Customer customer, int id)
    {
        Customer x = getById(id);
        if(x != null)
        {
            x.setEmail(customer.getEmail());
            x.setName(customer.getEmail());
        }
        else
        {
            throw new IllegalStateException("Customer with this id was not found.");
        }
    }

    private Customer getById(int id)
    {
        Customer c = customers.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        return c;
    }

    public void delete(int id)
    {
        Customer x = getById(id);
        if(x != null)
        {
            customers.remove(x);
        }
        else
        {
            throw new IllegalStateException("customer with this id was not found.");
        }
    }
}
