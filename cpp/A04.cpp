#include <iostream>

using namespace std;

int main() {

    const int price[] = {50, 20, 10};
    int quota[] = {100, 100, 500};
    int length = sizeof(price) / sizeof(price[0]);

    int input;
    while (true) {
        cin >> input;
        if (!cin) break;

        int amount;

        switch (input) {
            // pre process
            case 50: cout << "0\n2\n1\n"; break;
            case 20: cout << "0\n0\n2\n"; break;
            default:
            for (int i = 0; i < length; ++i) {
                amount = min(input / price[i], quota[i]);
                input -= amount*price[i];

                cout << amount << endl;
            }
        }

    }

    return 0;
}
