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
		cout << "�������rΪ: " << r << endl;
	}

	else if (argc == 5) 
	{
		stringstream s1(argv[2]);
		s1 >> r;
		cout << "�������rΪ: " << r << endl;
		stringstream s2(argv[4]);
		s2 >> n;
		cout << "�������nΪ: " << n << endl;
		client.inputRule(n, r);
	}
	else
	{
		cout << "����������������ָ����ʽ �� " << "Myapp.exe -r number -n number �� Myapp.exe -r number" << endl;
	}

	//else
	//{
	//	cout << "���ĸ�" << argv[4] << endl;
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
	//client.inputRule(50,100);//������������������������һ��Ϊ��Ŀ�����ڶ���Ϊ����������������ӷ�ĸ����Χ�����ֻ��һ����Ϊr����Ĭ��n = 2000��
	
	//Fraction f;
	//f.fraction(10);
	return 0;
	
}