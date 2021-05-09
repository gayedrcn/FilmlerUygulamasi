package com.gayedirican.recyclerviewkullanimi2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.gayedirican.recyclerviewkullanimi2.databinding.FragmentDetaySayfaBinding


class DetaySayfaFragment : Fragment() {

    private lateinit var tasarim:FragmentDetaySayfaBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim =DataBindingUtil.inflate(inflater,R.layout.fragment_detay_sayfa, container, false)
        val bundle:DetaySayfaFragmentArgs by navArgs()
        val gelenNesne = bundle.nesne
        //tasarim.textViewKisiAd.text = gelenNesne.kisi_ad
        //tasarim.textViewKisiTel.text=gelenNesne.kisi_tel
        tasarim.kisiNesnesi = gelenNesne


        return tasarim.root
    }

}