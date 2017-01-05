import java.util.*;
public class Itinerary {
	public List<String> findItinerary(String[][] tickets) {
		List<String> res = new ArrayList<>();
		if (tickets == null || tickets.length == 0 || tickets[0].length == 0)
			return res;
		HashMap<String, List<String>> hm = new HashMap<>();
		for (String[] ticket : tickets) {
			if (!hm.containsKey(ticket[0])) {
				hm.put(ticket[0], new ArrayList<>());
			}
			hm.get(ticket[0]).add(ticket[1]);
		}
		for (List<String> list : hm.values()) {
			Collections.sort(list);
		}
		res.add("JFK");
		if (DFS(res, "JFK", hm, tickets.length + 1))
			return res;
		return res;
	}
	public boolean DFS(List<String> res, String start, HashMap<String, List<String>> hm, int len) {
		if (res.size() == len)
			return true;
		if (!hm.containsKey(start) || hm.get(start) == null)
			return false;
		for (int i = 0; i < hm.get(start).size(); i++) {
			String temp = hm.get(start).get(i);
			res.add(temp);
			hm.get(start).remove(i);
			if (DFS(res, temp, hm, len))
				return true;
			res.remove(res.size() - 1);
			hm.get(start).add(i, temp);
		}
		return false;
	}
}
