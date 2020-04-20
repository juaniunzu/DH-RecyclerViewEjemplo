package com.example.recyclerviewejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String NOMBRE_ITEM = "nombreItem";
    public static final String DESCRIPCION_ITEM = "descripcionItem";
    public static final String IMAGEN_ITEM = "imagenItem";
    private ImageView activityDetailImageViewImagen;
    private TextView activityDetailTextViewNombre;
    private TextView activityDetailTextViewDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //linkeo los atributos a los elementos del xml
        activityDetailImageViewImagen = findViewById(R.id.activityDetailImageViewImagen);
        activityDetailTextViewNombre = findViewById(R.id.activityDetailTextViewNombre);
        activityDetailTextViewDescripcion = findViewById(R.id.activityDetailTextViewDescripcion);

        //traigo el intent
        Intent desdeMain = getIntent();

        //le saco el bundle
        Bundle bundleDesdeMain = desdeMain.getExtras();

        //le saco los datos al bundle y los guardo en variables locales
        String nombreItem = bundleDesdeMain.getString(NOMBRE_ITEM);
        String descripcionItem = bundleDesdeMain.getString(DESCRIPCION_ITEM);
        Integer imagenItem = bundleDesdeMain.getInt(IMAGEN_ITEM);

        //seteo los parametros del xml con los datos traidos por el bundle
        activityDetailImageViewImagen.setImageResource(imagenItem);
        activityDetailTextViewNombre.setText(nombreItem);
        activityDetailTextViewDescripcion.setText(descripcionItem);
    }
}
