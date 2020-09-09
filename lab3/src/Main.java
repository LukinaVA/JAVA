public class Main {
    public static void main(String[] args) {
        Cabinet cabinet = new Cabinet();

        Generator generator = new Generator(cabinet);
        Robot mathRobot = new Robot(cabinet, Generator.Subjects.MATH);
        Robot oopRobot = new Robot(cabinet, Generator.Subjects.OOP);
        Robot physicsRobot = new Robot(cabinet, Generator.Subjects.PHYSICS);

        new Thread(generator).start();
        new Thread(mathRobot).start();
        new Thread(oopRobot).start();
        new Thread(physicsRobot).start();
    }
}
