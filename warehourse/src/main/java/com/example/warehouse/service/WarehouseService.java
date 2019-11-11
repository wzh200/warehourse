package com.example.warehouse.service;

import com.example.warehouse.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
    List<Warehouse> getWarehouseList(String wName);

    boolean addWarehouse(Warehouse warehouse);

    boolean updateWarehouse(Warehouse warehouse);

    boolean deleteWarehouse(int wid);
}
