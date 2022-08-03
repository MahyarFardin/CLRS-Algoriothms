import java.util.Arrays;

public class App{
	public  static void  swap(int [] numbers, int i, int j){
		int temp= numbers[i];
		numbers[i]=numbers[j];
		numbers[j]=temp;
	}

	public static void heapify(int [] numbers, int parent){
		int leftChild=parent*2+1;
		int rightChild=parent*2+2;

		int maxIndex;

		if(leftChild>=numbers.length){
			return;
		}
		else if(leftChild==numbers.length-1)
			maxIndex=leftChild;
		else
			maxIndex= numbers[leftChild]>numbers[rightChild] ? leftChild:rightChild;


		if(numbers[parent]<numbers[maxIndex]) {
			swap(numbers, parent, maxIndex);
		}

		heapify(numbers, maxIndex);
	}

	public static  void  remover(int [] numbers, int[] originalNumbers, int n){
		if(n>originalNumbers.length) return;

		int [] temp=new int[numbers.length-1];
		int removedNumber=numbers[0];
		numbers[0]=numbers[numbers.length-1];

		System.arraycopy(numbers, 0, temp, 0, temp.length);

		heapify(temp,0);
		System.arraycopy(temp, 0, numbers, 0, temp.length);
		originalNumbers[originalNumbers.length-n]=removedNumber;
		n++;
		remover(temp, originalNumbers, n);
	}
	public static void main(String[] args) {
		// numbers variable should be a max heap 
		int [] numbers= {12,11,13,5,6,7};


		remover(numbers, numbers, 1);

		System.out.println(Arrays.toString(numbers));

	}
}