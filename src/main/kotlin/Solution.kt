/**
 * 카펫
 * 8~5000 brown : 외각에 칠해진 격자의 갯수
 * 1~2,000,000 yellow : 내부에 있는 격자의 갯수
 * 가로길이 >= 세로 ....누워진 직사각형
 * 가로세로 크기를 구하여 배열을 리턴
 *
 * 200만 크기면 어느 수식이 필요할꺼같다. x --> brown을 기준으로생각하자
 * m+n =brown 일때 (m,n)-> (m-1)*(n-1) == yellow 경우를 찾아 리턴하자
 */

class Solution {

    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        var maps = mutableMapOf<Pair<Int,Int>,Int>()
        //m,n >> 3,4,5,6,7,8...
        //brown = 2*(m+n)-4
        //m + n = (brown+4)/2
        var n = 0
        for(m in 3..(brown+4)/2){
            n = (brown+4)/2 - m
            if(n<3) continue
            if(m>=n) {
                maps.put(Pair(m, n), (m - 2) * (n - 2))
            }
            else{
                maps.put(Pair(n, m), (m - 2) * (n - 2))
            }
        }
        maps.forEach{
            if(it.value==yellow)
            {
                answer = intArrayOf(it.key.first,it.key.second)
            }
        }
        return answer
    }
}

fun main(){
    var a = Solution()
    a.solution(10,2)//[4,3]
    a.solution(8,1)//[3,3]
    a.solution(24,24)//[8,6]
}