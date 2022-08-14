package algorithm.greedy;

import java.util.Arrays;

/**
 * 455
 * https://leetcode.cn/problems/assign-cookies/
 *
 * 题解
 * https://www.programmercarl.com/0455.%E5%88%86%E5%8F%91%E9%A5%BC%E5%B9%B2.html
 *
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 示例 1:
 *
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1 解释:你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。所以你应该输出1。
 * 示例 2:
 *
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。你拥有的饼干数量和尺寸都足以让所有孩子满足。所以你应该输出2.
 * 提示：
 *
 * 1 <= g.length <= 3 * 10^4
 * 0 <= s.length <= 3 * 10^4
 * 1 <= g[i], s[j] <= 2^31 - 1
 *
 */
public class AssignCookies455 {
    public static void main(String[] args) {
        case1();
        case2();
    }

    private static void runCase(String caseName, int[] g, int[] s) {
        AssignCookies455 assignCookies455 = new AssignCookies455();
        System.out.println("思路1：优先考虑饼干，小饼干先喂饱小胃口 --- " + caseName + " >> " + assignCookies455.findContentChildren1(g, s));
        System.out.println("思路2：优先考虑胃口，先喂饱大胃口 --- " + caseName + " >> " + assignCookies455.findContentChildren2(g, s));
    }

    private static void case1() {
        int g[] = new int[3];
        g[0] = 1;
        g[1] = 2;
        g[2] = 3;
        int s[] = new int[2];
        s[0] = 1;
        s[1] = 1;
        runCase("case1", g, s);
    }

    private static void case2() {
        int g[] = new int[2];
        g[0] = 1;
        g[1] = 2;
        int s[] = new int[3];
        s[0] = 1;
        s[1] = 2;
        s[2] = 3;
        runCase("case2", g, s);
    }

    /**
     * 思路1：优先考虑饼干，小饼干先喂饱小胃口
     */
    public int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        int count = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                start++;
                count++;
            }
        }
        return count;
    }

    /**
     * 思路2：优先考虑胃口，先喂饱大胃口
     */
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start = s.length - 1;
        // 遍历胃口
        for (int index = g.length - 1; index >= 0; index--) {
            if(start >= 0 && g[index] <= s[start]) {
                start--;
                count++;
            }
        }
        return count;
    }
}
