package com.northwind.np.controllers;

import com.northwind.np.dto.ShipperDTO;
import com.northwind.np.services.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ShipperController {

    private ShipperService shipperService;

    @Autowired
    public ShipperController(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    //TODO: Testing required
    @GetMapping("/northwind/shippers/{shipperId}")
    public List<ShipperDTO> getShippersById(@PathVariable Optional<Integer> shipperId) {
        if (!shipperId.isPresent()) {
            return shipperService.getAllShippers();
        } else {
            List<ShipperDTO> shippers = new ArrayList<>();
            for (ShipperDTO s : shipperService.getAllShippers()) {
                if (s.getShipperID() != null && s.getShipperID() == shipperId.get()) {
                    shippers.add(s);
                    break;
                }
            }
            return shippers;
        }
    }
}
