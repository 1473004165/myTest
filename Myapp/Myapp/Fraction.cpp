#include "Fraction.h"




void Fraction::fraction(int r)
{
	int num1 = 1 + rand() % r;   //被操作数分子
	int num2 = 1 + rand() % r;	 //被操作数分母
	int num3 = 1 + rand() % r;   //操作数分子
	int num4 = 1 + rand() % r;   //操作数分母
	int num5 = 1 + rand() % 4;   //决定运算符号
	int z;                       //计算结果整数部分
	int x;                       //计算结果分数分子部分
	int m;                       //计算结果分数分母部分
	//cout << num1 << num2 << num3 << num4 << num5 << endl;
	//cout << "num5为   " << num5 << endl;
	int flag = 0;
	string question;
	if (num5 == 1)
	{
		//加
		question = to_string(num1).append("/").append(to_string(num2)).append(" + ").append(to_string(num3)).append("/").append(to_string(num4)).append(" = ").append("?");
		for (int j = 1; ; j++)
		{
			for (int i = 1; i <= max(num2, num4); i++)
			{
				if ((num2 >= num4) && ((m = num2*j) == num4*i))//获取分母
				{
					//cout << "i的值为" << i <<"m为  "<<m<< endl;
					num1 *= j;
					num3 *= i;
					//cout << "num1" << num1 << "--------" << num3 <<"和为  " << num1 + num3 <<endl;
					z = ((num1 + num3) / m);    //获取整数
					//cout << "z的值为" << z << endl;
					x = ((num1 + num3) % m);         //获取分子
					if (m % x == 0)					   //可以约分
					{
						m /= x;
						x = 1;
					}
					flag = 1;
					break;
				}
				else if ((num2 < num4) && ((m = num2*i) == num4*j))
				{
					//cout << "i的值为" << i << "m为" << m << endl;
					num1 *= i;
					num3 *= j;
					z = ((num1 + num3) / m);    //获取整数
					x = ((num1 + num3) % m);         //获取分子
					if (m % x == 0)					   //可以约分
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

		//减法
	    //排除负数
		//cout << "减法" <<(num1 / num3) - (num2 / num4) << endl;
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
					if ((num2 >= num4) && ((m = num2*j) == num4*i))//获取分母
					{
						//cout << "i的值为" << i <<"m为  "<<m<< endl;
						//cout << "j的值为" << j << "m为  " << m << endl;
						num1 *= j;
						num3 *= i;
						//cout << "num1" << num1 << "--------" << num3 <<"和为  " << num1 + num3 <<endl;
						z = ((num1 - num3) / m);    //获取整数
													//cout << "z的值为" << z << endl;
						x = ((num1 - num3) % m);         //获取分子
						if (m % x == 0)					   //可以约分
						{
							m /= x;
							x = 1;
						}
						flag = 1;
						break;
					}
					else if ((num2 < num4) && ((m = (num2*i)) == num4*j))
					{
						//cout << "i的值为" << i << "m为" << m << endl;
						//cout << "j的值为" << j << "m为  " << m << endl;
						num1 *= i;
						num3 *= j;
						z = ((num1 - num3) / m);    //获取整数
						x = ((num1 - num3) % m);         //获取分子
						if ((x != 0) && (m % x == 0))					   //可以约分
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
		//乘法
		question = to_string(num1).append("/").append(to_string(num2)).append(" × ").append(to_string(num3)).append("/").append(to_string(num4)).append(" = ").append("?");
		x = num1*num3;
		m = num2*num4;
		z = x / m;
		if (x > m)
		{
			x %= m;
		}
		if (m % x == 0)					   //可以约分
		{
			m /= x;
			x = 1;
		}
	}
	else if (num5 == 4)
	{


		//除法
		question = to_string(num1).append("/").append(to_string(num2)).append(" ÷ ").append(to_string(num3)).append("/").append(to_string(num4)).append(" = ").append("?");
		x = num1*num4;
		m = num2*num3;
		z = x / m;
		if (x > m)
		{
			x %= m;
		}
		if (m % x == 0)					   //可以约分
		{
			m /= x;
			x = 1;
		}
	}
	string answer;
	if (z == 0) {      //非带分数
		answer = to_string(x).append("/").append(to_string(m));
	}
	else
	{
		//cout << "x的值为" << x << endl;
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