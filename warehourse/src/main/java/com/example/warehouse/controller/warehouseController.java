package com.example.warehouse.controller;

import com.example.warehouse.entity.Warehouse;
import com.example.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class warehouseController {

  @Autowired
  WarehouseService warehouseService;
    @RequestMapping("/getWarehouseList")
    public String getWarehouseList(@RequestParam(required = false) String wName, HttpSession session){
        List<Warehouse> warehouseList=warehouseService.getWarehouseList(wName);
        session.setAttribute("warehouseList",warehouseList);
        return "warehouseTable";
    }
    @RequestMapping("/updateWarehouse")
    public String updateWarehouse(Warehouse warehouse, RedirectAttributes model) {
        boolean flag = warehouseService.updateWarehouse(warehouse);
        if (!flag) {
            model.addFlashAttribute("updateWarehouseMsg", "更新失败");
        }
        return "redirect:/getWarehouseList";
    }

    @RequestMapping("/addWarehouse")
    public String addWarehouse(Warehouse warehouse, RedirectAttributes model) {
        boolean flag = warehouseService.addWarehouse(warehouse);
        if (!flag) {
            model.addFlashAttribute("updateWarehouseMsg", "添加失败");
        }
        return "redirect:/getWarehouseList";
    }

    @RequestMapping("/deleteWarehouse")
    public String deleteWarehouse(int wid, RedirectAttributes model) {
        boolean flag = warehouseService.deleteWarehouse(wid);
        if (!flag) {
            model.addFlashAttribute("updateWarehouseMsg", "删除失败");
        }
        return "redirect:/getWarehouseList";
    }



}
