import java.io.*;
import java.util.*;
public class IdeaService{
    private static final String FILE_NAME = "ideas.txt";
    public void addIdea(Idea idea) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
        bw.write(idea.toFileString());
        bw.newLine();
        bw.close();
    }
    public List<Idea> getAllIdeas() throws IOException{
        List<Idea> ideas = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while ((line = br.readLine()) != null){
            line = line.trim();
            if (!line.isEmpty()) {
                ideas.add(Idea.fromFileString(line));
            }
        }
        br.close();
        return ideas;
    }
    public int getNextId() throws IOException{
        List<Idea> ideas = getAllIdeas();
        int maxId = 0;
        for (Idea idea : ideas) {
            if (idea.getId() > maxId){
                maxId = idea.getId();
            }
        }
        return maxId+1;
    }
    public List<Idea> searchIdeas(String keyword) throws IOException{
        List<Idea> ideas = getAllIdeas();
        List<Idea> result = new ArrayList<>();
        keyword = keyword.toLowerCase();
        for(Idea i:ideas){
            if (i.toFileString().toLowerCase().contains(keyword)){
                result.add(i);
            }
        }
        return result;
    }
}
