package com.skill.tracker.constants;

public enum SkillSetEnum {

	HTMLCSSJAVASCRIPT(1, "htmlCSSJavascript"),
	ANGULAR(2, "angular"),
	REACT(3, "react"),
	SPRING(4, "spring"),
	RESTFUL(5, "restful"),
	HIBERNATE(6, "hibernate"),
	GIT(7, "git"),
	DOCKER(8, "docker"),
	JENKINS(9, "jenkins"),
	AWS(10, "aws"),
	SPOKEN(11, "spoken"),
	COMMUNICATION(12, "communication"),
	APTITUDE(13, "aptitude");	
	
	private int skillSetId;
	private String skillSetName;
	
	public int getSkillSetId() {
		return skillSetId;
	}

	public String getSkillSetName() {
		return skillSetName;
	}

	SkillSetEnum(int skillSetId, String skillSetName) {
		this.skillSetId = skillSetId;
		this.skillSetName = skillSetName;
	}
	
	public static SkillSetEnum getSkillSetId(String skillSetName) {		
		for(SkillSetEnum value : SkillSetEnum.values()) {
			if(value.getSkillSetName().equals(skillSetName))
				return value;	
		}
		return null;
	}
}