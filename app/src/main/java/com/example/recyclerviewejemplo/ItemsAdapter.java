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
    //le agrego parametro listener que sera necesario para que la instanciacion
    //tome como parametro la clase que escuche el click
    private ItemsAdapterListener listener;

    public ItemsAdapter(List<Item> listaDeItems, ItemsAdapterListener listener) {
        this.listaDeItems = listaDeItems;
        this.listener = listener;
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


        //el constructor toma como parametro un elemento View.
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            //aca se programa lo necesario de cada celda, incluidos los findViewById y etceteras
            celdaItemImageView = itemView.findViewById(R.id.celdaItemImageView);
            celdaItemTextViewNombre = itemView.findViewById(R.id.celdaItemTextViewNombre);
            celdaItemTextViewPrecio = itemView.findViewById(R.id.celdaItemTextViewPrecio);
            celdaItemTextViewDescripcion = itemView.findViewById(R.id.celdaItemTextViewDescripcion);

            //creo el onClickListener de la celda
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //tomo la posicion donde se esta haciendo click
                    Integer itemPosition = getAdapterPosition();

                    //uso la posicion para tomar el item donde se esta haciendo click y lo guardo en variable local
                    Item item = listaDeItems.get(itemPosition);

                    //corro el hicieronClick() que es parte del aributo listener,
                    //le paso como parametro el item tomado arriba
                    listener.hicieronClick(item);

                }
            });

        }

        //metodo que enlaza cada item con la celda
        public void cargarItem(Item unItem){
            celdaItemImageView.setImageResource(unItem.getImagen());
            celdaItemTextViewNombre.setText(unItem.getNombre());
            celdaItemTextViewPrecio.setText(unItem.getPrecio());
            celdaItemTextViewDescripcion.setText(unItem.getDescripcion());
        }
    }

    //creo interfaz que tendra q implementar cada actividad que contenga celdas clickeables.
    //cada una sobreescribira el metodo segun a que actividad se ira
    public interface ItemsAdapterListener{
        void hicieronClick(Item unItem);
    }
}
