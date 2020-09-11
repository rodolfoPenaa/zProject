package com.example.z4project.view


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.z4project.R
import com.example.z4project.model.Ilustration
import com.example.z4project.viewModel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.view.*

class MainFragment : Fragment(), IlustrationADP.ToEIntent {

    private lateinit var viewModel: MainViewModel
    private var catchedUpdateList:List<Ilustration> = ArrayList<Ilustration>()
    private lateinit var igurl: LiveData<List<Ilustration>>
    private val BASE_URL = "https://corvalan.dev/evade/"
    private lateinit var mViewModel: MainViewModel
    private lateinit var ilustratingADP: IlustrationADP


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel= ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.refreshDATAserver()
        ilustratingADP= IlustrationADP(catchedUpdateList,this)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view:View = inflater.inflate(R.layout.main_fragment, container, false)
        view.recycled_container.adapter = ilustratingADP
        view.recycled_container.layoutManager = LinearLayoutManager(activity)

        mViewModel.getDATAr00m().observe(viewLifecycleOwner, Observer {
            //Log.d("DEBUG", it.toString())
            //Log.d("IMAGEn", it[id].toString())
            ilustratingADP.updateViewModel(it)
        })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       //viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun goIgtent(urlGo: String) {
        val gogo: Uri = Uri.parse(urlGo)
        val Eintent : Intent = Intent(Intent.ACTION_VIEW,gogo)
        startActivity(Eintent)
    }

}