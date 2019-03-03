
// 20. Valid Parentheses
// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Note that an empty string is also considered valid.

// Example 1:

// Input: "()"
// Output: true

// Example 2:

// Input: "()[]{}"
// Output: true

// Example 3:

// Input: "(]"
// Output: false

// Example 4:

// Input: "([)]"
// Output: falseRre

// Example 5:

// Input: "{[]}"
// Output: true
import java.util.*;

public class ValidParentheses {
	public boolean isValid(String s) {
		Deque<Character> dq = new ArrayDeque<>();
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				if (dq.size() == 0 || map.get(c) != dq.pop())
					return false;
			} else {
				dq.push(c);
			}
		}
		return dq.size() == 0;
	}

	public static void main(String[] args) {
		boolean result = new ValidParentheses().isValid(")");
		System.out.println(result);
	}
}
