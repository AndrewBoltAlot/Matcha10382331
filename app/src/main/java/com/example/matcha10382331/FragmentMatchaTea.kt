package com.example.matcha10382331

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_matcha_tea.view.*
import kotlinx.android.synthetic.main.fragment_shop_main.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class FragmentMatchaTea : Fragment(){
    private lateinit var database: DatabaseReference
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_matcha_tea, container, false)

        doAsync {
            val json = URL("https://my-json-server.typicode.com/AndrewBoltAlot/RestApiMatchaTeaApp/products").readText()
// ...
            database = FirebaseDatabase.getInstance().reference


            uiThread {
                val products = Gson().fromJson(json, Array<Product>::class.java).toList()

                root.matchaTea_recycler_view2.apply {
                    layoutManager = GridLayoutManager(activity, 2)
                    adapter = ProductsAdapter(context, products)
                    root.progressBar2.visibility = View.GONE
                }
            }
        }

        val categories = (listOf("Matcha Tea", " Tea Sets", "Japanese Matcha Tea", "American Matcha Tea"))

        root.matchaTea_categories2.apply{
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            adapter = CategoriesAdapter(categories)
        }


        return root
    }
}
