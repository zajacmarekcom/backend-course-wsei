package com.zajacmarek;

public class Main3 {
    public static void main(String[] args) {
        int array[] = {4, 5, 7, 11, 12, 15, 15, 21, 40, 45};

        int index = searchIntext(array, 11);

        System.out.println(index);
    }

    public static int searchIntext(int array[], int value)  {
        int index = 0;
        int limit = array.length - 1;
        while(index <= limit) {
            int point = (int)Math.ceil((index + limit) / 2.0);
            int entry = array[point];

            if (value > entry) {
                index = point + 1;
                continue;
            }
            if (value < entry) {
                limit = point - 1;
                continue;
            }

            return point;
        }

        return -1;
    }
}
