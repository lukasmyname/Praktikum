package aufgabe;

public class Aufgabe1 {

	
	public static void main(String[] args) {
		int [][] array = {{1,2,3,4,5},{},null,{2,3,7,-5}};
		int x = 3;
		int [] ergebnis = getGrößerAls(array,x);
		for (int k = 0; k<ergebnis.length; k++) {
			System.out.println(ergebnis[k]);
		}
		
	}

	public static int[] getGrößerAls (int[][] array,int x ){
		if (array == null){
			return null;
		}
		
		int count = 0;
		for(int i = 0; i < array.length; i++){
			if (array[i] != null){
				for(int j = 0; j < array[i].length; j++){
					
					if (array[i][j]>x){
					count++;
					}					
				}
			}
		}
		
		int [] zahlen = new int [count] ; // TO-DO
		
		count = 0;
		for(int i = 0; i < array.length; i++){
			if (array[i] != null){
				for(int j = 0; j < array[i].length; j++){
					
					if (array[i][j]>x){
					zahlen[count] = array[i][j];
					count++;
					}					
				}
			}
		}
		return zahlen;
	}
}
