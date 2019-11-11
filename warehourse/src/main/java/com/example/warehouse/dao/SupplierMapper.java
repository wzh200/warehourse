package com.example.warehouse.dao;

import com.example.warehouse.entity.Supplier;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Mapper
@Repository
public interface SupplierMapper {

    List<Supplier> getSupplierList(HashMap<String, Object> map);

    int updateSupplier(Supplier supplier);

    int addSupplier(Supplier supplier);

    @Delete("delete from supplier where sid=#{sid}")
    int deleteSupplier(int sid);

    int getSupplierNum(String sName);
}
