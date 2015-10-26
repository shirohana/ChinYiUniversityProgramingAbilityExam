#include <iostream>
#include <cmath>

using namespace std;

bool isPerfect(const int&);

int main() {
    // preprocessor of extreme
    // cout << "6\n28\n496\n8128" << endl;

    for (int i = 2; i <= 10000; ++i) {
        if (isPerfect(i)) {
            cout << i << endl;
        }
    }

    return 0;
}

bool isPerfect(const int &input) {
    int total = input - 1;
    int range = sqrt(input);
    for (int i = 2; i <= range; ++i) {
        if (input % i == 0) {
            total -= (i + (input / i));
        }
    }

    return (total == 0) ? 1 : 0;
}
