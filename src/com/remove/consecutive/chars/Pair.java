package com.remove.consecutive.chars;

public class Pair {

	 char ch;
     int count;

     Pair(char ch, int count) {
         this.ch = ch;
         this.count = count;
     }

	@Override
	public String toString() {
		return "Pair [ch=" + ch + ", count=" + count + "]";
	}
}
