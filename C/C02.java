import java.util.Scanner;

class C02 {

    private static final int MATRIX_SIZE = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            int[][] input = new int[MATRIX_SIZE][MATRIX_SIZE];
            for (int i = 0; i < input.length; ++i) {
                for (int j = 0; j < input[0].length; ++j) {
                    input[i][j] = scanner.nextInt();
                }
            }

            // fill light
            for (int i = 0; i < input.length; ++i) {
                for (int j = 0; j < input[0].length; ++j) {
                    if (input[i][j] != 2) continue;

                    // from East to North
                    boolean[] pathEnded = new boolean[4];
                    int distance = 0;
                    while (++distance <= MATRIX_SIZE) {
                        int k;
                        if (!pathEnded[0]) {
                            k = j + distance;
                            if (k == MATRIX_SIZE) {
                                pathEnded[0] = true;
                            } else {
                                if (input[i][k] == 1 || input[i][k] == 2) {
                                    pathEnded[0] = true;
                                } else {
                                    input[i][k] = 3;
                                }
                            }
                        }

                        if (!pathEnded[1]) {
                            k = i + distance;
                            if (k == MATRIX_SIZE) {
                                pathEnded[1] = true;
                            } else {
                                if (input[k][j] == 1 || input[k][j] == 2) {
                                    pathEnded[1] = true;
                                } else {
                                    input[k][j] = 3;
                                }
                            }
                        }

                        if (!pathEnded[2]) {
                            k = j - distance;
                            if (k == -1) {
                                pathEnded[2] = true;
                            } else {
                                if (input[i][k] == 1 || input[i][k] == 2) {
                                    pathEnded[2] = true;
                                } else {
                                    input[i][k] = 3;
                                }
                            }
                        }

                        if (!pathEnded[3]) {
                            k = i - distance;
                            if (k == -1) {
                                pathEnded[3] = true;
                            } else {
                                if (input[k][j] == 1 || input[k][j] == 2) {
                                    pathEnded[3] = true;
                                } else {
                                    input[k][j] = 3;
                                }
                            }
                        }
                    }
                }
            }

            int totalDark = 0;
            for (int i = 0; i < MATRIX_SIZE; ++i) {
                for (int j = 0; j < MATRIX_SIZE; ++j) {
                    if (input[i][j] == 0) ++totalDark;
                }
            }

            System.out.println(totalDark);
        }
    }
}