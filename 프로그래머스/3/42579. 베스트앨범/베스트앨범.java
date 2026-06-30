import java.util.*;


class Solution {

    private Map<String, List<int[]>> genreSongs;
    private Map<String, Integer> genresTotalPlays;
    
    public Solution(){
        genreSongs = new HashMap<>();
        genresTotalPlays = new HashMap<>();
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르별 맵 정리
        for(int i=0; i<genres.length; i++){
            if(!genreSongs.containsKey(genres[i])){
                genreSongs.put(genres[i], new ArrayList<>());
            }
            // {인덱스, 재생횟수로 저장}
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
        
        List<String> sortedGenres = new ArrayList<String>(genresTotalPlays.keySet());

        Collections.sort(sortedGenres, new Comparator<String>() {
            @Override
            public int compare(String g1, String g2) {
                int total1 = genresTotalPlays.get(g1);
                int total2 = genresTotalPlays.get(g2);
                return total2 - total1;
            }
        });
        
        List<Integer> answer = new ArrayList<>();
        for(String gen : sortedGenres){
            List<int[]> temp = genreSongs.get(gen);
            
            Collections.sort(temp, new Comparator<int[]>() {
                @Override
                public int compare(int a[], int b[]){
                    if(a[1] == b[1]){
                        return a[0] - b[0];
                    } else {
                        return b[1] - a[1];
                    }
                }
            });
            
            for(int i=0; i<Math.min(2,temp.size()); i++)
                answer.add(temp.get(i)[0]);
        }
        
        int[] result = new int[answer.size()];
        for(int i=0; i<answer.size(); i++)
            result[i] = answer.get(i);
        
        return result;
    }
}