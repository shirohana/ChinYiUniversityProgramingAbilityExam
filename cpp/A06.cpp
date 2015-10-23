#include <iostream>

using namespace std;

int main() {
    int times;
    cin >> times;

    int a, b;
    while (times--) {
        cin >> a >> b;
        if (!cin) break;
        if (b <= a) {
            cout << "輸入錯誤" << endl;
            continue;
        }

        // if (a <= 0) cout << "牛頓要哭哭囉" << endl;

        int quality = 0;
        for (; a <= b; ++a) {
            quality += a*a;
        }

        cout << quality << endl;
    }

    return 0;
}