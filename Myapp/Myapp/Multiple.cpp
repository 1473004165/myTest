#include "Multiple.h"



void Multiple::multiple(int num1, int num2)
{
	int result = num1 * num2;
	string str1;    //被乘数
	string str2;    //乘数
	string answer;		//运算结果
	str1 = to_string(num1);		//被乘数数转字符串
	str2 = to_string(num2);		//乘数转字符串
	answer = to_string(result);		//运算结果转字符串
	//cout << str1.append(" × ").append(str2).append(" = ").append(res) << endl;
	string question = str1.append(" × ").append(str2).append(" = ").append("?");
	rx.outputAnswer(answer);
	rx.outputQuestion(question);
}