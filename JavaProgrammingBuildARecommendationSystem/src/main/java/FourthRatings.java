import java.util.ArrayList;
import java.util.Collections;

public class FourthRatings {

    public FourthRatings() {
        this("ratings.csv");
    }

    public FourthRatings(String fileName){
        RaterDatabase.initialize(fileName);
    }

    public double getAverageByID(String movieId, int minimalRaters) {
        int counter = 0;
        int ratingsSum = 0;
        for (Rater currRater :RaterDatabase.getRaters()) {
            ArrayList<String> ratedMovies = currRater.getItemsRated();
            for (String currMovie : ratedMovies) {
                if (currMovie.equals(movieId)) {
                    ratingsSum += currRater.getRating(currMovie);
                    counter++;
                }
            }
        }
        if (counter >= minimalRaters) {
            return (double) ratingsSum / counter;
        }
        return 0.00;
    }

    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        ArrayList<Rating> avgForMovies = new ArrayList<>();
        for (String id : movies) {
            double averageRating = getAverageByID(id, minimalRaters);
            if (averageRating != 0.0) {
                avgForMovies.add(new Rating(id, averageRating));
            }
        }
        return avgForMovies;
    }

    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria) {
        ArrayList<Rating> avgForFilteredMovies = new ArrayList<>();
        ArrayList<String> moviesIds = MovieDatabase.filterBy(filterCriteria);
        for (String id : moviesIds) {
            double averageRating = getAverageByID(id, minimalRaters);
            if (averageRating != 0.0) {
                avgForFilteredMovies.add(new Rating(id, averageRating));
            }
        }
        return avgForFilteredMovies;
    }

    private double dotProduct(Rater me, Rater rater) {
        double sum = 0;
        for (String itemMe : me.getItemsRated()) {
            for (String itemR : rater.getItemsRated()) {
                double ratingMe = me.getRating(itemMe);
                double ratingR = rater.getRating(itemR);
                if (itemMe.equals(itemR) && ratingR != 0 && ratingMe != 0) {
                    sum += (ratingMe - 5) * (ratingR - 5);
                }
            }
        }
        return sum;
    }

    private ArrayList<Rating> getSimilarities(String id) {
        ArrayList<Rating> list = new ArrayList<>();
        Rater me = RaterDatabase.getRater(id);
        for (Rater r : RaterDatabase.getRaters()) {
            if (!r.getID().equals(id)) {
                list.add(new Rating(r.getID(), dotProduct(me, r)));
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters) {

        ArrayList<Rating> similarRaters = getSimilarities(id);
        ArrayList<Rating> moviesToRecommend = new ArrayList<>();

        //for (int i = 0; i < numSimilarRaters; i++) {

        //}

        return moviesToRecommend;
    }
}
