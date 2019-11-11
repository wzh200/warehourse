package com.example.warehouse.service.impl;

import com.example.warehouse.dao.SupplierMapper;
import com.example.warehouse.entity.Supplier;
import com.example.warehouse.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierMapper supplierMapper;
    @Override
    public List<Supplier> getSupplierList(HashMap<String, Object> map) {
        return supplierMapper.getSupplierList(map);
    }
    @Override
    public Boolean updateSupplier(Supplier supplier) {
        return supplierMapper.updateSupplier(supplier) > 0;
    }
    @Override
    public Boolean addSupplier(Supplier supplier) {
        return supplierMapper.addSupplier(supplier)>0;
    }
    @Override
    public Boolean deleteSupplier(int sid) {
        return supplierMapper.deleteSupplier(sid)>0;
    }
    @Override
    public int getSupplierNum(String sName) {
        return supplierMapper.getSupplierNum(sName);
    }
}
