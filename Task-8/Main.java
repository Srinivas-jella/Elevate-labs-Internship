import java.util.List;
public class Main {
    public static void main(String[] args) {
       
        QuizQuestion[] questions = new QuizQuestion[]{
            new QuizQuestion("What is the capital of France?", 
                List.of("Berlin", "Madrid", "Paris", "Rome"), 2),
            new QuizQuestion("What is 2 + 2?", 
                List.of("3", "4", "5", "6"), 1),
            new QuizQuestion("What is the largest planet in our solar system?", 
                List.of("Earth", "Mars", "Jupiter", "Saturn"), 2)
        };

        int score = 0;

        
        for (QuizQuestion question : questions) {
            System.out.println(question.getQuestion());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            
            int userAnswer = getUserAnswer(); 
            if (question.isCorrectAnswer(userAnswer - 1)) {
                score++;
            }
        }

        
        QuizResult result = new QuizResult(score, questions.length);
        System.out.println("Your score: " + result.getScore() + "/" + result.getTotalQuestions());
        System.out.println("Percentage: " + result.calculatePercentage() + "%");
        System.out.println(result.getResultMessage());
    }

    private static int getUserAnswer() {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    int answer = -1;
    while (true) {
        System.out.print("Enter your answer (1-4): ");
        if (scanner.hasNextInt()) {
            answer = scanner.nextInt();
            if (answer >= 1 && answer <= 4) {
                break;
            } else {
                System.out.println("Please enter a number between 1 and 4.");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); 
        }
        scanner.close();
    }
    return answer;
    
}

}