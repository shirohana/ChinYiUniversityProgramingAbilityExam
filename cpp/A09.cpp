#include <iostream>

using namespace std;

int main() {
    int pass;
    cin >> pass;
    cout << "1~1000" << endl;

    int min = 1, max = 1000, input;
    while (true) {
        cin >> input;
        if (!cin) break;
        if (input < min || max < input) continue;

        if (input == pass) {
            cout << "BINGO" << endl;
            break;
        }

        if (input < pass) {
            min = input + 1;
        } else {
            max = input - 1;
        }

        cout << min << "~" << max << endl;
    }

    return 0;
}
