#include <iostream>
#include <string>

using namespace std;

int main() {
    string input;
    cin >> input;

    int times = 1;
    while (true) {
        int total = 0;
        for (string::iterator it = input.begin(); it != input.end(); ++it) {
            total += *it - '0';
        }

        if (total <= 9) {
            if (total == 9)
                cout << times << endl;
            else
                cout << "0" << endl;
            break;
        }

        input = to_string(total);
        ++times;
    }

    return 0;
}
