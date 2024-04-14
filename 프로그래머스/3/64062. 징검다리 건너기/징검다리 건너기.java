public class Solution {
    public int solution(int[] stones, int k) {
        int start = 1, end = (int) (2 * 1e8), ans = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 0;
            int max = 0;
            for (int stone : stones)
                max = Math.max(max, cnt = (stone < mid ? cnt + 1 : 0));

            if (max >= k) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}