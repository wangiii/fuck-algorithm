package algorithm.array

/**
 * 59. 螺旋矩阵 II
 * https://leetcode.cn/problems/spiral-matrix-ii/
 *
 * 题解
 * https://www.programmercarl.com/0059.%E8%9E%BA%E6%97%8B%E7%9F%A9%E9%98%B5II.html#_59-%E8%9E%BA%E6%97%8B%E7%9F%A9%E9%98%B5ii
 *
 * @author wangchang on 20223/9/8
 */
class ProblemsSpiralMatrixII59 {

    fun generateMatrix(n: Int): Array<IntArray> {
        val result = Array(n) { IntArray(n) }
        var top = 0
        var bottom = n - 1
        var left = 0
        var right = n - 1
        var index = 1
        while (top <= bottom && left <= right) {
            for (i in left..right) {
                result[top][i] = index++
            }
            for (i in top + 1..bottom) {
                result[i][right] = index++
            }
            if (top < bottom && left < right) {
                for (i in right - 1 downTo left) {
                    result[bottom][i] = index++
                }
                for (i in bottom - 1 downTo top + 1) {
                    result[i][left] = index++
                }
            }
            top++
            bottom--
            left++
            right--
        }
        return result
    }

    private fun runCase(caseName: String, n: Int, result: Array<IntArray>) {
        val caseResult = generateMatrix(n)
        println("$caseName --- ${if (result.contentDeepToString() == caseResult.contentDeepToString()) "pass" else "fail"} --> " + caseResult.contentDeepToString())
    }

    fun case1() {
        val n = 3
        val result = arrayOf(intArrayOf(1, 2, 3), intArrayOf(8, 9, 4), intArrayOf(7, 6, 5))
        runCase(this::case1.name, n, result)
    }

    fun case2() {
        val n = 1
        val result = arrayOf(intArrayOf(1))
        runCase(this::case2.name, n, result)
    }

}

fun main() {
    val problemsSpiralMatrixII59 = ProblemsSpiralMatrixII59()
    problemsSpiralMatrixII59.case1()
    problemsSpiralMatrixII59.case2()
}