#include <iostream>

using namespace std;

int main() {
    int x, y;
    cin >> x >> y;

    if (y > x) {
        cout << "0" << endl;
    } else {
        int matrix[2][x+1];
        for (int j = 0; j <= x; ++j) {
            matrix[0][j] = 1;
        }

        for (int i = 1; i <= y; ++i) {
            int flag = i & 1;
            for (int j = i; j <= x; ++j) {
                matrix[flag][j] = matrix[!flag][j] + matrix[!flag][j-1] + matrix[flag][j-1];
                matrix[!flag][j-1] = 0;
            }
        }

        cout << matrix[(y & 1)][x] << endl;
    }

    return 0;
}
