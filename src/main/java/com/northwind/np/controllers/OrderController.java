package com.northwind.np.controllers;

import com.northwind.np.dto.OrderDTO;
import com.northwind.np.services.OrderService;
import com.northwind.np.util.ConvertDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/northwind/orders")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrderDTO();
    }

    @GetMapping(value="/northwind/orders", params={"customerId"})
    public List<OrderDTO> getOrdersByCustomer(@RequestParam String customerId) {
        return orderService.getOrdersByCustomer(customerId);
    }

    @GetMapping("/northwind/orders/{orderID}")
    public List<OrderDTO> getOrderByID(@PathVariable Optional<Integer> orderID) {
        List<OrderDTO> orders = new ArrayList<>();
        if (orderID.isPresent()) {
            for (OrderDTO o : orderService.getAllOrderDTO()) {
                if (o.getOrderID() == orderID.get()) {
                    orders.add(o);
                    break;
                }
            }
        }
        return orders;
    }

    @GetMapping("/northwind/orders/customer/{customerID}")
    public List<OrderDTO> getOrdersCustomerID(Optional<String> customerID) {
        List<OrderDTO> orders = new ArrayList<>();
        if (customerID.isPresent()) {
            for (OrderDTO o : orderService.getAllOrderDTO()) {
                if (o.getCustomerId().equals(customerID.get())) {
                    orders.add(o);
                    break;
                }
            }
        }
        return orders;
    }

    //TODO: Null handling
    @GetMapping("/northwind/orders/location")
    public List<OrderDTO> getOrdersByCountryAndRegion(String country, String region) {
        List<OrderDTO> results = new ArrayList<>();

        if (country != null && region != null) {
            for (OrderDTO o : orderService.getAllOrderDTO()) {
                if (o.getShipCountry() != null && o.getShipRegion() != null) {
                    if (o.getShipCountry().contains(country) && o.getShipRegion().contains(region)) {
                        results.add(o);
                    }
                }
            }
        } else if (region == null) {
            for (OrderDTO o : orderService.getAllOrderDTO()) {
                if (o.getShipCountry() != null && o.getShipCountry().contains(country)) {
                    results.add(o);
                }
            }
        }
        return results;
    }

    @GetMapping("/northwind/orders/date")
    public List<OrderDTO> getOrdersByDate(String orderDate, String shippedDate) {
        List<OrderDTO> results = new ArrayList<>();

        if (orderDate != null && shippedDate != null) {
            for (OrderDTO o : orderService.getAllOrderDTO()) {
                if (o.getOrderDate() != null && o.getShipDate() != null) {
                    if (o.getOrderDate().equals(ConvertDate.getDateAsInstant(orderDate))
                            && o.getShipDate().equals(ConvertDate.getDateAsInstant(shippedDate))) {
                        results.add(o);
                    }
                }
            }
        } else if (shippedDate == null) {
            for (OrderDTO o : orderService.getAllOrderDTO()) {
                if (o.getOrderDate() != null && o.getOrderDate().equals(orderDate)) {
                    results.add(o);
                }
            }
        }
        return results;
    }

    @GetMapping(value="/northwind/orders", params={"employeeId"})
    public List<OrderDTO> getOrdersByEmployeeId(@RequestParam Integer employeeId) {
        return orderService.getOrdersByEmployeeId(employeeId);
    }

}
