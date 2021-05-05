import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerSimilarRatings {

    private FourthRatings fourthRating;

    public MovieRunnerSimilarRatings() {
        fourthRating = new FourthRatings("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
    }

    public void printAverageRatings() {
        System.out.println("read data for: " + RaterDatabase.size() + " raters");
        System.out.println("read data for: " + MovieDatabase.size() + " movies");

        ArrayList<Rating> filteredMovies = fourthRating.getAverageRatings(2);
        System.out.println("founded movies: " + filteredMovies.size());
        Collections.sort(filteredMovies);
        for (Rating r : filteredMovies) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
        }
    }

    public void printAverageRatingsByYearAfterAndGenre() {
        AllFilters allFilters = new AllFilters();
        YearAfterFilter yearAfterFilter = new YearAfterFilter(1990);
        GenreFilter genreFilter = new GenreFilter("Drama");
        allFilters.addFilter(yearAfterFilter);
        allFilters.addFilter(genreFilter);
        ArrayList<Rating> filteredMovies = fourthRating.getAverageRatingsByFilter(8, allFilters);
        System.out.println("founded movies: " + filteredMovies.size());
        Collections.sort(filteredMovies);
        for (Rating r : filteredMovies) {
            System.out.println(r.getValue() + " " + MovieDatabase.getYear(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()) + "\n    " + MovieDatabase.getGenres(r.getItem()));
        }
    }

    public static void main(String[] args) {
        MovieRunnerSimilarRatings movieRunnerSimilarRatings = new MovieRunnerSimilarRatings();
        //movieRunnerSimilarRatings.printAverageRatings();
        movieRunnerSimilarRatings.printAverageRatingsByYearAfterAndGenre();

    }
}
