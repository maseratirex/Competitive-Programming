**Codeforces account:** https://codeforces.com/profile/maseratirex

**Problem 1526B:** https://codeforces.com/problemset/problem/1526/B
* Rating: 1400.
* Solved Thursday, February 13, 2025 first try.
* Determine if an integer can be expressed as a sum of 11's, 111's, 1111's, etc.
* For example, 144 is 11 + 11 + 11 + 111, so "YES" would be this example answer.
* I noticed 1111 = 11 * 100 + 11, and 11111 = 111 * 100 + 11. In other words, the problem is reduced to "Determine if there exist positive integers a and b such that 11a + 111b = x." Number theory solved the rest.

**Problem 489C:** https://codeforces.com/problemset/problem/489/C
* Rating: 1400.
* Solved Wednesday, February 12, 2025 first try.
* Your task is to find the smallest and the largest of the numbers that have d digits and sum of digits s or output -1 -1 if no integers match the constraints.
* To find the minimum integer, I maximized the right-most digits from right to left with the constraint that the left-most digit had to be at least 1 (or 0 if the number has 1 digit).
* To find the maximum integer, I maximized the left-most digits from left to right.

**Problem 520B:** https://codeforces.com/problemset/problem/520/B
* Rating: 1400.
* Solved Tuesday, February 11, 2025 first try.
* You have two moves: n -= 1 and n *= 2. Output the minimum number of moves needed to get to m.
* My solution, which ended up being optimal, was a math-heavy application of divide and conquer.
* If n > m, subtracting n - m times gets us to m.
* If n == m, output 0.
* If n < m, approach by cases:
  * If m is odd, then add 1. The result is m + 1 = 2k, where k is an integer. We can get from n to 2k by moving to k then multiplying by 2; we can get from 2k to m by subtracting 1.
  * If m is even, then we can get to m by getting to k = m/2 and multiplying by 2.
  * Thus, you now need to calculate the minimum number of moves to get from n to k.

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
