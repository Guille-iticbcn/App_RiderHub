package com.example.myapplication

import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class InformeActivity : AppCompatActivity() {
    private lateinit var seekBarAge: SeekBar
    private lateinit var seekBarAppRating: SeekBar
    private lateinit var seekBarBugsRating: SeekBar
    private lateinit var seekBarRecommendation: SeekBar
    private lateinit var spinnerAppSource: Spinner
    private lateinit var editTextComments: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informe)

        // Inicializar componentes de la interfaz de usuario
        seekBarAge = findViewById(R.id.seekBarAge)
        seekBarAppRating = findViewById(R.id.seekBarAppRating)
        seekBarBugsRating = findViewById(R.id.seekBarBugsRating)
        seekBarRecommendation = findViewById(R.id.seekBarRecommendation)
        spinnerAppSource = findViewById(R.id.spinnerAppSource)
        editTextComments = findViewById(R.id.editTextComments)

        // Configurar el botón "Generar Informe"
        val btnGenerateReport: Button = findViewById(R.id.btnGenerateReport)
        btnGenerateReport.setOnClickListener {
            // Generar y enviar el informe
            generateAndSendReport()
        }
    }

    // Método para generar y enviar el informe en formato PDF
    private fun generateAndSendReport() {
        // Obtener las respuestas seleccionadas por el usuario y los comentarios
        val age = seekBarAge.progress
        val appRating = seekBarAppRating.progress
        val bugsRating = seekBarBugsRating.progress
        val recommendation = seekBarRecommendation.progress
        val appSource = spinnerAppSource.selectedItem.toString()
        val comments = editTextComments.text.toString()

        // Crear el contenido del informe
        val reportContent = StringBuilder()
        reportContent.append("Rango de Edad: $age\n")
            .append("Calificación de la Aplicación: $appRating\n")
            .append("Calificación de los Fallos de la Aplicación: $bugsRating\n")
            .append("Recomendarías esta Aplicación: $recommendation\n")
            .append("Origen de Conocimiento de la Aplicación: $appSource\n")
            .append("Comentarios: $comments")

        // Generar el informe en formato PDF
        val document = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(300, 600, 1).create()
        val page = document.startPage(pageInfo)
        val canvas = page.canvas
        val paint = Paint()
        paint.color = Color.BLACK
        paint.textSize = 12f
        var y = 40f
        for (line in reportContent.toString().split("\n")) {
            canvas.drawText(line, 10f, y, paint)
            y += paint.descent() - paint.ascent()
        }
        document.finishPage(page)

        // Guardar el archivo PDF en almacenamiento externo
        val pdfFile = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            "Informe.pdf"
        )
        try {
            document.writeTo(FileOutputStream(pdfFile))
            document.close()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Error al guardar el archivo PDF", Toast.LENGTH_SHORT).show()
            return
        }

        // Enviar el informe por correo electrónico o compartirlo
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "application/pdf"
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(pdfFile))
        intent.putExtra(Intent.EXTRA_SUBJECT, "Informe de la Aplicación")
        intent.putExtra(Intent.EXTRA_TEXT, "Adjunto se encuentra el informe generado.")
        startActivity(Intent.createChooser(intent, "Enviar Informe por Correo Electrónico o Compartir"))
    }
}