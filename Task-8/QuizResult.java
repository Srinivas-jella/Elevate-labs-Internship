public class QuizResult {
    private int score;
    private int totalQuestions;

    public QuizResult(int score, int totalQuestions) {
        this.score = score;
        this.totalQuestions = totalQuestions;
    }

    public double calculatePercentage() {
        return ((double) score / totalQuestions) * 100;
    }

    public String getResultMessage() {
        double percentage = calculatePercentage();
        if (percentage >= 90) {
            return "Excellent!";
        } else if (percentage >= 75) {
            return "Good job!";
        } else if (percentage >= 50) {
            return "You passed!";
        } else {
            return "Better luck next time!";
        }
    }
    public int getScore() {
        return score;
    }
    public int getTotalQuestions() {
        return totalQuestions;
    }
    @Override
    public String toString() {
        return "QuizResult{" +
                "score=" + score +
                ", totalQuestions=" + totalQuestions +
                ", percentage=" + calculatePercentage() +
                ", resultMessage='" + getResultMessage() + '\'' +
                '}';
    }
}