package uz.digital.bottomapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.digital.bottomapp.databinding.ItemLayoutBinding
import uz.digital.bottomapp.model.Language

class LanguageAdapter : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {
    lateinit var onClick: (Language) -> Unit
    var languageList = mutableListOf<Language>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.bind(languageList[position])
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    inner class LanguageViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(language: Language) {
            binding.imageView.setImageResource(language.image)
            binding.textView.text = language.name
            itemView.setOnClickListener {
                onClick(language)
            }
        }
    }
}