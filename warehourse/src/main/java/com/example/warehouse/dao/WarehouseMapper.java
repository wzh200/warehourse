package com.example.warehouse.dao;

import com.example.warehouse.entity.Warehouse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface WarehouseMapper {
    List<Warehouse> getWarehouseList(String wName);

    int addWarehouse(Warehouse warehouse);

    int updateWarehouse(Warehouse warehouse);

    @Delete("delete from warehouse where wid=#{wid}")
    int deleteWarehouse(int wid);
}
