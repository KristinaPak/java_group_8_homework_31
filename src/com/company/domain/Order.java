package com.company.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Order {
    // Этот блок кода менять нельзя! НАЧАЛО!
    private final com.company.domain.Customer customer;
    private static List<com.company.domain.Item> items;
    private final boolean homeDelivery;
    private transient double total = 0.0d;

    public Order(com.company.domain.Customer customer, List<com.company.domain.Item> orderedItems, boolean homeDelivery) {
        this.customer = customer;
        this.items = List.copyOf(orderedItems);
        this.homeDelivery = homeDelivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return homeDelivery == order.homeDelivery &&
                Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, homeDelivery);
    }

    public List<com.company.domain.Item> getItems() {
        return items;
    }

    public boolean isHomeDelivery() {
        return homeDelivery;
    }

    public com.company.domain.Customer getCustomer() {
        return customer;
    }

    public double getTotal() {
        return total;
    }
    // Этот блок кода менять нельзя! КОНЕЦ!

    //----------------------------------------------------------------------
    //------   Реализация ваших методов должна быть ниже этой линии   ------
    //----------------------------------------------------------------------


    public void calculateTotal() {
        var totalPrice = items.stream()
                .mapToDouble(items -> items.getPrice())
                .sum();
        System.out.println(totalPrice);
    }

    public void printOrder() {
        var orders = new ArrayList<Order>();
        for (var order : orders) {
            for (var ord: order.getItems()){
                orders.add(order);
            }
        }
        System.out.println(orders);
    }
    public void maxPrice() {
        var maxPrice = items.stream()
                .limit(5)
                .max(Comparator.comparingDouble(Item::getPrice)).get();
        System.out.println(maxPrice);
    }
    public void minPrice() {
        var minPrice = items.stream()
                .limit(5)
                .min(Comparator.comparingDouble(Item::getPrice)).get();
        System.out.println(minPrice);
    }
    public void printHomeOrder() {
        var home = items.stream()
                .filter(item -> item.getType().equals(homeDelivery))
                .collect(Collectors.toList());
        System.out.println(home);
    }
    public void maxPriceHomeOrder() {
        var homeSort = items.stream()
                .filter(item -> item.getType().equals(homeDelivery))
                .sorted(Comparator.comparing(Item::getPrice))
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(homeSort);
    }

    public void avOrder() {
        var sort = items.stream()
                .sorted(Comparator.comparing(Item::getPrice))
                .skip(1)
                .collect(Collectors.toList());
        var resort = items.stream()
                .sorted(Comparator.comparing(Item::getPrice))
                .skip(getItems().lastIndexOf(items))
                .collect(Collectors.toList());
        System.out.println(sort);
        System.out.println(resort);

    }

    public void totalPrice() {
        var total = items.stream()
                .mapToDouble(item -> item.getPrice())
                .sum();
        System.out.println(total);
    }

    public void printEmails() {
        var emails = items.stream()
                .map(item -> customer.getEmail())
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(emails);
    }

}
