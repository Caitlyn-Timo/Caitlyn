package ccg.caitlyn.ctroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class loginAction {

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String login(String username,String password){
        return "welcome "+username;
    }


    @PostMapping(value = "/signin")
    public String Login(Model model, HttpSession httpSession,String username, String password){
        if ("caitlyn".equals(username) && !StringUtils.isEmpty(password)){
            httpSession.setAttribute("loginuser",username);
            return "redirect:/main.html";
        }
        return "login";
    }

}
