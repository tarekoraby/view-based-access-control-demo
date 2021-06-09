package com.vaadin.tutorial.crm.backend.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.tutorial.crm.backend.entity.Company;
import com.vaadin.tutorial.crm.backend.entity.Contact;

@Service
public class ContactService {

    CompanyService companyService;

    public ContactService(@Autowired CompanyService companyService) {
        this.companyService = companyService;
    }

    public List<Contact> findAll() {
        Random r = new Random(0);
        List<Company> companies = companyService.findAll();
        return Stream.of("Gabrielle Patel", "Brian Robinson", "Eduardo Haugen",
                "Koen Johansen", "Alejandro Macdonald", "Angel Karlsson", "Yahir Gustavsson", "Haiden Svensson",
                "Emily Stewart", "Corinne Davis", "Ryann Davis", "Yurem Jackson", "Kelly Gustavsson",
                "Eileen Walker", "Katelyn Martin", "Israel Carlsson", "Quinn Hansson", "Makena Smith",
                "Danielle Watson", "Leland Harris", "Gunner Karlsen", "Jamar Olsson", "Lara Martin",
                "Ann Andersson", "Remington Andersson", "Rene Carlsson", "Elvis Olsen", "Solomon Olsen",
                "Jaydan Jackson", "Bernard Nilsen")
                .map(name -> {
                    String[] split = name.split(" ");
                    Contact contact = new Contact();
                    contact.setFirstName(split[0]);
                    contact.setLastName(split[1]);
                    Company company = companies.get(r.nextInt(companies.size()));
                    company.getEmployees().add(contact);
                    contact.setCompany(company);
                    contact.setStatus(Contact.Status.values()[r.nextInt(Contact.Status.values().length)]);
                    String email = (contact.getFirstName() + "." + contact.getLastName() + "@" + contact.getCompany().getName().replaceAll("[\\s-]", "") + ".com").toLowerCase();
                    contact.setEmail(email);
                    return contact;
                }).collect(Collectors.toList());
    }

    public int count() {
        return findAll().size();
    }
}
