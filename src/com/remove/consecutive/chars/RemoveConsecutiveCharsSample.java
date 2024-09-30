package com.remove.consecutive.chars;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveConsecutiveCharsSample {
	
	public static void main(String[] args) {
        String word = "ptmxpmonvnytatktgvibctrhfccccccccccpdbfcluyxrplhegwcbzwpppppppppppppppppppmmmmmmmmmmpmscjaflvwtbnyct";
        int k = 10;

        String result = removeConsecutiveChars(word, k);
        System.out.println("Final word: " + result);
    }

    public static String removeConsecutiveChars(String word, int k) {
    	 // Use a stack to keep track of characters and their counts
        Deque<Pair> stack = new ArrayDeque<>();
        
        for (char c : word.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == c) {
                stack.peek().count++;
            } else {
                stack.push(new Pair(c, 1));
            }

            // If we have k consecutive characters, remove them
            if (stack.peek().count == k) {
                stack.pop();
            }
        }

        // Reconstruct the string from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair pair = stack.removeLast();
            sb.append(String.valueOf(pair.ch).repeat(pair.count));
        }
        
        return sb.toString();
    }

    // Helper class to store character and its count
    private static class Pair {
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
    
    public static String removeConsecutiveCharsOld(String word, int k) {
        StringBuilder sb = new StringBuilder(word);

        boolean found = true;

        while (found) {
            found = false;
            int length = sb.length();

            for (int i = 0; i < length - k; i++) {
                int j = i;

                // Find the length of the sequence of identical characters
                while (j < length && sb.charAt(j) == sb.charAt(i)) {
                    j++;
                }

                // Check if the sequence length is at equals k
                if (j - i == k) {
                    sb.delete(i, j);
                    found = true;
                    break;  // Restart the process
                }
            }
        }

        return sb.toString();
    }
    
    //ptmxpmonvnytatktgvibctrhfpdbfcluyxrplhegwcbzwpmscjaflvwtbnyct
    //ptmxpmonvnytatktgvibctrhfpdbfcluyxrplhegwcbzwmscjaflvwtbnyct
    //ptmxpmonvnytatktgvibctrhfpdbfcluyxrplhegwcbzwmscjaflvwtbnyct

}
