import java.util.Scanner;

class Main
{
	private int init;
	private int count;
	private long total;
	
	public Main(int num)
	{
		this.init = num;
		this.count = num;
		this.total = 0;
	}
	
	private int times(int vertical, int horizontal)
	{
		return (vertical - 1) + (horizontal -1);
	}
	
	public long getResult()
	{
		return this.total;
	}
	
	public void calculate(int vertical, int horizontal)
	{
		//System.out.print(vertical);
		//System.out.print(",");
		//System.out.println(horizontal);
		for (int i = vertical - 1; i > 0; i--) {
			if (this.count == 0) this.total += this.times(i, horizontal);
			else {
				this.count--;
				this.calculate(i, horizontal);
			}
		}
				
		for (int i = horizontal - 1; i > 0; i--) {
			if (this.count == 0) this.total += this.times(vertical, i);
			else {
				this.count--;
				this.calculate(vertical, i);
			}
		}
		
		this.count++;
		//System.out.print("out:");
		//System.out.println(this.total);
	}
	
    public static void main (String[] args) throws java.lang.Exception
    {
    	
        Scanner cin=new Scanner(System.in);
        String line;
        for(;cin.hasNext();){
            line=cin.nextLine();
            String[] keyValues = line.split(",");
    		int vertical = Integer.parseInt(keyValues[0]);
    		int horizontal = Integer.parseInt(keyValues[1]);
    		int num = Integer.parseInt(keyValues[2]);
    		int base = vertical + horizontal - 2;
    		
    		if (num > (base + 1)) System.out.println(0);
    		else if ((base + 1) == num || num == 1) System.out.println(1);
    		else if (num == 2) System.out.println(base);
    		else {
    			Main m = new Main(num - 3);
    			m.calculate(vertical, horizontal);
    			System.out.println(m.getResult());
    		}
        }
    }
}