#include <stack>
#include <string>
#include <iostream>
#include <cassert>
using namespace std;

int evaluate(string infix, string& postfix, bool& result);
// Evaluates a boolean expression
//   If infix is a syntactically valid infix boolean expression,
//   then set postfix to the postfix form of that expression, set
//   result to the value of the expression, and return zero.  If
//   infix is not a syntactically valid expression, return 1; in
//   that case, postfix may or may not be changed, but result must
//   be unchanged.)

void grabValues(stack<char>& o, bool& first, bool& second);



int evaluate(string infix, string& postfix, bool& result) {
	stack<char> s;
	postfix = "";
	if (infix.size() == 0)
		return 1;
	int braces = 0;

	int k = 0;
	while (k < infix.size() && infix[k] == ' ')
		k++;
	if (k >= infix.size())
		return 1;	//Was only blank string with nothing in it

	for (int i = k; i < infix.size(); i++) {
		
		
		switch (infix[i]) {
		case 'T':
		case 'F':
			postfix += infix[i];

			//moves i forward so it is at the next nonspace character
			while (i + 1 < infix.size() && infix[i + 1] == ' ') {
				i++;
			}
			//Everything after were space characters
			if (i + 1 >= infix.size()) {
				break;
			}

			//Otherwise, T and F must be followed by ), &, or a | (excluding spaces)
			switch (infix[i + 1]) {
			case ')':
			case '&':
			case '|':
				break;
			default:
				return 1;
			}
			

			
			break;
		case '(':
			s.push(infix[i]);
			braces++;
			while (i + 1 < infix.size() && infix[i + 1] == ' ') {
				i++;
			}
			//Cannot end with an opening parentheses 
			if (i + 1 >= infix.size()) {
				return 1;
			}
			//infix[i + 1] != ' '
			switch (infix[i + 1]) {
			case 'T':
			case 'F':
			case '(':
			case '!':
				break;
			default:
				//Only values that can come after a ( is T, F, or (
				return 1;
			}

			break;
		case ')':
			while (!s.empty() && s.top() != '(') {
				postfix += s.top();
				s.pop();
			}
			if(!s.empty())
				s.pop();
			braces--;
			while (i + 1 < infix.size() && infix[i + 1] == ' ') {
				i++;
			}
			//Can with an opening parentheses 
			if (i + 1 >= infix.size()) {
				break;
			}
			//infix[i + 1] != ' '
			switch (infix[i + 1]) {
			case '|':
			case '&':
			case ')':
				break;
			default:
				//Only values that can come after a ) is a &, |, or )
				return 1;
			}
			break;
		case '!':
			
			s.push(infix[i]);

			//Checking right most nonspace character to see if valid
			while (i + 1 < infix.size() && infix[i + 1] == ' ') {
				i++;
			}
			//! cannot be the last character
			if (i + 1 >= infix.size()) {
				return 1;
			}
			//infix[i+1] != ' '
			switch (infix[i + 1]) {
			case 'T':
			case 'F':
			case '!':	//! can chain
			case '(':
				break;
			default:
				//Not a valid character to follow a !
				return 1;
			}
			
			break;
		case '&':
		{
			while (!s.empty() && s.top() != '(' && (s.top() == '&' || s.top() == '!')) {
				postfix += s.top();
				s.pop();
			}
			s.push(infix[i]);

			//Checking operand before &
			int j = i;
			while (j - 1 >= 0 && infix[j - 1] == ' ') {
				j--;
			}
			//& requires an operand before it
			if (j - 1 < 0) {
				return 1;
			}
			switch (infix[j - 1]) {
			case 'T':
			case 'F':
			case ')':
				break;
			default:
				//Only T, F, or end of parenthetical expression ')' can come before &
				return 1;
			}

			//Checking operand after & 
			while (i + 1 < infix.size() && infix[i + 1] == ' ') {
				i++;
			}

			//& must have an argument after it
			if (i + 1 >= infix.size()) {
				return 1;
			}
			//infix[i+1] != ' '
			switch (infix[i + 1]) {
			case 'T':
			case 'F':
			case '(':
			case '!':
				break;
			default:
				//Argument after & can only be T, F, !, or beginning of parenthetical expression '('
				break;
			}
		}
			break;
		case '|':
		{
			while (!s.empty() && s.top() != '(' && (s.top() == '|' || s.top() == '&' || s.top() == '!')) {
				postfix += s.top();
				s.pop();
			}
			s.push(infix[i]);

			//Check argument before |
			int j = i;
			while (j - 1 >= 0 && infix[j - 1] == ' ') {
				j--;
			}
			//| requires an operand before it
			if (j - 1 < 0) {
				return 1;
			}
			switch (infix[j - 1]) {
			case 'T':
			case 'F':
			case ')':
				break;
			default:
				//Only T, F, or end of parenthetical expression ')' can come before |
				return 1;
			}

			//Check right argument for |
			while (i + 1 < infix.size() && infix[i + 1] == ' ') {
				i++;
			}

			//| must have an argument after it
			if (i + 1 >= infix.size()) {
				return 1;
			}
			//infix[i+1] != ' '
			switch (infix[i + 1]) {
			case 'T':
			case 'F':
			case '(':
			case '!':
				break;
			default:
				//Argument after | can only be T, F, !, or beginning of parenthetical expression 
				break;
			}
		}
			break;
		case ' ':
			break;
		default:
			//Not a valid symbol
			return 1;
		}
		
	}
	//cerr << postfix << endl;
	while (!s.empty()) {
		postfix += s.top();
		s.pop();
	}

	stack<char> o;
	//Now postfix is valid and can be evaluated
	for (size_t i = 0; i < postfix.size(); i++) {
		
		switch (postfix[i]) {
		case 'T':
		case 'F':
			o.push(postfix[i]);
			break;
		case '&':
		{
			bool first, second, result;
			grabValues(o, first, second);
			result = first && second;
			if (result) {
				o.push('T');
			}
			else {
				o.push('F');
			}
		}
		break;
		case '|':
		{
			bool first, second, result;
			grabValues(o, first, second);
			result = first || second;
			if (result) {
				o.push('T');
			}
			else {
				o.push('F');
			}
		}
		break;
		case '!':
		{
			char c = o.top();
			o.pop();
			if (c == 'T')
				o.push('F');
			else
				o.push('T');
		}

		}
	}
	if (braces != 0) 
		return 1;	//Every opening brace should have a closing brace
	//cerr << "Size is " << o.size() << endl;
	result = o.top() == 'T' ? true : false;
	return 0;
}

void grabValues(stack<char>& o, bool& first, bool& second) {
	char a = o.top();
	o.pop();
	char b = o.top();
	o.pop();

	switch (a) {
	case 'T':
		first = true;
		break;
	case 'F':
		first = false;
		break;
	}

	switch (b) {
	case 'T':
		second = true;
		break;
	case 'F':
		second = false;
		break;
	}
}
