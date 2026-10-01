package lat.pam.halamanlogin

import android.content.Intent
import android.graphics.Outline
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvNama     = findViewById<TextView>(R.id.tvNama)
        val tvUsername = findViewById<TextView>(R.id.tvUsername)
        val imgProfile = findViewById<ImageView>(R.id.imgProfile)
        val btnLogout  = findViewById<MaterialButton>(R.id.btnLogout)

        // Ambil username dari Intent
        val username = intent.getStringExtra("USERNAME") ?: "khansa067"

        // Set data ke tampilan
        tvNama.text     = "Khansa"
        tvUsername.text = "@$username"

        // Clip ImageView menjadi bentuk lingkaran
        imgProfile.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                outline.setOval(0, 0, view.width, view.height)
            }
        }
        imgProfile.clipToOutline = true

        // Set foto profil dari drawable
        // Letakkan file foto Anda dengan nama profile_photo.png di res/drawable/
        imgProfile.setImageResource(R.drawable.profile_photo)

        // Tombol keluar: kembali ke halaman Login
        btnLogout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}
