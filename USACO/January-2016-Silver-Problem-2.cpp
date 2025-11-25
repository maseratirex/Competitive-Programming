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
    vector<long long> psum(n+1);
    for(int i = 0; i <= n; i++) {
        int id;
        cin >> id;
        psum[i+1] = psum[i] + id;
    }
    long long longest_group = 0;
    unordered_map<int, int> first_seen;
    for(int i = 1; i <= n; i++) {
        int remainder = psum[i] % 7;
        if(remainder == 0) {
            longest_group = i;
        } else {
            if(first_seen.count(remainder)) {
                longest_group = max(longest_group, (long long) i - first_seen[remainder]);
            } else {
                first_seen[remainder] = i;
            }
        }
    }
    cout << longest_group << endl; 
}

int main() {
    freopen("div7.in", "r", stdin);
    freopen("div7.out", "w", stdout);
    ios::sync_with_stdio(false); // Don't sync cin with scanf
    cin.tie(NULL); // Don't flush cout on call to cin

    int t = 1;
    // cin >> t;
    while (t--) solve();
}
