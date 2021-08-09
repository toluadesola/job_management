package com.tolulope.payoneer.service;

import com.tolulope.payoneer.model.warehouse.WareHouse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface WareHouseService {
    String saveToWareHouse(@RequestBody WareHouse wareHouse);
}
