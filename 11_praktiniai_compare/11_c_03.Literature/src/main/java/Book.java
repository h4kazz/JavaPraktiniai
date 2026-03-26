public class Book implements Comparable<Book> {
    private String name;
    private int age;


    public Book(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (recommended for " + age + " year-olds or older)";
    }

    @Override
    public int compareTo(Book other) {
        if (this.age == other.age) {
            return this.name.compareTo(other.name);
        }

        return Integer.compare(this.age, other.age);
    }
}
