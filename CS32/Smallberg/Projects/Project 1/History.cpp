#include "History.h"
#include "globals.h"
#include <iostream>

using namespace std;

History::History(int nRows, int nCols) {
	this->disp = new char*[nRows];
	for (int i = 0; i < nRows; i++) {
		this->disp[i] = new char[nCols];
	}

	for (int i = 0; i < nRows; i++) {
		for (int j = 0; j < nCols; j++) {
			this->disp[i][j] = '.';
		}
	}

	this->rows = nRows;
	this->cols = nCols;
}

History::~History() {
	for (int j = 0; j < rows; j++) {
		delete disp[j];
	}
	delete disp;
}
bool History::record(int r, int c) {
	if (r > MAXROWS || r < 1 || c > MAXCOLS || c < 1)
		return false;

	char c1 = this->disp[r - 1][c - 1];
	if (c1 >= 'A' && c1 < 'Z') {
		this->disp[r - 1][c - 1] += 1;
	}
	else if (c1 != 'Z') {
		this->disp[r - 1][c - 1] = 'A';
	}
	
	return true;
}
void History::display() const {
	clearScreen();
	for (int i = 0; i < this->rows; i++) {
		for (int j = 0; j < this->cols; j++) {
			cout << this->disp[i][j];
		}
		cout << endl;
	}
	cout << endl;
}