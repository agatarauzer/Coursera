import java.util.ArrayList;

public class RecommendationRunner implements Recommender {

    public ArrayList<String> getItemsToRate(){
        GenreFilter genreFilter = new GenreFilter("Drama");
        YearAfterFilter yearAfterFilter = new YearAfterFilter(2015);
        AllFilters allFilters = new AllFilters();
        allFilters.addFilter(genreFilter);
        allFilters.addFilter(yearAfterFilter);

        int numberOfMovies = 25;
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
        return movies;
    }

    public void printRecommendationsFor(String webRaterID) {

        for (String s : getItemsToRate()) {

        }


    }
}
