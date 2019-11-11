package com.example.warehouse.dao;

import com.example.warehouse.entity.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface GoodsMapper {
    List<Goods> getGoodsList(String gName);

    int addGoods(Goods goods);

    int updateGoods(Goods goods);

    @Delete("delete from goods where gid=#{gid}")
    int deleteGoods(int gid);
}
