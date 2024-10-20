/*
 * @lc app=leetcode id=1106 lang=java
 *
 * [1106] Parsing A Boolean Expression
 */

// @lc code=start
import java.util.Stack;
import java.util.ArrayList;

class Solution
{
    public static boolean evaluate(char operator, ArrayList<Boolean> values)
    {
        if(operator == '&')
        {
            for(boolean value : values)
            {
                if(!value)
                {
                    return false;
                }
            }
            return true;
        }
        else if(operator == '|')
        {
            for(boolean value : values)
            {
                if(value)
                {
                    return true;
                }
            }
            return false;
        }
        else if(operator == '!')
        {
            return !values.get(0);
        }
        return false;
    }

    public boolean parseBoolExpr(String expression)
    {
        Stack<Character> stack = new Stack<>();

        for(char ch : expression.toCharArray())
        {
            if(ch == ')')
            {
                ArrayList<Boolean> values = new ArrayList<>();
                while(stack.peek() != '(')
                {
                    values.add(stack.pop() == 't');
                }
                stack.pop();

                char operator = stack.pop();
                boolean result = evaluate(operator, values);

                stack.push(result ? 't' : 'f');                
            }
            else if(ch != ',')
            {
                stack.push(ch);
            }
        }
        return stack.pop() == 't';
    }
}
// @lc code=end

