#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int amount;
    cin >> amount;

    int input[amount];
    for (int i = 0; i < amount; ++i) {
        cin >> input[i];
    }

    sort(input, input+amount);

    int index = amount*1.0/2-0.5;
    cout << input[index] << " " << !(amount & 1) + 1 << endl;

    return 0;
}
