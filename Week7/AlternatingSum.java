public class AlternatingSum {
    private final int sum;
    private final int operation; // +1 for add, -1 for subtract

    private AlternatingSum(int sum, int operation) {
        this.sum = sum;
        this.operation = operation;
    }

    // Start the chain with first number (added)
    public static AlternatingSum add_subtract(int num) {
        return new AlternatingSum(num, -1); // next operation will subtract
    }

    // Chain next number, applying alternating operation
    public AlternatingSum add_subtract(int num) {
        return new AlternatingSum(this.sum + this.operation * num, -this.operation);
    }

    // Extract final result
    public int value() {
        return this.sum;
    }

    @Override
    public String toString() {
        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        System.out.println(add_subtract(7));                  // 7
        System.out.println(add_subtract(1).add_subtract(2).add_subtract(3));     // 0
        System.out.println(add_subtract(-5).add_subtract(10).add_subtract(3).add_subtract(9)); // 11
    }
}
