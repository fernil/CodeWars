package mobilePhone;

import java.util.ArrayList;
import java.util.HashMap;

public class Kata {	
	public static char asciinum(int num) {
		HashMap<Integer, Integer> mob = new HashMap<Integer, Integer>();
		mob.put(0, 32); 
		mob.put(2, 97);
		mob.put(3, 100);
		mob.put(4, 103);
		mob.put(5, 106);
		mob.put(6, 109);
		mob.put(7, 112);
		mob.put(8, 116);
		mob.put(9, 119);
		mob.put(1, 46);
		mob.put(11, 44);
		mob.put(111, 63);
		mob.put(1111, 33);
		int number = num;

		if (number != 1 && number != 11 && number != 111 && number != 1111) {
			if (number > 10) {
				int numOfClicks = 0;
				while (number > 10) {
					number /= 10;
					numOfClicks++;
				}
				return (char) (mob.get(num % 10) + numOfClicks);
			}
		}
		return (char) (int) (mob.get(num));
	}

	public static char withStar(String s) {
		switch (s) {
		case "*":
			return (char) (39);
		case "**":
			return '-';

		case "***":
			return '+';

		case "****":
			return '=';
		case "#":
			return '#';   
		case "a":
			return '1';  
		case "b":
			return '2';
		case "c":
			return '3';
		case "d":
			return '4';		
		case "e":
			return '5';
		case "f":
			return '6';
		case "g":
			return '7';
		case "h":
			return '8';
		case "i":
			return '9';
		case "z":
			return '0';
		default: {
			return asciinum(Integer.parseInt(s));
		}
		}
	}

	public static String sendMessage(String message) {
		String sms = "";
		char[] s = numMes(message).toCharArray();
		String doListy = "";
		ArrayList<String> liczby = new ArrayList<String>();
		char z = s[0];
		for (int i = 0; i < s.length; i++) {

			if (z == s[i]) {
				doListy += s[i];
				z = s[i];
			} else if (z != s[i]) {
				liczby.add(doListy);
				z = s[i];
				doListy = "";
				doListy += z;
			}
		}
		liczby.add(doListy);

		for (int i = 0; i < liczby.size(); i++) {
			if (liczby.get(i).equals(" ")) {
				liczby.remove(i);
			}
		}
		for (String g : liczby) {
			sms = sms + withStar(g);
		}
		
		return sms;
	}
	
	public static String mes(String sms) {
		String n=sendMessage(sms);
		String[] stList=n.split("#");
		String retMes="";
		for(int i=0;i<stList.length;i++) {
			if(i%2!=0) {
				retMes+=stList[i].toUpperCase();
			}else retMes+=stList[i];
				
		}
		
		return retMes;
		
	}
	public static String numMes(String mess) {
		char[] ch=mess.toCharArray();
		ArrayList<Character> arr=new ArrayList<>();
	
		for(char c:ch) {
			arr.add(c);			
		}
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)=='-') {			
				arr.set(i-1,numMap(Integer.parseInt(String.valueOf(arr.get(i-1)+""))));
				arr.remove(i);
			}
		}String ret="";
		for(char z:arr) {
			ret+=z;
		}
		return  ret;		
		
	}
	public static char numMap(int num) {
		HashMap<Integer, Character> map=new HashMap<>();
		map.put(0, 'z');
		map.put(1, 'a');
		map.put(2, 'b');
		map.put(3, 'c');
		map.put(4, 'd');
		map.put(5, 'e');
		map.put(6, 'f');
		map.put(7, 'g');
		map.put(8, 'h');
		map.put(9, 'i');
	
	return  map.get(num);
	}


}
