package stdio.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import stdio.tech.DTO.MemberDTOresponse;
import stdio.tech.service.StdioMemberService;

import java.util.List;

@Controller
public class ThymeleafController {
    @Autowired
    StdioMemberService stdioMemberService;
    @GetMapping("thymeleaf/member/list")
    private String listMembers (Model model){
        List<MemberDTOresponse> members = stdioMemberService.readAll();
        model.addAttribute("members", members);
        return "view";

    }

}
