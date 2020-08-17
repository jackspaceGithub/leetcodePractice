/**
 * 252. Meeting Rooms 会议室
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 * Example 1:
 *
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 *
 *
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: true
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */


/**
 * 解题思路：
 * 其实就是找线段有无相交点，如果有则是false
 * 一，根据排序起始时间去优化查找时间复杂度
 * 二，注意排序后没必要使用起始时间点去做判断了，因为你已经排序，顺序查找相交区间的时候，起始节点，后面的区间一定比前面的大或相等，所以只需要判断前面的结束节点和后面的起始节点的关系即可
 * 三，注意要存最大结束时间点，否则没意义
 */

public class P252 {
}
