package com.example.warehouse.service.impl;

import com.example.warehouse.dao.WarehouseMapper;
import com.example.warehouse.entity.Warehouse;
import com.example.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class warehouseServiceImpl implements WarehouseService {
    @Autowired
    WarehouseMapper warehouseMapper;
    @Override
    public List<Warehouse> getWarehouseList(String wName) {
        return warehouseMapper.getWarehouseList(wName);
    }

    @Override
    public boolean addWarehouse(Warehouse warehouse) {
        return warehouseMapper.addWarehouse(warehouse)>0;
    }

    @Override
    public boolean updateWarehouse(Warehouse warehouse) {
        return warehouseMapper.updateWarehouse(warehouse)>0;
    }

    @Override
    public boolean deleteWarehouse(int wid) {
        return warehouseMapper.deleteWarehouse(wid)>0;
    }
}
