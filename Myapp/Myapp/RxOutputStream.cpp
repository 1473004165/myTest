#include "RxOutputStream.h"


//�ļ�д�����
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


//д���
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