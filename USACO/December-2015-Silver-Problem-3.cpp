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
    int n;
    int q;
    cin >> n >> q;
    vector<int> id1s(n);
    vector<int> id2s(n);
    vector<int> id3s(n);
    for(int i = 0; i < n; i++) {
        int id;
        cin >> id;
        id1s[i + 1] = id1s[i] + (id == 1 ? 1 : 0);
        id2s[i + 1] = id2s[i] + (id == 2 ? 1 : 0);
        id3s[i + 1] = id3s[i] + (id == 3 ? 1 : 0);
    }
    for(int i = 0; i < q; i++) {
        int a, b;
        cin >> a >> b;
        cout << id1s[b] - id1s[a-1] << ' ' << id2s[b] - id2s[a-1] << ' ' << id3s[b] - id3s[a-1] << endl;
    }
}

int main() {
    freopen("bcount.in", "r", stdin);
    freopen("bcount.out", "w", stdout);
    ios::sync_with_stdio(false);
    cin.tie(0);

    int t = 1;
    // cin >> t;
    while (t--) solve();
}
