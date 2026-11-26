package com.example.profildeveloppeur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profildeveloppeur.data.DeveloperProfileUi
import com.example.profildeveloppeur.data.sampleProfile
import com.example.profildeveloppeur.data.sampleProfileFullStack
import com.example.profildeveloppeur.ui.components.ContactCard
import com.example.profildeveloppeur.ui.components.ProfileHeader
import com.example.profildeveloppeur.ui.components.ProjectCard
import com.example.profildeveloppeur.ui.components.SkillsRow
import com.example.profildeveloppeur.ui.theme.ProfilDeveloppeurTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ProfilDeveloppeurTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(
                        profile = sampleProfile(),
                        onContactClick = {
                            // Plus tard : ouvrir l'application mail.
                        },
                        onPortfolioClick = {
                            // Plus tard : ouvrir le portfolio.
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Écran principal : une seule LazyColumn pour tout le contenu,
// la LazyRow des compétences est un élément de cette liste.
@Composable
fun ProfileScreen(
    profile: DeveloperProfileUi,
    onContactClick: () -> Unit,
    onPortfolioClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ProfileHeader(
                name = profile.name,
                role = profile.role,
                description = profile.description,
                isAvailable = profile.isAvailable,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            SectionTitle(text = "Compétences")
        }
        item {
            SkillsRow(skills = profile.skills)
        }

        item {
            SectionTitle(text = "Projets et expériences")
        }
        items(profile.projects, key = { it.id }) { project ->
            ProjectCard(
                project = project,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            SectionTitle(text = "Contact")
        }
        item {
            ContactCard(
                email = profile.email,
                location = profile.location,
                availability = profile.availability,
                onContactClick = onContactClick,
                onPortfolioClick = onPortfolioClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun SectionTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = modifier
            .padding(horizontal = 16.dp)
            .semantics { heading() }
    )
}

@Preview(name = "Profil - thème clair", showBackground = true, heightDp = 1400)
@Composable
fun ProfileScreenLightPreview() {
    ProfilDeveloppeurTheme(darkTheme = false) {
        ProfileScreen(
            profile = sampleProfile(),
            onContactClick = {},
            onPortfolioClick = {}
        )
    }
}

@Preview(name = "Profil - thème sombre", showBackground = true, heightDp = 1400)
@Composable
fun ProfileScreenDarkPreview() {
    ProfilDeveloppeurTheme(darkTheme = true) {
        ProfileScreen(
            profile = sampleProfile(),
            onContactClick = {},
            onPortfolioClick = {}
        )
    }
}

@Preview(name = "Profil full-stack non disponible", showBackground = true, heightDp = 1100)
@Composable
fun ProfileScreenFullStackPreview() {
    ProfilDeveloppeurTheme(darkTheme = false) {
        ProfileScreen(
            profile = sampleProfileFullStack(),
            onContactClick = {},
            onPortfolioClick = {}
        )
    }
}
