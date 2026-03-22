

public class Main {

    public static void main(String[] args) {

//        Box box1 = new BoxWithMaxWeight(5);
//        box1.add(new Item("a", 1));
//        box1.add(new Item("b", 2));
//        box1.add(new Item("c", 2));
//        box1.add(new Item("d", 1));
//        box1.add(new Item("f", 0));
//
//        System.out.println(box1.isInBox(new Item("b")));

        Box box = new OneItemBox();
        box.add(new Item("a", 1));
        box.add(new Item("b", 2));
        box.add(new Item("c", 2));
        box.isInBox(new Item("b"));

        System.out.println(box.isInBox(new Item("b")));


    }
}

