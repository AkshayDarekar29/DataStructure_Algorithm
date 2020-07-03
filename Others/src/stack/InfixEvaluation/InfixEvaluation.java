
package stack.InfixEvaluation;

import java.util.HashSet;
import java.util.Stack;

/*
 * Time Complexity- O(n);
 * Space Complexity - O(n)
 * Reference - https://www.geeksforgeeks.org/expression-evaluation/
 */
public class InfixEvaluation {
	public static void main(String[] args) {
		InfixEvaluation obj = new InfixEvaluation();
		String exp = "(100*2.5)+(50/5)-20+(55*2)+10/3";
		double result = obj.evaluateInfix(exp);
		System.out.println(result);
	}

	private double evaluateInfix(String exp) {
	
		Stack<Double> values =  new Stack<>();	
		Stack<Character> Ops =  new Stack<>();
		HashSet<Character> opsSet = new HashSet<>();
		opsSet.add('+');
		opsSet.add('-');
		opsSet.add('*');
		opsSet.add('/');
		for (int i = 0; i < exp.length(); i++) {
			
			if(exp.charAt(i) == ' '){
				continue;
			}else if(exp.charAt(i) >= '0' && exp.charAt(i) <= '9' || exp.charAt(i) == '.'){
				StringBuilder sb = new StringBuilder();	
				while(i<exp.length() && (exp.charAt(i) >= '0' && exp.charAt(i) <= '9' || exp.charAt(i) == '.')){
					sb.append(exp.charAt(i));
					i++;
				}
				i--;
				values.push(Double.parseDouble(sb.toString()));
			}else if( exp.charAt(i) == '('){
				Ops.push(exp.charAt(i));
			}else if( exp.charAt(i) == ')'){
				while(!Ops.empty() && Ops.peek() != '('){
					double result = applyOperation(values.pop(), values.pop(), Ops.pop() );
					values.push(result);
				}
				Ops.pop();
			}else if(opsSet.contains(exp.charAt(i))){
				while(!Ops.empty() && hasPrecedence(exp.charAt(i), Ops.peek())){
					double result = applyOperation(values.pop(), values.pop(), Ops.pop());
					values.push(result);
				}
				Ops.push(exp.charAt(i));
			}
		}
		while(!Ops.empty()){
			double result = applyOperation(values.pop(), values.pop(), Ops.pop());
			values.push(result);
		}
		return values.pop();
	}

	private boolean hasPrecedence(char c, Character peek) {
		if( peek == '(' || peek == '('){
			return false;
		}else if((c == '*' || c == '/') && (peek == '+' || peek == '-')){
			return false;
		}
		return true;
	}

	private double applyOperation(double n2, double n1, Character operator) {
		switch(operator){
			case '+':
				return n1+n2;
			case '-':
				return n1-n2;
			case '*':
				return n1*n2;
			case '/':
				if(n2 == 0){
					throw new UnsupportedOperationException();
				}
				return n1/n2;
		}
		return 0;
	}
}