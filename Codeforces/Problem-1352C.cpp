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

using namespace std;

const long long MOD = 1e9 + 7;

void solve() {
    int n, k;
    cin >> n >> k;
    long long res = 0;
    res += k/(n - 1) * n;
    if(k % (n - 1) == 0) {
        res--;
    } else {
        res += k % (n - 1);
    }
    cout << res << endl;
}

int main() {
#ifdef LOCAL_TESTING
    freopen("in.txt", "r", stdin);
    freopen("out.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false);
    cin.tie(0);

    int t = 1;
    cin >> t;
    while (t--) solve();
}
