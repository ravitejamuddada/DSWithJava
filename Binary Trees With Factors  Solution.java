https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3670/
iven an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.

We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.

Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [2,4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]
Example 2:

Input: arr = [2,4,5,10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 

Constraints:

1 <= arr.length <= 1000
2 <= arr[i] <= 109
  --------------------
  class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        Map<Integer, Long> counts = new HashMap<>();
        long count=0;
        for(int i =0; i<A.length; i++) {
            count += countMulti(counts, A, i);
        }
        // System.out.println(counts); // For debug
        return (int)(count % 1000000007);
    }
    
    public long countMulti(Map<Integer, Long> counts, int[] A, int i) {
        // System.out.println(counts); // For debug
        int n = A[i];
		// number itself as a single node
        long count=1; 
		// loop throught all number smaller than A[i]
        for (int j=0; j<i; j++) {
			// means A[j] cannot divide A[i], so skip
            if (n % A[j] != 0) continue;
            long currentCount = counts.get(A[j]);
            int target = n / A[j];
            long targetCount = counts.getOrDefault(target, (long)0); 
			// can divide but, the other number not appear, so skip
            if (targetCount == 0) continue;
            count += currentCount * targetCount;
        }
		// cache the result
        counts.put(n, count);
        return count;
    }
}
