/*
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
-- 示例 --
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
*/

// 1. 标准答案
class Solution {
    // 差分数组
    public int[][] merge(int[][] intervals) {
        int maxReach = 0;
        for(int[] a : intervals) maxReach = Math.max(maxReach, a[1]);
        int[] diff = new int[maxReach*2 + 2];
        for(int[] a : intervals) {
            diff[a[0]*2]++;
            diff[a[1]*2 + 1]--;
        }
        List<int[]> res = new ArrayList<>();
        int st = -1, preS = 0;
        for(int i = 0; i < maxReach*2 + 2; i++) {
            preS += diff[i];
            if(preS > 0 && st == -1) {
                st = i;
            }else if(preS == 0 && st != -1) {
                int[] tmp = new int[2];
                tmp[0] = st / 2;
                tmp[1] = i / 2;
                res.add(tmp);
                st = -1;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

// 2. 新颖答案
public static int[][] merge(int[][] intervals) {
    if (intervals.length == 0) return intervals;
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));//按每行的第0列升序排序
    Vector<int[]> integerVector;//由于我们事先不知道数组大小，所以用Vector类实现动态数组。
    integerVector = new Vector<>();
    int[] ints = intervals[0];//定义一个Int类型数组用于作比较，默认值为第一组二维数组的值。
    for (int i = 1; i < intervals.length; i++) {//循环这个二维数组
        if (ints[1] >= intervals[i][0]) {//如果第一个数组的右端点大于等于下一个数组的左端点，做说明两个数组有所交集。
            ints[1] = Math.max(ints[1], intervals[i][1]);//int类型数组的右端点等于两个数组中右端点大的那个值。
        } else {
            integerVector.add(ints);//把int类型一维数组ints添加到我们创建的vector类里面。
            ints = intervals[i];//给一维数组重新赋值。
        }
    }
    integerVector.add(ints);//把最后一个区间添加到Vector里面
    return integerVector.toArray(new int[integerVector.size()][2]);//把vector转换成二维数组返回。
}

/*
作者：陈陈陈晨晨
链接：https://leetcode.cn/leetbook/read/array-and-string/c5tv3/?discussion=pJ59b3
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
