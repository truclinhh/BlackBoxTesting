public class Student {
    private double midTermScore;
    private int absentLectures;

    public Student(double midTermScore, int absentLectures) {
        this.midTermScore = midTermScore;
        this.absentLectures = absentLectures;
    }

    public int validate(){
        if (this.midTermScore <= 10 && this.midTermScore >=4
                && this.absentLectures <=2 && this.absentLectures >=0)
            return 1;
        return 0;
    }
}