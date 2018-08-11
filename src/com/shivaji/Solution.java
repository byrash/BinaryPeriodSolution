package com.shivaji;

/**
 * Consider a non-empty string S = S[0]S[1]...S[Q-1] consisting of Q characters. The period of this
 * string is the smallest positive integer P such that:
 *
 * <p>P ≤ Q / 2 and S[K] = S[K+P] for every K, where 0 ≤ K < Q − P.
 *
 * <p>For example, 8 is the period of "codilitycodilityco" and 7 is the period of
 * "abracadabracadabra".
 *
 * <p>A positive integer M is the binary period of a positive integer N if M is the period of the
 * binary representation of N. For example, 4 is the binary period of 955, because the binary
 * representation of 955 is "1110111011" and its period is 4.
 *
 * <p>You are given an implementation of a function:
 *
 * <p>function solution(N); This function, when given a positive integer N, returns the binary
 * period of N. The function returns −1 if N does not have a binary period. For example, given N =
 * 955 the function returns 4, as explained in the example above.
 *
 * <p>Unfortunately, despite the fact that the function may return the expected result for the
 * example input, there is a bug (or bugs) in the implementation, which may produce incorrect
 * results for other inputs. Find the bug(s) and correct them. You should modify at most two lines
 * of code.
 *
 * <p>Assume that:
 *
 * <p>N is an integer within the range [1..1,000,000,000].
 *
 * <p>In your solution, focus on correctness. The performance of your solution will not be the focus
 * of the assessment.
 *
 * <p>it works sometimes(ex: n = 955, but sometimes not)
 *
 * <p>From Codality test where I was asked to edit only two lines and my solution is as below with
 * out SOP statements
 */
public class Solution {

  /**
   * Int version
   */
  public int solution(int n) {
    //    Integer[] d = new Integer[Integer.SIZE - Integer.numberOfLeadingZeros(n)];
    Integer[] d = new Integer[30];
    int l = 0;
    while (n > 0) {
      //      int i = (l - (d.length - 1)) * -1;
      d[l] = n % 2;
      n /= 2;
      l++;
    }
    return getBinaryPeriod(d, l);
  }

  /**
   * Core engine
   */
  private <T> int getBinaryPeriod(T[] d, int l) {
    for (int p = 1; p < 1 + l; ++p) {
      int i;
      boolean ok = true;
      for (i = 0; i < l - p; ++i) {
        if (d[i] != d[i + p]) {
          ok = false;
          break;
        }
      }
      if (ok && p != l && p <= l / 2) {
        return p;
      }
    }
    return -1;
  }

  /**
   * String version
   */
  public int solution(String s) {
    Character[] d = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
    int l = d.length;
    return getBinaryPeriod(d, l);
  }

  public static void main(String[] args) {
    Solution solObj = new Solution();
    System.out.println("955 --> " + solObj.solution(955)); // Binary of 955 is 1110111011
    System.out.println("codilitycodilityco --> " + solObj.solution("codilitycodilityco"));
    //    System.out.println(solObj.solution("dingding"));
    System.out.println("dingdongdingdong --> " + solObj.solution("dingdongdingdong"));
    System.out.println("abracadabracadabra --> " + solObj.solution("abracadabracadabra"));
    System.out.println(
        "111011100110101100101000000000 --> " + solObj.solution("111011100110101100101000000000"));
    System.out.println("657 --> " + solObj.solution(657)); // 1010010001
    System.out.println("1110111011 --> " + solObj.solution("1110111011")); // 1010010001
  }
}
