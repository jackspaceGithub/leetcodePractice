import java.util.Stack;

/**
 * 20, Valid Parentheses
 * 合法的括号，注意审题，我第一次审题把它看成了只要括号顺序对就可以，实际上括号要互相抵消，中间不能留多余字符
 */
public class P20 {

    public static void main(String[] args) {
        P20 p20 = new P20();
        if(p20.isValid("([)]")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    /**
     * 以正确顺序关闭版本
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<String> stringStack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {

            String e = String.valueOf(s.charAt(i));
            if(stringStack.empty()) {
                stringStack.add(e);
                continue;
            }

            // 栈顶元素是否跟输入元素相对立，如(和)相对立，则出栈，否则入栈
            if(judge(stringStack.peek().charAt(0), s.charAt(i))) {
                stringStack.pop();
            } else {
                stringStack.push(e);
            }
        }
        return stringStack.empty();
    }

    private boolean judge(char left, char right) {
        return ('(' == left && ')' == right)
                || ('[' == left && ']' == right)
                || ('{' == left && '}' == right);
    }


    /**
     * 不以正确顺序关闭版本这么写
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        int smallBracket = 0;
        int flowerBracket = 0;
        int squareBracket = 0;

        char[] list = s.toCharArray();
        for(char e : list) {
            if(e == '(') {
                smallBracket++;
                continue;
            } else if(e == ')') {
                if(smallBracket > 0) {
                    smallBracket--;
                    continue;
                }
                return false;
            }

            if(e == '{') {
                flowerBracket++;
                continue;
            } else if(e == '}') {
                if(flowerBracket > 0) {
                    flowerBracket--;
                    continue;
                }
                return false;
            }

            if(e == '[') {
                squareBracket++;
                continue;
            } else if(e == ']') {
                if(squareBracket > 0) {
                    squareBracket--;
                    continue;
                }
                return false;
            }
        }

        return (smallBracket == 0 && flowerBracket == 0 && squareBracket == 0);
    }

}
