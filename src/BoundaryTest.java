import junit.framework.TestCase;

public class BoundaryTest extends TestCase {
    public void test1() {
        Student stu = new Student(0, 7);
        assertEquals(0, stu.validate());
    }
    public void test2() {
        Student stu = new Student(0.1, 7);
        assertEquals(0, stu.validate());
    }
    public void test3() {
        Student stu = new Student(9.9, 7);
        assertEquals(0, stu.validate());
    }
    public void test4() {
        Student stu = new Student(10, 7);
        assertEquals(0, stu.validate());
    }
    public void test5() {
        Student stu = new Student(5, 7);
        assertEquals(0, stu.validate());
    }
    public void test6() {
        Student stu = new Student(5, 0);
        assertEquals(1, stu.validate());
    }
    public void test7() {
        Student stu = new Student(5, 1);
        assertEquals(1, stu.validate());
    }
    public void test8() {
        Student stu = new Student(5, 14);
        assertEquals(0, stu.validate());
    }
    public void test9() {
        Student stu = new Student(5, 15);
        assertEquals(0, stu.validate());
    }
    public void test10() {
        Student stu = new Student(-0.1, 7);
        assertEquals(-1, stu.validate());
    }
    public void test11() {
        Student stu = new Student(10.1, 7);
        assertEquals(-1, stu.validate());
    }
    public void test12() {
        Student stu = new Student(5, -1);
        assertEquals(-1, stu.validate());
    }
    public void test13() {
        Student stu = new Student(5, 16);
        assertEquals(-1, stu.validate());
    }
}
