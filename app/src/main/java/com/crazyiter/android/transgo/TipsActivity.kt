package com.crazyiter.android.transgo

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import com.crazyiter.android.transgo.Adapters.TipsPagerAdapter
import com.crazyiter.android.transgo.TipsFragments.Tips1Fragment
import com.crazyiter.android.transgo.TipsFragments.Tips2Fragment
import com.crazyiter.android.transgo.TipsFragments.Tips3Fragment
import kotlinx.android.synthetic.main.activity_tips.*

class TipsActivity : AppCompatActivity() {

    private val tipsFragmentsNumber = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips)

        // region tips view pager
        val adapter = TipsPagerAdapter(supportFragmentManager)
        adapter.addFragment(Tips1Fragment())
        adapter.addFragment(Tips2Fragment())
        adapter.addFragment(Tips3Fragment())
        tipsVP.adapter = adapter
        tipsVP.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {}
            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {}
            @SuppressLint("RestrictedApi")
            override fun onPageSelected(position: Int) {
                setPagerPoint(position)
                tipsNextFAB.visibility = View.VISIBLE
                tipsPreviousFAB.visibility = View.VISIBLE
                tipsContinueBTN.visibility = View.GONE
                if (position == 0) {
                    tipsPreviousFAB.visibility = View.GONE
                }
                if (position == tipsFragmentsNumber) {
                    tipsNextFAB.visibility = View.GONE
                    tipsContinueBTN.visibility = View.VISIBLE
                }
            }
        })
        // endregion

        tipsPreviousFAB.setOnClickListener {
            tipsVP.currentItem = tipsVP.currentItem - 1
        }

        tipsNextFAB.setOnClickListener {
            tipsVP.currentItem = tipsVP.currentItem + 1
        }

        tipsContinueBTN.setOnClickListener {
            setupMainApp()
        }
    }

    private fun setupMainApp() {
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun setPagerPoint(position: Int) {
        tipsPoint1.setBackgroundResource(R.drawable.background_point_unselected)
        tipsPoint2.setBackgroundResource(R.drawable.background_point_unselected)
        tipsPoint3.setBackgroundResource(R.drawable.background_point_unselected)
        when (position) {
            0 -> tipsPoint1.setBackgroundResource(R.drawable.background_point_selected)
            1 -> tipsPoint2.setBackgroundResource(R.drawable.background_point_selected)
            2 -> tipsPoint3.setBackgroundResource(R.drawable.background_point_selected)
        }
    }

}
