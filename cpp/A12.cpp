#include <iostream>

using namespace std;

int main() {
    int amount;
    cin >> amount;

    int arr[amount];
    int total = 0;
    for (int i = 0; i < amount; ++i) {
        cin >> arr[i];
        total += arr[i];
    }

    total = total*1.0/amount + 0.5;
    int diff = 0;
    for (int i = 0; i < amount; ++i) {
        int temp = total - arr[i];
        diff += temp < 0 ? -temp : temp;
    }

    cout << diff << endl;

    return 0;
}
