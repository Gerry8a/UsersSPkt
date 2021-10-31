package com.cosmocolor.userssp

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cosmocolor.userssp.adapters.UserAdapter
import com.cosmocolor.userssp.databinding.ActivityMainBinding
import com.cosmocolor.userssp.models.User
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayouManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inicializarcomponentes()

        val preferences = getPreferences(Context.MODE_PRIVATE)
        val isFirstTime = preferences.getBoolean(getString(R.string.sp_first_time), true)
        Log.i("SPREFERENCES", "${getString(R.string.sp_first_time)}")

        if (isFirstTime) {
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.dialog_confirm, { dialogInterface, i ->
                    preferences.edit().putBoolean(getString(R.string.sp_first_time), false).commit()
                })
                .setNegativeButton(R.string.dialog_cancelar, null)
                .show()

        }
    }

    private fun getUsers(): MutableList<User> {
        val users = mutableListOf<User>()
        val gerardo = User(
            1,
            "Gerardo",
            "Ochoa",
            "https://m.media-amazon.com/images/I/51RBBkCehdL._AC_SX425_.jpg"
        )
        val ceci = User(
            2,
            "Ceci",
            "Ochoa",
            "https://m.media-amazon.com/images/I/51RBBkCehdL._AC_SX425_.jpg"
        )
        var javier = User(
            3,
            "Javier",
            "Gomez",
            "https://m.media-amazon.com/images/I/51RBBkCehdL._AC_SX425_.jpg"
        )
        val pablo = User(
            4,
            "Pablo",
            "Cruz",
            "https://m.media-amazon.com/images/I/51RBBkCehdL._AC_SX425_.jpg"
        )
        val charly = User(
            5,
            "Charly",
            "Perez",
            "https://m.media-amazon.com/images/I/51RBBkCehdL._AC_SX425_.jpg"
        )
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
        userAdapter = UserAdapter(getUsers(), this)
        setContentView(binding.root) //se hace cambio en esta linea por la que hace la actividad por defecto
        linearLayouManager = LinearLayoutManager(this)

        binding.rvMain.apply {
            setHasFixedSize(true) //linea que sirve para aclarar que las vistas tienen un cambio definido
            layoutManager = linearLayouManager
            adapter = userAdapter
        }
    }

    override fun onClick(user: User, position: Int) {
        Toast.makeText(this, "$position: ${user.getFullName()}", Toast.LENGTH_SHORT).show()
    }
}