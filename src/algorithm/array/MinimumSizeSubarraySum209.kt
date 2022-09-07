package algorithm.array

/**
 * 209. 长度最小的子数组
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 *
 * 题解
 * https://www.programmercarl.com/0209.%E9%95%BF%E5%BA%A6%E6%9C%80%E5%B0%8F%E7%9A%84%E5%AD%90%E6%95%B0%E7%BB%84.html
 *
 * @author wangchang on 2022/9/4
 */
class MinimumSizeSubarraySum209 {

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var start = 0
        var end = 0
        var result = Int.MAX_VALUE
        var sum = 0
        while (end < nums.size) {
            sum += nums[end]
            while (sum >= target) {
                val temSum = end - start + 1
                result = if (result > temSum) temSum else result
                sum -= nums[start++]
            }
            end++
        }
        return if (result == Int.MAX_VALUE) 0 else result
    }

    fun case1() {
        val target = 7
        val nums = intArrayOf(2, 3, 1, 2, 4, 3)
        val result = 2
        runCase(this::case1.name, target, nums, result)
    }

    fun case2() {
        val target = 4
        val nums = intArrayOf(1, 4, 4)
        val result = 1
        runCase(this::case2.name, target, nums, result)
    }

    fun case3() {
        val target = 11
        val nums = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)
        val result = 0
        runCase(this::case3.name, target, nums, result)
    }

    private fun runCase(caseName: String, target: Int, nums: IntArray, result: Int) {
        val caseResult = minSubArrayLen(target, nums)
        println("$caseName --- ${if (result == caseResult) "pass" else "fail"} --> " + caseResult)
    }
}

fun main() {
    val minimumSizeSubarraySum209 = MinimumSizeSubarraySum209()
    minimumSizeSubarraySum209.case1()
    minimumSizeSubarraySum209.case2()
    minimumSizeSubarraySum209.case3()
}