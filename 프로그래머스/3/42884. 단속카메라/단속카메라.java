import java.util.Arrays;

public class Solution {
    public int solution(int[][] routes){
        int len = routes.length;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1])); // 도착지점 기반
        int cameraPosition = routes[0][1]; // 끝위치 먼저 설치
        int camera = 1; // 하나 우선 설치

        for(int i = 0; i<len; i++){
            if(routes[i][0] > cameraPosition){ // 만약 다음 index의 startPos가 카메라 범위안에 들어오지 않는다면
                camera++; // 신규 설치
                cameraPosition = routes[i][1];
            }
        }
        return camera;
    }
}
