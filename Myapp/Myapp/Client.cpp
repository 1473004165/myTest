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
		throw "�ò��������Ǵ��ڵ���1����Ȼ��";
	}

	//int a = 1 + rand() % r;

	//cout << a << endl;
	//����������㷽ʽ
	//string method[2000];
	int num = 2000;//Ĭ����Ŀ��Ŀǰ��2000��
	//cout << (sizeof(method) / sizeof(method[0])) << endl;
	//ofstream out("?C:\\Users\\Legion\\Desktop\\out.txt");
	int a;
	for (int i = 0; i < num; i++)
	{
		a = (rand() % 5) + 1;    //����[1,6)�����������������Ԥ�㷽ʽ
		if (a == 1)
		{
			//add.input(1 + rand() % r, 1 + rand() % r);  //�ӷ�
			add.add(1 + rand() % r, 1 + rand() % r);
		}
		else if (a == 2)
		{
			subtractPlus(r);     //����
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
			//���ɷ������ʽ
			fraction.fraction(r);
		}
		//method[i] = a;
		//cout << a << "��" << i << "��" << endl;
	}
	
	//return method;

}



void Client :: inputRule(int n, int r)    //���غ�������n��r����ʱ����
{

	if (r <= 0) {
		throw "�ò��������Ǵ��ڵ���1����Ȼ��";
	}

	if (n <= 0)
	{
		throw "��Ŀ��������ڵ���1";
	}



	//����������㷽ʽ
	//int *method = new int[n];		//Ĭ����Ŀ��Ŀǰ��2000��
	//cout << "����ĳ���Ϊ" << (sizeof(method) / sizeof(method[0])) << endl;
	int a;
	for (int i = 0; i < n; i++)
	{
		a = (rand() % 5) + 1;    //����[1,6)�����������������Ԥ�㷽ʽ
		if (a == 1)
		{
			//add.input(1 + rand() % r, 1 + rand() % r);  //�ӷ�
			add.add(1 + rand() % r, 1 + rand() % r);
		}
		else if (a == 2)
		{
			subtractPlus(r);     //����
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
			//���ɷ������ʽ
			fraction.fraction(r);
		}
		//method[i] = a;
		//cout << a << "��" << i << "��" << endl;
	}
	//delete method;
}
