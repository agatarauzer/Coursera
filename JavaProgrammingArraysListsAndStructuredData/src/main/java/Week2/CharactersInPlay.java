package Week2;

import Week1.predefinedClasses.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> counts;

    public CharactersInPlay() {
        names = new ArrayList<>();
        counts = new ArrayList<>();
    }

    public void update(String person) {
        if (!names.contains(person)) {
            names.add(person);
            counts.add(1);
        }
        else {
            int index = names.indexOf(person);
            int value = counts.get(index);
            counts.set(index, value + 1);
        }
    }

    public void findAllCharacters() {
        names.clear();
        counts.clear();
        FileResource fr = new FileResource();
        for (String line : fr.lines()) {
            if (line.contains(".")) {
                String name = line.substring(0, line.indexOf("."));
                update(name);
            }
        }
    }

    public void charactersWithNumParts(int num1, int num2) {
        System.out.println("Couts between: ");
        for (int i = 0; i < names.size(); i++) {
            if (counts.get(i) >= num1 && counts.get(i) <= num2) {
                System.out.println(names.get(i) + " " + counts.get(i));
            }
        }
    }
}
