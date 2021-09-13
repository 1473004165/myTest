#include"Add.h"
#include"Subtract.h"
#include"Multiple.h"
#include"Division.h"
#include"Client.h"
#include"Fraction.h"
#include<iostream>
#include<fstream>
#include<string>
using namespace std;

int main(int argc, char ** argv)
{

	int r;
	int n;
	Client client;

	if (argc == 3) 
	{
		stringstream ss(argv[2]);
		ss >> r;
		cout << "您输入的r为: " << r << endl;
	}

	else if (argc == 5) 
	{
		stringstream s1(argv[2]);
		s1 >> r;
		cout << "您输入的r为: " << r << endl;
		stringstream s2(argv[4]);
		s2 >> n;
		cout << "您输入的n为: " << n << endl;
		client.inputRule(n, r);
	}
	else
	{
		cout << "您输入有误，请输入指定格式 ： " << "Myapp.exe -r number -n number 或 Myapp.exe -r number" << endl;
	}

	//else
	//{
	//	cout << "第四个" << argv[4] << endl;
	//	stringstream ss(argv[4]);
	//	ss >> n;
	//}

	//cout << r << "=========" << n << endl;
	//Add a = Add();
	//a.add(30, 20);

	//Subtract s = Subtract();
	//s.subtract(30, 20);

	//Multiple m = Multiple();
	//m.multiple(60, 10);

	//Division* d = new Division();
	//d->division(8, 4);

	//Client client = Client();
	//client.inputRule(50,100);//这个方法如果传两个参数，第一个为题目数，第二个为数（运算的数，分子分母）范围。如果只传一个即为r，则默认n = 2000，
	
	//Fraction f;
	//f.fraction(10);
	return 0;
	
}