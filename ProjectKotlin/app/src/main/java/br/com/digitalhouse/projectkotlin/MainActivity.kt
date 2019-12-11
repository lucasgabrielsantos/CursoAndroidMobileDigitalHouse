package br.com.digitalhouse.projectkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.digitalhouse.projectkotlin.adapter.RecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = RecyclerViewAdapter(nomesAlunos())
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)

    }


    private fun nomesAlunos(): List<String> {
        val nomesAlunos = mutableListOf<String>()

        nomesAlunos.add("Lucas")
        nomesAlunos.add("Gabriel")
        nomesAlunos.add("Bruna")
        nomesAlunos.add("Lais")


        return nomesAlunos
    }
}
