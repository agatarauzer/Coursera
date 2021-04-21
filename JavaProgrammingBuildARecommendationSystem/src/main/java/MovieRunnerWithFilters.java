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


    public static void main(String[] args) {
        MovieRunnerWithFilters movieRunnerWithFilters = new MovieRunnerWithFilters();
        //movieRunnerWithFilters.printAverageRatings();
        movieRunnerWithFilters.printAverageRatingsByYear();
    }
}
