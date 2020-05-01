package com.study.april.week3;

import java.util.List;

/**
 * Leftmost Column with at Least a One
 * 
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution21 {
	
	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        
        List<Integer> dimension = binaryMatrix.dimensions();
        int rows = dimension.get(0);
        int cols = dimension.get(1);
        
        if(rows == 0 || cols == 0) return -1;
        
        int result = -1;
        int r = 0, c = cols - 1;
        
        while(r < rows && c >= 0){
            if(binaryMatrix.get(r,c) == 1){
                result = c;
                c--;                
            } else {
                r ++;
            }
        }
        
        return result;
        
    }

	// This is the BinaryMatrix's API interface.
	// You should not implement it, or speculate about its implementation
	interface BinaryMatrix {
		public int get(int x, int y);
		public List<Integer> dimensions();
	}


}
