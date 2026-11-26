package com.example.profildeveloppeur.data

data class DeveloperProfileUi(
    val name: String,
    val role: String,
    val description: String,
    val isAvailable: Boolean,
    val email: String,
    val location: String,
    val availability: String,
    val skills: List<SkillUi>,
    val projects: List<ProjectUi>
)

data class SkillUi(
    val id: Int,
    val name: String,
    val level: String
)

data class ProjectUi(
    val id: Int,
    val title: String,
    val description: String,
    val technologies: List<String>,
    val period: String
)
