import java.util.ArrayList;

public class ThirdRatings {
    private ArrayList<EfficientRater> myRaters;

    public ThirdRatings() {
        // default constructor
        this("ratings_short.csv");
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
}