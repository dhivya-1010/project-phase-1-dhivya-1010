import java.io.IOException;
import java.util.*;
public class IdeaApp {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        IdeaService service = new IdeaService();
        int choice = 0;
        do {
            System.out.println("\n PROJECT NOTION");
            System.out.println("1. Add New Idea");
            System.out.println("2. View All Ideas");
            System.out.println("3. Search Idea");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());
            switch (choice) {
                case 1:
                    int id = service.getNextId();
                    System.out.print("Enter Idea Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Problem: ");
                    String problem = sc.nextLine();
                    System.out.print("Enter Solution: ");
                    String solution = sc.nextLine();
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter Target Users: ");
                    String targetUsers = sc.nextLine();
                    Idea idea = new Idea(id, title, problem, solution, category, targetUsers);
                    service.addIdea(idea);
                    System.out.println("Idea added successfully!");
                    break;
                case 2:
                    List<Idea> allIdeas = service.getAllIdeas();
                    if (allIdeas.isEmpty()) {
                        System.out.println("No ideas found.");
                    } else {
                        for (Idea i : allIdeas) {
                            i.display();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine();
                    List<Idea> searchResult = service.searchIdeas(keyword);
                    if (searchResult.isEmpty()) {
                        System.out.println("No matching ideas found.");
                    } else {
                        for (Idea i : searchResult) {
                            i.display();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting. Stay innovative!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }
}
