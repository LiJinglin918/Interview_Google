import java.util.*;
public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		HashMap<String, List<String>> hm = new HashMap<>();
		for (String s : strings) {
			String key = genKey(s);
			if (hm.containsKey(key))
				hm.get(key).add(s);
			else {
				List<String> list = new ArrayList<>();
				list.add(s);
				hm.put(key, list);
			}
		}
		List<List<String>> res = new ArrayList<>();
		for (List<String> l : hm.values()) {
			Collections.sort(l);
			res.add(l);
		}
		return res;
	}
	public String genKey(String s) {
		if (s.length() == 0)
			return "";
		char[] c = s.toCharArray();
		int offset = c[0] - 'a';   // if c[0] =='a', offset = 0
		for (int i = 0; i < c.length; i++) {
			c[i] -= offset;
			if (c[i] < 'a')
				c[i] += 26;
		}
		return new String(c);
	}
}
