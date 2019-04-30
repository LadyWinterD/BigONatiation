package program;

import java.util.Random;

public class program {
	// bubble Sort
	private static void bubble_sort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					// swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	// quick sort
	// merge sort
	private static void merge_sort_recursive(int[] arr, int[] result,
			int start, int end) {
		if (start >= end) {
			return;
		}
		int len = end - start, mid = (len >> 1) + start;
		int start1 = start, end1 = mid;
		int start2 = mid + 1, end2 = end;
		merge_sort_recursive(arr, result, start1, end1);
		merge_sort_recursive(arr, result, start2, end2);
		int k = start;
		while (start1 <= end1 && start2 <= end2) {
			result[k++] = arr[start1] < arr[start2] ? arr[start1++]
					: arr[start2++];
		}
		while (start1 <= end1) {
			result[k++] = arr[start1++];
		}
		while (start2 <= end2) {
			result[k++] = arr[start2++];
		}
		for (k = start; k <= end; k++) {
			arr[k] = result[k];
		}
	}

	// merge sort
	private static void merge_sort(int[] arr) {
		int len = arr.length;
		int[] result = new int[len];
		merge_sort_recursive(arr, result, 0, len - 1);
	}

	public static void main(String[] args) {
		
		int[] nums = new int[100000];
		for (int i = 0; i < nums.length; i++) {
			Random rand = new Random();
			nums[i] = rand.nextInt();
		}
		// bubble_sort
		long start = System.currentTimeMillis();
		bubble_sort(nums);
		long end = System.currentTimeMillis();
		System.out.println("The time of using is Bubble:" + (end - start)
				+ "ms");
		// merge_sort
		start = System.currentTimeMillis();
		merge_sort(nums);
		end = System.currentTimeMillis();
		System.out
				.println("The time of using is Merge:" + (end - start) + "ms");
	}

}
