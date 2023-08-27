package devtepec.qrgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.jaque.qr.presentation.QrGenerator
import dev.jaque.qr.presentation.adapter.addQrBitmap
import devtepec.qrgenerator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showQrImage()
    }

    /**
     *
     */
    private fun showQrImage() {
        binding.apply {
            contentEncode = "https://codestats.net/users/JesusTepec"
            qrType = QrGenerator.AZTECT_TYPE
        }
    }
}