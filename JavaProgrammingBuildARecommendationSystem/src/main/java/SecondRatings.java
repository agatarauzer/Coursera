/**
 * Write a description of SecondRatings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<EfficientRater> myRaters;

    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }

    public SecondRatings(String moviefile, String ratingsfile) {
        FirstRatings firstRatings = new FirstRatings();
        myMovies = firstRatings.loadMovies(moviefile);
        myRaters = firstRatings.loadRaters(ratingsfile);
    }

    public int getMovieSize() {
        return myMovies.size();
    }

    public int getRaterSize() {
        return myRaters.size();
    }

    public double getAverageByID(String movieId, int minimalRaters) {
        int counter = 0;
        int ratingsSum = 0;
        for (Rater r : myRaters) {
            ArrayList<String> ratedMovies = r.getItemsRated();
            for (String m : ratedMovies) {
                if (m.equals(movieId)) {
                    ratingsSum += r.getRating(m);
                    counter++;
                }
            }
        }
        if (counter >= minimalRaters) {
            return (double)ratingsSum / counter;
        }
        return 0.00;
    }

    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<Rating> avgForMovies = new ArrayList<>();
        for (Movie movie : myMovies) {
            double averageRating = getAverageByID(movie.getID(), minimalRaters);
            if (averageRating != 0.00) {
                Rating ratingAvgForMovie = new Rating(movie.getID(), averageRating);
                avgForMovies.add(ratingAvgForMovie);
            }
        }
        return avgForMovies;
    }

    public String getTitle(String movieId) {
        for (Movie m : myMovies) {
            if (m.getID().equals(movieId)) {
                return m.getTitle();
            }
        }
        return "ID was not found";
    }

    public String getId(String title) {
        for (Movie m : myMovies) {
            if (m.getTitle().equals(title)) {
                return m.getID();
            }
        }
        return "No such title";
    }
}