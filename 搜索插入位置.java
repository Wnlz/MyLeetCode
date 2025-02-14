/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
要求必须使用时间复杂度为 O(log n) 的算法。

提示:
1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums 为 无重复元素 的 升序 排列数组
-10^4 <= target <= 10^4
*/

// 1.答案：
class Solution {
    public int searchInsert(int[] nums, int target) {
        // 二分法
        int left = 0, right = nums.length - 1;
        while(left <= right){
            // 防止 left + right 整型溢出
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return left;
    }
}

/*
作者：王二三
链接：https://leetcode.cn/leetbook/read/array-and-string/cxqdh/?discussion=g0UsEI
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
