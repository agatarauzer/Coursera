import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FourthRatings {

    public FourthRatings() {
        this("ratings.csv");
    }

    public FourthRatings(String fileName){
        RaterDatabase.initialize(fileName);
    }

    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters) {
        return getSimilarRatingsByFilter(id, numSimilarRaters, minimalRaters, null);
    }

    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalRaters, Filter filterCriteria) {
        ArrayList<Rating> similarRaters = getSimilarities(id);
        HashMap<String, Double> weightedRatingsForMovies = new HashMap<>();
        HashMap<String, Integer> counterRatingsForMovies = new HashMap<>();
        ArrayList<Rating> moviesToRecommend = new ArrayList<>();
        for (int i = 0; i < numSimilarRaters; i++) {
            String similarRaterId = similarRaters.get(i).getItem();
            double similarRaterDotProduct = similarRaters.get(i).getValue();
            Rater raterData = RaterDatabase.getRater(similarRaterId);
            ArrayList<String> moviesRated = raterData.getItemsRated();
            for (String movieId : moviesRated) {
                if (filterCriteria == null || filterCriteria.satisfies(movieId)) {
                    double weightedRating = raterData.getRating(movieId) * similarRaterDotProduct;
                    if (!weightedRatingsForMovies.containsKey(movieId)) {
                        weightedRatingsForMovies.put(movieId, weightedRating);
                        counterRatingsForMovies.put(movieId, 1);
                    }
                    else {
                        double actualWeightedRating = weightedRatingsForMovies.get(movieId) + weightedRating;
                        weightedRatingsForMovies.put(movieId, actualWeightedRating);
                        int actualCounter = counterRatingsForMovies.get(movieId) + 1;
                        counterRatingsForMovies.put(movieId, actualCounter);
                    }
                }
            }
        }
        for (String movieId : weightedRatingsForMovies.keySet()) {
            int counter = counterRatingsForMovies.get(movieId);
            if (counter >= minimalRaters) {
                double weightedAvg = weightedRatingsForMovies.get(movieId) / counter;
                moviesToRecommend.add(new Rating(movieId, weightedAvg));
            }
        }
        Collections.sort(moviesToRecommend, Collections.reverseOrder());
        return moviesToRecommend;
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
}