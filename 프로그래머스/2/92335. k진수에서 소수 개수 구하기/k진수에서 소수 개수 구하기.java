class Solution {
    public int solution(int n, int k) {
        StringBuilder kNumber = new StringBuilder();
        while (n > 0) {
            kNumber.insert(0, n % k);
            n /= k;
        }
        
        int pCount = 0;
        int start = 0;
        int len = kNumber.length();
        
        for (int i = 0; i <= len; i++) {
            if (i == len || kNumber.charAt(i) == '0') {
                if (start < i) {
                    String numStr = kNumber.substring(start, i);
                    if (!numStr.isEmpty()) {
                        long num = Long.parseLong(numStr);
                        if (isPrime(num)) pCount++;
                    }
                }
                start = i + 1;
            }
        }
        return pCount;
    }
    
    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        long sqrt = (long) Math.sqrt(n);
        for (long i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}