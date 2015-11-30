#include <iostream>
#include <stack>

using namespace std;

const char SIGNS[] = {'+', '-', '*', '/'};

bool contains100(unsigned int);

int main() {

    unsigned int operators, limit, ops;

    for (operators = 0, limit = 1 << 18; operators < limit; ++operators) {
        if (contains100(operators)) {
            ops = operators;

            cout << '1';

            for (int i = 2; i <= 10; ++i, ops >>= 2) {
                cout << SIGNS[ops & 0b11] << i;
            }
            cout << "=100" << endl;
        }
    }

    return 0;
}

bool contains100(unsigned int ops) {
    stack<double> iStack;
    double result = 0, temp;

    iStack.push(1.0);

    for (double i = 2; i <= 10; i += 1, ops >>= 2) {
        switch (ops & 0b11) {
        case 0:
            iStack.push(i);
            break;
        case 1:
            iStack.push(-i);
            break;
        case 2:
            temp = iStack.top() * i;
            iStack.pop(); iStack.push(temp);
            break;
        case 3:
            temp = iStack.top() / i;
            iStack.pop(); iStack.push(temp);
            break;
        }
    }

    while (!iStack.empty()) {
        result += iStack.top();
        iStack.pop();
    }

    return (result == 100.0);
}
