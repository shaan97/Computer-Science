#ifndef HISTORY_H
#define HISTORY_H



class History
{
private:
	char** disp;
	int rows, cols;
public:
	History(int nRows, int nCols);
	~History();
	bool record(int r, int c);
	void display() const;
};




#endif