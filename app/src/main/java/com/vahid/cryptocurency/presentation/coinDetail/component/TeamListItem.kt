package com.vahid.cryptocurency.presentation.coinDetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.vahid.cryptocurency.data.remote.dto.TeamMember

@Composable
fun TeamListMember(
    teamMember: TeamMember,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
        Text(
            text = teamMember.name.toString(),
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMember.position.toString(), style = MaterialTheme.typography.bodyMedium,
            fontStyle = FontStyle.Italic
        )
    }
}