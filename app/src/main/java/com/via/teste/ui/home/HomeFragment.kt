package com.via.teste.ui.home

import android.content.pm.PackageInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.via.teste.R
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pInfo : PackageInfo = activity?.packageManager!!.getPackageInfo("com.via.teste", 0)
        view.tv_version_name.text = "Version name ${pInfo.versionName}"
        view.tv_version_code.text = "Version code ${pInfo.versionCode}"


    }

}