# BLACKBOX TESTING

# Bài toán

Viết hàm kiểm tra điều kiện thi cuối kỳ của sinh viên. Sinh viên đủ điều kiện dự thi nếu điểm giữa kỳ lớn hơn hoặc bằng 4 và có số buổi vắng ít hơn 3.

- Đầu vào: Điểm thi giữa kỳ và số buổi học vắng
    - $0 ≤ midTermScore ≤ 10$
    - $0 ≤ absentLectures ≤ 15$
- Đầu ra:
    - -1 nếu Input không hợp lệ
    - 0 nếu không đủ điều kiện thi
    - 1 nếu đủ điều kiện thi

# Kỹ thuật kiểm thử giá trị biên

Xét mã nguồn:

```java
// version 1.0
public class Student {
    private double midTermScore;
    private int absentLectures;

    public Student(double midTermScore, int absentLectures) {
        this.midTermScore = midTermScore;
        this.absentLectures = absentLectures;
    }

    public int validate(){
        if (this.midTermScore <= 10 && this.midTermScore >=4
                && this.absentLectures <=3 && this.absentLectures >=0)
            return 1;
        return 0;
    }
}
```

## Kiểm thử giá trị biên

Ta xét các giá trị biên cho biến:

- Các giá trị biên của `midTermScore = 0, 0.1, 9.9, 10`
- Các giá trị biên của `absentLectures = 0, 1, 14, 15`
- Giá trị trung bình của `midTermScore = 5`
- Giá trị trung bình của `absentLectures = 7`

Bảng test case:

| ID | Điểm giữa kỳ | Số buổi vắng | Expected Output | System Output | Test Result |
| --- | --- | --- | --- | --- | --- |
| 1 | 0 | 7 | 0 | 0 | pass |
| 2 | 0.1 | 7 | 0 | 0 | pass |
| 3 | 9.9 | 7 | 0 | 0 | pass |
| 4 | 10 | 7 | 0 | 0 | pass |
| 5 | 5 | 7 | 0 | 0 | pass |
| 6 | 5 | 0 | 1 | 1 | pass |
| 7 | 5 | 1 | 1 | 1 | pass |
| 8 | 5 | 14 | 0 | 0 | pass |
| 9 | 5 | 15 | 0 | 0 | pass |

Chạy TestCase:

```java
import junit.framework.TestCase;

public class TestStudent extends TestCase {
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
}
```
Để ý là với bộ kiểm thử như trên, ta chưa thể kiểm thử được trường hợp input đầu vào không hợp lệ. Ta sẽ xét phương pháp kiểm thử tương đương mạnh xem vấn đề này có được khắc phục hay không.

## Kiểm thử giá trị biên mạnh

Ta xét thêm các giá trị biên mới cho biến:

- $min-$ và $max+$ của `midTermScore = -0.1, 10.1`
- $min-$ và $max+$ của `absentLectures = -1, 16`

Bảng test case mới:

| ID | Điểm giữa kỳ | Số buổi vắng | Expected Output | System Output | Test Result |
| --- | --- | --- | --- | --- | --- |
| 1 | 0 | 7 | 0 | 0 | pass |
| 2 | 0.1 | 7 | 0 | 0 | pass |
| 3 | 9.9 | 7 | 0 | 0 | pass |
| 4 | 10 | 7 | 0 | 0 | pass |
| 5 | 5 | 7 | 0 | 0 | pass |
| 6 | 5 | 0 | 1 | 1 | pass |
| 7 | 5 | 1 | 1 | 1 | pass |
| 8 | 5 | 14 | 0 | 0 | pass |
| 9 | 5 | 15 | 0 | 0 | pass |
| 10 | -0.1 | 7 | -1 | 0 | fail |
| 11 | 10.1 | 7 | -1 | 0 | fail |
| 12 | 5 | -1 | -1 | 0  | fail |
| 13 | 5 | 16 | -1 | 0 | fail |

Chạy TestCase:

```java
import junit.framework.TestCase;

public class TestStudent extends TestCase {
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
```

Ta thấy các test từ 10 đến 13 bị fail. Nguyên nhân là do hàm này chưa xét trường hợp Input không hợp lệ. Ta cần sửa mã nguồn để khắc phục lỗi này.

```java
// version 1.1
public class Student {
    private double midTermScore;
    private int absentLectures;

    public Student(double midTermScore, int absentLectures) {
        this.midTermScore = midTermScore;
        this.absentLectures = absentLectures;
    }
    public int validate(){
        if (this.midTermScore < 0 || this.midTermScore > 10
                || this.absentLectures <0 || this.absentLectures > 15)
            return -1;
        if (this.midTermScore <= 10 && this.midTermScore >=4
                && this.absentLectures <=2 && this.absentLectures >=0)
            return 1;
        return 0;
    }
}
```

