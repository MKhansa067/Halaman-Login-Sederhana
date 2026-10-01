package lat.pam.halamanlogin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var tilUsername: TextInputLayout
    private lateinit var tilPassword: TextInputLayout
    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnLogin: MaterialButton

    // Kredensial valid
    private val validUsername = "khansa067"
    private val validPassword = "123456"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi views
        tilUsername = findViewById(R.id.tilUsername)
        tilPassword = findViewById(R.id.tilPassword)
        etUsername  = findViewById(R.id.etUsername)
        etPassword  = findViewById(R.id.etPassword)
        btnLogin    = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Reset error
            tilUsername.error = null
            tilPassword.error = null

            var isValid = true

            if (username.isEmpty()) {
                tilUsername.error = "Username tidak boleh kosong"
                isValid = false
            }

            if (password.isEmpty()) {
                tilPassword.error = "Password tidak boleh kosong"
                isValid = false
            }

            if (!isValid) return@setOnClickListener

            if (username == validUsername && password == validPassword) {
                // Login berhasil → pindah ke ProfileActivity
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
                finish() // tutup halaman login agar tidak bisa back ke sini
            } else {
                Toast.makeText(
                    this,
                    "Username atau password salah!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}