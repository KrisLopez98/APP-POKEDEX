package com.example.pokedex

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    interface PokemonSelectListener{
        fun onPokemonSelected(pokemon: Pokemon)
    }

    private lateinit var pokemonSelectListener: PokemonSelectListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        pokemonSelectListener = try {
            context as PokemonSelectListener
        } catch (e: ClassCastException){
            throw ClassCastException("$context must implement PokemonSelectListener")
        }
    }


    //Función
    override fun onCreateView(
        //En esta parte son los propiedades que tiene la función ONCREATEVIEW
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val recycler:RecyclerView = view.findViewById<RecyclerView>(R.id.pokemon_recycler)
        recycler.layoutManager = LinearLayoutManager(requireActivity())
        val adapter = PokemonAdapter()
        recycler.adapter = adapter

        adapter.onItemClickListener = {
            pokemonSelectListener.onPokemonSelected(it)
        }

            val pokemonList = mutableListOf(
                Pokemon(1, "Bulbasaur", 45,49, 49, 45,
                    Pokemon.PokemonType.GRASS, "https://cdn.alfabetajuega.com/wp-content/uploads/2020/03/bulbasaur-pok%C3%A9mon.png"
                ),
                Pokemon(2,"Ivysaur",60,62, 63, 60,
                    Pokemon.PokemonType.GRASS, "https://mestrepokemon.com/wp-content/uploads/2019/11/Ivysaur-Pok%C3%A9dex.png"
                ),
                Pokemon(3, "Venuasaur", 80, 82, 83, 80,
                    Pokemon.PokemonType.GRASS, "https://static.wikia.nocookie.net/espokemon/images/f/f1/EP1085_Venusaur_de_Kukui.jpg/revision/latest?cb=20200407010928"
                ),
                Pokemon(4, "Charmander", 39, 52, 43, 65,
                    Pokemon.PokemonType.FIRE, "https://areajugones.sport.es/wp-content/uploads/2019/11/Pokemon-Espada-y-Escudo-Charmander.jpg"
                ),
                Pokemon(5,"Charmelon",58, 64, 58, 80,
                    Pokemon.PokemonType.FIRE, "https://static.wikia.nocookie.net/pokedex-br/images/0/06/800px-Ash_Charmeleon.png/revision/latest?cb=20151223201747&path-prefix=pt-br"
                ),
                Pokemon(6, "Charizzard", 78, 84,78, 100,
                    Pokemon.PokemonType.FIRE, "https://i.blogs.es/fb1922/1200px-ep803_charizard_de_ash/1366_521.jpeg"
                ),
                Pokemon(7, "Squirtle", 44, 48, 65, 43,
                    Pokemon.PokemonType.WATER, "https://areajugones.sport.es/wp-content/uploads/2019/07/squirtle-funko.jpg"
                ),
                Pokemon(8, "Wartotle", 59, 63, 80, 58,
                    Pokemon.PokemonType.WATER, "https://static.wikia.nocookie.net/wikianimeotaku/images/2/22/008Wartortle_AG_anime.png/revision/latest?cb=20160216210936&path-prefix=es"
                ),
                Pokemon(9,"Blastoise", 79, 83, 100, 78,
                    Pokemon.PokemonType.WATER, "https://images.wikidexcdn.net/mwuploads/wikidex/8/81/latest/20210528173042/EP1157_Blastoise_de_Gary.png"
                ),
                Pokemon(10, "Pikachu", 35, 55, 40, 90,
                    Pokemon.PokemonType.ELECTRIC, "https://areajugones.sport.es/wp-content/uploads/2021/02/pikachu-pokemon.jpg"
                ),
                Pokemon(11, "Raichu", 60, 90, 55, 110,
                    Pokemon.PokemonType.ELECTRIC, "https://cdn.alfabetajuega.com/wp-content/uploads/2020/11/pok%C3%A9mon-raichu.jpeg?width=1200&aspect_ratio=1200:631"
                ),
            )

            adapter.submitList(pokemonList)

        return view
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//        //Se crea una variable recycler con la finalidad de obtener la lista pokemon recycler
//        // y hacer uso de esta
//        val recycler = view.findViewById<RecyclerView>(R.id.pokemon_recycler)
//        //Aquí se hace uso del requiereActivity ya que por si solo el MainActivity no posee un
//        //contexto por lo tanto se dispone de se hace uso del requiereActivity
//        recycler.layoutManager = LinearLayoutManager(requireActivity())
//
//        val adapter = PokemonAdapter()
//        recycler.adapter = adapter
//
//        adapter.onItemClickListener = {
//            Toast.makeText(requireActivity(), it.name, Toast.LENGTH_SHORT).show()
//        }
//
//        val pokemonList = mutableListOf(
//            Pokemon(1, "Bulbasaur", 45,49, 49, 45,
//                Pokemon.PokemonType.GRASS
//            ),
//            Pokemon(2,"Ivysaur",60,62, 63, 60,
//                Pokemon.PokemonType.GRASS
//            ),
//            Pokemon(3, "Venuasaur", 80, 82, 83, 80,
//                Pokemon.PokemonType.GRASS
//            ),
//            Pokemon(4, "Charmander", 39, 52, 43, 65,
//                Pokemon.PokemonType.FIRE
//            ),
//            Pokemon(5,"Charmelon",58, 64, 58, 80,
//                Pokemon.PokemonType.FIRE
//            ),
//            Pokemon(6, "Charizzard", 78, 84,78, 100,
//                Pokemon.PokemonType.FIRE
//            ),
//            Pokemon(7, "Squirtle", 44, 48, 65, 43,
//                Pokemon.PokemonType.WATER
//            ),
//            Pokemon(8, "Wartotle", 59, 63, 80, 58,
//                Pokemon.PokemonType.WATER
//            ),
//            Pokemon(9,"Blastoise", 79, 83, 100, 78,
//                Pokemon.PokemonType.WATER
//            ),
//            Pokemon(10, "Pikachu", 35, 55, 40, 90,
//                Pokemon.PokemonType.ELECTRIC
//            ),
//            Pokemon(11, "Raichu", 60, 90, 55, 110,
//                Pokemon.PokemonType.ELECTRIC
//            ),
//        )
//
//        adapter.submitList(pokemonList)
//
//    }
}