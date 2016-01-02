import java.util.ArrayList;

public class MySorts {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) {
	for (int i = 0; i < data.size(); i++) {
		Comparable temp = data.get(i);
		int minLoc = minFinder(data, i);
		data.set(i, data.get(minLoc));
		data.set(minLoc, temp);
	}
    }//end selectionSort -- O(?)


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) {
	ArrayList copy = new ArrayList<Comparable>();
	for (int x = 0; x < input.size(); x++) {
		copy.set(x, input.get(x));
	}
	for (int i = 0; i < copy.size(); i++) {
		Comparable temp = copy.get(i);
		int minLoc = minFinder(copy, i);
		copy.set(i, copy.get(minLoc));
		copy.set(minLoc, temp);
	}
	return copy;
    }//end selectionSort -- O(?)
	
    public static int minFinder( ArrayList<Comparable> data, int min ){
	int minIndx = min;
	for (int i = min + 1; i < data.size(); i++) {
		if (data.get(minIndx).compareTo(data.get(i)) == 1) minIndx = i;
	}
	return minIndx;
    }
    
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	for (int w = 0; w < data.size(); w++) {
		for (int i = data.size() - 1; i > 0; i--) {
			if (data.get(i).compareTo(data.get(i - 1)) == -1) {
			Comparable temp = data.get(i);
			data.set(i, data.get(i - 1)); 
			data.set(i - 1, temp);
			}
		}
	}
    }//end bubbleSortV -- O(n^2)


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) {
	ArrayList copy = new ArrayList<Comparable>();
	for (int x = 0; x < input.size(); x++) {
		copy.set(x, input.get(x));
	}	
	for (int w = 0; w < copy.size(); w++) {
		for (int i = copy.size() - 1; i > 0; i--) {
			if (copy.get(i).compareTo(copy.get(i - 1)) == -1) {
			Comparable temp = copy.get(i);
			copy.set(i, copy.get(i - 1)); 
			copy.set(i - 1, temp);
			}
		}
	}
	return copy;
    }//end bubbleSort -- O(n ^ 2)
    
    public static Boolean isSorted?( ArrayList<Comparable> input) {
      for (int i = 0; i < input.size() - 1; i++) {
          if (input.get(i) > input.get(i + 1)) return false;
        }
      return true;
    }
    
    public static ArrayList<Comparable> bogoSort( ArrayList<Comparable> input) {
        if (isSorted?(input)) return input;
        else bogoSort(shuffle(input));
    }
  }
  
