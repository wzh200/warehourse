package com.example.warehouse.dao;

import com.example.warehouse.entity.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Goods_WarehouseMapper {
    int addGoods_Warehouse(@Param("gid") int gid,@Param("wid") int wid);

    int updateGoods_Warehouse(@Param("gid") int gid,@Param("wid") int wid);

    @Delete("delete from goods_warehouse where gid=#{gid}")
    int deleteGoods_Warehouse(int gid);
}
