package cn.edu.ustc.chinatsp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class tsp {
	public static void main(String[] args) throws IOException {
		double mindis = 1000000000;
		int maybetrip[] = new int[280];
		int sequence[] = new int[280];
		while (true) {
			FileReader fileReader = new FileReader("tsp280.txt");
			BufferedReader buf = new BufferedReader(fileReader);
			String readLine = "";
			String[] myArray = new String[3000];
			int[] no = new int[3000];
			double[] x = new double[3000];
			double[] y = new double[3000];
			for (int i = 0; (readLine = buf.readLine()) != null; i++) {
				myArray[i] = readLine;
				no[i] = Integer.parseInt(myArray[i].substring(0, 3).trim());
				x[i] = Double.valueOf(myArray[i].substring(4, 7).trim());
				y[i] = Double.valueOf(myArray[i].substring(8, 11).trim());
			}

			for (int p = 1; p <= 1; p++) {
				Random random = new Random();
				double orix = x[279];
				double oriy = y[279];
				int m = random.nextInt(279);
				double dis = Math.sqrt(Math.pow(x[279] - x[m], 2)
						+ Math.pow(y[279] - y[m], 2));
				maybetrip[0] = 280;
				maybetrip[1] = no[m];
				for (int i = 0, r = 278; i <= 277; i++, r--) {
					int n = random.nextInt(r);
					x[m] = x[r];
					y[m] = y[r];
					no[m] = no[r];
					dis = dis
							+ Math.sqrt(Math.pow(x[r] - x[n], 2)
									+ Math.pow(y[r] - y[n], 2));
					m = n;
					maybetrip[i + 2] = no[n];
				}
				dis = dis
						+ Math.sqrt(Math.pow(orix - x[0], 2)
								+ Math.pow(oriy - y[0], 2));
				if (mindis >= dis) {
					mindis = dis;
					for (int i = 0; i <= 279; i++)
						sequence[i] = maybetrip[i];
				}
				for (int i = 0; i <= 279; i++)
					System.out.print(sequence[i] + "; ");
				System.out.print("distance:" + mindis);
				System.out.println();
			}
		}
	}
}
