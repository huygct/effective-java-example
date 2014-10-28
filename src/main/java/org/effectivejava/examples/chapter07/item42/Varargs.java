// Sample uses of varargs
package org.effectivejava.examples.chapter07.item42;

import java.util.Arrays;
import java.util.List;

public class Varargs {

    // Simple use of varargs - Page 197
    static int sum(int... args) {
        int sum = 0;
        for (int arg : args)
            sum += arg;
        return sum;
    }

    // The WRONG way to use varargs to pass one or more arguments! - Page 197
    static int min(int... args) {
        if (args.length == 0)
            throw new IllegalArgumentException("Too few arguments");
        int min = args[0];
        for (int i = 1; i < args.length; i++)
            if (args[i] < min)
                min = args[i];
        return min;
    }

    // The right way to use varargs to pass one or more arguments - Page 198
	static int min_2(int firstArg, int... remainingArgs) {
		int min = firstArg;
		for (int arg : remainingArgs)
			if (arg < min)
				min = arg;
		return min;
	}

    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		System.out.println(min(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(min_2(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        int[] digits = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 4 };

        // Obsolete idiom to print an array!
        System.out.println(Arrays.asList(digits)); // use Array.asList is used vararg therefore It not println as expect

        // The right way to print an array
        System.out.println(Arrays.toString(digits)); // Array.toString use int[]


//        List<int[]> list1 = Arrays.asList(digits);
//
//        // printing the list
//        System.out.println("The list is:" + list1.get(0)[2]);
    }
}
