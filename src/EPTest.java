import junit.framework.TestCase;

public class EPTest extends TestCase {
    public void test1() {
        Student stu = new Student(13,-2);
        assertEquals(-1, stu.validate());
    }
    public void test2() {
        Student stu = new Student(3, 1);
        assertEquals(0, stu.validate());
    }
    public void test3() {
        Student stu = new Student(8, 7);
        assertEquals(0, stu.validate());
    }
    public void test4() {
        Student stu = new Student(13,1);
        assertEquals(-1, stu.validate());
    }
    public void test5() {
        Student stu = new Student(13,7);
        assertEquals(-1, stu.validate());
    }
    public void test6() {
        Student stu = new Student(3, -2);
        assertEquals(-1, stu.validate());
    }
    public void test7() {
        Student stu = new Student(3, 7);
        assertEquals(0, stu.validate());
    }
    public void test8() {
        Student stu = new Student(8, -2);
        assertEquals(-1, stu.validate());
    }
    public void test9() {
        Student stu = new Student(8, 1);
        assertEquals(1, stu.validate());
    }
}
