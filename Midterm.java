import java.util.*;

/**
 * Created by zhengkevin on 3/17/17.
 */
public class Midterm {

    // 1
    public static void reverse(ArrayList<Integer> list) {

        //write your code here
        for (int i = list.size() - 1; i > -1; i--) {
            list.add(list.get(i));
            list.remove(i);
        }
        System.out.println(list.toString());

    }

    // 2
    public static String generateStrings(String s1, String s2) {

        //write your code here
        ArrayList<Character> a1 = new ArrayList<Character>();
        ArrayList<Character> a2 = new ArrayList<Character>();
        String result = "";

        if (s1 == "" || s2 == "") {
            result = "Invaild input";
        } else {
            for (int i = 0; i < s1.length(); i++) {
                if (!a1.contains(s1.charAt(i))) {
                    a1.add(s1.charAt(i));
                }
            }
            for (int i = 0; i < s2.length(); i++) {
                if (!a2.contains(s2.charAt(i))) {
                    a2.add(s2.charAt(i));
                }
            }

            for (char c1 : a1) {
                for (char c2 : a2) {
                    result += (String.valueOf(c1) + String.valueOf(c2) + " ");
                }
            }
        }
        return result;

    }

    // 3
    public static int singleNumber(int[] nums) {

        //write your code here
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                i++;
            } else if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];

    }

    //4
    public static int[] twoSum(int[] nums, int target) {

        //write your code here
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }

    //extra credit
    public static List<Integer> getRow(int rowIndex) {

        //write your code here
        ArrayList<Integer> l = new ArrayList<Integer>();
        int[][] pascal = new int[rowIndex + 1][rowIndex + 1];

        if (rowIndex == 0) {
            l.add(1);
            return l;
        } else {
            for (int i = 0; i < rowIndex + 1; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == 0) {
                        pascal[i][j] = 0;
                    } else if (j == 0 || j == i) {
                        pascal[i][j] = 1;
                    } else {
                        pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                    }
                }
            }
            for (int i = 0; i < pascal[rowIndex].length; i++) {
                if (pascal[rowIndex][i] != 0) {
                    l.add(pascal[rowIndex][i]);
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            a.add(i);
        }
        String s1 = "ACDC";
        String s2 = "ABBA";
        int[] nums = {2, 2, 5, 4, 5, 6, 4};
        int[] nums2 = {2, 7, 11, 15};

        reverse(a);
        System.out.println(generateStrings(s1, s2));
        System.out.println(singleNumber(nums));
        System.out.println(Arrays.toString(twoSum(nums2, 9)));
        System.out.println(getRow(3));

    }
}
