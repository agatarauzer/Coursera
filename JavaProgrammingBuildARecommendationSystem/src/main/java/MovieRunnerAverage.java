import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerAverage {

    public void printAverageRatings() {

        SecondRatings secondRatings = new SecondRatings();
        ArrayList<Rating> moviesWithAverage = secondRatings.getAverageRatings(12);
        Collections.sort(moviesWithAverage);
        for (Rating r : moviesWithAverage) {
            System.out.println(r.getValue() + " " + secondRatings.getTitle(r.getItem()));
        }
    }

    public void getAverageRatingOneMovie() {
        SecondRatings secondRatings = new SecondRatings();
        String searchedTitle = "Vacation";
        String id = secondRatings.getId(searchedTitle);
        System.out.println("Rating for searched movie " + searchedTitle + " is: " + secondRatings.getAverageByID(id, 3));
    }

    public static void main(String[] args) {
        MovieRunnerAverage movieRunnerAverage = new MovieRunnerAverage();
        movieRunnerAverage.printAverageRatings();
        movieRunnerAverage.getAverageRatingOneMovie();
    }
}
