package aufgabe;

import java.util.Arrays;

public class fifo {

	private static final int length = 5;
	private int  tFIFO[] = new int[length];
	private int count;
	
	public static void main(String[] args) {
		fifo test = new fifo();
		System.out.println("Erstelle FIFO");
		System.out.println(test.toString());
		System.out.println(test.pull());
		test.push(1);
		System.out.println("Push: 1");
		System.out.println(test.toString());
		test.push(2);
		System.out.println("Push: 2");
		System.out.println(test.toString());
		test.push(3);
		System.out.println("Push: 3");
		System.out.println(test.toString());
		
		System.out.println("Pull: " + test.pull());
		System.out.println(test.toString());
		
		test.push(4);
		System.out.println("Push: 4");
		System.out.println(test.toString());
		test.push(4);
		System.out.println("Push: 4");
		System.out.println(test.toString());
		test.push(4);
		System.out.println("Push: 4");
		System.out.println(test.toString());
		test.push(4);
		System.out.println("Push: 4");
		System.out.println(test.toString());
		
		System.out.println("Geklonter FIFO:");
		fifo Klon = test.clone();
		System.out.println(Klon.toString());
		
		System.out.println("Klon equals test:");
		System.out.println(Klon.equals(test));
		
		System.out.println("Pull: " + test.pull());
		System.out.println(test.toString());
		
		System.out.println("Klon equals test:");
		System.out.println(Klon.equals(test));
		
		
	}

	public fifo(){
		for (int i = 0; i < length; i++){
		this.tFIFO[i] = 0;
		}
		this.setCount(0);
	}
	
	public fifo( int [] array, int counter){
		this.settFIFO(array);
		this.setCount(counter);
	}
	
	public void push(int x){
		if (this.getCount()<this.gettFIFO().length){
		this.tFIFO[this.getCount()] = x;
		this.setCount(this.getCount()+1);
		}
		else if(this.getCount()==this.gettFIFO().length-1){
			for (int i = 0; i <this.gettFIFO().length-1; i++){
				this.tFIFO[i] = this.tFIFO[i+1];
			}
			this.tFIFO[this.getCount()] = x;
		}
		else {
			System.out.println("Speicher voll!");
		}
	}

	public int pull(){
		int pull =0;
		if (this.getCount() > 0){
		pull = this.tFIFO[0];
		for (int i = 0; i <this.gettFIFO().length-1; i++){
			this.tFIFO[i] = this.tFIFO[i+1];
		}
		this.tFIFO[this.gettFIFO().length-1] = 0;
		this.count--;
		}
		else if (this.getCount()==0){
			System.out.println("Keine Elemente gespeichert!");
			return 0;
		}
		return pull;
	}
	
	public String toString(){
		return ("FIFO:" + Arrays.toString(this.gettFIFO()));
		//return ("FIFO:" + this.tFIFO[0] + this.tFIFO[1] + this.tFIFO[2] + this.tFIFO[3] + this.tFIFO[4]);
	}
	
	public boolean equals(fifo param){
		if (this.tFIFO.equals(param.tFIFO)&&this.count==param.count){
			return true;
		}
		else{
			return false;
		}
	}
	
	public fifo clone(){
		return new fifo(this.tFIFO, this.count);
	}

	public int [] gettFIFO() {
		return tFIFO;
	}

	public void settFIFO(int [] tFIFO) {
		this.tFIFO = tFIFO;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
