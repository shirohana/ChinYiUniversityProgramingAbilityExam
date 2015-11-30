#include <iostream>

using namespace std;

int step, length;

void hanoi(int);
void hanoi(int, char, char, char);

int main() {

    int level;
    cin >> level;

    hanoi(level);

    return 0;
}

void hanoi(int level) {
    char a = 'a', b = 'b', c = 'c';

    if (level == 1) {
        printf("第 1 步: 移動 1 從塔 %c 到 %c\n", a, c);
        return;
    }

    char buffer[32];

    step = 1;
    length = sprintf(buffer, "%d", (1 << level) - 1);

    hanoi(level, a, b, c);
}

void hanoi(int level, char a, char b, char c) {
    if (level == 2) {
        printf("第 %*d 步: 移動 %d 從塔 %c 到 %c\n", length, step++, 1, a, b);
        printf("第 %*d 步: 移動 %d 從塔 %c 到 %c\n", length, step++, 2, a, c);
        printf("第 %*d 步: 移動 %d 從塔 %c 到 %c\n", length, step++, 1, b, c);
    } else {
        hanoi(level - 1, a, c, b);
        printf("第 %*d 步: 移動 %d 從塔 %c 到 %c\n", length, step++, level, a, c);
        hanoi(level - 1, b, a, c);
    }
}
