package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.todoapp.Adapter.viewpageerAdapter
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.fragments.AllEventFragment
import com.example.todoapp.fragments.FinisheventFragment
import com.example.todoapp.fragments.TommorowFragment
import com.example.todoapp.fragments.pendingeventFragment

class MainActivity : AppCompatActivity() {
    private  val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var aadapter: viewpageerAdapter
    lateinit var  fragmentlist:ArrayList<Fragment>
    lateinit var fragmenttitle:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fragmentlist=ArrayList()
        fragmenttitle=ArrayList()
        addFragment(TommorowFragment(),"tommorow")
        addFragment(AllEventFragment(),"All Event")
        addFragment(pendingeventFragment(),"Pending Task")
        addFragment(FinisheventFragment(),"Finished")
        aadapter= viewpageerAdapter(supportFragmentManager,fragmentlist,fragmenttitle)
        binding.viewpage.adapter=aadapter
        binding.tabLayout.setupWithViewPager(binding.viewpage)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {  // menu ka element ka function krwana hai
        if(item.itemId==R.id.refresh){
            recreate()
        }
        return super.onOptionsItemSelected(item)
    }

    fun addFragment(fragment: Fragment, title:String){
        fragmentlist.add(fragment)
        fragmenttitle.add(title)
    }

}