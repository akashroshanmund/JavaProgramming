package blind75;

public class Day10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class solution10{
//371. Sum of Two Integers	
	public int getSum(int a, int b) {
        //approach
       while(b != 0){
           int ret = a ^ b;
           int carry = (a & b) << 1; 
           a =  ret;
           b = carry;
       }
        return a;
    }
}