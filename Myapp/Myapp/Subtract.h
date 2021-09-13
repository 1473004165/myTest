#pragma once
#include <string>
#include <iostream>
#include <sstream>
#include"RxOutputStream.h"
using namespace std;

/**
 * <author>杨滨鸿</author>
 * 整数减法类
 */
class Subtract
{
	public:
		RxOutputStream rx;
		void subtract(int num1, int num2);
};

