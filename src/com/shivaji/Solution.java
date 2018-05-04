package com.shivaji;

/**
 * Consider a non-empty string S = S[0]S[1]...S[Q-1] consisting of Q characters. The period of this string is the smallest positive integer P such that:
 *
 * P ≤ Q / 2 and S[K] = S[K+P] for every K, where 0 ≤ K < Q − P.
 *
 * For example, 8 is the period of "codilitycodilityco" and 7 is the period of "abracadabracadabra".
 *
 * A positive integer M is the binary period of a positive integer N if M is the period of the binary representation of N. For example, 4 is the binary period of 955, because the binary representation of 955 is "1110111011" and its period is 4.
 *
 * You are given an implementation of a function:
 *
 * function solution(N);
 * This function, when given a positive integer N, returns the binary period of N. The function returns −1 if N does not have a binary period. For example, given N = 955 the function returns 4, as explained in the example above.
 *
 * Unfortunately, despite the fact that the function may return the expected result for the example input, there is a bug (or bugs) in the implementation, which may produce incorrect results for other inputs. Find the bug(s) and correct them. You should modify at most two lines of code.
 *
 * Assume that:
 *
 * N is an integer within the range [1..1,000,000,000].
 *
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 *
 * it works sometimes(ex: n = 955, but sometimes not)
 *
 * From Codality test where I was asked to edit only two lines and my solution is as below with out SOP statements
 */
public class Solution {

    public int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            int i = (l - (d.length - 1)) * -1;
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        // System.out.println(Arrays.stream(d).boxed().collect(Collectors.toList()));
        for (p = 1; p < 1 + l; ++p) {
            int i;
            boolean ok = true;
            // System.out.println();
            // System.out.println("i < " + (l - p) + " where p is " + p);
            for (i = 0; i < l - p; ++i) {
                System.out.println("Comparing i -> " + i + " with (i+p) " + (i + p) + " values " + d[i] + " != "
                    + d[i + p] + " is " + (d[i] != d[i + p]));
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }

    public int solution(String s) {
        char[] d = s.toCharArray();
        int l = d.length;
        int p;
        for (p = 1; p < 1 + l; ++p) {
            int i;
            boolean ok = true;
            // System.out.println();
            // System.out.println("i < " + (l - p) + " where p is " + p);
            for (i = 0; i < l - p; ++i) {
//				System.out.println("Comparing i -> " + i + " with (i+p) " + (i + p) + " values " + d[i] + " != "
//						+ d[i + p] + " is " + (d[i] != d[i + p]));
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solObj = new Solution();
        // System.out.println(solObj.solution(955));
        System.out.println(solObj.solution("codilitycodilityco"));

    }
}
