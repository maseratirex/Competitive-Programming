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

const long long MOD = 1e9 + 7;

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

void solve() {
    int n;
    cin >> n;
    if(n % 2 == 0) {
        if(n == 2) {
            cout << "Ashishgup" << '\n';
            return;
        }
        if(n % 4 != 0) {
            if(is_prime(n/2)) {
                cout << "FastestFinger" << '\n';
                return;
            }
            cout << "Ashishgup" << '\n';
            return;
        }
        while(n % 2 == 0) n /= 2;
        if(n == 1) {
            // No odd factors
            cout << "FastestFinger" << '\n';
            return;
        }
        cout << "Ashishgup" << '\n';
        return;
    }
    if(n == 1) {
        cout << "FastestFinger" << '\n';
        return;
    }
    cout << "Ashishgup" << '\n';
}

int main() {
#ifdef LOCAL_TESTING
    freopen("in.txt", "r", stdin);
    freopen("out.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false); // Don't sync cin with scanf
    cin.tie(NULL); // Don't flush cout on call to cin

    int t = 1;
    cin >> t;
    while (t--) solve();
    cout.flush();
}
