public class Robot implements Runnable {
    private final Cabinet cabinet;
    private final Generator.Subjects subject;

    Robot(Cabinet cabinet, Generator.Subjects subject) {
        this.cabinet = cabinet;
        this.subject = subject;
    }

    @Override
    public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (!cabinet.getQueue().isEmpty()) {
                takeStudent();
            }
    }

    void takeStudent() {
        cabinet.getLock().lock();
        try {
            if (this.subject == cabinet.getQueue().peek().getSubjectName()) {
                Student student = cabinet.getQueue().take();
                System.out.println("Робот " + this.subject + " взял на проверку студента");

                cabinet.getRobotOccupied().signalAll();
                cabinet.getLock().unlock();

                while (student.getLabsCount() != 0) {
                    Thread.sleep(1000);
                    student.setLabsCount(student.getLabsCount() - 10);
                    System.out.println("--- Робот " + this.subject + " проверил 10 работ, осталось: " + student.getLabsCount());
                }
            } else {
                System.out.println("Робот " + this.subject + " ждёт мучеников");
                cabinet.getRobotOccupied().await();
                cabinet.getLock().unlock();
                System.out.println("GM");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }
}
