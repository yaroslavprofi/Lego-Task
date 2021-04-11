import java.util.*
import kotlin.collections.ArrayList

const val ALPHABET_SIZE = 26
val graph = arrayListOf<ArrayList<Boolean>>()
var used: BooleanArray = BooleanArray(ALPHABET_SIZE) { false }

fun dfs(x: Int, y: Int): Boolean {
    if (x == y) {
        return true
    }
    if (used[x]) {
        return false
    }
    used[x] = true
    for (i in 0 until ALPHABET_SIZE) {
        if (graph[x][i]) {
            if (dfs(i, y)) {
                return true
            }
        }
    }
    return false
}

fun reachable(x: Int, y: Int): Boolean {
    used = BooleanArray(ALPHABET_SIZE) { false }
    return dfs(x, y)
}

fun check(x: Int, y: Int): Boolean {
    return reachable(x, y) && reachable(y, x)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n: Int = scanner.nextLine().toInt()
    val surnames = arrayListOf<String>()
    for (i in 0 until n) {
        surnames.add(scanner.nextLine())
    }
    for (i in 0 until ALPHABET_SIZE) {
        graph.add(arrayListOf())
        for (j in 0 until ALPHABET_SIZE) {
            graph[i].add(false)
        }
    }
    for (i in 0..99) {
        for (j in 0 until n) {
            for (k in j + 1 until n) {
                if (i < surnames[j].length && i < surnames[k].length) {
                    graph[surnames[j][i] - 'a'][surnames[k][i] - 'a'] = true
                }
            }
        }
    }
    val res = arrayListOf<Int>()
    val answer = arrayListOf<Char>()
    for (i in 0 until ALPHABET_SIZE) {
        res.add(26)
        answer.add('a')
        for (j in 0 until ALPHABET_SIZE) {
            if (j != i) {
                if (reachable(i, j)) {
                    if (reachable(j, i)) {
                        println("Impossible")
                        return
                    }
                    res[i]--
                }
            }
        }
    }
    var temp = 0
    for (i in res.distinct().sorted()) {
        for (j in 0 until ALPHABET_SIZE) {
            if (res[j] == i) {
                answer[j] = 'a' + temp
                temp++
            }
        }
    }
    for (char in answer) {
        print(char)
    }
}