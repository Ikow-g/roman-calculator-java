package roman_calculator;

import java.util.*;
import java.io.*;

//kelas romawi
class romawi{
	String a;
	int b;
	
	public romawi(String huruf, int value) {
		this.a = huruf;
		this.b = value;
	}
}

//comparator untuk membandingkan berdasarkan value
class Compare{
	static void compare(ArrayList<romawi> arr)
    {
        Collections.sort(arr, new Comparator<romawi>()
        {
            @Override public int compare(romawi p1, romawi p2)
            {
                return p2.b - p1.b;
            }
        });
    }
}

//main class nama filenya Main.java
public class Main {
	//nilai romawi
	static int nilaiRomawi(char r)
	{
	    if (r == 'I')
	        return 1;
	 
	    if (r == 'V')
	        return 5;
	 
	    if (r == 'X')
	        return 10;
	 
	    if (r == 'L')
	        return 50;
	 
	    if (r == 'C')
	        return 100;
	 
	    if (r == 'D')
	        return 500;
	 
	    if (r == 'M')
	        return 1000;
	 
	    return -1;
	}
	
	//memberi nilai romawi untuk di sort nanti
	static int memberiValue(String str)
	{
		int res = 0;
		
	    for(int i = 0; i < str.length(); i++)
	    {
	        int s1 = nilaiRomawi(str.charAt(i));
	        if (i + 1 < str.length())
	        {
	            int s2 = nilaiRomawi(str.charAt(i + 1));
	 
	            //membandingkan
	            if (s1 >= s2)
	            {
	                //Nilai di index sekarang lebih besar dari
	            	//index selanjutnya
	                res = res + s1;
	            }
	            else
	            {
	            	//Nilai di index sekarang lebih kecil dari
	            	//index selanjutnya
	                res = res + s2 - s1;
	                i++;
	            }
	        }
	        else
	        {
	            res = res + s1;
	        }
	    }
	    return res;
	}
	
	//method 1 substractive notation to additive
	public static String subsToAddi(String input) {
		if(input.contains("IV")) {
			return input.replace("IV", "IIII");
		}else if(input.contains("IX")) {
			return input.replace("IX", "VIIII");
		}else if(input.contains("XL")) {
			return input.replace("XL", "XXXX");
		}else if(input.contains("XC")) {
			return input.replace("XC", "LXXXX");
		}else if(input.contains("CD")) {
			return input.replace("CD", "CCCC");
		}else if(input.contains("CM")) {
			return input.replace("CM", "DCCCC");
		}
		return input;
	}
	
	//method 2 combine
	public static String combine(String a, String b) {
		String input = null;
		input = a+b;
		return input;
	}
	
	//method 3 sorting 
	public static ArrayList<romawi> sortArr(String[] arr, int n)
	{
	     
	    // Menyimpan huruf romawi dengan nilai
		// sesuai dengan hurufnya
	    ArrayList<romawi> array = new ArrayList<romawi>();
	 
	    //tiap simbol diberi nilai berdasarkan niali romawinya
	    for(int i = 0; i < n; i++)
	    {
	    	array.add(new romawi(arr[i],memberiValue(arr[i])));
	    }
	    //sort array list berdasarkan nilai dari besar ke kecil
	    Compare obj = new Compare();
	    obj.compare(array);
	 
	    //cek romawinya berdasar value
//	    for(int i = 0; i < array.size(); i++){
//	        System.out.print(array.get(i).a);
//		}
	    return array;
	}
	
	//method 4 simplify
	public static String simplify(String str) {
		if(str.contains("IIIII")) {
			return str.replace("IIIII", "V");
		}else if(str.contains("XXXXX")) {
			return str.replace("XXXXX", "L");
		}else if(str.contains("CCCCC")){
			return str.replace("CCCCC", "D");
		}else if(str.contains("VV")) {
			return str.replace("VV", "X");
		}else if(str.contains("LL")) {
			return str.replace("LL", "C");
		}else if(str.contains("DD")) {
			return str.replace("DD", "M");
		}
		return str;
	}
	
	//method 5 additive to substractive
	public static String addiToSubs(String input) {
		if(input.contains("IIII")) {
			return input.replace("IIII", "IV");
		}else if(input.contains("VIIII")) {
			return input.replace("VIIII", "IX");
		}else if(input.contains("LXXXX")) {
			return input.replace("LXXXX", "XC");
		}else if(input.contains("XXXX")) {
			return input.replace("XXXX", "XL");
		}else if(input.contains("DCCCC")) {
			return input.replace("DCCCC", "CM");
		}else if(input.contains("CCCC")) {
			return input.replace("CCCC", "CD");
		}
		return input;
	}
	
