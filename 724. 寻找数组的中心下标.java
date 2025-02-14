// 思路：遍历数组，对每个数组元素两边分别求和并进行比较
class Solution {
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int l = 0, r = 0;
            for (int j = 0; j < i; j++) {
                l = l + nums[j];
            }
            for (int k = i + 1; k < nums.length; k++) {
                r = r + nums[k];
            }
            if (l == r) return i;
        }
        return -1;
    }
}

// 更好的解法：求得数组元素之和sum，从左遍历数组时每遍历一个元素用sum减去该元素，比较left_sum等于sum则返回，不等则给left_sum加上当前下标的数值继续遍历
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        int left_sum = 0;
        for(int i=0;i<nums.length;i++){
            sum -= nums[i];
            if(left_sum == sum){
                return i;
            }
            left_sum += nums[i];
        }
        return -1;
    }
}

/*
作者：xiaoyi
链接：https://leetcode.cn/leetbook/read/array-and-string/yf47s/?discussion=D6slGT
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
