package stdio.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stdio.tech.DTO.SkillDTO;
import stdio.tech.DTO.MemberDTOrequest;
import stdio.tech.service.SkillService;
import java.util.List;

@RestController
@RequestMapping("/member")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @GetMapping("/{id}/skills")
    public ResponseEntity<List<SkillDTO>> listMemberSkills(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<>(skillService.readMemberSkills(id), HttpStatus.OK);
    }

    @PostMapping("/{id}/skills")
    public ResponseEntity<MemberDTOrequest> addSkill(@PathVariable("id") Integer memberId,
                                                     @RequestBody List<SkillDTO> skillList) throws Exception {
        return new ResponseEntity<>(skillService.addSkills(memberId, skillList), HttpStatus.OK);

    }

}
