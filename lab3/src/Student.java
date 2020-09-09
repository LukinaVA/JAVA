public class Student {
    private Generator.Subjects subjectName;
    private int labsCount;

    Student(Generator.Subjects subjectName, int labsCount) {
        this.subjectName = subjectName;
        this.labsCount = labsCount;
    }

    public int getLabsCount() {
        return labsCount;
    }

    public Generator.Subjects getSubjectName() {
        return subjectName;
    }

    public void setLabsCount(int labsCount) {
        this.labsCount = labsCount;
    }

    public void setSubjectName(Generator.Subjects subjectName) {
        this.subjectName = subjectName;
    }
}
