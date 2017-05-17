// Player.cpp

#include <climits>
#include "provided.h"
#include <string>
#include <iostream>

using namespace std;

class HumanPlayerImpl
{
public:
	int chooseMove(const Scaffold& s, int N, int color);
};

class BadPlayerImpl
{
public:
	int chooseMove(const Scaffold& s, int N, int color);
};

class SmartPlayerImpl
{
public:
	int chooseMove(const Scaffold& s, int N, int color);
};

int HumanPlayerImpl::chooseMove(const Scaffold& s, int N, int color)
{
	if (s.numberEmpty() == 0)
		return -1;

	int answer;
	cout << "Select column (1 - " << s.cols() << ") to insert checker:\t";
	cin >> answer;
	while (answer < 1 || answer > s.cols()) {
		cout << "Invalid column. Try again!" << endl;
		cin >> answer;
	}

	cin.ignore(INT_MAX, '\n');
	return answer;
}

int BadPlayerImpl::chooseMove(const Scaffold& s, int N, int color)
{
	//Put here as an optimization
	if (s.numberEmpty() == 0)
		return -1;

	//Finds leftmost non-filled column and returns it
	for (int j = 1; j <= s.cols(); j++) {
		if (s.checkerAt(j, s.levels()) == VACANT)
			return j;
	}

	//Redundant, but put here as a precaution
	return -1;
}

int opt_examine(const Scaffold& scaf, int n, int col_new, int color, int depth) {
	int lvl_new;
	for (int i = scaf.levels(); i > 0; i--) {
		if (scaf.checkerAt(col_new, i) == color) {
			lvl_new = i;
			break;
		}
	}

	for (int j = -1; j <= 1; j++) {
		int i = 1;
		if (i == 0 && j == 0)
			continue;

		int currentLvl = lvl_new;
		int currentCol = col_new;
		int count = 0;
		do {
			count++;
			if (count == n)
				return (scaf.numberEmpty() + 1) * (depth % 2 == 0 ? -1 : 1);

			currentLvl += i;
			currentCol += j;
			if (currentCol <= 0 || currentCol > scaf.cols() || currentLvl <= 0 || currentLvl > scaf.levels())
				break;
		} while (scaf.checkerAt(currentCol, currentLvl) == color);

		currentLvl = lvl_new;
		currentCol = col_new;
		count--;
		do {
			count++;
			if (count == n)
				return (scaf.numberEmpty() + 1) * (depth % 2 == 0 ? -1 : 1);
			currentLvl -= i;
			currentCol -= j;
			if (currentCol <= 0 || currentCol > scaf.cols() || currentLvl <= 0 || currentLvl > scaf.levels())
				break;
		} while (scaf.checkerAt(currentCol, currentLvl) == color);
	}

	int j = 1;
	int i = 0;

	int currentLvl = lvl_new;
	int currentCol = col_new;
	int count = 0;
	do {
		count++;
		if (count == n)
			return (scaf.numberEmpty() + 1) * (depth % 2 == 0 ? -1 : 1);
		currentLvl += i;
		currentCol += j;
		if (currentCol <= 0 || currentCol > scaf.cols() || currentLvl <= 0 || currentLvl > scaf.levels())
			break;
	} while (scaf.checkerAt(currentCol, currentLvl) == color);
	currentLvl = lvl_new;
	currentCol = col_new;
	count--;
	do {
		count++;
		if (count == n)
			return (scaf.numberEmpty() + 1) * (depth % 2 == 0 ? -1 : 1);
		currentLvl -= i;
		currentCol -= j;
		if (currentCol <= 0 || currentCol > scaf.cols() || currentLvl <= 0 || currentLvl > scaf.levels())
			break;
	} while (scaf.checkerAt(currentCol, currentLvl) == color);

	return 0;
}

