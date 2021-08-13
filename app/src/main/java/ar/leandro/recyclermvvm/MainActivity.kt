package ar.leandro.recyclermvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.leandro.recyclermvvm.model.Animal
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnAnimalClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val listAnimals = listOf(
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
            )
        )

        recyclerView.adapter = RecyclerAdapter(this, listAnimals, this)
    }

    override fun onImageClick(imagen: String) {
        val intent = Intent(this,ImageDetail::class.java)
        intent.putExtra("imageUrl",imagen)
        startActivity(intent)
    }

    override fun onItemClick(nombre: String) {
        Toast.makeText(this, "El animal es: $nombre", Toast.LENGTH_SHORT).show()
    }
}