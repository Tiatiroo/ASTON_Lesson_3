
import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        TestList<Integer> list = new TestList<>(testList);
        System.out.println(list.toString());
        list.add(3);
        list.add(5);
        list.add(7);
        System.out.println(list.toString());
        list.remove((Integer) 3);
        System.out.println(list.toString());
        list.remove(0);
        System.out.println(list.toString());
        System.out.println(list.getSize());
        System.out.println(list.get(0));
    }
}