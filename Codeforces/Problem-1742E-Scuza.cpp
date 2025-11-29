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
    int n;
    cin >> n;
    int q;
    cin >> q;
    vector<ll> highest_seen(n);
    vector<ll> psum(n+1);
    int highest = 0;
    for(int i = 0; i < n; i++) {
        int val;
        cin >> val;
        highest = max(highest, val);
        highest_seen[i] = highest;
        psum[i+1] = psum[i] + val;
    }
    for(int i = 0; i < q; i++) {
        int query;
        cin >> query;
        // Get the index of the first value greater than query
        int ind = upper_bound(highest_seen.begin(), highest_seen.end(), query) - highest_seen.begin();
        cout << psum[ind] << ' ';
    }
    cout << '\n';
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
