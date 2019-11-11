package com.example.warehouse.controller;

import com.example.warehouse.entity.Goods;
import com.example.warehouse.entity.Supplier;
import com.example.warehouse.entity.Warehouse;
import com.example.warehouse.service.GoodsService;
import com.example.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class goodsController {

    @Autowired
    GoodsService goodsService;
    @Autowired
    WarehouseService warehouseService;

    @RequestMapping("/getGoodsList")
    public String getGoodsList(@RequestParam(required = false) String gName, HttpSession session){
            List<Goods> goodsList=goodsService.getGoodsList(gName);
            List<Warehouse> warehousesList=warehouseService.getWarehouseList("");
            System.out.println(goodsList);
            session.setAttribute("goodsList",goodsList);
            session.setAttribute("warehousesList",warehousesList);
                  return "goodsTable";
    }
    @RequestMapping("/updateGoods")
    public String updateGoods(Goods goods, RedirectAttributes model,int wid) {
        boolean flag = goodsService.updateGoods(goods);
            boolean flag2=goodsService.updateGoods_Warehouse(goods.getGid(),wid);
        if (!flag&&!flag2) {
            model.addFlashAttribute("updateGoodsMsg", "更新失败");
        }
        return "redirect:/getGoodsList";
    }

    @RequestMapping("/addGoods")
    public String addGoods(Goods goods, RedirectAttributes model,int wid) {
        boolean flag = goodsService.addGoods(goods);
        boolean flag2=goodsService.addGoods_Warehouse(goods.getGid(),wid);
        if (!flag&&!flag2) {
            model.addFlashAttribute("updateGoodsMsg", "添加失败");
        }
        return "redirect:/getGoodsList";
    }

    @RequestMapping("/deleteGoods")
    public String deleteGoods(int gid, RedirectAttributes model) {
        boolean flag = goodsService.deleteGoods(gid);
        boolean flag2=goodsService.deleteGoods_Warehouse(gid);
        if (!flag&&!flag2) {
            model.addFlashAttribute("updateGoodsMsg", "删除失败");
        }
        return "redirect:/getGoodsList";
    }

}
