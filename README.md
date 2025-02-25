**Codeforces account:** https://codeforces.com/profile/maseratirex

**Templates:**
* Java Main class with main method and fast scanning and boolean logic to choose input and output from standard in/out or in.txt/out.txt
* Java comparable Pair class for problems with sorting pairs
* Java BitwiseOperations class for defining common bitwise operations

**Problem 2072D:** https://codeforces.com/problemset/problem/2072/D
* Rating: unknown rating.
* Solved Tuesday, February 25, 2025 first try.
* You are given an array of integers.
* You may move the first element of a sequence to the end of the sequence, shifting all the other elements back. You must identify a range of values [i, j] that minimizes the number of decreasing pairs in the array.
* To choose the optimal i and j, you must identify a start value that is greater or equal to most of the following values. For example, if your input is [4, 1, 2, 5, 6, 3], then 4 is greater than or equal to 1, 2, and 3. However, using the range of indices [1, 6] would result in [1, 2, 5, 6, 3, 4]. Thus, you have introduced the decreasing pairs (5, 4) and (6, 4). A more optimal range is [1, 3] for a result of [1, 2, 4, 5, 6, 3].
* I scanned the array from left to right and formed all the possible ranges, scoring them by adding 1 for each decreasing pair removed and subtracting 1 for each decreasing pair introduced. 

**Problem 515C:** https://codeforces.com/problemset/problem/515/C
* Rating: 1400.
* Solved Monday, February 24, 2025 first try.
* Given an input string of n digits, output the largest number such that none of its digits are 0 or 1 and the product of the factorials of each of its digits is equivalent to the product of the factorials of each of the digits of the input string.
* For example, the product of the factorials of each of the digits of an input string "1234" is (1!)(2!)(3!)(4!) = (3!)(3!)(2!)(2!)(2!), so we would output 33222.
* I found the solution almost immediately, but spent a bit more time than I would have liked implementing it because I wanted to write a fast and fancy solution.
* In retrospect, Codeforces contests only care if you solve the problem with the given time and space constraints. It would have been totally appropriate to write "output7String = '7' + output7String" rather than using a String Builder and keeping track of the frequencies of the digits that would appear in the output.

**Problem 1195C:** https://codeforces.com/problemset/problem/1195/C
* Rating: 1400.
* Solved Sunday, February 23, 2025 second try.
* You can opt to include a player using the maximal height obtainable if you used the diagonal player or using the maximal height obtainable using players two columns before.
* I learned that Java 21 has made performance improvements over Java 8. This is in general, and perhaps the smaller size of a competitive programming solution reduces the performance gain.

**Problem 1324D:** https://codeforces.com/problemset/problem/1324/D
* Rating: 1400.
* Solved Saturday, February 22, 2025 second try.
* A simple two sum-like problem.
* I suspected that integer overflow might occur when adding two topics. However, I missed that the number of good topics (in the worst case, 200000(200000 + 1)/2) could well exceed 2^31 - 1, and I needed to change its type to a long data structure.
* I learned that wild card imports only slightly increase compilation time.

**Problem 479C:** https://codeforces.com/problemset/problem/479/C
* Rating: 1400.
* Solved Thursday, February 20, 2025 first try.
* A simple greedy problem made difficult by sorting pairs. I created a template class for sorting integer pairs in the future.
* Or, use a 2-element array for a pair.

**Problem 698A:** https://codeforces.com/problemset/problem/698/A
* Rating: 1400.
* Solved Friday, February 14, 2025 first try.
* A fun 2D DP

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
