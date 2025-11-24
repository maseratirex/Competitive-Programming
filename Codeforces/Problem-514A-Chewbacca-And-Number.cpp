#include <iostream>
// #include <vector>
// #include <algorithm>
// #include <string>
// #include <map>
// #include <set>
// #include <queue>
// #include <stack>
#include <cmath>
// #include <numeric>

using namespace std;

// const long long MOD = 1e9 + 7;

void solve() {
    string x;
    cin >> x;

    if('4' < x[0] && x[0] < '9') {
        x[0] = '9' - x[0] + '0';
    }

    for(int i = 1; i < x.length(); i++) {
        if('4' < x[i]) {
            x[i] = '9' - x[i] + '0';
        } 
    }
    cout << stoll(x);
}

int main() {
#ifdef LOCAL_TESTING
    freopen("in.txt", "r", stdin);
    freopen("out.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false);
    cin.tie(0);

    int t = 1;
    // cin >> t;
    while (t--) solve();
}