int standard_examine(const Scaffold& s, int N, int color, int depth) {
	for (int i = s.levels(); i > 0; i--) {
		for (int j = 1; j <= s.cols(); j++) {
			if (s.checkerAt(j, i) != color)
				continue;
			//s.checkerAt(j, i) == color

			//Look right if haven't already examined this pathway before
			if ((j + N <= s.cols() + 1) && (j == 1 || s.checkerAt(j - 1, i) != color)) {
				int count = 1;
				int t_j = j + 1;
				if (count == N) {
					//	cerr << "End is at " << t_j - 1 << "," << i << endl;
					return (s.numberEmpty() + 1) * (depth % 2 == 0 ? -1 : 1);
				}
				while (s.checkerAt(t_j, i) == color) {
					t_j++;
					count++;
					if (count == N) {
						//		cerr << "End is at " << t_j - 1 << "," << i << endl;
						return (s.numberEmpty() + 1) * (depth % 2 == 0 ? -1 : 1);
					}
				}
			}

			//Look down if haven't already examined this pathway before
			if ((i >= N) && (i == s.levels() || s.checkerAt(j, i + 1) != color)) {
				int count = 1;
				int t_i = i - 1;
				if (count == N) {
					//	cerr << "End is at " << j << ", " << t_i + 1 << endl;
					return (s.numberEmpty() + 1) * (depth % 2 == 0 ? -1 : 1);
				}
				while (s.checkerAt(j, t_i) == color) {
					t_i--;
					count++;
					if (count == N) {
						//		cerr << "End is at " << j << ", " << t_i + 1 << endl;
						return (s.numberEmpty() + 1) * (depth % 2 == 0 ? -1 : 1);
					}
				}

			}


			//Look diagonally downwards to the right if haven't already examined this pathway before
			if (j + N <= s.cols() + 1 && i >= N && ((i == s.levels() || j == 1) || s.checkerAt(j - 1, i + 1) != color)) {
				int count = 1;
				int t_i = i - 1;
				int t_j = j + 1;
				if (count == N) {
					//		cerr << "End is at " << t_j - 1 << ", " << t_i + 1 << endl;
					return (s.numberEmpty() + 1)* (depth % 2 == 0 ? -1 : 1);
				}
				while (s.checkerAt(t_j, t_i) == color) {
					t_i--;
					t_j++;
					count++;
					if (count == N) {
						//	cerr << "End is at " << t_j - 1 << ", " << t_i + 1 << endl;
						return (s.numberEmpty() + 1) * (depth % 2 == 0 ? -1 : 1);
					}
				}
			}

			//Look diagonally downwards to the left if haven't already examined this pathway before
			if (i >= N && j >= N && ((i == s.levels() || j == s.cols()) || s.checkerAt(j + 1, i + 1))) {
				int count = 1;
				int t_i = i - 1;
				int t_j = j - 1;
				if (count == N) {
					//	cerr << "End is at " << t_j + 1 << ", " << t_i + 1 << endl;
					return (s.numberEmpty() + 1) * (depth % 2 == 0 ? -1 : 1);
				}
				while (s.checkerAt(t_j, t_i) == color) {
					t_i--;
					t_j--;
					count++;
					if (count == N) {
						//		cerr << "End is at " << t_j + 1 << ", " << t_i + 1 << endl;
						return (s.numberEmpty() + 1) * (depth % 2 == 0 ? -1 : 1);
					}
				}
			}

		}
	}

	return 0;
}

//returns worst case result for the given player in the given game
int rate(Scaffold& s, int N, int color, int depth, int col_new) {


	if ((s.cols()*s.levels() - s.numberEmpty() == (2 * N - 1))) {
		int t = standard_examine(s, N, (color == RED ? BLACK : RED), depth);
		if (t != 0)
			return t;
		if (s.numberEmpty() == 0)
			return 0;
	}
	else if ((s.cols()*s.levels() - s.numberEmpty() > (2 * N - 1))) {
		//	bool stand = standard_examine(s, N, (color == RED ? BLACK : RED), depth);
		//	bool opt = opt_examine(s, N, col_new, (color == RED ? BLACK : RED));
		int t = opt_examine(s, N, col_new, (color == RED ? BLACK : RED), depth);
		/*	if ( stand != opt)
		{
		cout << "Stand:\t" << stand << endl;
		cout << "Opt:\t" << opt << endl;
		s.display();
		cin.ignore(INT_MAX, '\n');
		}
		*/

		if (t != 0)
			return t;
		if (s.numberEmpty() == 0)
			return 0;
	}
	//Not a tie and not empty

	//otherwise, rate each next possible move to find which move yields the best result in the worst case 
	int worst = INT_MAX, best = -1 * INT_MAX;
	for (int column = 1; column <= s.cols(); column++) {
		//For the given column #, insert a checker
		if (s.checkerAt(column, s.levels()) != VACANT)
			continue;
		s.makeMove(column, color);
		int temp = rate(s, N, (color == RED ? BLACK : RED), depth + 1, column);
		if (temp > best) {
			best = temp;
		}
		if (temp < worst) {
			worst = temp;
		}
		s.undoMove();
	}

	if (depth % 2 == 1) {
		return worst;
	}
	else
		return best;

}

int SmartPlayerImpl::chooseMove(const Scaffold& s, int N, int color) {
	Scaffold a(s);
	int bestIndex = 1, bestCaseValue = -1 * INT_MAX;

	//Go through each column and figure out which column will yield the best result in the worst case
	for (int column = 1; column <= s.cols(); column++) {
		//Put a checker in this # column
		if (a.checkerAt(column, a.levels()) != VACANT)
			continue;
		a.makeMove(column, color);
		//Figure out its worst case result
		int temp = rate(a, N, (color == RED ? BLACK : RED), 1, column);
		//if that is the most profitable worst case, remember it
		if (temp > bestCaseValue) {
			bestIndex = column;
			bestCaseValue = temp;
		}
		//take out that checker
		a.undoMove();
	}

	return bestIndex;
}



//******************** Player derived class functions *************************

// These functions simply delegate to the Impl classes' functions.
// You probably don't want to change any of this code.

HumanPlayer::HumanPlayer(string nm)
	: Player(nm)
{
	m_impl = new HumanPlayerImpl;
}

HumanPlayer::~HumanPlayer()
{
	delete m_impl;
}

int HumanPlayer::chooseMove(const Scaffold& s, int N, int color)
{
	return m_impl->chooseMove(s, N, color);
}

BadPlayer::BadPlayer(string nm)
	: Player(nm)
{
	m_impl = new BadPlayerImpl;
}

BadPlayer::~BadPlayer()
{
	delete m_impl;
}

int BadPlayer::chooseMove(const Scaffold& s, int N, int color)
{
	return m_impl->chooseMove(s, N, color);
}

SmartPlayer::SmartPlayer(string nm)
	: Player(nm)
{
	m_impl = new SmartPlayerImpl;
}

SmartPlayer::~SmartPlayer()
{
	delete m_impl;
}

int SmartPlayer::chooseMove(const Scaffold& s, int N, int color)
{
	return m_impl->chooseMove(s, N, color);
}
