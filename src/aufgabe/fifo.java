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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + Arrays.hashCode(tFIFO);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		fifo other = (fifo) obj;
		if (count != other.count)
			return false;
		if (!Arrays.equals(tFIFO, other.tFIFO))
			return false;
		return true;
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
	
	@Override
	public String toString() {
		return "fifo [tFIFO=" + Arrays.toString(tFIFO) + ", count=" + count + "]";
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
