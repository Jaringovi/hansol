package boj.boj1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 15972 KB
// 140 MS
public class BOJ후보추천하기 {
	static StringTokenizer tokens;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		List<Integer> frame = new ArrayList<>(); //사진틀
		int n = Integer.parseInt(input.readLine());
		int recommend = Integer.parseInt(input.readLine()); //추천수
		tokens = new StringTokenizer(input.readLine());
		int[] recommends = new int[recommend];

		for(int i=0; i<recommend; i++) {
			recommends[i] = Integer.parseInt(tokens.nextToken());
		}

		int student[] = new int[101]; //최대 학생 수까지
		for(int i=0; i<recommend; i++) {
			if(student[recommends[i]]==0) { //현재 후보자가 사진틀에 없을 때
				if(frame.size()<n) {
					frame.add(recommends[i]);
					student[recommends[i]] ++;
				}
				else { //비어있는 사진틀이 없을 때
					int studentMin = 0;
					int studentVal=Integer.MAX_VALUE;
					int studentIdx=0;
					for(int j=0; j< frame.size(); j++) {
						int studentNum = frame.get(j);
						if(studentVal > student[studentNum]) {
							studentVal = student[studentNum];
							studentMin=studentNum;
							studentIdx=j;
						}
					}
					// 추천횟수가 가장 적은 학생의 가진 삭제
					student[studentMin]=0;
					frame.remove(studentIdx);
					frame.add(recommends[i]);
					student[recommends[i]]++;
				}
			}
			else { //사진 틀에 있을 때
				student[recommends[i]]++;
			}
		}
		//최종 후보 정렬
		frame.sort(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});

		for(int f: frame) {
			System.out.print(f +" ");
		}
	}
}
