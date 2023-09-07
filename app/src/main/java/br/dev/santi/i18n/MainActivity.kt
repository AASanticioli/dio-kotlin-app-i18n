package br.dev.santi.i18n

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import br.dev.santi.i18n.ui.theme.LabProject01I18nTheme
import br.dev.santi.i18n.ui.theme.sacramentoFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabProject01I18nTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quote(stringResource(R.string.quote), stringResource(R.string.quote_author), stringResource(R.string.quote_title))
                }
            }
        }
    }
}

@Composable
fun Quote(quote: String, author: String, title: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth().padding(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth()
        ){
            Text(
                text = "\"$quote\"",
                fontStyle = FontStyle.Italic,
                fontFamily = sacramentoFamily,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                lineHeight = 1.5.em,
                modifier = modifier
            )
        }
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth().paddingFromBaseline(top=20.dp)
        ){
            Text(
                text = "- $author",
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                modifier = modifier.padding(end=10.dp)
            )
            Text(
                text = title,
                fontStyle = FontStyle.Normal,
                fontSize = 12.sp,
                modifier = modifier
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun QuotePreview() {
    LabProject01I18nTheme {
        Quote(
            stringResource(R.string.quote),
            stringResource(R.string.quote_author),
            stringResource(R.string.quote_title)
        )
    }
}