package stdio.tech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import stdio.tech.DTO.MemberDTOrequest;
import stdio.tech.model.User;
import stdio.tech.service.StdioMemberService;
import stdio.tech.service.UserService;

import java.time.LocalDate;

@SpringBootApplication
@Controller
public class RestapiApplication implements ApplicationRunner {

    @Autowired
    public PasswordEncoder passwordEncoder;
    @Autowired
    public UserService userService;
    @Autowired
    public StdioMemberService stdioMemberService;

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }
    @Override
    public void run(ApplicationArguments memberAPI) throws Exception {
        User user = new User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("pass"));
        userService.saveUser(user);
        MemberDTOrequest memberDTOrequest = new MemberDTOrequest();
        memberDTOrequest.setName("Luong");
        memberDTOrequest.setSurname("Tran");
        memberDTOrequest.setBirthday(LocalDate.parse("1990-01-01"));
        memberDTOrequest.setAddress("Hue");
        stdioMemberService.add(memberDTOrequest);
        memberDTOrequest.setName("Nhat");
        memberDTOrequest.setSurname("Le");
        memberDTOrequest.setBirthday(LocalDate.parse("2001-01-01"));
        memberDTOrequest.setAddress("Hue");
        stdioMemberService.add(memberDTOrequest);
    }



}
