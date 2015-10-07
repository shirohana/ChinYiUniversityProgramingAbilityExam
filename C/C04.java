class C04 {

    private static final int SIZE = 8;

    public static void main(String[] args) {
        int[] array = new int[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            array[i] = i + 1;
        }
        printFullSequence(array, 0, array.length);
    }

    private static void printFullSequence(int[] array, int current, int length) {
        if (current + 1 < length) {
            printFullSequence(array, current + 1, length);

            int temp;
            for (int i = current + 1; i < length; ++i) {
                    temp = array[current];
                    array[current] = array[i];
                    array[i] = temp;
                printFullSequence(array, current + 1, length);
                    temp = array[current];
                    array[current] = array[i];
                    array[i] = temp;
            }
        } else {
            printQueen(array);
            System.out.println();
        }
    }

    private static void printQueen(int[] array) {
        int length = array.length;
        for (int i : array) {
            // print dot
            for (int j = i; j > 1; --j) {
                System.out.print(".");
            }
            System.out.print("Q");
            // print dot
            for (int j = i; j < length; ++j) {
                System.out.print(".");
            }
            System.out.println();
        }
    }
}