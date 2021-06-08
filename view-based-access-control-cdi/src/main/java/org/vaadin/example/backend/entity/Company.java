package org.vaadin.example.backend.entity;

import java.util.ArrayList;
import java.util.List;

public class Company {
  private final String name;
  private final String description;
  private final String feedback;
  private final List<Contact> employees = new ArrayList<>();

  public Company(String name, String description, String feedback) {
    this.name = name;
    this.description = description;
    this.feedback = feedback;
  }

  public String getName() {
    return name;
  }

  public List<Contact> getEmployees() {
    return employees;
  }

  public String getDescription() {
    return description;
  }

  public String getFeedback() {
    return feedback;
  }
}