import java.util.ArrayList;
import java.util.Collections;


public class RecommendationRunner implements Recommender {

    public ArrayList<String> getItemsToRate(){
        GenreFilter genreFilter = new GenreFilter("Drama");
        YearAfterFilter yearAfterFilter = new YearAfterFilter(2000);
        AllFilters allFilters = new AllFilters();
        allFilters.addFilter(genreFilter);
        allFilters.addFilter(yearAfterFilter);

        int numberOfMovies = 20;
        ArrayList<String> movies = new ArrayList<>();
        for (String movie : MovieDatabase.filterBy(allFilters)) {
           if (numberOfMovies > 0) {
                movies.add(movie);
                numberOfMovies--;
            }
           else {
               break;
           }
        }
        Collections.sort(movies);
        return movies;
    }

    public void printRecommendationsFor(String webRaterID) {
        MovieDatabase.initialize("ratedmoviesfull.csv");
        FourthRatings fourthRatings = new FourthRatings();
        String resultHtml = "";
        GenreFilter genreFilter = new GenreFilter("Crime");
        YearAfterFilter yearAfterFilter = new YearAfterFilter(2000);
        AllFilters allFilters = new AllFilters();
        allFilters.addFilter(genreFilter);
        allFilters.addFilter(yearAfterFilter);

        ArrayList<Rating> recommendedMovies = fourthRatings.getSimilarRatingsByFilter(webRaterID, 10, 3, allFilters);

        if (recommendedMovies.isEmpty()) {
            resultHtml = "No movies to show";
        }
        else {
            resultHtml += " <style>\n" +
                    "    table{\n" +
                    "        border:1px solid #000; width:100%;\n" +
                    "    }\n" +
                    "    td{\n" +
                    "        border:1px solid #000; width:100%;\n" +
                    "    }\n" +
                    "    </style>" +
                    "<h2>Recommended crime movies: <h2>\n" +
                    "<table>\n" +
                    "<tr>\n" +
                    "    <th style=\"background-color:#9fd3d4\">Title</th>\n" +
                    "    <th style=\"background-color:#9fd3d4\">Year</th>\n" +
                    "    <th style=\"background-color:#9fd3d4\">Average rating</th>\n" +
                    "</tr>\n";

            int counter = 0;
            for (Rating rating : recommendedMovies) {
                String movieId = rating.getItem();

                if (!getItemsToRate().contains(movieId)) {
                    String title = MovieDatabase.getTitle(movieId);
                    int year = MovieDatabase.getYear(movieId);
                    double average = Math.round(rating.getValue());

                    resultHtml += "<tr>\n" +
                            "    <td>" + title + "</td>\n" +
                            "    <td>" + year + "</td>\n" +
                            "    <td>" + average + "</td>\n" +
                            "  </tr>";
                }
                if (++counter > 15) {
                    break;
                }
            }
        }

        resultHtml += "</table>";
        System.out.println(resultHtml);
    }
}
