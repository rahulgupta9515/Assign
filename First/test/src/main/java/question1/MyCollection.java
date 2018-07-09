package question1;

/**
 * Please implement Dynamic Array Interface 
 * @author 
 *
 */
public class MyCollection implements DynamicArray{
// Uncomment commented section
	
	/**
	 * You can declare local/global variables as per your requirement
	 */
	@SuppressWarnings("unused")
	private int[] numArray;
	int arraySize;
	int indexTillWhichElementIsPresentInArray;
	/**
	 * It constructs an empty Collection object with an array capacity specified by the integer
		parameter "arraySize".
	 */
	public MyCollection(int arraySize){
		this.arraySize=arraySize;
		numArray = new int[arraySize];
	}

	public int search(int searchingNum) {
		// TODO Auto-generated method stub
		for(int searchForNumber=0;searchForNumber<indexTillWhichElementIsPresentInArray;searchForNumber++) {
			if(searchingNum==numArray[searchForNumber]) {
				return searchForNumber;
			}
		}
		return -1;
	}

	public boolean add(int numberToAdd) {
		// TODO Auto-generated method stub
		if(search(numberToAdd)==-1) {
			if(indexTillWhichElementIsPresentInArray==arraySize)
				doubleCapacity();
			numArray[indexTillWhichElementIsPresentInArray++]=numberToAdd;
			//System.out.println(numArray[indexTillWhichElementIsPresentInArray-1]+" "+numberToAdd);
			return true;
		}
		return false;
	}

	public void doubleCapacity() {
		// TODO Auto-generated method stub//change Array Size
		int[] tempArrayToStoreElement=new int[arraySize];
		for(int i=0;i<indexTillWhichElementIsPresentInArray;i++) {
			tempArrayToStoreElement[i]=numArray[i];
		}
		arraySize=2*arraySize;
		numArray=new int[arraySize];
		for(int i=0;i<tempArrayToStoreElement.length;i++) {
			numArray[i]=tempArrayToStoreElement[i];
		}
	}

	public boolean remove(int numberToRemove) {
		int searchNumberIndex=search(numberToRemove);
		if(searchNumberIndex!=-1) {
			for(int i=searchNumberIndex;i<indexTillWhichElementIsPresentInArray;i++){
				numArray[i]=numArray[i+1];
			}
			indexTillWhichElementIsPresentInArray--;
			return true;
		}
		return false;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return indexTillWhichElementIsPresentInArray;
	}

	public int[] rotate(int n) {
		// TODO Auto-generated method stub
		int[] tempArray=new int[n];
		int[] tempArray1=new int[indexTillWhichElementIsPresentInArray-n];
		for(int i=0;i<tempArray.length;i++) {
			tempArray[i]=numArray[i];
		}
		int k=0;
		for(int i=n;i<indexTillWhichElementIsPresentInArray;i++) {
			tempArray1[k]=numArray[i];k++;
		}
		int i=0;
		for(i=0;i<tempArray1.length;i++) {
			numArray[i]=tempArray1[i];
		}
		for(int j=0;j<tempArray.length;j++) {
			numArray[i]=tempArray[j];i++;
		}
		return numArray;
	}
	public String toString( ) {
		String s="{";
		if(indexTillWhichElementIsPresentInArray!=0) {
			for(int i=0;i<indexTillWhichElementIsPresentInArray-1;i++) {
				s=s+numArray[i]+",";
			}
			System.out.println(numArray.toString());
			
			s=s+numArray[indexTillWhichElementIsPresentInArray-1]+"}";
			//System.out.println(s);
		}
		if(indexTillWhichElementIsPresentInArray==0) {
			return "{}";
		}
		return s;
	}

}
