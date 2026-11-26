package com.example.profildeveloppeur.data

// Données locales uniquement : pas d'API, pas de base de données.
fun sampleSkills(): List<SkillUi> = listOf(
    SkillUi(id = 1, name = "Kotlin", level = "Confirmé"),
    SkillUi(id = 2, name = "Jetpack Compose", level = "Intermédiaire"),
    SkillUi(id = 3, name = "Material 3", level = "Intermédiaire"),
    SkillUi(id = 4, name = "Git / GitHub", level = "Confirmé"),
    SkillUi(id = 5, name = "SQL", level = "Débutant"),
    SkillUi(id = 6, name = "Figma", level = "Débutant")
)

fun sampleProjects(): List<ProjectUi> = listOf(
    ProjectUi(
        id = 1,
        title = "Catalogue produits",
        description = "Application Compose qui affiche un catalogue avec LazyColumn et LazyRow.",
        technologies = listOf("Kotlin", "Compose"),
        period = "2026"
    ),
    ProjectUi(
        id = 2,
        title = "Fiche détail produit",
        description = "Écran de détail avec image, prix, badges et bouton d'achat.",
        technologies = listOf("Compose", "Material 3"),
        period = "2026"
    ),
    ProjectUi(
        id = 3,
        title = "Thème Product Explorer",
        description = "Création d'un thème clair et sombre avec couleurs, formes et typographie.",
        technologies = listOf("Material 3"),
        period = "2026"
    ),
    ProjectUi(
        id = 4,
        title = "Stage - outil de suivi interne",
        description = "Participation au développement d'un petit outil web de suivi d'interventions.",
        technologies = listOf("JavaScript", "SQL"),
        period = "2025"
    )
)

fun sampleProfile(): DeveloperProfileUi = DeveloperProfileUi(
    name = "Camille Laurent",
    role = "Développeuse Android junior",
    description = "Passionnée par le développement mobile, je crée des applications " +
        "Android simples, lisibles et accessibles avec Kotlin et Jetpack Compose.",
    isAvailable = true,
    email = "camille.laurent@example.com",
    location = "Lyon, France",
    availability = "Disponible pour un stage dès janvier",
    skills = sampleSkills(),
    projects = sampleProjects()
)

fun sampleProfileFullStack(): DeveloperProfileUi = DeveloperProfileUi(
    name = "Alex Bernard",
    role = "Développeur full-stack",
    description = "Je développe des sites et des services web, et je découvre Android.",
    isAvailable = false,
    email = "alex.bernard@example.com",
    location = "Nantes, France",
    availability = "Non disponible actuellement",
    skills = listOf(
        SkillUi(id = 1, name = "JavaScript", level = "Confirmé"),
        SkillUi(id = 2, name = "Kotlin", level = "Débutant"),
        SkillUi(id = 3, name = "SQL", level = "Intermédiaire")
    ),
    projects = sampleProjects().take(2)
)
