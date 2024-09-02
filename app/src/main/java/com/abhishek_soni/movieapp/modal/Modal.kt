package com.abhishek_soni.movieapp.modal


data class User(
    val username:String,
    val password:String
)

data class Movie(
    val play: String="",
    val imgUrl: String="",
    val title: String="",
    val body: String="",
    val director: String = "",
    val year: Int = 0,
)
fun getMovies(): List<com.abhishek_soni.movieapp.modal.Movie> {
    return listOf(
        Movie(
            play = "https://youtu.be/8ugaeA-nMTc?feature=shared",
            imgUrl="https://i.redd.it/o9sj0hsa1jjb1.jpg",
            title="Iron Man",
            body="After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.",
            director="Jon Favreau",
            year=2008
        ),
        Movie(
            play = "https://youtu.be/BoohRoVA9WQ?feature=shared",
            imgUrl="https://images-na.ssl-images-amazon.com/images/I/91cp0lKCbkL.jpg",
            title="Iron Man 2",
            body="With the world now aware of his identity as Iron Man, Tony Stark must contend with both his declining health and a vengeful madman with ties to his father's legacy.",
            director="Jon Favreau",
            year=2010
        ),
        Movie(
            play = "https://youtu.be/Ke1Y3P9D0Bc?feature=shared",
            imgUrl="https://images-na.ssl-images-amazon.com/images/I/A15bQonvFrL.jpg",
            title="Iron Man 3",
            body="When Tony Stark's world is torn apart by a formidable terrorist called the Mandarin, he starts an odyssey of rebuilding and retribution.",
            director="Shane Black",
            year=2013
        ),

        Movie(
            play = "https://youtu.be/YoHD9XEInc0?feature=shared",
            imgUrl="https://s3.amazonaws.com/static.rogerebert.com/uploads/movie/movie_poster/inception-2010/large_ziKvu3Th9l1wN2aIeVj5ElpBqFu.jpg",
            title="Inception",
            body="A skilled thief who steals corporate secrets through the use of dream-sharing technology.",
            director="Christopher Nolan",
            year=2010
        ),
        Movie(
            play = "https://youtu.be/AD_8i1xRyTA?feature=shared",
            imgUrl="https://m.media-amazon.com/images/I/51Ttvb17dtL.jpg",
            title="The Matrix",
            body="A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.",
            director="The Wachowskis",
            year=1999
        ),
        Movie(
            play = "https://youtu.be/zSWdZVtXT7E?feature=shared",
            imgUrl="https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg",
            title="Interstellar",
            body="A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
            director="Christopher Nolan",
            year=2014
        ),
        Movie(
            play = "https://youtu.be/EXeTwQWrcwY?feature=shared",
            imgUrl="https://mediaproxy.tvtropes.org/width/1200/https://static.tvtropes.org/pmwiki/pub/images/the_dark_knight_poster.jpg",
            title="The Dark Knight",
            body="Batman battles the Joker, who threatens to plunge Gotham City into anarchy.",
            director="Christopher Nolan",
            year=2008
        ),
        Movie(
            play = "https://youtu.be/qtRKdVHc-cE?feature=shared",
            imgUrl="https://static1.colliderimages.com/wordpress/wp-content/uploads/fight-club-poster.jpg",
            title="Fight Club",
            body="An insomniac office worker forms an underground fight club that evolves into something much more.",
            director="David Fincher",
            year=1999
        ),
        Movie(
            play = "https://youtu.be/tGpTpVyI_OQ?feature=shared",
            imgUrl="https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@.jpg",
            title="Pulp Fiction",
            body="The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
            director="Quentin Tarantino",
            year=1994
        ),
        Movie(
            play = "https://youtu.be/PLl99DlL6b4?feature=shared",
            imgUrl="https://s3.amazonaws.com/static.rogerebert.com/uploads/movie/movie_poster/the-shawshank-redemption-1994/large_9O7gLzmreU0nGkIB6K3BsJbzvNv.jpg",
            title="The Shawshank Redemption",
            body="Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
            director="Frank Darabont",
            year=1994
        ),
        Movie(
            play = "https://youtu.be/UaVTIH8mujA?feature=shared",
            imgUrl="https://i.pinimg.com/originals/09/4b/37/094b37f4a3a1075e67c127a9a285ff96.jpg",
            title="The Godfather",
            body="The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
            director="Francis Ford Coppola",
            year=1972
        ),
        Movie(
            play = "https://youtu.be/XHhAG-YLdk8?feature=shared",
            imgUrl="https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@.jpg",
            title="Forrest Gump",
            body="The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75.",
            director="Robert Zemeckis",
            year=1994
        ),
        Movie(
            play = "https://youtu.be/_nZdmwHrcnw?feature=shared",
            imgUrl="https://static1.colliderimages.com/wordpress/wp-content/uploads/2023/11/lord-of-the-rings-the-two-towers-movie-poster-1.jpg",
            title="The Lord of the Rings: The Fellowship of the Ring",
            body="A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",
            director="Peter Jackson",
            year=2001
        ),
        Movie(
            play = "https://www.starwars.com/video/star-wars-episode-iv-a-new-hope-opening-crawl",
            imgUrl="https://images-na.ssl-images-amazon.com/images/I/71ABa3+0B1L.jpg",
            title="Star Wars: Episode IV - A New Hope",
            body="\"Star Wars: Episode IV - A New Hope\" is a science fiction epic that transports viewers to a galaxy far, far away, where the evil Galactic Empire, led by the sinister Darth Vader, holds the galaxy in its iron grip. The story follows a young farm boy named Luke Skywalker, who dreams of adventure beyond his home planet of Tatooine. Luke’s life changes forever when he encounters two droids, R2-D2 and C-3PO, who carry a distress message from Princess Leia Organa. She is a leader in the Rebel Alliance, fighting against the Empire’s tyranny, and has been captured by Vader.\n" +
                    "\n" +
                    "With the help of the wise and enigmatic Jedi Master Obi-Wan Kenobi, the charismatic smuggler Han Solo, and the loyal Wookiee Chewbacca, Luke embarks on a daring mission to rescue the princess and destroy the Empire’s ultimate weapon: the Death Star, a massive space station capable of annihilating entire planets. As Luke learns about the mystical energy known as the Force and his connection to the ancient Jedi Order, he begins his journey to becoming a Jedi Knight.\n" +
                    "\n" +
                    "The film combines breathtaking visual effects, memorable characters, and an iconic score by John Williams to create an unforgettable adventure that has captivated audiences for generations. \"Star Wars: Episode IV - A New Hope\" is more than just a movie; it's a cultural phenomenon that has spawned an entire universe of sequels, prequels, spin-offs, books, games, and more, solidifying its place as one of the most influential films in cinema history.",
            director="George Lucas",
            year=1977
        )
    )
}