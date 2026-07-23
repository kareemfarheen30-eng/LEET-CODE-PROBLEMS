import java.util.*;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsSet = new HashSet<>();
        for (char j : jewels.toCharArray()) {
            jewelsSet.add(j);
        }
        
        int res = 0;
        for (char s : stones.toCharArray()) {
            if (jewelsSet.contains(s)) {
                res++;
            }
        }
        return res;
    }
}
