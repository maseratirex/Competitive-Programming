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
    vector<int> psum(n+1);
    for(int i = 0; i < n; i++) {
        int val;
        cin >> val;
        psum[i+1] = psum[i] + val;
    }
    int m;
    cin >> m;
    for(int i = 0; i < m; i++) {
        int val;
        cin >> val; 
        int l = 1;
        int h = n;
        int mid;
        while(true) {
            mid = l + (h - l) / 2;
            if(val < psum[mid-1] + 1) {
                h = mid - 1;
            } else if(val > psum[mid]) {
                l = mid + 1;
            } else {
                cout << mid << endl;
                break;
            }
        }
    }
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
