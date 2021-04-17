import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import predefinedClasses.FileResource;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirstRatings {

    public ArrayList<Movie> loadMovies(String filename) {
        ArrayList<Movie> movies = new ArrayList<>();
        FileResource fr = new FileResource(filename);
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record : parser) {
            String id = record.get("id");
            String title = record.get("title");
            String year = record.get("year");
            String country = record.get("country");
            String genres = record.get("genre");
            String director = record.get("director");
            int minutes = Integer.parseInt(record.get("minutes"));
            String poster = record.get("poster");
            Movie movie = new Movie(id, title, year, genres, director, country, poster, minutes);
            movies.add(movie);
        }
        return movies;
    }

    public void testLoadMovies() {
        ArrayList<Movie> movies = loadMovies("ratedmoviesfull.csv");

        System.out.println("Number of movies: " + movies.size());
        //System.out.println("Movies: ");
        //for(Movie m : movies) {
           // System.out.println(m);
       // }
        int counterOfComedies = 0;
        int counterOfMoviesLongerThan150 = 0;
        Map<String, Integer> directors = new HashMap<>();
        int maxVal = 1;
        for (Movie m : movies) {
            String genre = m.getGenres().toLowerCase();
            if (genre.contains("comedy")) {
                counterOfComedies++;
            }
            int minutes = m.getMinutes();
            if (minutes > 150) {
                counterOfMoviesLongerThan150++;
            }
            String[] dir = m.getDirector().split(",");
            for (int i = 0; i < dir.length; i++) {
                String d = dir[i].trim();
                if (directors.containsKey(d)) {
                    int movieNum = directors.get(d);
                    movieNum = movieNum + 1;
                    directors.put(d, movieNum);
                    if (movieNum > maxVal) {
                        maxVal = movieNum;
                    }
                }
                else {
                    directors.put(d, 1);
                }
            }
        }
        System.out.println("The number of comedy movies: " + counterOfComedies);
        System.out.println("The number of movies longer than 150 minutes: " + counterOfMoviesLongerThan150);
        System.out.println("Maximum number of movies by one director: " + maxVal);
        System.out.println("Director/s: ");
        for (String d : directors.keySet()) {
            if (directors.get(d) == maxVal) {
                System.out.println(d) ;
            }
        }
    }

    public static void main (String[] args) {
        FirstRatings fr = new FirstRatings();
        fr.testLoadMovies();
    }
}
