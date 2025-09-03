public class Idea {
    private int id;
    private String title, problem, solution, category, targetUsers;
    public Idea(int id, String title, String problem, String solution, String category, String targetUsers) {
        this.id = id;
        this.title = title;
        this.problem = problem;
        this.solution = solution;
        this.category = category;
        this.targetUsers = targetUsers;
    }
    public String toFileString(){
        return id+"  "+title+"  "+problem+"   "+solution+"    "+category+"    "+targetUsers+ "\n";
    }
    public static Idea fromFileString(String line) {
        String[] parts = line.split("  ");
        if (parts.length < 6){
            throw new IllegalArgumentException("Malformed data: " + line);
        }
        return new Idea(
            Integer.parseInt(parts[0].trim()),
            parts[1].trim(),
            parts[2].trim(),
            parts[3].trim(),
            parts[4].trim(),
            parts[5].trim().replace("\n","")
        );
    }
    public void display(){
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Problem: " + problem);
        System.out.println("Solution: " + solution);
        System.out.println("Category: " + category);
        System.out.println("Target Users: " + targetUsers);
        System.out.println("-------------------------");
    }
    public int getId() {
        return id;
    }
}
