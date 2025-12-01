#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <map>
#include <set>
#include <queue>
#include <stack>
#include <cmath>
#include <numeric>

#define ll long long

using namespace std;

bool is_prime(long long val) {
    if(val == 1) return false;
    if(val == 2) return true;
    if(val == 3) return true;
    if(val % 2 == 0) return false;
    if(val % 3 == 0) return false;
    int increment = 4;
    for(long long i = 5; i * i <= val; i += increment) {
        if(val % i == 0) return false;
        if(increment == 2) {
            increment = 4;
        } else {
            increment = 2;
        }
    }
    return true;
}