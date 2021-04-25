import java.util.Arrays;
import java.util.List;

public class DirectorsFilter implements Filter {

    private List<String> directors;

    public DirectorsFilter(String directors) {

        this.directors = Arrays.asList(directors.split(","));

    }

    @Override
    public boolean satisfies(String id) {

        for (String d : directors) {
            if (MovieDatabase.getDirector(id).contains(d)) {
                return true;
            }
        }
        return false;
    }
}
