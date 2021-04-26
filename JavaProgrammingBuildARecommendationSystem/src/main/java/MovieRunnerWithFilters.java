import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerWithFilters {
    private ThirdRatings thirdRatings;

    public MovieRunnerWithFilters() {
        MovieDatabase.initialize("ratedmoviesfull.csv");
        thirdRatings = new ThirdRatings();
    }

    public void printAverageRatings() {
        System.out.println("read data for: " + thirdRatings.getRaterSize() + " raters");
        System.out.println("read data for: " + MovieDatabase.size() + " movies");

        ArrayList<Rating> filteredMovies = thirdRatings.getAverageRatings(35);
        System.out.println("founded movies: " + filteredMovies.size());
        Collections.sort(filteredMovies);
        for (Rating r : filteredMovies) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
        }
    }

    public void printAverageRatingsByYear() {
        Filter filter = new YearAfterFilter(2000);
        ArrayList<Rating> filteredMovies = thirdRatings.getAverageRatingsByFilter(20, filter);
        System.out.println("founded movies: " + filteredMovies.size());
        Collections.sort(filteredMovies);
        for (Rating r : filteredMovies) {
            System.out.println(r.getValue() + " " + MovieDatabase.getYear(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
        }
    }

    public void printAverageRatingsByGenre() {
        GenreFilter genreFilter = new GenreFilter("Comedy");
        ArrayList<Rating> filteredMovies = thirdRatings.getAverageRatingsByFilter(20, genreFilter);
        System.out.println("founded movies: " + filteredMovies.size());
        Collections.sort(filteredMovies);
        for (Rating r : filteredMovies) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()) + "\n    " + MovieDatabase.getGenres(r.getItem()));
        }
    }

    public void printAverageRatingsByMinutes() {
        MinutesFilter minutesFilter = new MinutesFilter(105, 135);
        ArrayList<Rating> filteredMovies = thirdRatings.getAverageRatingsByFilter(5, minutesFilter);
        System.out.println("founded movies: " + filteredMovies.size());
        Collections.sort(filteredMovies);
        for (Rating r : filteredMovies) {
            System.out.println(r.getValue() + " Time:  " + MovieDatabase.getMinutes(r.getItem()) + "  " + MovieDatabase.getTitle(r.getItem()));
        }
    }

    public void printAverageRatingsByDirectors() {
        DirectorsFilter directorsFilter = new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
        ArrayList<Rating> filteredMovies = thirdRatings.getAverageRatingsByFilter(4, directorsFilter);
        System.out.println("founded movies: " + filteredMovies.size());
        Collections.sort(filteredMovies);
        for (Rating r : filteredMovies) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()) + "\n    " + MovieDatabase.getDirector(r.getItem()));
        }
    }

    public void printAverageRatingsByYearAfterAndGenre() {
        AllFilters allFilters = new AllFilters();
        YearAfterFilter yearAfterFilter = new YearAfterFilter(1990);
        GenreFilter genreFilter = new GenreFilter("Drama");
        allFilters.addFilter(yearAfterFilter);
        allFilters.addFilter(genreFilter);
        ArrayList<Rating> filteredMovies = thirdRatings.getAverageRatingsByFilter(8, allFilters);
        System.out.println("founded movies: " + filteredMovies.size());
        Collections.sort(filteredMovies);
        for (Rating r : filteredMovies) {
            System.out.println(r.getValue() + " " + MovieDatabase.getYear(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()) + "\n    " + MovieDatabase.getGenres(r.getItem()));
        }
    }

    public void printAverageRatingsByDirectorsAndMinutes() {
        AllFilters allFilters = new AllFilters();
        DirectorsFilter directorsFilter = new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack");
        MinutesFilter minutesFilter = new MinutesFilter(90, 180);
        allFilters.addFilter(directorsFilter);
        allFilters.addFilter(minutesFilter);
        ArrayList<Rating> filteredMovies = thirdRatings.getAverageRatingsByFilter(3, allFilters);
        System.out.println("founded movies: " + filteredMovies.size());
        Collections.sort(filteredMovies);
        for (Rating r : filteredMovies) {
            System.out.println(r.getValue() + " Time: " + MovieDatabase.getMinutes(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()) + "\n    " + MovieDatabase.getDirector(r.getItem()));
        }
    }

    /*
    public static void main(String[] args) {
        MovieRunnerWithFilters movieRunnerWithFilters = new MovieRunnerWithFilters();
        //movieRunnerWithFilters.printAverageRatings();
        //movieRunnerWithFilters.printAverageRatingsByYear();
        //movieRunnerWithFilters.printAverageRatingsByGenre();
        //movieRunnerWithFilters.printAverageRatingsByMinutes();
        //movieRunnerWithFilters.printAverageRatingsByDirectors();
        //movieRunnerWithFilters.printAverageRatingsByYearAfterAndGenre();
        movieRunnerWithFilters.printAverageRatingsByDirectorsAndMinutes();
    }
     */
}
