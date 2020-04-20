package com.example.recyclerviewejemplo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemsAdapter.ItemsAdapterListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //necesito el dato - hacemos una lista de objetos
        //necesito el xml q represente la celda (cada uno de los elementos)
        //necesito el recyclerview
        //necesito el adapter
        //juntar el recyclerView

        //linkeo el atributo con el elemento del xml
        this.recyclerView = findViewById(R.id.activityMainRecyclerView);

        //creo la lista de items que usare como parametro para crear el adaptador
        List<Item> listaDeItems = listaItems();

        //creo el adaptador, paso this (esta misma actividad) como parametro, ya que es "escuchadora" dado la interfaz q implementa
        ItemsAdapter itemsAdapter = new ItemsAdapter(listaDeItems, this);

        //creo el layout manager porque si no toda esta verga no anda, el reverseLayout es por si queremos que la lista se muestre del final para adelante
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        //le seteo el layout manager y el adapter al recyclerview

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(itemsAdapter);


    }

    //le agrego varios items a una lista que despues uso como parametro para crear el adaptador

    public List<Item> listaItems() {
        List<Item> listaItems = new ArrayList<>();

        listaItems.add(new Item("Fodera RB", "$10.000", "Fodera Imperial Richard Bona Signature", R.drawable.fodera1));
        listaItems.add(new Item("Fodera JG", "$12.000", "Fodera Imperial Janek Gwizdala Signature", R.drawable.fodera2));
        listaItems.add(new Item("Fodera JG2", "$13.500", "Fodera Imperial Janek Gwizdala II Signature", R.drawable.fodera3));
        listaItems.add(new Item("Fodera MG", "$11.500", "Fodera Imperial Matthew Garrison Signature", R.drawable.fodera4));
        listaItems.add(new Item("Fodera RB", "$10.000", "Fodera Imperial Richard Bona Signature", R.drawable.fodera1));
        listaItems.add(new Item("Fodera JG", "$12.000", "Fodera Imperial Janek Gwizdala Signature", R.drawable.fodera2));
        listaItems.add(new Item("Fodera JG2", "$13.500", "Fodera Imperial Janek Gwizdala II Signature", R.drawable.fodera3));
        listaItems.add(new Item("Fodera MG", "$11.500", "Fodera Imperial Matthew Garrison Signature", R.drawable.fodera4));
        listaItems.add(new Item("Fodera RB", "$10.000", "Fodera Imperial Richard Bona Signature", R.drawable.fodera1));
        listaItems.add(new Item("Fodera JG", "$12.000", "Fodera Imperial Janek Gwizdala Signature", R.drawable.fodera2));
        listaItems.add(new Item("Fodera JG2", "$13.500", "Fodera Imperial Janek Gwizdala II Signature", R.drawable.fodera3));
        listaItems.add(new Item("Fodera MG", "$11.500", "Fodera Imperial Matthew Garrison Signature", R.drawable.fodera4));

        return listaItems;

    }

    //detallar el comportamiento de la actividad cuando se haga click a la celda
    @Override
    public void hicieronClick(Item unItem) {

        //creo intent
        Intent mainADetail = new Intent(this, DetailActivity.class);

        //creo bundle
        Bundle bundle = new Bundle();

        //le agrego los datos que quiero llevar
        bundle.putString(DetailActivity.NOMBRE_ITEM, unItem.getNombre());
        bundle.putString(DetailActivity.DESCRIPCION_ITEM, unItem.getDescripcion());
        bundle.putInt(DetailActivity.IMAGEN_ITEM, unItem.getImagen());

        //cargo el bundle en el intent
        mainADetail.putExtras(bundle);

        //start
        startActivity(mainADetail);


    }
}
