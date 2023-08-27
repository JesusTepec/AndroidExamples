package dev.jaque.qr.presentation.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.google.zxing.BarcodeFormat
import dev.jaque.qr.presentation.QrGenerator

@BindingAdapter("setBinmapQr", "typeQr")
fun addQrBitmap(imageView: ImageView, contentEncode: String, qrType: BarcodeFormat) {
    imageView.apply {
        val qrGenerator = QrGenerator(contentEncode)
        qrGenerator.setQrType(qrType)
        setImageBitmap(qrGenerator.getImage())
    }
}