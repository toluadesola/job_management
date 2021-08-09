package com.tolulope.payoneer.service.serviceImplementation;

import com.tolulope.payoneer.model.Status;
import com.tolulope.payoneer.model.warehouse.WareHouse;
import com.tolulope.payoneer.repository.WareHouseRepository;
import com.tolulope.payoneer.service.WareHouseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@Slf4j
@AllArgsConstructor
public class WareHouseServiceImpl implements WareHouseService {

    private final WareHouseRepository wareHouseRepository;

    @Override
    public String saveToWareHouse(@RequestBody WareHouse wareHouse)
    {

        Status status = null;
        try{
            status = Status.RUNNING;
            wareHouse.setUnit_price(wareHouse.getUnit_price() * 100);
            wareHouseRepository.save(wareHouse);
            status = Status.SUCCESS;

        }catch (Exception e){
            if(wareHouse.getId() == null) status = Status.FAILED;
        }

        return "Job Done";
    }
}