Hàm mới đã pass tất cả các test

Kỹ thuật kiểm thử giá trị biên mạnh đã giúp ta chỉ ra những lỗi nằm ngoài miền xác định của biến, kiểm thử phân hoạch tương đương cũng có thể giải quyết vấn đề này.

# Kỹ thuật kiểm thử phân hoạch tương đương

## Kiểm thử phân hoạch tương đương

Xét mã nguồn:

```java
// Ma nguon version 2.0
public class Student {
    private double midTermScore;
    private int absentLectures;

    public Student(double midTermScore, int absentLectures) {
        this.midTermScore = midTermScore;
        this.absentLectures = absentLectures;
    }
    public int validate(){
        if (this.midTermScore < 0 || this.midTermScore > 10
                || this.absentLectures <0 || this.absentLectures > 15)
            return -1;
        if (this.midTermScore < 10 && this.midTermScore >=4
                && this.absentLectures <2 && this.absentLectures >=0)
            return 1;
        return 0;
    }
}
```

Ta phân 2 biến thành các lớp:

- $midTermScore = \{v \notin [0, 10]\} ~ \cup ~ \{v \in [0, 4)\} ~ \cup \{v \in [4, 10]\}$
- $absentLectures = \{v \notin [0, 15]\} ~ \cup ~ \{v \in [0, 2]\} ~ \cup \{v \in [3, 15]\}$

| ID | Điểm giữa kỳ | Số buổi vắng | Expected Output | System Output | Test Result |
| --- | --- | --- | --- | --- | --- |
| 1 | 13 | -2 | -1 | -1 | pass |
| 2 | 3 | 1 | 0 | 0 | pass |
| 3 | 8 | 7 | 0 | 0 | pass |


## Kiểm thử phân hoạch tương đương mạnh

Với kỹ thuật kiểm thử phân hoạch tương đương, ta chưa sinh được testcase cho trường hợp đủ điều kiện thi. Ta sẽ xét tổ hợp các giá trị để khắc phục vấn đề này. Kỹ thuật này chính là kiểm thử lớp tương đương mạnh.

| ID | Điểm giữa kỳ | Số buổi vắng | Expected Output | System Output | Test Result |
| --- | --- | --- | --- | --- | --- |
| 1 | 13 | -2 | -1 | -1 | pass |
| 2 | 3 | 1 | 0 | 0 | pass |
| 3 | 8 | 7 | 0 | 0 | pass |
| 4 | 13 | 1 | -1 | -1 | pass |
| 5 | 13 | 7 | -1 | -1 | pass |
| 6 | 3 | -2 | -1 | -1 | pass |
| 7 | 3 | 7 | 0 | 0 | pass |
| 8 | 8 | -2 | -1 | -1 | pass |
| 9 | 8 | 1 | 1 | 1 | pass |

Như vậy, ta đã test mã nguồn với bộ kiểm thử tương đương mạnh và đều qua tất cả các testcase. Tuy nhiên, nhìn kỹ lại mã nguồn `ver2.0` đã bị sửa so với `ver1.1`  ở phần điều kiện `<10` và `<2` nhưng phương pháp kiểm thử phân hoạch tương đương mạnh lại không phát hiện ra lỗi này. Để tìm ra những lỗi như thế này, ta cần sử dụng kiểm thử giá trị biên.

# Kết luận

Sau khi kiểm thử mã nguồn bằng cả 2 kỹ thuật kiểm thử, ta có thể thấy mỗi kỹ thuật đều có ưu, nhược điểm riêng. Kiểm thử giá trị biên tập trung kiểm thử các giá trị ở biên của miền xác định của các biến, trong khi kiểm thử phân hoạch tương đương lại kiểm tra các giá trị theo từng miền của các biến. Hai kỹ thuật này bù trừ và hỗ trợ lẫn nhau, khi kiểm thử ta nên kết hợp chúng để xây dựng bộ ca kiểm thử tốt.

Tuy nhiên, kỹ thuật kiểm thử phân hoạch tương đương và kiểm thử giá trị biên chỉ thích hợp cho các hàm có các biến đầu vào không có quan hệ ràng buộc với nhau. Với các hàm có các hành vi khác nhau dựa trên tính chất của bộ giá trị của đầu vào, ta cần áp dụng kỹ thuật kiểm thử bảng quyết định.
