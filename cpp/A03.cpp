#include <iostream>

using namespace std;

int main() {

    int input;
    while (true) {
        cin >> input;
        if (!cin) break;

        cout << input << "=";

        int i = 2;
        int times = 0;
        bool cap = false;
        while (true) {
            if (input % i == 0) {
                input /= i;
                ++times;

            } else if (times > 0) {
                if (cap) cout << "*";
                cout << i;
                if (times > 1) cout << "^" << times;

                cap = true;
                times = 0;

            } else if (input == 1) {
                break;

            } else {
                i += (i & 1) ? 2 : 1;
            }
        }

        cout << endl;
    }

    return 0;
}
