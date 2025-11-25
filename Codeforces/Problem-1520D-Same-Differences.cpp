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

void solve() {
    int n;
    cin >> n;
    unordered_map<int, int> freq;
    long long res = 0;
    for(int i = 1; i <= n; i++) {
        int val;
        cin >> val;
        res += freq[val - i]++;
    }
    cout << res << endl;
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
}
