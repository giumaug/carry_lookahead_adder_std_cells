import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.math.BigDecimal;

public class Validator {

	public static void main(String[] args) {
       	BigDecimal[] v_t = new BigDecimal[9000];
		BigDecimal[] v_s1 = new BigDecimal[9000];
		BigDecimal[] v_s2 = new BigDecimal[9000];
		BigDecimal[] v_s3 = new BigDecimal[9000];
		BigDecimal[] v_s4 = new BigDecimal[9000];
		BigDecimal[] v_co = new BigDecimal[9000];

		BigDecimal[] v_e_s1 = new BigDecimal[1024];
		BigDecimal[] v_e_s2 = new BigDecimal[1024];
		BigDecimal[] v_e_s3 = new BigDecimal[1024];
		BigDecimal[] v_e_s4 = new BigDecimal[1024];
		BigDecimal[] v_e_co = new BigDecimal[1024];
		int i = 0; 
		int z = 0;

		int a,b;
		String out;
		for (int i0 = 0; i0 < 2; i0++) {
			for (int i1 = 0; i1 < 2; i1++) {
				for (int i2 = 0; i2  < 2; i2++) {
					for (int i3 = 0; i3  < 2; i3++) {
						for (int i4 = 0; i4 < 2; i4++) {
							for (int i5 = 0; i5 < 2; i5++) {
								for (int i6 = 0; i6 < 2; i6++) {
									for (int i7 = 0; i7 < 2; i7++) {
										for (int i8 = 0; i8 < 2; i8++) {
											a = (i8 * 1) + (i6 * 2) + (i4 * 4) + (i2 * 8);
											b = (i7 * 1) + (i5 * 2) + (i3 * 4) + (i1 * 8);
											out = Integer.toBinaryString(a + b + i0);
											out = String.format("%5s", out).replaceAll(" ", "0");
											v_e_s1[i] = BigDecimal.valueOf(out.charAt(4) - 48);
											v_e_s2[i] = BigDecimal.valueOf(out.charAt(3) - 48);
											v_e_s3[i] = BigDecimal.valueOf(out.charAt(2) - 48);
											v_e_s4[i] = BigDecimal.valueOf(out.charAt(1) - 48);
											v_e_co[i] = BigDecimal.valueOf(out.charAt(0) - 48);

											System.out.println("i = " + i);
											System.out.println("a = " + a);
											System.out.println("b = " + b);
											System.out.println("i0 = " + i0);
											System.out.println("out = " + (a + b + i0));
											System.out.println(v_e_co[i] + " " + 
                    						v_e_s4[i] + " " +
                        					v_e_s3[i] + " " +
                        					v_e_s2[i] + " " +
                        					v_e_s1[i]);
											i++;
										}
									}
								}
							}
						}
					}
				}
			}
		}
					

		i = 0;
		try {
			Scanner scanner = new Scanner(new File("simout.out"));
			while (scanner.hasNextLine() && !scanner.nextLine().equals("Values:"));
			while (scanner.hasNextLine()) {
				String l1 = scanner.nextLine();
				l1 = (l1.split("\t"))[1];
				v_t[i] = new BigDecimal(l1);
				String l2 = scanner.nextLine();
				l2 = (l2.split("\t"))[1];
				v_s1[i] = new BigDecimal(l2);
				String l3 = scanner.nextLine();
				l3 = (l3.split("\t"))[1];
				v_s2[i] = new BigDecimal(l3);
				String l4 = scanner.nextLine();
 				l4 = (l4.split("\t"))[1];
				v_s3[i] = new BigDecimal(l4);
				String l5 = scanner.nextLine();
				l5 = (l5.split("\t"))[1];
				v_s4[i] = new BigDecimal(l5);
				String l6 = scanner.nextLine();
				l6 = (l6.split("\t"))[1];
				v_co[i] = new BigDecimal(l6);
				String l7 = scanner.nextLine();
		
//				System.out.println("v_t = " + v_t[i]);
//				System.out.println("i = " + i);
//				System.out.println("11 = " + l1);
//				System.out.println(v_s1[i]);
//				System.out.println(v_s2[i]);
//				System.out.println(v_s3[i]);
//				System.out.println(v_s4[i]);
//				System.out.println(v_co[i]);
				i++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		BigDecimal index = new BigDecimal("400E-12");
		boolean done = false;
		int passed = 0;
		i = 0;
		z = 0;
	
		int lastCaught = 0;

		while (!done && v_t[z] != null) {
			//System.out.println("zz = " +z);
			if (v_t[z].compareTo(index) >= 0 && v_t[z].compareTo(index.add(new BigDecimal("20E-12"))) <=0) {
				BigDecimal val1 = v_s1[z];
				BigDecimal low1 = v_e_s1[i].multiply(new BigDecimal("1.8")).subtract(new BigDecimal("10E-3"));
				BigDecimal high1 = v_e_s1[i].multiply(new BigDecimal("1.8")).add(new BigDecimal("10E-3"));

				BigDecimal val2 = v_s2[z];
				BigDecimal low2 = v_e_s2[i].multiply(new BigDecimal("1.8")).subtract(new BigDecimal("10E-3"));
				BigDecimal high2 = v_e_s2[i].multiply(new BigDecimal("1.8")).add(new BigDecimal("10E-3"));

				BigDecimal val3 = v_s3[z];
				BigDecimal low3 = v_e_s3[i].multiply(new BigDecimal("1.8")).subtract(new BigDecimal("10E-3"));
				BigDecimal high3 = v_e_s3[i].multiply(new BigDecimal("1.8")).add(new BigDecimal("10E-3"));

				BigDecimal val4 = v_s4[z];
				BigDecimal low4 = v_e_s4[i].multiply(new BigDecimal("1.8")).subtract(new BigDecimal("10E-3"));
				BigDecimal high4 = v_e_s4[i].multiply(new BigDecimal("1.8")).add(new BigDecimal("10E-3"));

				BigDecimal val5 = v_co[z];
				BigDecimal low5 = v_e_co[i].multiply(new BigDecimal("1.8")).subtract(new BigDecimal("10E-3"));
				BigDecimal high5 = v_e_co[i].multiply(new BigDecimal("1.8")).add(new BigDecimal("10E-3"));


				if (val1.compareTo(low1) >=0 && val1.compareTo(high1) <=0 &&
					val2.compareTo(low2) >=0 && val2.compareTo(high2) <=0 &&
					val3.compareTo(low3) >=0 && val3.compareTo(high3) <=0 &&
					val4.compareTo(low4) >=0 && val4.compareTo(high4) <=0 &&
					val5.compareTo(low5) >=0 && val5.compareTo(high5) <=0 ) {
						passed++;
				} else {
					System.out.println("Error a i" + i);
					System.out.println("time = " + v_t[z]);
					System.out.println("val1 = " + val1);
					System.out.println("low1 = " + low1);
					System.out.println("high1 = " + high1);

					System.out.println("val2 = " + val2);
					System.out.println("low2 = " + low2);
					System.out.println("high2 = " + high2);

					System.out.println("val3 = " + val3);
					System.out.println("low3 = " + low3);
					System.out.println("high3 = " + high3);

					System.out.println("val4 = " + val4);
					System.out.println("low4 = " + low4);
					System.out.println("high4 = " + high4);

					System.out.println("val5 = " + val5);
					System.out.println("low5 = " + low5);
					System.out.println("high5 = " + high5);
					break;
				}
				index = index.add(new BigDecimal("400E-12"));
				lastCaught = z;
				i++;
			}
			z++;
		}
		System.out.println("z = " + z);
		System.out.println("i = " + i);
		System.out.println("passed = " + passed);
	}
}
