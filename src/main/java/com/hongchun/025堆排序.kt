package com.hongchun

fun main() {
    val nums = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val heapSort = heapSort(nums)
    heapSort.forEach { println(it) }
}

fun heapSort(nums: Array<Int>): Array<Int> {

    val arr = Array(nums.size) { 0 }
    var size = 0

    fun swap(a: Int, b: Int) {
        arr[a] = arr[b].also { arr[b] = arr[a] }
    }

    fun heapInsert(index: Int) {
        size++
        arr[size - 1] = index
        var i = size - 1
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(i, (i - 1) / 2)
            i = (i - 1) / 2
        }
    }

    fun heapify(index: Int) {
        var l = index * 2 + 1
        var i = index
        while (l < size) {
            // 计算孩子节点中较大值
            val best = if (l + 1 < size && arr[l + 1] > arr[l]) l + 1 else l
            // 判断当前节点和孩子节点较大值
            if (arr[best] > arr[i]) {
                swap(best, i)
                i = best
                l = i * 2 + 1
            } else {
                break
            }
        }
    }

    for (i in nums.indices) {
        heapInsert(nums[i])
    }
    while (size > 0) {
        swap(0, --size)
        heapify(0)
    }
    return arr
}
