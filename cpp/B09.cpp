#include <iostream>

using namespace std;

const int SIZE = 17;

int main() {

    int input;
    cin >> input;

    int temp, carry = 0;
    int buffer[SIZE] = {};

    buffer[0] = 1;

    for (int i = 2; i <= input; ++i) {
        for (int j = 0; j < SIZE; ++j) {
            temp = buffer[j] * i + carry;

            buffer[j] = temp % 10000;
            carry = temp / 10000;
        }
    }

    bool started = false;

    for (int i = SIZE - 1; i > -1; --i) {

        if (!started && buffer[i] == 0) continue;

        if (started) {
            printf("%04d", buffer[i]);
        } else {
            printf("%d", buffer[i]);
        }
        started = true;
    }

    cout << endl;

    return 0;
}
