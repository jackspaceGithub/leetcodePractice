import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * P239 Sliding Window Maximum
 * 滑动窗口最大值
 * 双端队列，这种数据结构非常巧妙的维护了一个区间x，这个区间x记录了我们以后可能用到和肯定会用到的元素
 * 下面是题目原意，我们称题目里的滑动区间为y，y区间内最大值为y_max
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  1，我们可以看到如果y的最后尾部元素是最大的，那么其实y的尾部之前元素通通没用，在我们向下一个元素滑动的时候，根本不用去比较他们，每一个新进元素只需要跟y尾部比较即可。
 *  2，如果y_max不在尾部，那么进行下一次滑动的时候，y_max可能已经越界被弹出y，或者y_max被新元素代替，
 *      1）如果y_max被新元素替代了，说明y_max在尾部，新元素满足了‘1’里面的情况，那么尾部前面的元素都不需要了
 *      2) 当y_max越界弹出y时，我们需要知道y里面第二大的元素是什么，用来跟新元素比较决定出新的y_max
 *  综上所述，我们需要维护一个数据结构，它在确定y尾部为y_max时候只记录y_max自己，不在尾部时候要记录第二大的元素
 *
 *  这里采用双端队列即可满足：
 *  a: 当队列x为空，无脑进队列x，（但是也要记录一下子当前最大值，容易忽略）
 *  b: 先判断队首元素是否已经越界，如果y已经包含它了，则它要从x出去
 *  c: 当x不为空，比较新元素和队尾元素大小，新元素大则队尾元素出队列x，继续比较队尾（满足1）,直到找到了比它大的元素，则它入队列x（满足2中的（2）），
 *      相当于记录了第二大的元素，当然也可能记录了第三第四的，这都没关系，因为队列大小一直被'b'维护，会保证队列内元素一直是有用元素
 *
 */
public class P239 {

    public static void main(String args[]){
        int[] nums ={1,3,-1,-3,5,3,6,7};
        P239 p239 = new P239();
        int k = 3;
        int[] result = p239.maxSlidingWindow(nums, k);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(null == nums || nums.length == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int i2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(deque.isEmpty()) {
                deque.add(i);
            } else {
                if(i - deque.peekFirst() >= k) deque.pollFirst();

                while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }

                deque.add(i);
            }

            if(i >= k - 1) result[i2++] = nums[deque.peekFirst()];
        }
        return result;
    }
}
