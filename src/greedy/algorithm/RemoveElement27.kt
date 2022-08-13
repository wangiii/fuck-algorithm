package greedy.algorithm

/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/
 *
 * 题解
 * https://www.programmercarl.com/0027.%E7%A7%BB%E9%99%A4%E5%85%83%E7%B4%A0.html
 *
 * @author wangchang on 2022/8/13
 */
class RemoveElement27 {
    private fun removeElement(nums: IntArray, value: Int): Int {
        var slow = 0
        for (fast in nums.indices) {
            if (nums[fast] != value) {
                nums[slow++] = nums[fast]
            }
        }
        return slow
    }

    fun case1() {
        val nums = intArrayOf(3, 2, 2, 3)
        val value = 3
        val result = 2
        runCase(this::case1.name, result, nums, value)
    }

    fun case2() {
        val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
        val value = 2
        val result = 5
        runCase(this::case2.name, result, nums, value)
    }

    private fun runCase(caseName: String, result: Int, nums: IntArray, value: Int) {
        val len = removeElement(nums, value)
        println("$caseName -- result is ${result == len} --> $len")
    }
}

fun main() {
    val removeElement27 = RemoveElement27()
    removeElement27.case1()
    removeElement27.case2()
}


