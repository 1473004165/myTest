#include "Fraction.h"




void Fraction::fraction(int r)
{
	int num1 = 1 + rand() % r;   //������������
	int num2 = 1 + rand() % r;	 //����������ĸ
	int num3 = 1 + rand() % r;   //����������
	int num4 = 1 + rand() % r;   //��������ĸ
	int num5 = 1 + rand() % 4;   //�����������
	int z;                       //��������������
	int x;                       //�������������Ӳ���
	int m;                       //������������ĸ����
	//cout << num1 << num2 << num3 << num4 << num5 << endl;
	//cout << "num5Ϊ   " << num5 << endl;
	int flag = 0;
	string question;
	if (num5 == 1)
	{
		//��
		question = to_string(num1).append("/").append(to_string(num2)).append(" + ").append(to_string(num3)).append("/").append(to_string(num4)).append(" = ").append("?");
		for (int j = 1; ; j++)
		{
			for (int i = 1; i <= max(num2, num4); i++)
			{
				if ((num2 >= num4) && ((m = num2*j) == num4*i))//��ȡ��ĸ
				{
					//cout << "i��ֵΪ" << i <<"mΪ  "<<m<< endl;
					num1 *= j;
					num3 *= i;
					//cout << "num1" << num1 << "--------" << num3 <<"��Ϊ  " << num1 + num3 <<endl;
					z = ((num1 + num3) / m);    //��ȡ����
					//cout << "z��ֵΪ" << z << endl;
					x = ((num1 + num3) % m);         //��ȡ����
					if (m % x == 0)					   //����Լ��
					{
						m /= x;
						x = 1;
					}
					flag = 1;
					break;
				}
				else if ((num2 < num4) && ((m = num2*i) == num4*j))
				{
					//cout << "i��ֵΪ" << i << "mΪ" << m << endl;
					num1 *= i;
					num3 *= j;
					z = ((num1 + num3) / m);    //��ȡ����
					x = ((num1 + num3) % m);         //��ȡ����
					if (m % x == 0)					   //����Լ��
					{
						m /= x;
						x = 1;
					}
					flag = 1;
					break;
				}
			}
			if (flag == 1)
			{
				break;
			}
		}
	}
	else if (num5 == 2)
	{

		//����
	    //�ų�����
		//cout << "����" <<(num1 / num3) - (num2 / num4) << endl;
		if ((num1 / num3) - (num2 / num4) < 0)
		{
			fraction(r);
			return;
		}
		else
		{
			question = to_string(num1).append("/").append(to_string(num2)).append(" - ").append(to_string(num3)).append("/").append(to_string(num4)).append(" = ").append("?");
			for (int j = 1; ; j++)
			{
				for (int i = 1;i <= max(num2,num4); i++)
				{
					if ((num2 >= num4) && ((m = num2*j) == num4*i))//��ȡ��ĸ
					{
						//cout << "i��ֵΪ" << i <<"mΪ  "<<m<< endl;
						//cout << "j��ֵΪ" << j << "mΪ  " << m << endl;
						num1 *= j;
						num3 *= i;
						//cout << "num1" << num1 << "--------" << num3 <<"��Ϊ  " << num1 + num3 <<endl;
						z = ((num1 - num3) / m);    //��ȡ����
													//cout << "z��ֵΪ" << z << endl;
						x = ((num1 - num3) % m);         //��ȡ����
						if (m % x == 0)					   //����Լ��
						{
							m /= x;
							x = 1;
						}
						flag = 1;
						break;
					}
					else if ((num2 < num4) && ((m = (num2*i)) == num4*j))
					{
						//cout << "i��ֵΪ" << i << "mΪ" << m << endl;
						//cout << "j��ֵΪ" << j << "mΪ  " << m << endl;
						num1 *= i;
						num3 *= j;
						z = ((num1 - num3) / m);    //��ȡ����
						x = ((num1 - num3) % m);         //��ȡ����
						if ((x != 0) && (m % x == 0))					   //����Լ��
						{
							m /= x;
							x = 1;
						}
						flag = 1;
						break;
					}
				}
				if (flag == 1)
				{
					break;
				}
			}
		}
	}
	else if (num5 == 3)
	{
		//�˷�
		question = to_string(num1).append("/").append(to_string(num2)).append(" �� ").append(to_string(num3)).append("/").append(to_string(num4)).append(" = ").append("?");
		x = num1*num3;
		m = num2*num4;
		z = x / m;
		if (x > m)
		{
			x %= m;
		}
		if (m % x == 0)					   //����Լ��
		{
			m /= x;
			x = 1;
		}
	}
	else if (num5 == 4)
	{


		//����
		question = to_string(num1).append("/").append(to_string(num2)).append(" �� ").append(to_string(num3)).append("/").append(to_string(num4)).append(" = ").append("?");
		x = num1*num4;
		m = num2*num3;
		z = x / m;
		if (x > m)
		{
			x %= m;
		}
		if (m % x == 0)					   //����Լ��
		{
			m /= x;
			x = 1;
		}
	}
	string answer;
	if (z == 0) {      //�Ǵ�����
		answer = to_string(x).append("/").append(to_string(m));
	}
	else
	{
		//cout << "x��ֵΪ" << x << endl;
		if (x == 0) 
		{
			answer = to_string(z);
		}
		else 
		{
			answer = to_string(z).append("' ").append(to_string(x)).append("/").append(to_string(m));
		}
	}
	//cout << question << "and         " << answer << endl;
	rx.outputQuestion(question);
	rx.outputAnswer(answer);
}