package uz.digital.bottomapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import uz.digital.bottomapp.R
import uz.digital.bottomapp.adapter.LanguageAdapter
import uz.digital.bottomapp.databinding.FragmentHomeBinding
import uz.digital.bottomapp.model.Language
import uz.digital.bottomapp.util.Constants

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val languageAdapter by lazy { LanguageAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        languageAdapter.languageList = Constants.mixLanguages().toMutableList()
        binding.rv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = languageAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        }
        languageAdapter.onClick = {
            showBottomSheetDialog(it)
        }
    }

    private fun showBottomSheetDialog(lan: Language) {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(R.layout.bottom_dialog)
        val imageView = bottomSheetDialog.findViewById<ImageView>(R.id.imageView)
        val textName = bottomSheetDialog.findViewById<TextView>(R.id.textView)
        val pop = bottomSheetDialog.findViewById<TextView>(R.id.pop)
        val count = bottomSheetDialog.findViewById<TextView>(R.id.count)
        val btnOk = bottomSheetDialog.findViewById<Button>(R.id.btnOk)
        imageView?.setImageResource(lan.image)
        textName?.text = lan.name
        pop?.text = lan.speakPopulation.toString()
        count?.text = lan.speakCounties.toString()

        btnOk?.setOnClickListener {
            bottomSheetDialog.dismissWithAnimation = true
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}