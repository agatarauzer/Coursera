import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerWithFilters {

    public void printAverageRatings() {
        ThirdRatings thirdRatings = new ThirdRatings();
        System.out.println("Rater size: " + thirdRatings.getRaterSize());
        MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("Number of movies in database: " + MovieDatabase.size());
        ArrayList<Rating> moviesWithAverage = thirdRatings.getAverageRatings(1);
        System.out.println("Number of movies with ratings: " + moviesWithAverage.size());
        Collections.sort(moviesWithAverage);
        for (Rating r : moviesWithAverage) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
        }
    }

    public void printAverageRatingsByYear() {
        ThirdRatings thirdRatings = new ThirdRatings();
        System.out.println("Rater size: " + thirdRatings.getRaterSize());
        Filter filter = new YearAfterFilter(2000);
        ArrayList<Rating> filteredMovies = thirdRatings.getAverageRatingsByFilter(1, filter);
        System.out.println("Founded movies: " + filteredMovies.size());
        Collections.sort(filteredMovies);
        for (Rating r : filteredMovies) {
            System.out.println(r.getValue() + " " + MovieDatabase.getYear(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
        }
    }

    public void printAverageRatingsByGenre() {
        ThirdRatings thirdRatings = new ThirdRatings();
        GenreFilter genreFilter = new GenreFilter("Crime");
        ArrayList<Rating> filteredMovies = thirdRatings.getAverageRatingsByFilter(1, genreFilter);
        Collections.sort(filteredMovies);
        for (Rating r : filteredMovies) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()) + "\n    " + MovieDatabase.getGenres(r.getItem()));
        }
    }

    public void printAverageRatingsByMinutes() {
        ThirdRatings thirdRatings = new ThirdRatings();
        MinutesFilter minutesFilter = new MinutesFilter(110, 170);
        ArrayList<Rating> filteredMovies = thirdRatings.getAverageRatingsByFilter(1, minutesFilter);
        Collections.sort(filteredMovies);
        for (Rating r : filteredMovies) {
            System.out.println(r.getValue() + " Time:  " + MovieDatabase.getMinutes(r.getItem()) + "  " + MovieDatabase.getTitle(r.getItem()));
        }
    }

    public void printAverageRatingsByDirectors() {
        ThirdRatings thirdRatings = new ThirdRatings();
        DirectorsFilter directorsFilter = new DirectorsFilter("Charles Chaplin,Michael Mann,Spike Jonze");
        ArrayList<Rating> filteredMovies = thirdRatings.getAverageRatingsByFilter(1, directorsFilter);
        Collections.sort(filteredMovies);
        for (Rating r : filteredMovies) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()) + "\n    " + MovieDatabase.getDirector(r.getItem()));
        }
    }

    public static void main(String[] args) {
        MovieRunnerWithFilters movieRunnerWithFilters = new MovieRunnerWithFilters();
        //movieRunnerWithFilters.printAverageRatings();
        //movieRunnerWithFilters.printAverageRatingsByYear();
        //movieRunnerWithFilters.printAverageRatingsByGenre();
        movieRunnerWithFilters.printAverageRatingsByMinutes();
        //movieRunnerWithFilters.printAverageRatingsByDirectors();
    }
}
