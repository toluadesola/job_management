package com.tolulope.payoneer.repository;

import com.tolulope.payoneer.model.warehouse.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse, Long> {
}
