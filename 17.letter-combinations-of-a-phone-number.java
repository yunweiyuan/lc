/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (39.80%)
 * Total Accepted:    356.6K
 * Total Submissions: 877.2K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    private Map<Integer, String> mapConstructor() {
        Map<Integer, String> panel = new HashMap<>();
	panel.put(1, "*,");
	panel.put(2, "a,b,c");
	panel.put(3, "d,e,f");
	panel.put(4, "g,h,i");
	panel.put(5, "j,k,l");
	panel.put(6, "m,n,o");
	panel.put(7, "p,q,r,s");
	panel.put(8, "t,u,v");
	panel.put(9, "w,x,y,z");
	panel.put(0, " ,");
	return panel;
    }

    public List<String> letterCombinations(String digits) {
	List<String> result = new ArrayList<>();
	if (digits == null || digits.length() == 0) {
            return result;
	}

	Map<Integer, String> keyboard = mapConstructor();
	result = letterCombinationsWithMap(digits, keyboard);
        return result;
    }

    private List<String> letterCombinationsWithMap(String digits,
		    Map<Integer, String> keyboard) {
        List<String> result = new ArrayList<>();
	if (digits.length() == 1) {
	    result.addAll(Arrays.asList(keyboard.get(Integer.valueOf(digits)).split(",")));
	    return result;
	}

	List<String> preCombinations = letterCombinationsWithMap(
				digits.substring(0, digits.length() - 1), keyboard);
        int last = Integer.valueOf(digits.substring(digits.length() - 1));
        List<String> lettersFromLastDigit = Arrays.asList(keyboard.get(last).split(","));
	for (String comb : preCombinations) {
	    for (String letter : lettersFromLastDigit) {
                result.add(comb + letter);
	    } 
	}
	return result;
    }
}
