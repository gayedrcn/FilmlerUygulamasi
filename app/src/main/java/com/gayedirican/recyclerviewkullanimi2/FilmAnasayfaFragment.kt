package com.gayedirican.recyclerviewkullanimi2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gayedirican.recyclerviewkullanimi2.databinding.FragmentFilmAnasayfa2Binding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FilmAnasayfaFragment : Fragment() {

    private lateinit var tasarim:FragmentFilmAnasayfa2Binding
    private lateinit var filmListesi:ArrayList<Filmler>
    private lateinit var adapter:FilmlerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_film_anasayfa2, container, false)

        tasarim.rvfilm.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val f1 = Filmler(1, "Anadoluda", "anadoluda", 2013, 13.99, "Dram", "Nuri Bilge Ceylan")
        val f2 = Filmler(2, "Django", "django", 2011, 15.99, "Aksiyon", "Quentin Tarantino")
        val f3 = Filmler(3, "Inception", "inception", 2009, 18.99, "Bilim Kurgu", "Christopher Nolan")
        val f4 = Filmler(4, "Interstellar", "interstellar", 2013, 13.99, "Bilim Kurgu", "Christopher Nolan")
        val f5 = Filmler(5, "The Hateful Eight", "thehatefuleight", 2016, 16.99, "Dram", "Quantin Taran")
        val f6 = Filmler(6, "The Pianist", "thepianist", 2018, 10.99, "Dram", "Roman")

        filmListesi = ArrayList()
        filmListesi.add(f1)
        filmListesi.add(f2)
        filmListesi.add(f3)
        filmListesi.add(f4)
        filmListesi.add(f5)
        filmListesi.add(f6)

        adapter = FilmlerAdapter(requireContext(), filmListesi)
        tasarim.rvfilm.adapter = adapter

        return tasarim.root
    }

}