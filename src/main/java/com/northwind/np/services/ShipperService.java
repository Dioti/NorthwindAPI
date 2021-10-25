package com.northwind.np.services;

import com.northwind.np.dto.ShipperDTO;
import com.northwind.np.entities.ShipperEntity;
import com.northwind.np.repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipperService {

    @Autowired
    private ShipperRepository shipperRepository;

    public List<ShipperDTO> getAllShippers() {
        return shipperRepository
                .findAll()
                .stream()
                .map(this::convertToShipperDTO)
                .collect(Collectors.toList());
    }

    private ShipperDTO convertToShipperDTO(ShipperEntity shipperEntity) {
        return new ShipperDTO(shipperEntity);
    }

}
