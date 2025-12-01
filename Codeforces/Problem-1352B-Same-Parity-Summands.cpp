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

#define ll long long

using namespace std;

const long long MOD = 1e9 + 7;

void solve() {
    int n, k;
    cin >> n >> k;
    if (n % 2 == 0) {
        if (k % 2 == 0) {
            if (n < k) {
                cout << "NO" << '\n';
                return;
            }
            cout << "YES" << '\n';
            for (int i = 0; i < k - 1; i++) {
                cout << 1 << ' ';
            }
            cout << n - (k - 1) << '\n';
            return;
        } else {
            if (n < 2 * k) {
                cout << "NO" << '\n';
                return;
            }
            cout << "YES" << '\n';
            for (int i = 0; i < k - 1; i++) {
                cout << 2 << ' ';
            }
            cout << n - 2 * (k - 1) << '\n';
            return;

        }
    } else {
        if (k % 2 == 0) {
            cout << "NO" << '\n';
            return;
        } else {
            if (n < k) {
                cout << "NO" << '\n';
                return;
            }
            cout << "YES" << '\n';
            for (int i = 0; i < k - 1; i++) {
                cout << 1 << ' ';
            }
            cout << n - (k - 1) << '\n';
        }
    }
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
