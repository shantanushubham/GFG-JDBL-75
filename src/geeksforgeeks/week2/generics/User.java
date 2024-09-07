package geeksforgeeks.week2.generics;

public class User {
}


class Student extends Teacher {

}

class Teacher extends User {

}

class GenClass<T extends User> extends User {

}

class Test {
    public static void main(String[] args) {
        GenClass<GenClass<Student>> s = new GenClass<> ();
    }
}