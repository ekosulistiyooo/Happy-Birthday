package com.saputroekosulistiyo.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saputroekosulistiyo.happybirthday.ui.theme.HappyBirthdayTheme

// Definisi Activity utama yang dijalankan saat aplikasi dimulai
class MainActivity : ComponentActivity() {
    // Fungsi onCreate() adalah titik awal di mana UI diatur
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setel konten UI menggunakan tema yang ditentukan
        setContent {
            // Terapkan tema aplikasi yang sudah didefinisikan
            HappyBirthdayTheme {
                // Buat Surface sebagai wadah konten dengan warna latar belakang dari tema
                Surface(
                    modifier = Modifier.fillMaxSize(), // Surface mengisi seluruh ukuran layar
                    color = MaterialTheme.colorScheme.background // Warna latar belakang diambil dari tema
                ) {
                    // Tampilkan pesan ucapan ulang tahun dengan teks dan padding
                    GreetingText(
                        message = "Happy Birthday Sam!",
                        from = "From Emma",
                        modifier = Modifier.padding(8.dp) // Beri padding 8dp di seluruh sisi
                    )
                }
            }
        }
    }
}

// Fungsi komposabel untuk menampilkan teks ucapan ulang tahun
@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    // Column digunakan untuk menampilkan teks secara vertikal
    Column(
        verticalArrangement = Arrangement.Center, // Mengatur konten agar berada di tengah secara vertikal
        modifier = modifier // Modifier diterapkan dari argumen fungsi
    ) {
        // Tampilkan teks pesan ulang tahun
        Text(
            text = message,
            fontSize = 100.sp, // Ukuran teks besar
            lineHeight = 116.sp, // Jarak antar baris teks
            textAlign = TextAlign.Center // Teks rata tengah
        )
        // Tampilkan teks pengirim pesan dengan sedikit padding dan rata kanan
        Text(
            text = from,
            fontSize = 36.sp, // Ukuran teks lebih kecil
            modifier = Modifier
                .padding(16.dp) // Beri padding 16dp di seluruh sisi
                .align(alignment = Alignment.End) // Teks sejajar di kanan
        )
    }
}

// Fungsi untuk menampilkan preview di Android Studio
@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    // Terapkan tema aplikasi pada preview
    HappyBirthdayTheme {
        // Tampilkan contoh pesan ucapan ulang tahun dalam preview
        GreetingText(message = "Happy Birthday Sam!", from = "From Emma")
    }
}