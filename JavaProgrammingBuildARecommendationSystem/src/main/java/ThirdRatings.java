import java.util.ArrayList;

public class ThirdRatings {
    private ArrayList<EfficientRater> myRaters;

    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }

    public ThirdRatings(String ratingsfile) {
        FirstRatings firstRatings = new FirstRatings();
        myRaters = firstRatings.loadRaters(ratingsfile);
    }

    public int getRaterSize() {
        return myRaters.size();
    }

    public double getAverageByID(String movieId, int minimalRaters) {
        int counter = 0;
        int ratingsSum = 0;
        for (EfficientRater r : myRaters) {
            ArrayList<String> ratedMovies = r.getItemsRated();
            for (String m : ratedMovies) {
                if (m.equals(movieId)) {
                    ratingsSum += r.getRating(m);
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
            avgForMovies.add(new Rating(id, averageRating));
        }
        return avgForMovies;
    }
}