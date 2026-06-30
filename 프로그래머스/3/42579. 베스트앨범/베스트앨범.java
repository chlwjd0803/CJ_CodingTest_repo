import java.util.*;


class Solution {

    // Key는 장르, Value는 장르에 대한 {인덱스번호, 재생횟수}를 여러개 저장하고있는 List
    private Map<String, List<int[]>> genreSongs;

    // 장르별 총 재생횟수
    private Map<String, Integer> genresTotalPlays;
    
    public Solution(){
        genreSongs = new HashMap<>();
        genresTotalPlays = new HashMap<>();
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르별 맵 정리
        for(int i=0; i<genres.length; i++){

            // 해당 장르가 맵에 처음 추가되는 거라면
            if(!genreSongs.containsKey(genres[i])){
                // 반드시 List를 할당해줘야함
                genreSongs.put(genres[i], new ArrayList<>());
            }
            
            // 해시 값을 불러오고 단순히 {인덱스, 재생횟수로 저장} 로 저장
            genreSongs.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        // 장르별 재생횟수를 집계하기
        for(int i=0; i<genres.length; i++){
            if(genresTotalPlays.containsKey(genres[i])){
                genresTotalPlays.put(genres[i], genresTotalPlays.get(genres[i]) + plays[i]);
            } else {
                genresTotalPlays.put(genres[i], plays[i]);
            }
        }

        // 장르별로 가장 많이 재생된 순서로 정렬하기

        // 장르 이름이 들어간 String형 List를 선언
        List<String> sortedGenres = new ArrayList<String>(genresTotalPlays.keySet());

        // Comparator 익명함수를 이용한 정렬
        Collections.sort(sortedGenres, new Comparator<String>() {
            @Override
            public int compare(String g1, String g2) {
                // 각각 장르의 총 재생횟수 가져와서
                int total1 = genresTotalPlays.get(g1);
                int total2 = genresTotalPlays.get(g2);
                // 내림차순 정렬
                return total2 - total1;
            }
        });

        // 응답 List 할당
        List<Integer> answer = new ArrayList<>();
        // 내림차순 정렬된 장르별로 반복실행
        for(String gen : sortedGenres){
            // 해당 장르의 {인덱스번호, 재생횟수} 리스트 가져오기
            List<int[]> temp = genreSongs.get(gen);

            
            Collections.sort(temp, new Comparator<int[]>() {
                @Override
                public int compare(int a[], int b[]){
                    // 만약 재생횟수가 같다면 인덱스 번호의 오름차순으로
                    if(a[1] == b[1]){
                        return a[0] - b[0];
                    } else {
                        // 다르면 재생횟수의 내림차순으로
                        return b[1] - a[1];
                    }
                }
            });

            // 응답에 원소 추가하기, 최대 2개의 음악만 삽입하므로 min 2 조건 필요
            for(int i=0; i<Math.min(2,temp.size()); i++)
                answer.add(temp.get(i)[0]);
        }
        // 원시 배열에 붙여넣기
        int[] result = new int[answer.size()];
        for(int i=0; i<answer.size(); i++)
            result[i] = answer.get(i);
        
        return result;
    }
}
