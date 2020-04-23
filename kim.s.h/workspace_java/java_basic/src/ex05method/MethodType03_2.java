package ex05method;

import java.util.Scanner;

/*
연습문제] 사용자로부터 2~9사이의 숫자중 2개를 입력받아
그에 해당하는 구구단을 출력하는 메소드를 작성하시오.
무조건 첫번째 입력받는수가 작아야한다. 
입력예]
	첫번째숫자 : 3
	두번째숫자 : 12
	3*1=3 3*2=6........
	........
	...................6*9=54
메소드명 : inputGugudan(int sNum, int eNum)
 */
public class MethodType03_2 {

	static void inputGugudan(int sNum, int eNum){		
		for(int su=1 ; su<=9 ; su++) {
			for(int dan=sNum ; dan<=eNum ; dan++) {
				System.out.print(dan +"*"+ su +"="+ 
						(dan*su)+" ");
			}
			//한줄 출력후 줄바꿈 처리
			System.out.println();
		}		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("구구단의 시작숫자를 입력:");
		int s = scanner.nextInt();
		System.out.print("구구단의 종료숫자를 입력:");
		int e = scanner.nextInt();
		inputGugudan(s, e);
	}
}
