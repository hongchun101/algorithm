package leetcode

class Bitset(size: Int) {

    var set = IntArray((size + 31) / 32) { 0 }
    var size = size
    var zeros = size
    var ones = 0
    var reverse = false

    fun fix(idx: Int) {
        val index = idx / 32
        val bit = idx % 32
        if (!reverse) {
            if (set[index] and (1 shl bit) == 0) {
                zeros--
                ones++
                set[index] = set[index] or (1 shl bit)
            }
        } else {
            if (set[index] and (1 shl bit) != 0) {
                zeros--
                ones++
                set[index] = set[index] xor (1 shl bit)
            }
        }
    }

    fun unfix(idx: Int) {
        val index = idx / 32
        val bit = idx % 32
        if (!reverse) {
            if (set[index] and (1 shl bit) != 0) {
                zeros++
                ones--
                set[index] = set[index] xor (1 shl bit)
            }
        } else {
            if (set[index] and (1 shl bit) == 0) {
                zeros++
                ones--
                set[index] = set[index] or (1 shl bit)
            }
        }
    }

    fun flip() {
        reverse = !reverse
        val tmp = zeros
        zeros = ones
        ones = tmp
    }

    fun all(): Boolean {
        return ones == size
    }

    fun one(): Boolean {
        return ones > 0
    }

    fun count(): Int {
        return ones
    }

    override fun toString(): String {
        val builder = StringBuilder()
        run {
            var i = 0
            var k = 0
            var number: Int
            var status: Int
            while (i < size) {
                number = set[k]
                var j = 0
                while (j < 32 && i < size) {
                    status = (number shr j) and 1
                    status = status xor if (reverse) 1 else 0
                    builder.append(status)
                    j++
                    i++
                }
                k++
            }
        }
        return builder.toString()
    }

}
