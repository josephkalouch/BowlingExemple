import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bowling {

	
	public static List<String> result = new ArrayList<String>();
	
	
	public static void FillResult() {
		System.out.println("Put the list of frames result, seperated by space (you have to enter results for 12 frames)");
		Scanner sc = new Scanner(System.in);
		String Strresult = sc.nextLine();
		String []res = Strresult.split(" ");
		for (int i=0;i<res.length;i++) {
			if(!res[i].endsWith("/") && !res[i].endsWith("-") && !res[i].equals("x")) {
				System.out.println("Invalid input, Please make sure that all frames results ends with '-' or '/' or 'x'");
				break;
			}else {
		     	result.add(res[i]);
			}
		}
	}
	
	public static int CalculateFrameScrore(String res1,String res2,String res3) {
		int score = 0;
		if(res1.endsWith("-")) {
			String []num = res1.split("-");
			int number = Integer.parseInt(num[0]);
			score = score + number;
		}else {
			if(res1.endsWith("/")) {
				if(res2 != null) {
					String []num = {};
					if(res2.endsWith("/")) {
						num = res2.split("/");
					}
					if(res2.endsWith("-")) {
						num = res2.split("-");
					}
					if(res2.equals("x")) {
						num = null;
					}
					
				int number = 0;
				if(num != null) {
					number = Integer.parseInt(num[0]);
				}else {
					number = 0;
				}
				
				score = score + 10 + number;
				}
			}else {
				if(res1.equals("x")) {
					int score2 = 0;
					int score3 = 0;
					if(res2 != null && res3 != null) {
						
						//get number from res2
						String []num2 = {};
						if(res2.endsWith("/")) {
							num2 = res2.split("/");
						}
						if(res2.endsWith("-")) {
							num2 = res2.split("-");
						}
						if(res2.equals("x")) {
							num2 = null;
						}
						int number2 = 0;
						if(num2 != null) {
							number2 = Integer.parseInt(num2[0]);
						}
						else {
							number2 = number2 + 10;
						}
						score2 = score2 + number2;
						
						
						//get number from res3
						String []num3 = {};
						if(res3.endsWith("/")) {
							num3 = res3.split("/");
						}
						if(res3.endsWith("-")) {
							num3 = res3.split("-");
						}
						if(res3.equals("x")) {
							num3 = null;
							
						}
						int number3 = 0;
						if(num3 != null) {
							number3 = Integer.parseInt(num3[0]);
						}else {
							number3 = number3 + 10;
						}
						score3 = score3 +  number3;
						
					}
					score = 10 + score2 + score3;
				}
			}
		}
	
		return score;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Fscore = 0;
	    int temp;
		FillResult();
		if(result.size() != 12) {
			System.out.println("You have entered a wrong number of frames (different than 12), Please Reinput the results");
			FillResult();
		}
		
		
		
		for (int i = 0; i < 10 ; i++) {
			temp = CalculateFrameScrore(result.get(i),result.get(i+1),result.get(i+2));
			Fscore = Fscore + temp;
		}
		
		
		System.out.println("Your Score is : "+Fscore);	
        
	}

}
