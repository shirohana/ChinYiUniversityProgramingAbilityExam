#include <iostream>
#include <string>
#include <cmath>

using namespace std;

bool isNarcissus(int);

int main() {
    // pre processor
    // cout << "1634" << endl
    //      << "8208" << endl
    //      << "9474" << endl;

    for (int i = 1000; i < 10000; ++i) {
        if (isNarcissus(i)) {
            cout << i << endl;
        }
    }

    return 0;
}

bool isNarcissus(int input) {
    string value = to_string(input);

    int temp;
    for (string::iterator it = value.begin(); it != value.end(); ++it) {
        input -= pow(*it - '0', 4);
        if (input < 0) {
            return false;
        }
    }

    return (input == 0);
}
