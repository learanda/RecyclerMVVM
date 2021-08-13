package ar.leandro.recyclermvvm

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import ar.leandro.recyclermvvm.databinding.ActivityImageDetailBinding
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_image_detail.*

class ImageDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)
        if(intent.extras != null){
            Glide.with(this).load(intent.getStringExtra("imageUrl")).into(photo_view)
        }

    }
}