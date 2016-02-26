import java.util.Scanner;

class B04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (y > x) {
                System.out.println("0");
                continue;
            }

            int[][] matrix = new int[y+1][x+1];
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = i; j < matrix[0].length; ++j) {
                    if (i == 0) {
                        matrix[i][j] = 1;
                        continue;
                    }

                    matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j];
                    if (j != i) {
                        matrix[i][j] += matrix[i][j-1];
                    }
                }
            }

            System.out.println(String.valueOf(matrix[y][x]));
        }
    }
}