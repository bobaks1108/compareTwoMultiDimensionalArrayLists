import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void compareMultiDimIntegerArrayLists(ArrayList<ArrayList<Integer>> multiDimArrayList01,
                                                        ArrayList<ArrayList<Integer>> multiDimArrayList02) {

        System.out.println("--------------------------------------");
        System.out.println("Comparing:");
        System.out.println(multiDimArrayList01);
        System.out.println("With:");
        System.out.println(multiDimArrayList02);

        boolean arraysMatch = false;

        // check if the length of each top level multi-dimensional ArrayList is the same if not then they cannot be equal.
        if (multiDimArrayList01.size() == multiDimArrayList02.size()) {

            // Create an int array to store the results of the check.
            // The size of each array is the number of top level elements in multiDimArrayList01,
            // which is the same as multiDimArrayList02.
            // We will use this array to indicate which elements in multiDimArrayList01
            // match one element in multiDimArrayList02(-1 means no match)
            int[] matches = new int[multiDimArrayList01.size()];

            // Create an int array to store the position of where the elements are of the
            // second array multiDimArrayList02.
            // The size of each array is also the number of top level elements in multiDimArrayList01
            int[] matchesPos = new int[multiDimArrayList01.size()];

            // Now fill the results arrays with -1s intially
            java.util.Arrays.fill(matches, -1);
            java.util.Arrays.fill(matchesPos, -1);

            int loopFirstArrayListCount = 0;
            int loopSecondArrayListCount;
            boolean anElementNotFound = false;

            // Loop through the top level elements (arrayLists) in multiDimArrayList01
            while (!anElementNotFound && loopFirstArrayListCount < multiDimArrayList01.size()) {
                ArrayList<Integer> temp = multiDimArrayList01.get(loopFirstArrayListCount);
                System.out.println("");
                System.out.println("Array 1 element " + temp);
                loopSecondArrayListCount = 0;

                // Loop through the elements of the second array (multiDimArrayList02)
                for (ArrayList<Integer> temp1 : multiDimArrayList02) {
                    System.out.println("Array 2 element " + temp1);

                    // If the arrayLists Match AND this position has not already been matched.
                    // Then update the matches array (replace the -1 with the top level loop number)
                    // and record the position in the second int array (matchesPos)
                    if (temp.equals(temp1) && !contains(matchesPos, loopSecondArrayListCount)) {
                        System.out.println(" ** Match at " + loopSecondArrayListCount + "**");
                        matches[loopFirstArrayListCount] = loopFirstArrayListCount;
                        matchesPos[loopFirstArrayListCount] = loopSecondArrayListCount;
                        break;
                    }
                    loopSecondArrayListCount++;
                    // If we have looped through all the elements in the second array
                    // then element has not been found.
                    if (loopSecondArrayListCount == multiDimArrayList02.size()) {
                        anElementNotFound = true;
                    }
                }
                loopFirstArrayListCount++;
            }

            System.out.println("The elements in arrayList 1 that match one element in arrayList 2 (-1 means no match):");
            System.out.println(Arrays.toString(matches));

            System.out.println("The positions in arrayList 2 of the elements matched:");
            System.out.println(Arrays.toString(matchesPos));

            if (!anElementNotFound && matches.length == multiDimArrayList02.size())
                arraysMatch = true;
            else
                arraysMatch = false;

        } else {
            arraysMatch = false;
        }

        if (arraysMatch) {
            System.out.println("***** ArrayLists Match! *******");
        } else {
            System.out.println("***** No Match! *******");
        }

        System.out.println("--------------------------------------");
        System.out.println("");

    }

    // Check if an array of ints contains a single value
    public static boolean contains(int[] arr, int item) {
        for (int n : arr) {
            if (item == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        //Generate some test arrayList data
        ArrayList<ArrayList<Integer>> multiDimArrayListA = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> multiDimArrayListB = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> multiDimArrayListC = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> multiDimArrayListD = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> multiDimArrayListE = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> multiDimArrayListF = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> multiDimArrayListG = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> multiDimArrayListH = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> arryListTest01 = new ArrayList<Integer>(java.util.Arrays.asList(7, 2, 3));
        ArrayList<Integer> arryListTest02 = new ArrayList<Integer>(java.util.Arrays.asList(8, 2, 0));
        ArrayList<Integer> arryListTest03 = new ArrayList<Integer>(java.util.Arrays.asList(6, 1, 9));
        ArrayList<Integer> arryListTest04 = new ArrayList<Integer>(java.util.Arrays.asList(5, 6, 1));
        ArrayList<Integer> arryListTest05 = new ArrayList<Integer>(java.util.Arrays.asList(7, 2, 5));
        ArrayList<Integer> arryListTest06 = new ArrayList<Integer>(java.util.Arrays.asList(9, 3));

        multiDimArrayListA.add(arryListTest01);
        multiDimArrayListA.add(arryListTest02);
        multiDimArrayListA.add(arryListTest03);
        multiDimArrayListA.add(arryListTest04);

        multiDimArrayListB.add(arryListTest02);
        multiDimArrayListB.add(arryListTest03);
        multiDimArrayListB.add(arryListTest04);
        multiDimArrayListB.add(arryListTest01);

        multiDimArrayListC.add(arryListTest01);
        multiDimArrayListC.add(arryListTest03);
        multiDimArrayListC.add(arryListTest02);
        multiDimArrayListC.add(arryListTest05);

        multiDimArrayListD.add(arryListTest01);
        multiDimArrayListD.add(arryListTest03);
        multiDimArrayListD.add(arryListTest02);

        multiDimArrayListE.add(arryListTest01);
        multiDimArrayListE.add(arryListTest03);
        multiDimArrayListE.add(arryListTest02);
        multiDimArrayListE.add(arryListTest06);

        multiDimArrayListF.add(arryListTest01);
        multiDimArrayListF.add(arryListTest01);
        multiDimArrayListF.add(arryListTest03);
        multiDimArrayListF.add(arryListTest02);

        multiDimArrayListG.add(arryListTest01);
        multiDimArrayListG.add(arryListTest03);
        multiDimArrayListG.add(arryListTest02);
        multiDimArrayListG.add(arryListTest01);

        multiDimArrayListH.add(arryListTest01);
        multiDimArrayListH.add(arryListTest01);
        multiDimArrayListH.add(arryListTest02);
        multiDimArrayListH.add(arryListTest02);

        compareMultiDimIntegerArrayLists(multiDimArrayListA, multiDimArrayListB); // elements match -> Output: Matches
        compareMultiDimIntegerArrayLists(multiDimArrayListA, multiDimArrayListC); // elements do not match -> Output: No Match
        compareMultiDimIntegerArrayLists(multiDimArrayListA, multiDimArrayListD); // elements do not match at all ->  Output: No Match
        compareMultiDimIntegerArrayLists(multiDimArrayListA, multiDimArrayListE); // elements do not match -> Output: No Match
        compareMultiDimIntegerArrayLists(multiDimArrayListF, multiDimArrayListG); // elements match with duplicates in different order -> Output: Matches
        compareMultiDimIntegerArrayLists(multiDimArrayListH, multiDimArrayListG); // elements do not match with duplicates -> Output: No Match

    }

}

