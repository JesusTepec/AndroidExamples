package dev.jaque.qr.presentation

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder

class QrGenerator(val content: String) {

    /* Defalt value standar QR */
    private var qrType: BarcodeFormat = DEFAULT_TYPE

    /**
     * Define according to Contants
     */
    fun setQrType(type: BarcodeFormat) {
        this.qrType = type
    }

    /**
     * Generate bitmap QR
     */
    fun getImage(): Bitmap? =
        try {
            BarcodeEncoder().encodeBitmap(
                content,
                qrType,
                300,
                300
            )
        } catch (e: WriterException) {
            null
        }

    companion object {
        val AZTECT_TYPE = BarcodeFormat.AZTEC
        val DEFAULT_TYPE = BarcodeFormat.QR_CODE
    }
}