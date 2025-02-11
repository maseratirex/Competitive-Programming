**Problem 279B:** https://codeforces.com/problemset/problem/279/B
* Rating: 1400.
* Solved Tuesday, February 11, 2025 first try.
* You need to calculate the longest subarray whose elements do not sum more than a given value.
* It is a classic example of the sliding window technique.

**Problem 429B:** https://codeforces.com/problemset/problem/492/B
* Rating: 1200.
* Solved Sunday, February 9, 2025 first try.
* You need to calculate the distance from each lamp position in 1D to its immediate neighbors.
* To do so efficiently, you eventually need a data structure containing the positions, sorted. Since the I/O requires adding each lamp position one by one, I considered adding each element to a TreeSet for O(log n) per insertion and traversing in O(n) to calculate the neighbor distances.
* However, the total insertion time is O(n log n) and you still have to traverse in O(n). Since you don't need the data structure sorted at all times, I decided to keep it simple, adding all the positions to an array and sorting it in O(n log n).
* Despite an array being "cheaper" with respect to memory, I leveraged ArrayList for simpler sorting and faster coding. No need for perfect efficiency.
