#include "Subtract.h"



void Subtract::subtract(int num1, int num2)
{
	int result = num1 - num2;
	string str1;    //������
	string str2;    //����
	string answer;		//������
	str1 = to_string(num1);		//������ת�ַ���
	str2 = to_string(num2);		//����ת�ַ���
	answer = to_string(result);		//������ת�ַ���
	//cout << str1.append(" - ").append(str2).append(" = ").append(res) << endl;
	string question = str1.append(" - ").append(str2).append(" = ").append("?");
	rx.outputAnswer(answer);
	rx.outputQuestion(question);
}
