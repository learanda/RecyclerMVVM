package ar.leandro.recyclermvvm.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.leandro.recyclermvvm.ImageDetail
import ar.leandro.recyclermvvm.viewmodel.MainViewModel
import ar.leandro.recyclermvvm.R
import ar.leandro.recyclermvvm.RecyclerAdapter
import ar.leandro.recyclermvvm.model.Animal
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnAnimalClickListener {

    private lateinit var adapter: RecyclerAdapter
    private lateinit var list:MutableList<Animal>
    private val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeData()
        setupRecyclerView(list)

    }

    private fun setupRecyclerView(list:MutableList<Animal>) {
        //adapter = RecyclerAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        /*val listAnimals = listOf(
            Animal(
                "Perro",
                "https://www.dogalize.com/wp-content/uploads/2018/08/bernese-mountain-dog-67266_640.jpg"
            ),
            Animal(
                "Gato",
                "https://ichef.bbci.co.uk/news/800/cpsprodpb/10E9B/production/_109757296_gettyimages-1128004359.jpg"
            ),
            Animal(
                "Aguilucho",
                "https://destinosanjuan.com.ar/wp-content/uploads/2021/07/aguilucho2.jpg"
            ),
            Animal(
                "Tigre",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Siberischer_tiger_de_edit02.jpg/1200px-Siberischer_tiger_de_edit02.jpg"
            ),
            Animal(
                "Loro",
                "https://estaticos-cdn.elperiodico.com/clip/9a36bb77-0c88-4b3c-a7dc-f3d41dd85987_alta-libre-aspect-ratio_default_0.jpg"
            )
        )*/

        recyclerView.adapter = RecyclerAdapter(this, list, this)
    }

    private fun observeData() {
        viewModel.fetchAnimalData().observe(this, {
            list = it
            recyclerView.adapter?.notifyDataSetChanged()

        })
    }


    // Clicks en la imágen o el ítem
    override fun onImageClick(imagen: String) {
        /*val intent = Intent(this, ImageDetail::class.java)
        intent.putExtra("imageUrl", imagen)
        startActivity(intent)*/
    }

    override fun onItemClick(nombre: String) {
        /*Toast.makeText(this, "El animal es: $nombre", Toast.LENGTH_SHORT).show()*/
    }
}