
class Student{
    private int studentId;
    private String studentName;
    private double studentMarks;

    public Student(int studentId,String studentName, double studentMarks){
        this.studentId=studentId;
        this.studentName=studentName;
        this.studentMarks=studentMarks;
    }

    public int getStudentId() {
        return studentId;
    }
    public double getStudentMarks() {
        return studentMarks;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public void setStudentMarks(double studentMarks) {
        this.studentMarks = studentMarks;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    @Override
public String toString() {
    return "Student [ID=" + studentId + ", Name=" + studentName + ", Marks=" + studentMarks + "]";
}
}