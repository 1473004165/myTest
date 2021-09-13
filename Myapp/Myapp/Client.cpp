#include "Client.h"




void Client :: subtractPlus(int r)
{
	int num1 = 1 + rand() % r;
	int num2 = 1 + rand() % r;

	if (num1 >= num2)
	{
		subtract.subtract(num1,num2);
	}
	else
	{
		subtractPlus(r);
	}
}


void Client:: inputRule(int r)
{


	if (r <= 0) {
		throw "该参数必须是大于等于1的自然数";
	}

	//int a = 1 + rand() % r;

	//cout << a << endl;
	//定义随机运算方式
	//string method[2000];
	int num = 2000;//默认题目数目前是2000道
	//cout << (sizeof(method) / sizeof(method[0])) << endl;
	//ofstream out("?C:\\Users\\Legion\\Desktop\\out.txt");
	int a;
	for (int i = 0; i < num; i++)
	{
		a = (rand() % 5) + 1;    //生成[1,6)的随机数，代表四种预算方式
		if (a == 1)
		{
			//add.input(1 + rand() % r, 1 + rand() % r);  //加法
			add.add(1 + rand() % r, 1 + rand() % r);
		}
		else if (a == 2)
		{
			subtractPlus(r);     //减法
		}
		else if (a == 3)
		{
			multiple.multiple(1 + rand() % r, 1 + rand() % r);
		}
		else if (a == 4)
		{
			division.division(1 + rand() % r, 1 + rand() % r);
		}
		else if (a == 5)
		{
			//生成分数表达式
			fraction.fraction(r);
		}
		//method[i] = a;
		//cout << a << "第" << i << "次" << endl;
	}
	
	//return method;

}



void Client :: inputRule(int n, int r)    //重载函数，当n和r都传时调用
{

	if (r <= 0) {
		throw "该参数必须是大于等于1的自然数";
	}

	if (n <= 0)
	{
		throw "题目数必须大于等于1";
	}



	//定义随机运算方式
	//int *method = new int[n];		//默认题目数目前是2000道
	//cout << "数组的长度为" << (sizeof(method) / sizeof(method[0])) << endl;
	int a;
	for (int i = 0; i < n; i++)
	{
		a = (rand() % 5) + 1;    //生成[1,6)的随机数，代表四种预算方式
		if (a == 1)
		{
			//add.input(1 + rand() % r, 1 + rand() % r);  //加法
			add.add(1 + rand() % r, 1 + rand() % r);
		}
		else if (a == 2)
		{
			subtractPlus(r);     //减法
		}
		else if (a == 3)
		{
			multiple.multiple(1 + rand() % r, 1 + rand() % r);
		}
		else if (a == 4)
		{
			division.division(1 + rand() % r, 1 + rand() % r);
		}
		else if (a == 5)
		{
			//生成分数表达式
			fraction.fraction(r);
		}
		//method[i] = a;
		//cout << a << "第" << i << "次" << endl;
	}
	//delete method;
}
