// Scaffold.cpp

#include "provided.h"
#include <iostream>
#include <vector>
#include <stack>

using namespace std;

class ScaffoldImpl
{
private:
	vector<int>* col;
	stack<int>* moves;
	int numLvl, numCol;
	int vacancies;
public:
	ScaffoldImpl(int nColumns, int nLevels);
	~ScaffoldImpl();
	ScaffoldImpl(const ScaffoldImpl& s);
	int cols() const;
	int levels() const;
	int numberEmpty() const;
	int checkerAt(int column, int level) const;
	void display() const;

	bool makeMove(int column, int color);
	int undoMove();
	//int mostRecentMove() const;

	ScaffoldImpl& operator=(const ScaffoldImpl& s);
	void swap(ScaffoldImpl& s);
};

ScaffoldImpl::~ScaffoldImpl() {
	delete[] col;
	delete moves;
}

ScaffoldImpl::ScaffoldImpl(const ScaffoldImpl& s) {
	
	this->numLvl = s.numLvl;
	this->numCol = s.numCol;

	this->moves = new stack<int>(*(s.moves));
	this->vacancies = s.vacancies;

	col = new vector<int>[s.numCol];
	for (int i = 0; i < s.numCol; i++) {
		this->col[i] = s.col[i];
	}
}

//O(N)
ScaffoldImpl::ScaffoldImpl(int nColumns, int nLevels) : numLvl(nLevels), numCol(nColumns)
{
	this->vacancies = this->numLvl * this->numCol;
	col = new vector<int>[nColumns];

	for (int i = 0; i < nColumns; i++) {
		col[i].reserve(nLevels);
	}

	moves = new stack<int>;
	
}

/*int ScaffoldImpl::mostRecentMove() const {
	return moves->top();
}*/
int ScaffoldImpl::cols() const
{
	return this->numCol;
}

int ScaffoldImpl::levels() const
{
	return this->numLvl;
}

int ScaffoldImpl::numberEmpty() const
{
	return this->vacancies;
}

int ScaffoldImpl::checkerAt(int column, int level) const
{
	if (level > col[column - 1].size())
		return VACANT;
		

	return col[column - 1].at(level - 1);
}

void ScaffoldImpl::display() const
{
	for (int j = this->numLvl - 1; j >= 0; j--) {
		for (int i = 0; i < this->numCol; i++) {
			cout << "|";
			switch (checkerAt(i + 1, j + 1)) {
			case RED:
				cout << "R";
				break;
			case BLACK:
				cout << "B";
				break;
			case VACANT:
				cout << " ";
				break;
			default:
				cout << " ";
				break;
			}
		}
		cout << "|\n";
	}

	for (int i = 0; i < this->numCol; i++) {
		cout << "+-";
	}
	cout << "+\n";
}

bool ScaffoldImpl::makeMove(int column, int color)
{
	if (column < 1 || column > this->numCol)	//Valid number?
		return false;
	if (col[column - 1].size() >= this->numLvl) //Is there space?
		return false;
	if (color != RED && color != BLACK)			//Is it a valid value?
		return false;

	col[column - 1].push_back(color);			//Push, record, and decrement vacancies
	moves->push(column - 1);
	this->vacancies--;
	return true;
}

int ScaffoldImpl::undoMove()
{
	if (moves->empty())
		return 0;
	
	int a = moves->top();
	col[a].pop_back();
	moves->pop();
	this->vacancies++;
	return a + 1;
}

ScaffoldImpl& ScaffoldImpl::operator=(const ScaffoldImpl& s) {
	ScaffoldImpl a = s;
	swap(a);
	return *this;
}

void ScaffoldImpl::swap(ScaffoldImpl& s) {
	vector<int>* temp = this->col;
	this->col = s.col;
	s.col = temp;

	stack<int>* t = this->moves;
	this->moves = s.moves;
	s.moves = t;

	int t2 = this->numCol;
	this->numCol = s.numCol;
	s.numCol = t2;

	t2 = this->numLvl;
	this->numLvl = s.numLvl;
	s.numLvl = t2;

	
}

//******************** Scaffold functions *******************************

// These functions simply delegate to ScaffoldImpl's functions.
// You probably don't want to change any of this code.

Scaffold::Scaffold(int nColumns, int nLevels)
{
	m_impl = new ScaffoldImpl(nColumns, nLevels);
}

Scaffold::~Scaffold()
{
	delete m_impl;
}

Scaffold::Scaffold(const Scaffold& other)
{
	m_impl = new ScaffoldImpl(*other.m_impl);
}

Scaffold& Scaffold::operator=(const Scaffold& rhs)
{
	if (this != &rhs)
	{
		Scaffold temp(rhs);
		swap(m_impl, temp.m_impl);
	}
	return *this;
}

int Scaffold::cols() const
{
	return m_impl->cols();
}

int Scaffold::levels() const
{
	return m_impl->levels();
}

int Scaffold::numberEmpty() const
{
	return m_impl->numberEmpty();
}

int Scaffold::checkerAt(int column, int level) const
{
	return m_impl->checkerAt(column, level);
}

void Scaffold::display() const
{
	m_impl->display();
}

bool Scaffold::makeMove(int column, int color)
{
	return m_impl->makeMove(column, color);
}

int Scaffold::undoMove()
{
	return m_impl->undoMove();
}
