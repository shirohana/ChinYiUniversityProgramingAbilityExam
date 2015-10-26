#include <iostream>

using namespace std;

int main() {
    const int LENGTH = 20;
    int arr[LENGTH];

    for (int i = 0; i < LENGTH; ++i) {
        cin >> arr[i];
    }

    int look;
    cin >> look;

    bool finded = false;
    for (int i = 0; i < LENGTH; ++i) {
        if (arr[i] == look) {
            finded = true;
            cout << i << endl;
        }
    }

    if (!finded) cout << "-1" << endl;

    return 0;
}
