package hackerrank.algorithm;

import java.util.ArrayList;

/**
 * [Facebook Question]
 * 
 * You are in an infinite 2D grid where you can move in any of the 8 directions
 * :
 * 
 * (x,y) to (x+1, y), (x - 1, y), (x, y+1), (x, y-1), (x-1, y-1), (x+1,y+1),
 * (x-1,y+1), (x+1,y-1) 
 * 
 * You are given a sequence of points and the order in
 * which you need to cover the points. Give the minimum number of steps in which
 * you can achieve it. You start from the first point.
 * 
 * Example :
 * 
 * Input : [(0, 0), (1, 1), (1, 2)] Output : 2 It takes 1 step to move from (0,
 * 0) to (1, 1). 
 * 
 * It takes one more step to move from (1, 1) to (1, 2).
 * 
 * This question is intentionally left slightly vague. Clarify the question by
 * trying out a few cases in the “See Expected Output” section.
 * 
 * @author Ray LI
 * @date Oct 29, 2017
 * @contact ray@daocha.me
 */
public class FindMinimumPointMovement {
	
	 public static void main(String[] args) {
		String string = "(0, 0) (1, 1) (1, 2)";
		ArrayList<Integer> X = new ArrayList<Integer>();
		ArrayList<Integer> Y = new ArrayList<Integer>();
		String[] points = string.replaceAll(",\\s", ",").split(" ");
		for(int i = 0; i<points.length; i++) {
			String pt = points[i];
			String[] xy = pt.replaceAll("\\(|\\)|\\s", "").split(",");
			X.add(Integer.parseInt(xy[0]));
			Y.add(Integer.parseInt(xy[1]));
		}
		
		System.out.println(string + ", min steps:" + coverPoints(X,Y));
	 }
	
	 public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
	        if(X.size() <=1 || Y.size() <= 1){
	            return 0;
	        }
	        
	        int cur_x = X.get(0);
	        int cur_y = Y.get(0);
	        int sum_steps = 0;
	        for(int i = 1;i<X.size() && i<Y.size(); i++){
	            int tar_x = X.get(i);
	            int tar_y = Y.get(i);
	            
	            int x_steps = Math.abs(tar_x - cur_x);
	            int y_steps = Math.abs(tar_y - cur_y);
	            int steps = Math.max(x_steps, y_steps);
	            
	            sum_steps+= steps;
	            
	            cur_x = tar_x;
	            cur_y = tar_y;
	        }
	        
	        return sum_steps;
	    }
}
