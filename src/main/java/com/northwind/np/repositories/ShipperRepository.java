package com.northwind.np.repositories;

import com.northwind.np.entities.ShipperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<ShipperEntity, Integer> {
}