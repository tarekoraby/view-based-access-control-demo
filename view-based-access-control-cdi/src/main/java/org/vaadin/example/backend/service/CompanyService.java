package org.vaadin.example.backend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.vaadin.example.backend.entity.Company;

public class CompanyService {

    public List<Company> findAll() {
        return Stream.of("Path-Way Electronics", "E-Tech Management", "Path-E-Tech Management")
                .map(Company::new)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getStats() {
        Random random = new Random(0);
        HashMap<String, Integer> stats = new HashMap<>();
        findAll().forEach(company ->
                stats.put(company.getName(), random.nextInt(10)));
        return stats;
    }
}
