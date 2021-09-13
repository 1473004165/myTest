#include "RxOutputStream.h"


//文件写入题库
void RxOutputStream::outputQuestion(string text)
{
	ofstream file;
	file.open("Exercises.txt", ios::app);
	if (file.is_open())
	{
		file << text << endl;
	}
	file.close();
}


//写入答案
void RxOutputStream::outputAnswer(string text)
{
	ofstream file;
	file.open("Answers.txt", ios::app);
	if (file.is_open())
	{
		file << text << endl;
	}
	file.close();
}