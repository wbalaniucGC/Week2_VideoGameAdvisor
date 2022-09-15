package com.mdev.videogameadvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findGames = findViewById<Button>(R.id.find_game)

        findGames.setOnClickListener {
            val gameGenres = findViewById<Spinner>(R.id.game_genres)
            val genre = gameGenres.selectedItem
            val gamesList = getGames(genre.toString())
            val reducedGamesList = gamesList.reduce {str, item -> str + '\n' + item}
            val games = findViewById<TextView>(R.id.games)
            games.text = reducedGamesList
        }
    }

    fun getGames(genre: String) : List<String> {
        return when (genre) {
            "Action" -> listOf("Legend of Zelda", "GTA5")
            "Adventure" -> listOf("Final Fantasy", "Elden Ring")
            "Strategy" -> listOf("Age of Empires", "StarCraft")
            "Sports" -> listOf("FIFA22", "NBA2K22")
            "RPG" -> listOf("Elder Scrolls 4", "Fallout")
            else -> listOf("Super Mario", "Kirby")
        }
    }
}