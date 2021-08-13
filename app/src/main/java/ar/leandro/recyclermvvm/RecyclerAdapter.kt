package ar.leandro.recyclermvvm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.leandro.recyclermvvm.base.BaseViewHolder
import ar.leandro.recyclermvvm.model.Animal
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.animal_row.view.*

class RecyclerAdapter(private val context: Context,
                      private val listaAnimales: List<Animal>,
                      private val itemClickListener:OnAnimalClickListener
): RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnAnimalClickListener{
        fun onImageClick(imagen: String)
        fun onItemClick(nombre: String)
    }

    // infla la vista que va a contener los datos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return AnimalesViewHolder(LayoutInflater.from(context).inflate(R.layout.animal_row,parent,false))
    }

    // agarra toda la info que mandamos en la lista y se lo pone a cada uno de los elementos
    // en el formato que se infló
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is AnimalesViewHolder -> holder.bind(listaAnimales[position],position)
            else -> throw IllegalArgumentException("Se olvidó de pasar el viewholder en el bind")
        }
    }

    // devuelve la cantidad de vistas que tiene que inflar
    override fun getItemCount(): Int = listaAnimales.size

    inner class AnimalesViewHolder(itemView: View):BaseViewHolder<Animal>(itemView){
        override fun bind(item: Animal, position: Int) {
            itemView.setOnClickListener {itemClickListener.onItemClick(item.nombre)}
            itemView.img_animal.setOnClickListener { itemClickListener.onImageClick(item.imagen) }
            Glide.with(context).load(item.imagen).into(itemView.img_animal)
            itemView.tv_nombre_animal.text = item.nombre
        }

    }

}