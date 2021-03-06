package com.study.may.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Online Stock Span
 * 
 * Write a class StockSpanner which collects daily price quotes for some stock,
 * and returns the span of that stock's price for the current day.
 * 
 * The span of the stock's price today is defined as the maximum number of
 * consecutive days (starting from today and going backwards) for which the
 * price of the stock was less than or equal to today's price.
 * 
 * For example, if the price of a stock over the next 7 days were [100, 80, 60,
 * 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 * 
 * 
 * Input: ["StockSpanner","next","next","next","next","next","next","next"],
 * [[],[100],[80],[60],[70],[60],[75],[85]] Output: [null,1,1,1,2,1,4,6]
 * Explanation:
 * 
 * First, S = StockSpanner() is initialized.
 * 
 * Then:
 * 
 * S.next(100) is called and returns 1, S.next(80) is called and returns 1,
 * S.next(60) is called and returns 1, S.next(70) is called and returns 2,
 * S.next(60) is called and returns 1, S.next(75) is called and returns 4,
 * S.next(85) is called and returns 6.
 * 
 * Note that (for example) S.next(75) returned 4, because the last 4 prices
 * (including today's price of 75) were less than or equal to today's price.
 * 
 * @author mayur.p.ozardekar
 *
 */
public class Solution19 {

	class StockSpanner_17ms {

		private int[] pricesStack;
		private int[] spansStack;
		private int top;

		public StockSpanner_17ms() {
			pricesStack = new int[10000];
			spansStack = new int[10000];
			top = -1;
		}

		public int next(int price) {
			int span = 1;
			while (0 <= top && pricesStack[top] <= price) {
				span += spansStack[top--];
			}
			top++;
			pricesStack[top] = price;
			spansStack[top] = span;
			return span;
		}
	}

	class StockSpanner {

		List<Integer> stockPrice = new ArrayList<>();
		List<Integer> stockSpan = new ArrayList<>();
		Stack<Integer> prices, weights;

		public StockSpanner() {
			prices = new Stack<>();
			weights = new Stack<>();
		}

		public int next(int price) {
			int w = 1;
			while (!prices.isEmpty() && prices.peek() <= price) {
				prices.pop();
				w += weights.pop();
			}

			prices.push(price);
			weights.push(w);
			return w;
		}

		public int next_n(int price) {
			int index = stockPrice.size() - 1;

			while (index >= 0 && stockPrice.get(index) <= price) {
				int span = stockSpan.get(index);
				index = index - span;
			}

			stockPrice.add(price);
			int spanCost = stockPrice.size() - 1 - index;
			stockSpan.add(spanCost);

			return spanCost;
		}
	}
}
