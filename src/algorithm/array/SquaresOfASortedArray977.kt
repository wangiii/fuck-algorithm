package algorithm.array

import java.util.Arrays

/**
 * 977.有序数组的平方
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 *
 * 题解
 * https://www.programmercarl.com/0977.%E6%9C%89%E5%BA%8F%E6%95%B0%E7%BB%84%E7%9A%84%E5%B9%B3%E6%96%B9.html
 *
 * @author wangchang on 2022/8/14
 */
class SquaresOfASortedArray977 {

    fun sortedSquares(nums: IntArray): IntArray {
        val res = IntArray(nums.size)
        var left = 0
        var right = nums.size - 1
        for (index in nums.size - 1 downTo 0) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[index] = nums[left] * nums[left]
                left++
            } else {
                res[index] = nums[right] * nums[right]
                right--
            }
        }
        return res
    }

    fun case1() {
        val nums = intArrayOf(-4, -1, 0, 3, 10)
        val result = intArrayOf(0, 1, 9, 16, 100)
        runCase(this::case1.name, nums, result)
    }

    fun case2() {
        val nums = intArrayOf(-7, -3, 2, 3, 11)
        val result = intArrayOf(4, 9, 9, 49, 121)
        runCase(this::case2.name, nums, result)
    }

    fun case3() {
        val nums = intArrayOf()
        val result = intArrayOf()
        runCase(this::case3.name, nums, result)
    }

    fun case4() {
        val nums = intArrayOf(1)
        val result = intArrayOf(1)
        runCase(this::case4.name, nums, result)
    }

    fun case5() {
        val nums = intArrayOf(-5, -3, -2, -1)
        val result = intArrayOf(1, 4, 9, 25)
        runCase(this::case5.name, nums, result)
    }

    fun case6() {
        val nums = intArrayOf(1, 2, 3, 5)
        val result = intArrayOf(1, 4, 9, 25)
        runCase(this::case6.name, nums, result)
    }

    private fun runCase(caseName: String, nums: IntArray, result: IntArray) {
        val caseResult = sortedSquares(nums)
        println(
            "$caseName --- ${if (result.contentEquals(caseResult)) "pass" else "fail"} --> " +
                    caseResult.contentToString()
        )
    }

}

fun main() {
    val squaresOfASortedArray977 = SquaresOfASortedArray977()
    squaresOfASortedArray977.case1()
    squaresOfASortedArray977.case2()
    squaresOfASortedArray977.case3()
    squaresOfASortedArray977.case4()
    squaresOfASortedArray977.case5()
    squaresOfASortedArray977.case6()
}