def min_visible_sum(N, faces):
    A, B, C, D, E, F = faces
    
    # 주사위의 3개의 면이 보이는 경우
    three_face_min = min(A + B + C, A + C + E, A + E + D, A + D + B, F + B + C, F + C + E, F + E + D, F + D + B)
    
    # 주사위의 2개의 면이 보이는 경우
    two_face_min = min(A + B, A + C, A + D, A + E, F + B, F + C, F + D, F + E, B + C, C + E, E + D, D + B)
    
    # 주사위의 1개의 면이 보이는 경우
    one_face_min = min(A, B, C, D, E, F)
    
    if N == 1:
        return sum(faces) - max(faces)
    
    # 각 경우의 면 수 계산
    three_face_count = 4
    two_face_count = 4 * (N - 1) + 4 * (N - 2)
    one_face_count = 5 * N * N - (three_face_count * 3 + two_face_count * 2)
    
    # 총합 계산
    total_sum = (three_face_min * three_face_count) + (two_face_min * two_face_count) + (one_face_min * one_face_count)
    
    return total_sum

# 입력 받기
N = int(input().strip())
faces = list(map(int, input().strip().split()))

# 결과 출력
print(min_visible_sum(N, faces))
