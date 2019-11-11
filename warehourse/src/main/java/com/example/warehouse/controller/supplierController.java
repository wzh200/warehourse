package com.example.warehouse.controller;

import com.example.warehouse.entity.Supplier;
import com.example.warehouse.entity.User;
import com.example.warehouse.service.SupplierService;
import com.example.warehouse.tool.Page;
import com.example.warehouse.tool.Pagetool;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class supplierController {
    @Autowired
    SupplierService supplierService;

    @RequestMapping("/getSupplierList")
    public String getSupplierList(HttpSession session, @RequestParam(defaultValue = "", required = false) String sName, @RequestParam(defaultValue = "1", required = false) int pageIndex) {
        Pagetool<Supplier> pagetool = new Pagetool<Supplier>();
        int pageNumber = supplierService.getSupplierNum(sName);
        Page<Supplier> page = pagetool.pageTool(pageIndex, pageNumber);
        List<Supplier> suppliers = supplierService.getSupplierList(pagetool.hashMap(sName));
        page.setList(suppliers);
        session.setAttribute("suppliersPage", page);
        return "supplierTable";
    }

    @RequestMapping("/updateSupplier")
    public String updateSupplier(Supplier supplier, RedirectAttributes model) {
        boolean flag = supplierService.updateSupplier(supplier);
        if (!flag) {
            model.addFlashAttribute("updateSupplierMsg", "更新失败");
        }
        return "redirect:/getSupplierList";
    }

    @RequestMapping("/addSupplier")
    public String addSupplier(Supplier supplier, RedirectAttributes model) {
        boolean flag = supplierService.addSupplier(supplier);
        if (!flag) {
            model.addFlashAttribute("updateSupplierMsg", "添加失败");
        }
        return "redirect:/getSupplierList";
    }

    @RequestMapping("/deleteSupplier")
    public String deleteSupplier(int sid, RedirectAttributes model) {
        boolean flag = supplierService.deleteSupplier(sid);
        if (!flag) {
            model.addFlashAttribute("updateSupplierMsg", "删除失败");
        }
        return "redirect:/getSupplierList";
    }
}
