package com.example.geckosample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.fragment_content.*
import kotlinx.android.synthetic.main.fragment_content.view.*
import org.mozilla.geckoview.GeckoSession

class FirstFragment : Fragment() {

    private val url = "https://www.google.com/"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GeckoSession().apply {
            val runtime = (activity as MainActivity).getGeckoRuntime()
            loadUri(url)
            open(runtime)
            gecko_view.setSession(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_content, container, false)
            .apply {
                screen_label.text = url
                button.setOnClickListener {
                    SecondFragment.run(requireFragmentManager())
                }
            }
    }

    companion object {
        fun run(fm: FragmentManager) {
            fm.beginTransaction().apply {
                add(R.id.root_container, FirstFragment())
                commit()
            }
        }
    }
}