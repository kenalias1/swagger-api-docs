package stdio.tech.mapper;

import stdio.tech.DTO.SkillDTO;
import stdio.tech.common.enumType.SkillLevelEnum;
import stdio.tech.model.Skill;


public class SkillDTOMapper {
    public static SkillDTO toDTO(Skill skill) {
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setName(skill.getName());
        skillDTO.setLevel(skill.getSkillLevel().name());
        return skillDTO;
    }
    public static Skill toEntity(SkillDTO skillDTO) {
        Skill skill = new Skill();
        skill.setName(skillDTO.getName());
        skill.setSkillLevel(SkillLevelEnum.valueOf(skillDTO.getLevel()));
        return skill;
    }
}
