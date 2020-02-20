import java.util.Stack;

/**
 * P739 Daily Temperatures
 * 每日温度
 * 图解算法链接: https://mp.weixin.qq.com/s/3kDSOHyd-qOw7apzj0Z9YQ
 * 原理是递减栈：巧妙在一次遍历，每一个元素最多只会被压栈一次或者弹栈一次即可，所以保证了O(n)的时间复杂度
 * 栈存贮了遍历游标位置之前的那些，还没有找到value的元素
 */
public class P739 {

    public static void main(String[] args) {
        P739 p739 = new P739();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = p739.dailyTemperatures(T);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        // 递减栈，保存数组下标
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < T.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            while(!stack.isEmpty() && T[stack.peek()] < T[i]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
