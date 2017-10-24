package hackerrank.algorithm;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * [Facebook Question]
 * 
 * Given a matrix of N * M, given the coordinates (x, y) present in a matrix,
 * Find the number of paths that can reach (0, 0) from the (x, y) points with k
 * steps (requires exactly k, k> = 0) From each point you can go up, down, left
 * and right in four directions.
 * 
 * For example, the following matrix:
 * <p>
 * ----------
 * <p>
 * 0 0 0 0 0
 * <p>
 * 0 0 0 0 0
 * <p>
 * 0 0 0 0 0
 * <p>
 * 0 0 0 0 0
 * <p>
 * (x, y) = (1, 1), k = 2, the output is 2
 * 
 * 
 * @author Ray LI
 * @date Oct 25, 2017
 * @contact ray@daocha.me
 */
public class FindPaths {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] cmd = input.split(" ");
		int x = Integer.parseInt(cmd[0]);
		int y = Integer.parseInt(cmd[1]);
		int k = Integer.parseInt(cmd[2]);

		System.out.println("Starting calculating");

		final int w = 10, h = 10;

		LinkedList<Path> allPaths = new LinkedList<Path>();
		findPath(allPaths, x, y, k, w, h);
		int count = 0;
		// check how many attempts contain the case that last step stops at the
		// target point(x,y)
		for (Path path : allPaths) {
			if (path.footprints.getLast().getKey() == x && path.footprints.getLast().getValue() == y) {
				count++;
				System.out.println(path.printFootprints());
			}
		}

		System.out.println("Paths=" + count);

	}

	// to store all the foot prints
	static class Path {
		LinkedList<Entry<Integer, Integer>> footprints = new LinkedList<Entry<Integer, Integer>>();
		int steps;

		public Path() {

		}

		public Path(int x, int y) {
			Entry<Integer, Integer> initial = new AbstractMap.SimpleEntry<Integer, Integer>(x, y);
			footprints.add(initial);
			steps = 0;
		}

		public String printFootprints() {
			String str = "";
			for (Entry<Integer, Integer> print : footprints) {
				str += "(" + print.getKey() + "," + print.getValue() + "), ";
			}
			return str;
		}

		public Path clone() {
			Path cl = new Path();
			cl.steps = this.steps;
			cl.footprints = new LinkedList<Entry<Integer, Integer>>();
			cl.footprints.addAll(footprints);
			return cl;
		}
	}

	/**
	 * start from (0,0) and try all the possible directions/combinations, until
	 * it reaches max steps and then stop.
	 */
	private static void findPath(LinkedList<Path> allPaths, int x, int y, int k, int w, int h) {
		LinkedList<Path> nextSteps = new LinkedList<Path>();
		nextSteps.add(new Path(0, 0));
		while (!nextSteps.isEmpty()) {
			Path path = nextSteps.poll();
			int currentX = path.footprints.getLast().getKey();
			int currentY = path.footprints.getLast().getValue();
			System.out.println("current step at: (" + currentX + "," + currentY + "), steps: " + path.steps);

			if (path.steps >= k) {
				// reach the max steps, stop.
				allPaths.add(path);
			} else {
				// try next steps (4 possible directions)
				if (currentX + 1 < w) {
					Path clPath = path.clone();
					clPath.steps++;
					Entry<Integer, Integer> nextPt = new AbstractMap.SimpleEntry<Integer, Integer>(currentX + 1,
							currentY);
					clPath.footprints.add(nextPt);
					nextSteps.add(clPath);
				}
				if (currentX - 1 >= 0) {
					Path clPath = path.clone();
					clPath.steps++;
					Entry<Integer, Integer> nextPt = new AbstractMap.SimpleEntry<Integer, Integer>(currentX - 1,
							currentY);
					clPath.footprints.add(nextPt);
					nextSteps.add(clPath);
				}
				if (currentY + 1 < h) {
					Path clPath = path.clone();
					clPath.steps++;
					Entry<Integer, Integer> nextPt = new AbstractMap.SimpleEntry<Integer, Integer>(currentX,
							currentY + 1);
					clPath.footprints.add(nextPt);
					nextSteps.add(clPath);
				}
				if (currentY - 1 >= 0) {
					Path clPath = path.clone();
					clPath.steps++;
					Entry<Integer, Integer> nextPt = new AbstractMap.SimpleEntry<Integer, Integer>(currentX,
							currentY - 1);
					clPath.footprints.add(nextPt);
					nextSteps.add(clPath);
				}
			}
		}
	}
}
