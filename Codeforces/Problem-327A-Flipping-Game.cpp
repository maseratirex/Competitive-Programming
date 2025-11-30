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
    vector<int> psum(n+1);
    int totalOnes = 0;
    for(int i = 0; i < n; i++) {
        int val;
        cin >> val;
        psum[i+1] = psum[i] + (val == 0 ? -1 : 1);
        if(val == 1) totalOnes++;
    }
    int minimum = 1;
    for(int l = 1; l <= n; l++) {
        for(int r = l; r <= n; r++) {
            // What if we flip [l, r]?
            // Then -1 becomes 1 and 1 becomes -1, so the sum
            // is negated
            minimum = min(minimum, psum[r] - psum[l-1]);
        }
    }
    cout << totalOnes - minimum << endl;
}

int main() {
#ifdef LOCAL_TESTING
    freopen("in.txt", "r", stdin);
    freopen("out.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false); // Don't sync cin with scanf
    cin.tie(NULL); // Don't flush cout on call to cin

    int t = 1;
    // cin >> t;
    while (t--) solve();
}