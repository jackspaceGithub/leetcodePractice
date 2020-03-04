import java.util.HashSet;
import java.util.Set;

/**
 *  p785，Is Graph Bipartite?
 *  二部图
 */
public class P785 {

  public static void main(String args[]) {
    int [][] inputs = new int[][] {{1,3}, {0,2}, {1,3}, {0,2}};
    int [][] inputs2 = new int[][] {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
    int [][] inputs3 = new int[][] {{1}, {0}, {4}, {4}, {2, 3}};
    P785 p785 = new P785();
    if(p785.isBipartite(inputs3)) {
      System.out.println("是二部图");
    } else {
      System.out.println("不是二部图");
    }

  }

  /**
   * 先说我自己的想法，
   * 自定义一个原则：从第一个点开始，把能跟它直接连接到的都标记为集合b元素，它自己是集合a元素，未涉及到的元素就是待确认元素
   * 然后开始遍历第二个点，观察点和临街点是否属于同一个集合，如果属于则不能找到答案
   * 一开始这种想法被一个场景困扰-非连通图，abc相连, fgh相连，但是俩图不想连，万一有n个非连通图，我难道还要去申请n个集合，这代码根本没法写
   * 后来转念，连不连通根本无所谓的，题目是让你把节点分两边，只要找到的边能在两个集合就可以，跟连通图没有关系，
   * 但是遇到的一个图如果跟之前的图没有连接，这时候怎么分组，万一瞎分组，把他们分到了a组，后来发现人家其实在b组，
   * 所以看网上这里就要用深度优先搜索，先把他们可能链接的点都标记好了，这样这个思路才可以继续
   * 不过我这里用集合太笨了，其实用数组就可以标记
   * @param graph
   * @return
   */
  public boolean isBipartite(int[][] graph) {
    // 声明标记数组
    int[] mark = new int[graph.length];

    // 待确认元素集合构建
    for(int i = 0; i < graph.length; i++) {
      if(!dfs(i, graph, mark)){
        return false;
      }
    }
    return true;
  }

  private boolean dfs(int i, int[][] graph, int[] mark) {
    // 说明一定是跟之前节点不连接的，所以一定不是同一个连通图，分组就随意分一个就可以
    if(mark[i] == 0) {
      mark[i] = 1;
    }
    // 开始遍历
    for(int i2 = 0; i2 < graph[i].length; i2++) {
      // 判断临街点颜色，i节点不可能是未着色的初始化值0，所以如果临界点颜色跟i相同则说明之前被染色，则判断为失败
      if(mark[graph[i][i2]] == mark[i]) {
        return false;
      }

      if(mark[graph[i][i2]] != 0) {
        continue;
      }

      mark[graph[i][i2]] = mark[i] == 1 ? 2 : 1;
      if(!dfs(graph[i][i2], graph, mark)) {
        return false;
      }
    }
    return true;
  }
}
