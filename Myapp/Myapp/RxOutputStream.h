#pragma once
#include<iostream>
#include<fstream>
#include<string>
using namespace std;


/**
 * <author>杨滨鸿</author>
 * I/O输出类
 */
class RxOutputStream
{
	public:

		//将写入题目写入文件
		void outputQuestion(string text);
		void outputAnswer(string text);
};

