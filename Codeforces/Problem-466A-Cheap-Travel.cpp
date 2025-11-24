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

void solve()
{
    int n, m, a, b;
    cin >> n >> m >> a >> b;
    int remaining = n;
    long long cost = 0;
    if (remaining < m)
    {
        if (a * remaining < b)
        {
            cost += a * remaining;
        }
        else
        {
            cost += b;
        }
        cout << cost;
        return;
    }
    if (b < a * m)
    {
        cost += b * (remaining / m);
        remaining -= (remaining / m) * m;
    }
    else
    {
        cost += remaining * a;
        cout << cost;
        return;
    }
    if (remaining != 0)
    {
        if (a * remaining < b)
        {
            cost += a * remaining;
        }
        else
        {
            cost += b;
        }
    }
    cout << cost;
}

int main()
{
#ifdef LOCAL_TESTING
    freopen("in.txt", "r", stdin);
    freopen("out.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false);
    cin.tie(0);

    // int t;
    // cin >> t;
    // while (t--) solve();
    solve();
}
