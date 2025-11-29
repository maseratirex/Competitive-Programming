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
#include <unordered_map>

using namespace std;

const long long MOD = 1e9 + 7;

vector<long long> primeFactorize(long long val) {
    vector<long long> res;
    if(val % 2 == 0) {
        long long curr = 1;
        while (val % 2 == 0) {
            val /= 2;
            curr *= 2;
        }
        res.push_back(curr);
    }
    if(val % 3 == 0) {
        long long curr = 1;
        while (val % 3 == 0) {
            val /= 3;
            curr *= 3;
        }
        res.push_back(curr);
    }
    int increment = 4;
    for(long long i = 5; i * i <= val; i += increment) {
        if(val % i == 0) {
            long long curr = 1;
            while (val % i == 0) {
                val /= i;
                curr *= i;
            }
            res.push_back(curr);
        }
        if(increment == 2) {
            increment = 4;
        } else {
            increment = 2;
        }
    }
    if(val > 1) {
        // The remaining factor wasn't divisible by anything less than it so it's a prime factor
        res.push_back(val);
    }
    return res;
}

void solve() {
    long long X;
    cin >> X;
    vector<long long> factorization = primeFactorize(X);
    long long minimum = X;
    long long best_a = 1;
    long long best_b = X;
    for(long long i = 0; i < (1 << factorization.size()); i++) {
        // 0 means b gets all the factors
        // 1 means a gets first factor
        // 2 means a gets second factor
        // 3 means a gets first and second factor
        long long a = 1;
        for(long long j = 0; j < factorization.size(); j++) {
            if(i & (1 << j)) {
                a *= factorization[j];
            }
        }
        long long b = X/a;
        if(minimum > max(a, b)) {
            best_a = a; 
            best_b = b;
        }
        minimum = min(minimum, max(a, b));
    }
    cout << best_a << ' ' << best_b << endl;
}

int main() {
#ifdef LOCAL_TESTING
    freopen("in.txt", "r", stdin);
    freopen("out.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false); // Don't sync cin with scanf
    cin.tie(0); // Don't flush cout on call to cin

    int t = 1;
    // cin >> t;
    while (t--) solve();
}