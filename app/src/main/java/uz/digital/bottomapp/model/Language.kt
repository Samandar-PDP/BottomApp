package uz.digital.bottomapp.model

data class Language(
    val name: String,
    val image: Int,
    val speakPopulation: Long,
    val speakCounties: List<String>
)