package com.company;

// import static java.util.stream.Collectors.*;
// import static java.util.Comparator.*;

// используя статические imports
// мы импортируем *всё* из Collectors и Comparator.
// теперь нам доступны такие операции как
// toList(), toSet() и прочие, без указания уточняющего слова Collectors. или Comparator.
// вот так было до импорта Collectors.toList(), теперь стало просто toList()


import com.company.domain.Item;
import com.company.domain.Order;
import com.company.util.GenerateOrder;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        var orders = RestaurantOrders.read("orders_100.json").getOrders();

    }


}
