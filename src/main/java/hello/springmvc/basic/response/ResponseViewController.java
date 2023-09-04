package hello.springmvc.basic.response;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseView1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data","hello");
        return mav;
    }

    @RequestMapping("/response-view-v2") //만약 @ResponseBody를 쓰면 http 응답메세지로 바로나가버림. 뷰 리졸버를 안찾음
    public String responseView2(Model model) {
        model.addAttribute("data", "hello!");
        return "response/hello"; //view의 논리적 path로 바뀌어서 찾으러감
    }
}
