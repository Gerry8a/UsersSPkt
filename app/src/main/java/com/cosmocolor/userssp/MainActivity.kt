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
        val gerardo = User(1, "Gerardo", "Ochoa", "")
        val ceci = User(2, "Ceci", "Ochoa", "")
        users.add(gerardo)
        users.add(ceci)

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