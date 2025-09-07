package Week6;
public class MisereNim {
    public static boolean firstPlayerWins(int[] heaps) {
        int countOnes = 0;
        boolean allOnes = true;
        for (int h : heaps) {
            if (h != 1) allOnes = false;
            if (h == 1) countOnes++;
        }
        if (allOnes) {
            // First player wins iff number of heaps is even
            return countOnes % 2 == 0;
        } else {
            int nimSum = 0;
            for (int h : heaps) nimSum ^= h;
            return nimSum != 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(firstPlayerWins(new int[]{3, 4, 5})); // True
        System.out.println(firstPlayerWins(new int[]{1, 1, 1})); // False
        System.out.println(firstPlayerWins(new int[]{1, 1, 2})); // True
    }
}

