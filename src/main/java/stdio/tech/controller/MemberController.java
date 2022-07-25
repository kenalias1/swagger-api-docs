package stdio.tech.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stdio.tech.DTO.MemberDTOrequest;
import stdio.tech.DTO.MemberDTOresponse;
import stdio.tech.service.StdioMemberService;

import java.util.List;

@RestController
public class MemberController {
    @GetMapping("/member/list")
    private ResponseEntity<List<MemberDTOresponse>> ListMembers() {
        return new ResponseEntity<>(stdioMemberService.readAll(), HttpStatus.OK);
    }
    @DeleteMapping("/member/delete/{id}")
    private void deletemember(@PathVariable("id") Integer id) {
        stdioMemberService.delete(id);
    }

    @PostMapping("/member/add")
    private ResponseEntity<MemberDTOresponse> addMember(@RequestBody MemberDTOrequest memberDTOrequest) {
        return new ResponseEntity<>(stdioMemberService.add(memberDTOrequest), HttpStatus.OK);
    }
    @PutMapping("/member/update/{id}")    //processing update form
    private ResponseEntity<MemberDTOresponse> UpdateMember(@PathVariable("id") int id, @RequestBody MemberDTOrequest memberDTOrequest) throws Exception {
        return new ResponseEntity<>(stdioMemberService.update(id, memberDTOrequest), HttpStatus.OK);
    }
    @Autowired
    public StdioMemberService stdioMemberService;
}
