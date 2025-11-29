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
    vector<ll> psum(n+1);
    vector<int> vals(n);
    for(int i = 0; i < n; i++) {
        int val;
        cin >> val;
        psum[i+1] = psum[i] + val;
        vals[i] = val;
    }
    sort(vals.begin(), vals.end());
    vector<ll> sorted_psum(n+1);
    for(int i = 0; i < n; i++) {
        sorted_psum[i+1] = sorted_psum[i] + vals[i]; 
    }
    int m;
    cin >> m;
    // Starts with type
    // Then l and r separated by spaces
    for(int i = 0; i < m; i++) {
        int type;
        cin >> type;
        int l, r;
        cin >> l;
        cin >> r;
        if(type == 1) {
            cout << psum[r] - psum[l-1] << '\n';
        } else {
            cout << sorted_psum[r] - sorted_psum[l-1] << '\n';
        }
    }
    cout.flush();
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
