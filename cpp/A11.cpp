#include <iostream>

using namespace std;

int main() {
    char input[21];
    cin.getline(input, 21);
    char *ptr = input;

    char from, to;
    cin >> from >> to;

    do {
        if (*ptr == from) {
            cout << to;
        } else {
            cout << *ptr;
        }
    } while ((*ptr++) != '\0');

    cout << endl;

    return 0;
}
