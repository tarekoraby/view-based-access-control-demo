package org.vaadin.example.backend.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.vaadin.example.backend.entity.Company;

import com.vaadin.cdi.annotation.VaadinServiceScoped;

@VaadinServiceScoped
public class CompanyService {

    public List<Company> findAll() {

        Company pathWayElectronics = new Company("Path-Way Electronics",
                "Path-Way Electronics is an electronics manufacturing corporation",
                "Competitive electronic components prices");
        Company eTechManagement = new Company("E-Tech Management",
                "E-Tech Management is a global sourcing company in the electronics recycling industry",
                "Fast delivery, friendly managers");
        Company pathETech = new Company("Path-E-Tech Management",
                "Path-E-Tech Management is the company where Dilbert, Dogbert, Wally, Alice, " +
                "Asok, Tina, the Pointy-Haired Boss, Carol, Loud Howard, Catbert, and many others work",
                "Company has been successful and made lots of money, becoming" +
                " a multi-billion dollar company");
        return Arrays.asList(pathWayElectronics, eTechManagement, pathETech);
    }

    public Map<String, Integer> getStats() {
        Random random = new Random(0);
        HashMap<String, Integer> stats = new HashMap<>();
        findAll().forEach(company ->
                stats.put(company.getName(), random.nextInt(10)));
        return stats;
    }
}
