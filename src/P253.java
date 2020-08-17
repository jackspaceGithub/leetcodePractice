/**
 * 253. Meeting Rooms II 会议室之二
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 *
 *
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */

/**
 * 解题思路：
 * 跟会议室1类似，肯定都要排序的，不同点是会议室2是要找不相交的片段，
 * 一，排序不多哔哔
 * 二，顺序比较，如果不相交，则放入一个 List<集合> 集合列表中的某一集合中，如果相交了，遍历下一个集合，如果都没有，新建一个集合放入
 * 三，按照二的方法，时间复杂度必然会超，这里优化方案跟会议室一类似，我们只判断结束时间点即可，而且一个集合中其实只需要存最大的结束时间点即可，所以也用不到集合，一个 List<Integer>就可以了
 * 这样判断相交的时间负责度最快O(1)，最坏O(n) 总体时间复杂度就是 排序时间复杂度 + 判断相交时间复杂度 = N*Log(N) + O(1)  到 N*Log(N) + O(N)
 * 四，近一步优化，其实新节点过来，我们只需要判断他的起始时间跟List里的最小结束时间相比就可以了，因为我们是排过序的，你起始时间比我们这里面最小的结束时间都小的话，其他结束时间我就不用看了，必然有相交啊
 * 所以这里可以维护一个最小堆，每次只跟堆顶元素比较，也就是最小结束时间，这样判断相交的逻辑稳定成了O(1)， N*Log(N) + O(1) + 维护小顶堆的时间负责度 即 Log(N)最坏
 */
public class P253 {
}
