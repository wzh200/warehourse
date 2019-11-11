package com.example.warehouse.service;

import com.example.warehouse.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {
    List<Goods> getGoodsList(String gName);

    boolean addGoods(Goods goods);

    boolean updateGoods(Goods goods);

    boolean deleteGoods(int gid);

    boolean addGoods_Warehouse(@Param("gid") int gid, @Param("wid") int wid);

    boolean updateGoods_Warehouse(@Param("gid") int gid,@Param("wid") int wid);

    boolean deleteGoods_Warehouse(int gid);
}
