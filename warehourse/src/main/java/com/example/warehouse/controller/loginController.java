package com.example.warehouse.controller;
import com.example.warehouse.entity.User;
import com.example.warehouse.service.MailService;
import com.example.warehouse.service.UserService;
import com.example.warehouse.tool.Page;
import com.example.warehouse.tool.Pagetool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class loginController {
     @Autowired
    UserService userService;
     @Autowired
     MailService mailService;

    @RequestMapping("/index")
    public String toLogin(){
        return  "index";
    }
    @RequestMapping("/register")
    public String toRegister(){
        return  "register";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return  "index";
    }

    @RequestMapping("/toUserTable")
    public String toUserTable(HttpSession session,@RequestParam(defaultValue="",required=false)String username,@RequestParam(defaultValue="1",required=false) int pageIndex){
        Pagetool<User> pagetool=new Pagetool<User>();
        int pageNumber=userService.getNum(username);
        Page<User> page=pagetool.pageTool(pageIndex, pageNumber);
        List<User> users=userService.getUserList(pagetool.hashMap(username));
        page.setList(users);
        session.setAttribute("usersPage",page);
        return "userTable";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        userService.deleteUser(id);
        return "redirect:/toUserTable";
    }
    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam(required = false ) MultipartFile multipartFile, HttpServletRequest request, User user) throws IOException {
        System.out.println(!multipartFile.isEmpty());
        if (!multipartFile.isEmpty()) {
            String oldname = multipartFile.getOriginalFilename();
            String lastprefix = oldname.substring(oldname.lastIndexOf("."));
            String newname = UUID.randomUUID() + lastprefix;
            String uploadpath = request.getServletContext().getRealPath("/resources/static/img/");
            File filepath = new File(uploadpath);
            if (!filepath.exists()) {
                filepath.mkdirs();
            }
            user.setImgName(newname);
            boolean u=userService.updateUser(user);
            multipartFile.transferTo(new File(uploadpath, newname));
        }else{
           boolean n= userService.updateUser(user);
        }
        return "redirect:/toUserTable";
    }
  @RequestMapping("/login")
    public String login(User user,String code,HttpSession session) {
      User user1 =userService.getByName(user.getUsername());
      String code2= (String) session.getAttribute("code");
      if (!code.equals(code2)) {
          session.setAttribute("msgLogin", "验证码错误");
          System.out.println("验证码错误");
      } else {
          if (user1 == null) {
              session.setAttribute("msgLogin", "用户不存在，请先注册");
              System.out.println("用户不存在，请先注册");
          } else {
              if (!user.getPassword().equals(user1.getPassword()) ) {
                  session.setAttribute("msgLogin", "密码错误，请输入正确密码");
                  System.out.println("密码错误，请输入正确密码");
              } else {
                  session.setAttribute("user",user1);
                    return "main";
              }
          }

      }
      return "redirect:/index";
  }


    @RequestMapping("/getImgName")
       @ResponseBody
       public User getImgName(@RequestBody User user){
                 User user2=userService.getByName(user.getUsername());
                 return  user2;
       }

    @PostMapping("/UpLoad")
    public String upload(MultipartFile multipartFile, HttpServletRequest request, User user, RedirectAttributes model) throws IOException {
        User user1 = userService.getByName(user.getUsername());
        if (user1 != null) {
            model.addFlashAttribute("msgRegister","用户名已存在！");
            return "redirect:/register";
        } else {
            String oldname = multipartFile.getOriginalFilename();
            String lastprefix = oldname.substring(oldname.lastIndexOf("."));
            String newname = UUID.randomUUID() + lastprefix;
            String uploadpath = request.getServletContext().getRealPath("/resources/static/img/");
            File filepath = new File(uploadpath);
            if (!filepath.exists()) {
                filepath.mkdirs();
            }
            user.setImgName(newname);
            Boolean falg = userService.addUser(user);
            multipartFile.transferTo(new File(uploadpath, newname));
            return "redirect:index";
        }
    }
    @RequestMapping("/sendMail")
    @ResponseBody
    public void sendSimpleMail(@RequestBody User user,HttpSession session) {
        User user1=userService.getByName(user.getUsername());
        int randNum = 1 + (int)(Math.random() * ((999999 - 1) + 1));
        session.setAttribute("code",String.valueOf(randNum));
        session.setMaxInactiveInterval(60);
        mailService.sendSimpleMail(user1.getEmail(),randNum);
    }

}
