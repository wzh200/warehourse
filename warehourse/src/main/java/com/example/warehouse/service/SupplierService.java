package com.example.warehouse.service;

import com.example.warehouse.entity.Supplier;

import java.util.HashMap;
import java.util.List;

public interface SupplierService {

    List<Supplier> getSupplierList(HashMap<String, Object> map);

    Boolean updateSupplier(Supplier supplier);

    Boolean addSupplier(Supplier supplier);

    Boolean deleteSupplier(int sid);

    int getSupplierNum(String sName);
}
