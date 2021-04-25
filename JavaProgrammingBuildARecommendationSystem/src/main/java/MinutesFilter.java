public class MinutesFilter implements Filter {

    private int minutesMax;
    private int minutesMin;

    public MinutesFilter(int minutesMin, int minutesMax) {
        this.minutesMax = minutesMax;
        this.minutesMin = minutesMin;
    }

    @Override
    public boolean satisfies(String id) {
        return MovieDatabase.getMinutes(id) >= minutesMin && MovieDatabase.getMinutes(id) <= minutesMax;
    }
}
