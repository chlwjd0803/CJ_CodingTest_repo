import java.util.*;

class Solution {
    private char[] ops;
    private int[] nums;

    private HashMap<Integer, int[]> cache = new HashMap<>();

    // end는 포함하지 않음
    private int[] slice(int start, int end){

        int key = start * 1000 + end;

        if(cache.containsKey(key)){
            return cache.get(key);
        }

        // 하나 뿐이면 그냥 그 값을 최대 최소값으로 반환 (min, max)
        if((end-1) == start){
            cache.put(key, new int[] {nums[start], nums[start]});
            return cache.get(key);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=start+1; i<end; i++){
            // 부호 저장
            char op = ops[i-1];

            int[] left = slice(start, i);
            int[] right = slice(i, end);

            if(op == '+'){
                for(int l : left){
                    for(int r : right){
                        min = Math.min(min, l + r);
                        max = Math.max(max, l + r);
                    }
                }
            } else {
                for(int l : left){
                    for(int r : right){
                        min = Math.min(min, l - r);
                        max = Math.max(max, l - r);
                    }
                }
            }
        }

        cache.put(key, new int[] {min, max});
        return cache.get(key);
    }

    public int solution(String arr[]) {

        ops = new char[arr.length/2];
        nums = new int[arr.length/2 + 1];

        for (int i = 0; i < arr.length; i++) {
            if(i%2==0){
                nums[i/2] = Integer.parseInt(arr[i]);
            } else {
                ops[i/2] = arr[i].charAt(0);
            }
        }

        return slice(0, nums.length)[1];
    }
}