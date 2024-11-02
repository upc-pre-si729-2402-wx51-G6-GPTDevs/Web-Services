package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

public record WorkerSkills(String skillName, String descriptionSkill) {

    public WorkerSkills() {
        this(null, null);
    }

    public WorkerSkills(String skillName, String descriptionSkill) {
        if (skillName == null || skillName.isBlank()) {
            throw new IllegalArgumentException("Skill name cannot be null or empty.");
        }

        if (descriptionSkill == null) {
            throw new IllegalArgumentException("Skill level cannot be null.");
        }

        this.skillName = skillName;
        this.descriptionSkill = descriptionSkill;
    }

    public String getWorkerSkills() {
        return String.format("Skill: %s, Description: %s", skillName, descriptionSkill);
    }

}

