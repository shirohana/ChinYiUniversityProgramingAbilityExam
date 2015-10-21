#include <iostream>

using namespace std;

const int DAYS_OF_MONTH[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

inline bool isLeapYear(int);

int main() {

    int year, month, date;
    int totalDays;
    while (true) {
        cin >> year >> month >> date;
        if (!cin) break;

        totalDays = date;

        for (int i = 0; i < month - 1; ++i) {
            totalDays += DAYS_OF_MONTH[i];
        }

        if (month >= 3 && isLeapYear(year)) {
            totalDays += 1;
        }

        cout << totalDays << endl;
    }

    return 0;
}

inline bool isLeapYear(int year) {
    return (year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0));
}
