#include <iostream>
#include <cmath>

using namespace std;

long goldenNumber(const int&);
const double GOLDEN_NUMBER = (1 + sqrt(5)) / 2;

int main() {

    int input;
    while (true) {
        cin >> input;
        if (!cin) break;

        if (input <= 0 || 50 <= input) {
            cout << "輸入錯誤" << endl;
            continue;
        }

        cout << goldenNumber(input) << endl;
    }

    return 0;
}

long goldenNumber(const int &n) {

    double result = 1;

    if (n > 2) {
        for (int i = 2; i < n; ++i) {
            result = round(result * GOLDEN_NUMBER);
        }
    }

    return (long) result;
}
