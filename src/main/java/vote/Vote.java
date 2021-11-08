package vote;

import java.util.ArrayList;

public class Vote {
    private final String title;
    private final ArrayList<String> choices;

    public Vote(String title, ArrayList<String> choices){
        this.title = title;
        this.choices = choices;
    };

    public String getTitle(){
        return title;
    }

    public String getResult(){
        StringBuilder result = new StringBuilder();
        for(String choice:choices){
            result.append(choice).append("\n");
        }
        return result.toString();
    }
}
