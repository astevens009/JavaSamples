# Apple Orchard
## Sample Exercise

Alice and Bob work in a beautiful orchard. There are N apple trees in the orchard. The apple trees are arranged in a row and they are numbered from 1 to N.

Alice is planning to collect all the apples from K consecutive trees and Bob is planning to collect all the apples from L consecutive trees. They want to choose two disjoint segments (one consisting of K trees for Alice and the other consisting of L trees fro Bob) so as not to disturb each other. <strong>What is the maximum number of apples that they can collect?</strong>

Write a function
<br/>
<code>
class Solution{
	solution (int[] A, int K, int L);
}
</code>
<br/>
<br/>
that, given an array A consisting of N integers (denoting the number of apples on each apple tree) and integers K and L (denoting, respectively, the number of trees that Alice and Bob can choose) when collecting returns the maximum number of apples that be collected by them <em>both</em>; or -1 if there are no such intervals.

For example, given: 
<strong>Example 1:</strong>
<pre>

A = [6, 1, 4, 6, 3, 2, 7, 4]
K = 3
L = 2

your function should return 24.

<strong>Explanation:</strong>

Alice chooses trees 3 to 5 and collects 
<pre>
4 + 6 + 3 = 13 //representing the <em>maximum</em> number of apples that Alice can pick
</pre>

and Bob can choose trees 7 to 8 and collect
<pre>
7 + 4 = 11 //representing the <em>maximum</em> number of apples that Bob can pick
</pre>
Thus they will collect 13 + 11 = 24 apples in total, and that is the maximum number that can be achieved
</pre>

<strong>Example 2:</strong>
<pre>

Given:
A = [10, 19, 15]
K = 2
L = 2

your function should return -1 because it's not possibel for Alice and Bob to choose two disjoint intervals.
</pre>

Assume that
- N is an integer within the range [2..100]
- K and L are integers within the range[1..N-1]
- Each element of array A is an integer within the range [1..500]

In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment
