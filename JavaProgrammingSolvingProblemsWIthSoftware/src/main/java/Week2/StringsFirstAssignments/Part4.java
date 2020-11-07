package Week2.StringsFirstAssignments;

import Week1.predefinedClasses.URLResource;

import java.util.ArrayList;
import java.util.List;


public class Part4 {

    public List<String> findYoutubeLinks() {
        List<String> links = new ArrayList<>();
        URLResource file = new  URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for (String item : file.words()) {
            String itemLower = item.toLowerCase();
            int pos = itemLower.indexOf("youtube.com");
            if (pos != -1) {
                int beg = item.lastIndexOf("\"",pos);
                int end = item.indexOf("\"", pos+1);
                String link = item.substring(beg+1,end);
                links.add(link);
            }
        }
        return links;
    }

    public void printLinks(List<String> links) {
        for (String link : links ) {
            System.out.println(link);
        }
    }

    public static void main(String[] args) {
        Part4 test = new Part4();
        test.printLinks(test.findYoutubeLinks());
    }
}
