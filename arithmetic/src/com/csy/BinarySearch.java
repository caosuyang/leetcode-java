package com.csy;

import com.csy.sort.cmp.insertion.InsertionSort3;

/**
 * 二分搜索
 * @author myfolders
 *
 */
public class BinarySearch {
	/**
	 * 查找v在有序数组array中的位置
	 * @param array
	 * @param v
	 * @return
	 */
	public int indexOf(int[] array, int v) {
		if (array == null || array.length == 0) {
			return -1;
		}
		// 假设在[begin, end)范围内搜索某个元素v
		int begin = 0, end = array.length;
		// 循环条件begin小于end，否则二分搜索范围不成立，跳出循环
		while (begin < end) {
			// 那么mid = (begin + end)/2
			// 注意mid需要不断切一半计算新的值，所以需要放在while内
			int mid = (begin + end) >> 1;
			// 如果v<m
			if (v < array[mid]) {
				// 去[begin, mid)范围二分搜索
				end = mid;
			} else if (v > array[mid]) {// 如果v>m
				// 去[mid+1, end)范围二分搜索
				begin = mid + 1;
			} else {// 如果v==m
				// 直接命中返回mid
				return mid;
			}
		}
		return -1;
	}
	
	/**
	 * 查找v在有序数组array中待插入的位置
	 * 要求二分搜索返回的插入位置：第一个大于v的元素位置
	 * @param array
	 * @param v
	 * @return
	 */
	public int insertIndex(int[] array, int v) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int begin = 0, end = array.length;
		while (begin < end) {
			int mid = (begin + end) >> 1;
			if (v < array[mid]) {
				end = mid;
			} else if (v > array[mid]) {
				begin = mid + 1;
			} else {
				// 插入位置是第一个大于v的元素位置
				return mid + 1;
			}
		}
		// v > array[mid]时，正好位置为begin
		return begin;
	}
	
	/**
	 * 查找v在有序数组array中待插入的位置，优化条件合并
	 * 要求二分搜索返回的插入位置：第一个大于v的元素位置
	 * @param array
	 * @param 
	 * @return
	 */
	public int insertIndex1(int[] array, int v) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int begin = 0, end = array.length;
		while (begin < end) {
			int mid = (begin + end) >> 1;
			if (v < array[mid]) {
				end = mid;
			} else {// v >= array[mid]
				// 插入位置是第一个大于v的元素位置
				begin = mid + 1;
			}
		}
		// v >= array[mid]时，插入位置正好为begin
		return begin;
	}
	
	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.indexOf(array, 0));
		System.out.println(bs.indexOf(array, 5));
	}

}
