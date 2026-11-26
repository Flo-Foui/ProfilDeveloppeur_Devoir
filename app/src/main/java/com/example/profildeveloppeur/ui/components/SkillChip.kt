package com.example.profildeveloppeur.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.profildeveloppeur.data.SkillUi

// Liste horizontale des compétences : chaque élément est un SkillChip.
@Composable
fun SkillsRow(
    skills: List<SkillUi>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(skills, key = { it.id }) { skill ->
            SkillChip(skill = skill)
        }
    }
}

@Composable
fun SkillChip(
    skill: SkillUi,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.extraLarge,
        color = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
        modifier = modifier.semantics(mergeDescendants = true) {
            contentDescription = "Compétence ${skill.name}, niveau ${skill.level}"
        }
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            Text(
                text = skill.name,
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = skill.level,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
