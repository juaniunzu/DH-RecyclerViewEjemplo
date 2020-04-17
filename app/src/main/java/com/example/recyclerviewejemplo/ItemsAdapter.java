package com.example.recyclerviewejemplo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter {

    private List<Item> listaDeItems;

    public ItemsAdapter(List<Item> listaDeItems) {
        this.listaDeItems = listaDeItems;
    }

    //crea la celda del layout
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflar el xml a View
        //inflador:
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        //con el inflador, inflo el xml a View y la guardo en una variable local
        View viewInflada = layoutInflater.inflate(R.layout.celda_item, parent, false);

        //esta View la uso como parametro para crear un nuevo ViewHolder que es lo que se tiene que retornar
        ItemViewHolder itemViewHolderFinal = new ItemViewHolder(viewInflada);

        //se retorna este ViewHolder final
        return itemViewHolderFinal;

    }

    //le da a la celda creada los valores correspondientes
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        //tomo cada item de la lista
        Item itemAMostrar = this.listaDeItems.get(position);

        //casteo el parametro holder como ItemViewHolder para que tenga el metodo cargarItem creado abajo
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

        //una vez casteado el parametro pasa de ViewHolder a ItemViewHolder entonces puedo cargarle items con el metodo q ya sabe
        itemViewHolder.cargarItem(itemAMostrar);

    }

    //retorna la cantidad de elementos de la lista
    @Override
    public int getItemCount() {
        return this.listaDeItems.size();
    }

    //se crea el ViewHolder, es la representacion java de cada celda. contiene el metodo que enlaza el objeto item con la celda
    private class ItemViewHolder extends RecyclerView.ViewHolder {

        //los atributos segun los elementos del xml
        private ImageView celdaItemImageView;
        private TextView celdaItemTextViewNombre;
        private TextView celdaItemTextViewPrecio;
        private TextView celdaItemTextViewDescripcion;
        private Button celdaItemButtonComprar;
        private TextView carritoContador;

        //el constructor toma como parametro un elemento View.
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            //aca se programa lo necesario de cada celda, incluidos los findViewById y etceteras
            celdaItemImageView = itemView.findViewById(R.id.celdaItemImageView);
            celdaItemTextViewNombre = itemView.findViewById(R.id.celdaItemTextViewNombre);
            celdaItemTextViewPrecio = itemView.findViewById(R.id.celdaItemTextViewPrecio);
            celdaItemTextViewDescripcion = itemView.findViewById(R.id.celdaItemTextViewDescripcion);
            celdaItemButtonComprar = itemView.findViewById(R.id.celdaItemButtonComprar);
            carritoContador = itemView.findViewById(R.id.celdaItemLinearLayoutTextViewCarrito);

            // TODO: 17/04/2020 programar el boton y el contador

        }

        //metodo que enlaza cada item con la celda
        public void cargarItem(Item unItem){
            celdaItemImageView.setImageResource(unItem.getImagen());
            celdaItemTextViewNombre.setText(unItem.getNombre());
            celdaItemTextViewPrecio.setText(unItem.getPrecio());
            celdaItemTextViewDescripcion.setText(unItem.getDescripcion());
        }
    }
}
