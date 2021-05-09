package com.gayedirican.recyclerviewkullanimi2

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gayedirican.recyclerviewkullanimi2.databinding.FilmCardBinding
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter(var mContext:Context, var filmListesi:List<Filmler>) : RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(filmCardBinding: FilmCardBinding):RecyclerView.ViewHolder(filmCardBinding.root){
        var tasarim:FilmCardBinding

        init {
            this.tasarim = filmCardBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = FilmCardBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmListesi.get(position)

        holder.tasarim.imageViewFilm.setImageResource(mContext.resources.getIdentifier(film.film_resim_adi, "drawable", mContext.packageName))

        holder.tasarim.textViewFilmAdi.text = film.film_adi
        holder.tasarim.textViewFiyat.text = "${film.film_fiyat} \u20BA"

        holder.tasarim.buttonSepet.setOnClickListener {
            Snackbar.make(it, "${film.film_adi} sepete eklendi.", Snackbar.LENGTH_LONG).show()
        }
        holder.tasarim.filmCardview.setOnClickListener {
            val gecis = FilmAnasayfaFragmentDirections.filmDetayGecis(film)

            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return filmListesi.size
    }
}