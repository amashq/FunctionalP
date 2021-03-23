import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        int size = 10;

        // число = сумма индекса и модификатора
        int[] result1 = getFilledArray(size, input, Integer::sum);
        System.out.println(Arrays.toString(result1));

        // число = произведение индекса и модификатора
        int[] result2 = getFilledArray(size, input, (i, m) -> i * m);
        System.out.println(Arrays.toString(result2));

        //  число = для чётного индекса <(разделить на 2) плюс модификатор>,
        //  для нечётного <(квадрат индекса) минус модификатор>
        int[] result3 = getFilledArray(size, input, (i, m) -> {
            if (i % 2 == 0) {
                return i / 2 + m;
            } else {
                return i * i - m;
            }
        });
        System.out.println(Arrays.toString(result3));

        // число = сумма модификатора в степени индекса и индекса
        int[] result4 = getFilledArray(size, input, (i, m) -> (int) (Math.pow(m, i) + i));
        System.out.println(Arrays.toString(result4));

        //  число = для индекса, кратного пяти, <(умножить на пять) плюс модификатор>,
        //  для остальных <сумма индекса и модификатора>
        int[] result5 = getFilledArray(size, input, (i, m) -> {
            if (i % 5 == 0) {
                return i * 5 + m;
            } else {
                return i + m;
            }
        });
        System.out.println(Arrays.toString(result5));
        sc.close();
    }

    static int[] getFilledArray(final int size, final int modifier, final ProcessInterface p) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = p.process(i, modifier);
        }
        return res;
    }
}
