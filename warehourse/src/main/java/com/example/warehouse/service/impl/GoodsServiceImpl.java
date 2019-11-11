package com.example.warehouse.service.impl;

import com.example.warehouse.dao.GoodsMapper;
import com.example.warehouse.dao.Goods_WarehouseMapper;
import com.example.warehouse.entity.Goods;
import com.example.warehouse.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    Goods_WarehouseMapper goods_warehouseMapper;
    @Override
    public List<Goods> getGoodsList(String gName) {
        return goodsMapper.getGoodsList(gName);
    }

    @Override
    public boolean addGoods(Goods goods) {
        return goodsMapper.addGoods(goods)>0;
    }

    @Override
    public boolean updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods)>0;
    }

    @Override
    public boolean deleteGoods(int gid) {
        return goodsMapper.deleteGoods(gid)>0;
    }

    @Override
    public boolean addGoods_Warehouse(int gid, int wid) {
        return goods_warehouseMapper.addGoods_Warehouse(gid,wid)>0;
    }

    @Override
    public boolean updateGoods_Warehouse(int gid, int wid) {
        return goods_warehouseMapper.updateGoods_Warehouse(gid,wid)>0;
    }
    @Override
    public boolean deleteGoods_Warehouse(int gid) {
        return goods_warehouseMapper.deleteGoods_Warehouse(gid)>0;
    }
}
