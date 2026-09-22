class Solution {
    
    private int cnt = 0;
    private int sum = 0;
    
    private void calculate(int index, int[] N, int target, int op){
        sum += N[index] * op;
        if(index == N.length-1){
            if(sum == target)
                cnt++;
        } else {
            dfs(index + 1, N, target);
        }
        sum -= N[index] * op;
    }
    
    private void dfs(int index, int[] N, int target){
        calculate(index, N, target, 1); // 양수
        calculate(index, N, target, -1); // 음수
    }
    
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target);
        return cnt;
    }
}