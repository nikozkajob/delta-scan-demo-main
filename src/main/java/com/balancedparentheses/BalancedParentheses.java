package com.balancedparentheses;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

//Write a program to determine if the parentheses (), the brackets [], and the braces {}, in a string are balanced.
//For example:
//        {{)(}} is not balanced because ) comes before (
//({)} is not balanced because ) is not balanced between {} and similarly the { is not balanced between ()
//        [({})] is balanced
//    {}([]) is balanced
//    {()}[[{}]] is balanced
public class BalancedParentheses {

    //    public static boolean isBalanced(String brackets) {
//
//        boolean isOpenRound = false;
//        boolean isOpenSquare = false;
//        boolean isOpenCurly = false;
//
//        char[] charArray = brackets.toCharArray();
//
//        for (int i = 0; i < charArray.length; i++) {
//            if (charArray[i] == '(') {
//                isOpenRound = true;
//                continue;
//            }
//            if ((isOpenRound && charArray[i] == ')')
//                    && i != 0
//                    && charArray[i - 1] != '{'
//                    && charArray[i - 1] != '[') {
//                isOpenRound = false;
//            }
//            if (charArray[i] == '[') {
//                isOpenSquare = true;
//                continue;
//            }
//            if (isOpenSquare && charArray[i] == ']'
//                    && i != 0
//                    && charArray[i - 1] != '('
//                    && charArray[i - 1] != '{') {
//                isOpenSquare = false;
//            }
//            if (charArray[i] == '{') {
//                isOpenCurly = true;
//                continue;
//            }
//            if (charArray[i] == '}'
//                    && i != 0
//                    && charArray[i - 1] != '('
//                    && charArray[i - 1] != '[') {
//                isOpenCurly = false;
//            }
//
//        }
//
//        return !isOpenRound && !isOpenSquare && !isOpenCurly;
//    }
    public static boolean isBalanced(String brackets) {
        Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');
        Set<Character> openingBrackets = Set.of('(', '{', '[');
        Deque<Character> stack = new ArrayDeque<>();

        char[] charArray = brackets.toCharArray();

        for (char c : charArray) {
            if (openingBrackets.contains(c)) {
                stack.push(c);
            } else if (map.containsKey(c)
                    && !Objects.equals(map.get(c), stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
