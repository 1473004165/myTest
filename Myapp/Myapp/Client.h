#pragma once
#include"Add.h"
#include"Subtract.h"
#include"Multiple.h"
#include"Division.h"
#include"Fraction.h"
#include <string>
#include <iostream>
#include <sstream>
#include<fstream>

using namespace std;

/**
* <author>—Ó±ı∫Ë</author>
* ¬ﬂº≠ µœ÷¿‡
*/
class Client
{

	private:
		void subtractPlus(int r);


	public:
		Division division;
		Fraction fraction;
		Subtract subtract;
		Multiple multiple;
		Add add;

		void inputRule(int r);
		void inputRule(int n, int r);


};

