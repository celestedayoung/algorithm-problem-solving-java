import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> remain = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt();
            remain.add(num % 42);
        }

        HashSet<Integer> result = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            result.add(remain.get(i));
        }

        System.out.println(result.size());

    }
}
