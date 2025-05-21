package checkstyle;


class Solution {
    public static int sum(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
                result += arr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6, 8};
        System.out.println(sum(array));
    }
}