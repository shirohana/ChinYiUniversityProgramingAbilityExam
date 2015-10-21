#include <iostream>

using namespace std;

int gcd(int, int);
int gcd(int*, int*);

int main() {

    int m, n;
    while (true) {
        cin >> m >> n;
        if (!cin) break;

        int result = gcd(m, n);

        cout << result << " " << m*n/result << endl;

    }

    return 0;
}

int gcd(int m, int n) {
    return gcd(&m, &n);
}

int gcd(int *m, int *n) {
    if (*n == 0) return *m;

    *m = *m % *n;
    return gcd(n, m);
}
