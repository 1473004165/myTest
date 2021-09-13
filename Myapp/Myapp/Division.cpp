#include "Division.h"



void Division::division(int num1, int num2)
{
	int result = num1 / num2;
	string str1;    //被除数
	string str2;    //除数
	string answer;		//运算结果
	str1 = to_string(num1);		//被加数转字符串
	str2 = to_string(num2);		//除数转字符串
	answer = to_string(result);		//运算结果转字符串
	//cout << str1.append(" ÷ ").append(str2).append(" = ").append(res) << endl;
	string question = str1.append(" ÷ ").append(str2).append(" = ").append("?");
	rx.outputAnswer(answer);
	rx.outputQuestion(question);
}
