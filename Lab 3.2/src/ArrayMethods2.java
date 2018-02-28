import java.util.Arrays;

public class ArrayMethods2 {
	
	public static void main(String[] args) {
        String[] ClassOne = {"zebra", "tortilla", "abba", "foo", "wall", "method"};
        String[] ClassTwo = { "bar", "baz", "monkey", "Stuff", "java", "pass" };
        int[] Class3 = {3,5,67,8,9,1,2};
       
        long start = System.nanoTime();
        String[] mergeResult = merge(ClassOne,ClassTwo);
        long end = System.nanoTime();
        long time = end - start;
        System.out.println( " Merge test took: " + time + " nanoseconds");
        System.out.println(Arrays.toString(mergeResult));
        
        start = System.nanoTime();
        int pivotFinalPos = partition(Class3);
        end = System.nanoTime();
        time = end - start;
        System.out.println( "Partition test took: " + time + " nanoseconds");
        System.out.println("Final Pivot Position: " + pivotFinalPos);
        System.out.println(Arrays.toString(Class3));
        
        }
    

    public static void mergeSort(String[] names) {
        if (names.length > 2) {
            String[] left = new String[names.length / 2];
            String[] right = new String[names.length - names.length / 2];

            for (int i = 0; i < left.length; i++) {
                left[i] = names[i];
            }

            for (int i = 0; i < right.length; i++) {
                right[i] = names[i + names.length / 2];
            }

            mergeSort(left);
            mergeSort(right);
            merge(names, left, right);
        }
    }

    public static void merge(String[] names, String[] left, String[] right) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < names.length; i++) {
            if (b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b]) < 0)) {
                names[i] = left[a];
                a++;
            } else {
                names[i] = right[b];
                b++;
            }
        }
    }
    
    public static String[] merge(String[] list1, String[] list2) {
		String merged[] = new String[list1.length+list2.length-1];
		int a=0;
		int b=0;
		for(int i=0; i<merged.length;i++) {
			if(list1[a].compareTo(list2[b])<0) {
				merged[i]=list1[a];
				if(a<list1.length-1) {
				a++;
				}
			}else if(list1[a].compareTo(list2[b])>0){
				merged[i]=list2[b];
				if(b<list2.length-1) {
				b++;
				}
			}else {
				merged[i]=list1[a];
				a++;
				i++;
				merged[i]=list1[b];
				b++;
			}
		}
		return merged;
	}
    public static int partition(int[] list) {
		int[] partitioned= new int[list.length];
		int a = 0;
		int x = list[0];
		for(int i=1;i<list.length;i++) {
			if(list[0]>list[i]) {
				partitioned[a]=list[i];
				a++;
			}
		}
		
		partitioned[a]=3;
		x = a;
		a++;
		for(int i=1;i<list.length;i++) {
			if(list[0]<=list[i]) {
				partitioned[a]=list[i];
				a++;
			}
		}
		for(int i=0;i<list.length;i++) {
		list[i] = partitioned[i];
		}
		System.out.println(x);
		return x;
	}
}
	
	
