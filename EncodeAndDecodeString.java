/*
Design an algorithm to encode a list of strings to a string. 
The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note:
The string may contain any possible characters out of 256 valid ascii characters. 
Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
*/


import java.util.*;
public class EncodeAndDecodeString {
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			
			// 记录每一个string的长度，用#相隔
			sb.append(s.length());
			sb.append("#");
			sb.append(s);
		}
		return sb.toString();
	}
	public List<String> decode(String s) {
		List<String> str = new ArrayList<>();
		int i = 0;
		while (i < s.length()) {
			
			// 从i开始，出现‘#’的第一个index
			int sharp = s.indexOf('#', i);
			int len = Integer.parseInt(s.substring(i, sharp));
			str.add(s.substring(sharp + 1, sharp + len + 1));
			i = sharp + len + 1;
		}
		return str;
	}
}
