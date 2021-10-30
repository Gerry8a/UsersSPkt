package com.cosmocolor.userssp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cosmocolor.userssp.adapters.UserAdapter
import com.cosmocolor.userssp.databinding.ActivityMainBinding
import com.cosmocolor.userssp.models.User

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayouManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inicializarcomponentes()
    }

    private fun getUsers() : MutableList<User>{
        val users = mutableListOf<User>()
        val gerardo = User(1, "Gerardo", "Ochoa", "https://m.media-amazon.com/images/I/51RBBkCehdL._AC_SX425_.jpg")
        val ceci = User(2, "Ceci", "Ochoa", "https://m.media-amazon.com/images/I/51RBBkCehdL._AC_SX425_.jpg")
        var javier = User(3, "Javier", "Gomez", "https://m.media-amazon.com/images/I/51RBBkCehdL._AC_SX425_.jpg")
        val pablo = User(4, "Pablo", "Cruz", "https://m.media-amazon.com/images/I/51RBBkCehdL._AC_SX425_.jpg")
        val charly = User(5, "Charly", "Perez", "https://m.media-amazon.com/images/I/51RBBkCehdL._AC_SX425_.jpg")
        users.add(gerardo)
        users.add(ceci)
        users.add(javier)
        users.add(pablo)
        users.add(charly)
        users.add(gerardo)
        users.add(ceci)
        users.add(javier)
        users.add(pablo)
        users.add(charly)
        users.add(gerardo)
        users.add(ceci)
        users.add(javier)
        users.add(pablo)
        users.add(charly)
        users.add(gerardo)
        users.add(ceci)
        users.add(javier)
        users.add(pablo)
        users.add(charly)

        return users
    }

    private fun inicializarcomponentes() {
        binding = ActivityMainBinding.inflate(layoutInflater) //inicializar binding
        setContentView(binding.root)
        userAdapter = UserAdapter(getUsers())
        linearLayouManager = LinearLayoutManager(this)

        binding.rvMain.apply {
            layoutManager = linearLayouManager
            adapter = userAdapter
        }
    }
}