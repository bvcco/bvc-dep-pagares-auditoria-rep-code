package com.deceval.auditoria.util.converter;

import java.util.Calendar;
/**
 * For testing purposes only
 * @author Johann Camilo Olarte Díaz.
 */
public class BaseConverter {
	
	// converts integer n into a base b string
    static String toString(int n, int base) {
       // special case
       if (n == 0) return "0";

       String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String s = "";
       while (n > 0) {
          int d = n % base;
          s = digits.charAt(d) + s;
          n = n / base;
       }
       return s;
    }

    static String toBinaryString(int n) { return toString(n,  2); }
    static String toHexString(int n)    { return toString(n, 16); }


    static void inputError(String s) {
        throw new RuntimeException("Input error with" + s);
    }

    // convert a String representing a base b integer into an int
    static int fromString(String s, int b) {
       int result = 0;
       int digit = 0;
       for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (c >= '0' && c <= '9')
             digit = c - '0';
          else if (c >= 'A' && c <= 'Z')
             digit = 10 + c - 'A';
          else inputError(s);

          if (digit < b) result = b * result + digit;
          else inputError(s);
       }
       return result;
    }

    static int fromBinaryString(String s) { return fromString(s,  2); }
    static int fromHexString(String s)    { return fromString(s, 16); }
    
    static String toStringAnna(String lastNumber){
    	int value=10000;
    	try{
    		value=Integer.parseInt(lastNumber);    		
    	}catch(Exception e){
    	}
    	
    	if(value<9999){
    		return ""+(value+1);
    	}else{
    		if(value==9999){
    			return "000A";
    		}
    		int valAnt=fromString(lastNumber, 36);
    		while(true){    		 
    		 String valAnna=toString(++valAnt, 36);
    		 try{    			 
    			 Integer.parseInt(valAnna);
    		 }catch(Exception e){
    			 return valAnna;
    		 }
    		}
    		 
    	}    	    	
    }

    // sample test client
    public static void main(String[] args) throws Exception{
        //int n = 1679615;
        /*String s = "101111";
        System.out.println(n +  ":  " + toBinaryString(n));
        System.out.println(s +  ":  " + fromBinaryString(s));
        System.out.println(n +  ":  " + toHexString(n));
        System.out.println();

        n = 2620;
        s = "0A3C";
        System.out.println(n +  ":  " + toBinaryString(n));
        System.out.println(s +  ":  " + fromHexString(s));
        System.out.println(n +  ":  " + toHexString(n));*/
        
    	//int maxValue = 1679616;
        
    	//First try
    	/*File mapeo1=new File("c:/mapeoTipo1.txt");
        BufferedWriter writer=new BufferedWriter(new FileWriter(mapeo1));
        System.out.println("Generando numeros base 36: "+Calendar.getInstance().getTime());
        for(int n=1;n<maxValue;n++){
        	String result=toString(n,36);
        	writer.write(StringUtils.leftPad(result, 4, "0")+"\n");        	
        	//System.out.println(StringUtils.leftPad(result, 4, "0"));    	    	
        }
        writer.close();
        System.out.println("Finalizado 36: "+Calendar.getInstance().getTime());
    	
        
        System.out.println("Generando numeros algoritmo Deceval: "+Calendar.getInstance().getTime());
        File mapeo2=new File("c:/mapeoTipo2.txt");
        BufferedWriter writer2=new BufferedWriter(new FileWriter(mapeo2));
        String result="0000";	
        for(int n=1;n<maxValue;n++){
        	result=toStringAnna(result);
        	writer2.write(StringUtils.leftPad(result, 4, "0")+"\n");
        	//System.out.println(StringUtils.leftPad(result, 4, "0"));
        }
        writer2.close();
        System.out.println("Finalizada generacion numeros algoritmo Deceval: "+Calendar.getInstance().getTime());*/
    	System.out.println("Generando numeros algoritmo Deceval: "+Calendar.getInstance().getTime());
    	String result="100Z";	
    	result=toStringAnna(result);
    	
    	
    	//import org.apache.commons.lang.StringUtils;
    	//System.out.println(StringUtils.leftPad(result, 4, "0"));
    	System.out.println("Finalizada generacion numeros algoritmo Deceval: "+Calendar.getInstance().getTime());
    }

}
