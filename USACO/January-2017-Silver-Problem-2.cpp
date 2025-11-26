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
    vector<int> p_freq(n+1);
    vector<int> h_freq(n+1);
    vector<int> s_freq(n+1);

    for(int i = 0; i < n; i++) {
        char val;
        cin >> val;
        p_freq[i+1] = p_freq[i] + (val == 'P' ? 1 : 0);
        h_freq[i+1] = h_freq[i] + (val == 'H' ? 1 : 0);
        s_freq[i+1] = s_freq[i] + (val == 'S' ? 1 : 0);
    }
    if(n == 1) {
        cout << 1;
        return;
    }
    int res = 0;
    for(int i = 1; i < n; i++) {
        int left_max_freq = max({p_freq[i], h_freq[i], s_freq[i]});
        int right_max_freq = max({p_freq[n] - p_freq[i], h_freq[n] - h_freq[i], s_freq[n] - s_freq[i]});
        res = max(res, left_max_freq + right_max_freq);
    }
    cout << res << endl;
}

int main() {
    freopen("hps.in", "r", stdin);
    freopen("hps.out", "w", stdout);
    ios::sync_with_stdio(false); // Don't sync cin with scanf
    cin.tie(NULL); // Don't flush cout on call to cin

    int t = 1;
    // cin >> t;
    while (t--) solve();
}
