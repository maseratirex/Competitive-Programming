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
    vector<int> boy(n);
    for(int i = 0; i < n; i++) {
        cin >> boy[i];
    }
    sort(boy.begin(), boy.end());
    int m;
    cin >> m;
    vector<int> girl(m);
    for(int j = 0; j < m; j++) {
        cin >> girl[j];
    }
    sort(girl.begin(), girl.end());
    int i = 0;
    int j = 0;
    int pair_count = 0;
    while(i < n && j < m) {
        if(boy[i] < girl[j] - 1) {
            i++;
        } else if(boy[i] > girl[j] + 1) {
            j++;
        } else {
            i++;
            j++;
            pair_count++;
        }
    }
    cout << pair_count << endl;
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
