package A_Arrays;

public class D_merge_two_sorted_arrays {

	public static int[] merge(int arr1[], int arr2[], int n, int m) 
    {
	int i = 0;
    int j = 0;
    int arr3[] = new int[n+m];
    int k = 0;
    while(i<n && j<m){
        if(arr1[i]<arr2[j]){
            arr3[k] = arr1[i];
            i++;
            k++;
        }else{
            arr3[k] = arr2[j];
            j++;
            k++;
        }
       
    }
    while(i<n){
        arr3[k] = arr1[i];
        i++;
        k++;
    }
     while(j<m){
        arr3[k] = arr2[j];
        j++;
        k++;
    }
     return arr3;
    }
	public static void main(String[] args) {
		int arr1[] = {1 ,3 ,5 ,7};
		int arr2[] = {0 ,2 ,6 ,8 ,9};
		int n = arr1.length;
		int m = arr2.length;
		int arr3[]=merge(arr1,arr2,n,m);
		for(int i = 0; i<arr3.length;i++) {
			System.out.print(arr3[i]+" ");
		}

	}

}
