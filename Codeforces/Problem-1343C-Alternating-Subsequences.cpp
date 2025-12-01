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
    int state;
    long long sum = 0;
    int current_max;
    for(int i = 0; i < n; i++) {
        int val;
        cin >> val;
        if(i == 0) {
            state = val;
            current_max = val;
        }
        if((state < 0 && val > 0) || (state > 0 && val < 0)) {
            state = val;
            sum += current_max;
            current_max = val;
            continue;
        }
        current_max = max(current_max, val);
    }
    sum += current_max;
    cout << sum << '\n';
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