	//turn string to array to arraylist to sort to string
	public static String turn(String arr) {
		int length = arr.length();
		String[] bilRom = arr.split("");
		
		ArrayList<romawi> temp = sortArr(bilRom,length);
		String str = "";
		for(int i=0;i<temp.size();i++) {
			str += temp.get(i).a;
		}
		arr = str;
		
		return arr;
	}
	
	
	//main function
	public static void main(String[]  args) {
		String result;
		Scanner read = new Scanner(System.in);
		System.out.println("Input :");
		System.out.print("1st Number : ");
		String input1 = read.nextLine();
		System.out.print("2nd Number : ");
		String input2 = read.nextLine();
		
		//save inputan untuk bagian step
		String n1 = input1;
		String n2 = input2;
		//step1
		String step1n1 ="";
		String step1n2 ="";
		//step2
		String step2combine ="";
		//step3 sort
		String step3sort = "";
		//step 4 simplify
		//deklarasi dibawah setelah sorting step3
		//step 5
		String step5="";
		
		//variabel counter deteksi step 1, 4, dan 5
		int det1 = 0;
		int det4 = 0;
		int det5 = 0;
		
		//jadiin additive dari substract klo ada ====================
		
		//cek input1 sampai ga ada
		int flagcek1=1;
		while(flagcek1==1) {
			if(input1.contains("IV")
				||input1.contains("IX")
				||input1.contains("XL")
				||input1.contains("XC")
				||input1.contains("CD")
				||input1.contains("CM")) {
				input1 = subsToAddi(input1);det1++;
				continue;
			}else {
				flagcek1=0;
				step1n1 = input1;//save step1
				break;
			}
		}
		//cek input2 sampai ga ada
		int flagcek2=1;
		while(flagcek2==1) {
			if(input2.contains("IV")
					||input2.contains("IX")
					||input2.contains("XL")
					||input2.contains("XC")
					||input2.contains("CD")
					||input2.contains("CM")) {
					input2 = subsToAddi(input2);det1++;
					continue;
				}else {
					flagcek2=0;
					step1n2 = input2;//save step1
					break;
				}
		}
		
		
		//gabungin ===================
		result = combine(input1,input2);
		step2combine = result;//save step2
		
		//sort highest to lowest ============================
		//dimasukkan kedalam arraylist agar bisa melihat nilai
		//dari masing - masing simbol
		int length = result.length();
		String[] bilRom;
		bilRom = result.split("");
		ArrayList<romawi> temp = sortArr(bilRom,length);
		
		//dijadikan ke string
		String str = "";
		for(int i=0;i<temp.size();i++) {
			str += temp.get(i).a;
		}
		
		step3sort = str;//save step3
		
		//save step4 simplify
		int len4 = step3sort.length();
		String[] from = new String[len4];
		String[] to = new String[len4];
		String[] get = new String[len4];
		
		//simplify ========================
		int flag=1;
		String temp2= str;
		int indexsimp=0;//save itungan index step4
		//cek sampai ga ada
		while(flag==1) {
			if(temp2.contains("IIIII")){
				from[indexsimp]="IIIII";
				to[indexsimp]="V";
				temp2 = simplify(temp2);
				get[indexsimp] = temp2;
				indexsimp++;det4++;
				temp2 = turn(temp2);
				continue;
			}
			else if(temp2.contains("XXXXX")){
				from[indexsimp]="XXXXX";
				to[indexsimp]="L";
				temp2 = simplify(temp2);
				get[indexsimp] = temp2;
				indexsimp++;det4++;
				temp2 = turn(temp2);
				continue;
			}
			else if(temp2.contains("CCCCC")){
				from[indexsimp]="CCCCC";
				to[indexsimp]="D";
				temp2 = simplify(temp2);
				get[indexsimp] = temp2;
				indexsimp++;det4++;
				temp2 = turn(temp2);
				continue;
			}
			else if(temp2.contains("VV")){
				from[indexsimp]="VV";
				to[indexsimp]="X";
				temp2 = simplify(temp2);
				get[indexsimp] = temp2;
				indexsimp++;det4++;
				temp2 = turn(temp2);
				continue;
			}
			else if(temp2.contains("LL")){
				from[indexsimp]="LL";
				to[indexsimp]="C";
				temp2 = simplify(temp2);
				get[indexsimp] = temp2;
				indexsimp++;det4++;
				temp2 = turn(temp2);
				continue;
			}
			else if(temp2.contains("DD")) {
				from[indexsimp]="DD";
				to[indexsimp]="M";
				temp2 = simplify(temp2);
				get[indexsimp] = temp2;
				indexsimp++;det4++;
				temp2 = turn(temp2);
				continue;
			}else {
				flag=0;
				break;
			}
		}
		
		//additive to subtractive ======================
		int flag2=1;
		//cek sampai ga ada
		while(flag2==1) {
			if(temp2.contains("IIII")
				||temp2.contains("VIIII")
				||temp2.contains("LXXXX")
				||temp2.contains("XXXX")
				||temp2.contains("DCCCC")
				||temp2.contains("CCCC")) {
				temp2 = addiToSubs(temp2);det5++;
				continue;
			}else {
				flag2=0;
				break;
			}
		}
		step5 = temp2; //save step5
		
		System.out.println("\nResult	:");
		System.out.println(n1+" + "+n2+" = "+ temp2);
		
		//print steps
		System.out.println("\nSteps :");
		System.out.println("Input : "+n1+" + "+n2);
		int nomor=6;
		if(det1==0 && det4==0 && det5==0) {
			nomor=3;
		}else if(det1==0 && det4==0) {
			nomor=4;
		}else if(det1==0 && det4!=0) {
			nomor=5;
		}else if(det4==0 && det1!=0){
			nomor=5;
		}
		
		for(int loop=1;loop<=nomor;loop++) {
			if(loop==1) {
				if(det1!=0) {
					System.out.println("\n   1. Convert any substractive notation to additive notation to get:");
					System.out.println("      "+ step1n1 +" + "+step1n2);
				}else {
					System.out.println("\n   1. Combine the two numerals into one to get:");
					System.out.println("      "+ step2combine);
				}
			}else if(loop==2) {
				if(det1!=0) {
					System.out.println("\n   2. Combine the two numerals into one to get:");
					System.out.println("      "+ step2combine);
				}else {
					System.out.println("\n   2. Sort the symbols highest to lowest to get:");
					System.out.println("      "+ step3sort);
				}
			}else if(loop==3) {
				if(det1!=0) {
					System.out.println("\n   3. Sort the symbols highest to lowest to get:");
					System.out.println("      "+ step3sort);
				}else if(det4!=0){
					System.out.println("\n   3. Simplify by replacing symbol, from right to left");
					for(int i =0; i<indexsimp;i++) {
						System.out.printf("      Replace \"%s\" with \"%s\" to get\n",from[i],to[i]);
						System.out.printf("      %s\n",get[i]);
					}
				}else if(det1==0 && det4==0){
					if(det5!=0) {
						System.out.println("\n   3. Convert any additive notation back to subtractive notation to get:");
						System.out.println("      "+step5);
					}else {
						System.out.println("\n   3. Answer:");
						System.out.println("      "+step5);
					}
				}
			}else if(loop==4) {
				if(det4!=0 && det1!=0) {
					System.out.println("\n   4. Simplify by replacing symbol, from right to left");
					for(int i =0; i<indexsimp;i++) {
						System.out.printf("      Replace \"%s\" with \"%s\" to get\n",from[i],to[i]);
						System.out.printf("      %s\n",get[i]);
					}
				}else if(det1!=0 && det4==0){
					if(det5!=0) {
						System.out.println("\n   4. Convert any additive notation back to subtractive notation to get:");
						System.out.println("      "+step5);
					}else {
						System.out.println("\n   4. Answer:");
						System.out.println("      "+step5);
					}
				}
			}else if(loop==5) {
				if(det1!=0 && det4!=0) {
					System.out.println("\n   5. Convert any additive notation back to subtractive notation to get:");
					System.out.println("      "+step5);
				}else {
					System.out.println("\n   5. Answer:");
					System.out.println("      "+step5);
				}
			}else if(loop==6) {
				System.out.println("\n   6. Answer:");
				System.out.println("      "+step5);
			}
		}
		
		System.out.println("\n2440099946\nMuh. Rizal Sakti Djatmieka");
	}
}
