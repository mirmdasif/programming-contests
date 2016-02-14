#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    // your code goes here
    int n,m;
    int numbers[200200];
    int mappings[200200];
    scanf("%d",&n);
     scanf("%d",&m);


    numbers[0] = -1;
    mappings[0] = -1;
    int leftPos = 0;
    for (int i = 1; i <= n; i++) {
         scanf("%d",&numbers[i]);
        if (numbers[i] != numbers[i-1]) {
            leftPos = i;
        }
        mappings[i] = leftPos;
    }
    for (int i = 1; i <= m; i++) {
        int l,r,x;
        scanf("%d",&l);
        scanf("%d",&r);
        scanf("%d",&x);

        if (numbers[r] != x) {
            printf("%d\n",r);
        }
        else if (l < mappings[r]) {
           printf("%d\n",(mappings[r] - 1));
        }
        else {
            printf("-1\n");

        }

    }

    return 0;
}
