import java.util.Random;

public class Generator implements Runnable {
    private final Cabinet cabinet;

    Generator(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    enum Subjects {
        MATH,
        OOP,
        PHYSICS
    }

    int[] Quantity = {10, 20, 100};

    @Override
    public void run() {
        for (int i = 0; i < 15; ++i) {
            //генерируем случайный предмет
            Subjects subject = Subjects.values()[(int)(Math.random() * Subjects.values().length)];

            //генерируем случайное число лаб
            int randomIndex  = new Random().nextInt(Quantity.length);
            int labsCount = Quantity[randomIndex];

            //создаём студента с данными параметрами
            Student student = new Student(subject, labsCount);

            //кладём в очередь
            try {
                cabinet.getQueue().put(student);
                System.out.println("+ Студент пришёл сдавать " + student.getLabsCount() + " лаб по " + student.getSubjectName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
