import java.util.ArrayList;

public class MovieRunnerSimilarRatings {

    private FourthRatings fourthRating;

    public MovieRunnerSimilarRatings() {
        fourthRating = new FourthRatings("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
    }

    public void printSimilarRatings() {
        ArrayList<Rating> result = fourthRating.getSimilarRatings("71", 20, 5);
        for (Rating r : result){
            System.out.println(MovieDatabase.getTitle(r.getItem()) + ": " + r.getValue());
        }
    }

    public void printSimilarRatingsByGenre() {
        GenreFilter genreFilter = new GenreFilter("Mystery");
        ArrayList<Rating> result = fourthRating.getSimilarRatingsByFilter("964", 20, 5, genreFilter);
        for (Rating r : result){
            System.out.println(MovieDatabase.getTitle(r.getItem()) + ": " + r.getValue());
        }
    }

    public void printSimilarRatingsByDirector() {
        DirectorsFilter directorsFilter = new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh");
        ArrayList<Rating> result = fourthRating.getSimilarRatingsByFilter("120", 10, 2, directorsFilter);
        for (Rating r : result){
            System.out.println(MovieDatabase.getTitle(r.getItem()) + ": " + r.getValue());
        }
    }

    public void printSimilarRatingsByGenreAndMinutes() {
        GenreFilter genreFilter = new GenreFilter("Drama");
        MinutesFilter minutesFilter = new MinutesFilter(80, 160);
        AllFilters genreAndMinutesFilter = new AllFilters();
        genreAndMinutesFilter.addFilter(genreFilter);
        genreAndMinutesFilter.addFilter(minutesFilter);
        ArrayList<Rating> result = fourthRating.getSimilarRatingsByFilter("168", 10, 3, genreAndMinutesFilter);
        for (Rating r : result) {
            System.out.println(MovieDatabase.getTitle(r.getItem()) + ": " + r.getValue());
        }
    }

    public void printSimilarRatingsByYearAfterAndMinutes() {
        YearAfterFilter yearAfterFilter = new YearAfterFilter(1975);
        MinutesFilter minutesFilter = new MinutesFilter(70, 200);
        AllFilters yearAfterAndMinutesFilter = new AllFilters();
        yearAfterAndMinutesFilter.addFilter(yearAfterFilter);
        yearAfterAndMinutesFilter.addFilter(minutesFilter);
        ArrayList<Rating> result = fourthRating.getSimilarRatingsByFilter("314", 10, 5, yearAfterAndMinutesFilter);
        for (Rating r : result) {
            System.out.println(MovieDatabase.getTitle(r.getItem()) + ": " + r.getValue());
        }
    }

    public static void main(String[] args) {
        MovieRunnerSimilarRatings movieRunnerSimilarRatings = new MovieRunnerSimilarRatings();
        movieRunnerSimilarRatings.printSimilarRatings();
        //movieRunnerSimilarRatings.printSimilarRatingsByGenre();
        //movieRunnerSimilarRatings.printSimilarRatingsByDirector();
        //movieRunnerSimilarRatings.printSimilarRatingsByGenreAndMinutes();
        //movieRunnerSimilarRatings.printSimilarRatingsByYearAfterAndMinutes();
    }
}
