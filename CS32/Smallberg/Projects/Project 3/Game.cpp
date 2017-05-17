// Game.cpp

#include <climits>
#include "provided.h"
#include <iostream>

using namespace std;

class GameImpl
{
private:
	Scaffold scaf;
	int n;
	Player* red, *black;
	bool redTurn, gameOver;
	bool examine(int color) const;
	bool opt_examine(int color) const;
	int col_new;
public:
	GameImpl(int nColumns, int nLevels, int N, Player* red, Player* black);
	bool completed(int& winner) const;
	bool takeTurn();
	void play();
	int checkerAt(int c, int r) const;
};

GameImpl::GameImpl(int nColumns, int nLevels, int N, Player* red, Player* black) : scaf(nColumns, nLevels), n(N)
{
	this->red = red;
	this->black = black;	//TODO: See if this can be fixed
	redTurn = true;
	gameOver = false;
}

bool GameImpl::completed(int& winner) const
{
	//This code COULD be optimized by checking the most recent player first, but
	//in the manner that I use this function, it's not really necessary, and will only
	//make things messier, in my opinion.
	if (examine(RED)) {
		winner = RED;
		return true;
	}
	else if (examine(BLACK)) {
		winner = BLACK;
		return true;
	}
	else if (this->scaf.numberEmpty() == 0) {
		winner = TIE_GAME;
		return true;
	}

	return false;
}

bool GameImpl::opt_examine(int color) const {
	int lvl_new;
	for (int i = scaf.levels(); i > 0; i--) {
		if (scaf.checkerAt(col_new, i) == color) {
			lvl_new = i;
			break;
		}
	}

	for (int i = -1; i <= 1; i++) {
		for (int j = -1; j <= 1; j++) {
			if (i == 0 && j == 0)
				continue;

			int currentLvl = lvl_new;
			int currentCol = col_new;
			int count = 0;
			do {
				count++;
				if (count == n)
					return true;

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
					return true;

				currentLvl -= i;
				currentCol -= j;
				if (currentCol <= 0 || currentCol > scaf.cols() || currentLvl <= 0 || currentLvl > scaf.levels())
					break;

			} while (scaf.checkerAt(currentCol, currentLvl) == color);
		}
	}
	return false;
}
	
bool GameImpl::examine(int color) const {
	for (int i = scaf.levels(); i > 0; i--) {
		for (int j = 1; j <= scaf.cols(); j++) {
			if (scaf.checkerAt(j, i) != color)
				continue;
			//s.checkerAt(j, i) == color

			//Look right if haven't already examined this pathway before
			if ((j + this->n <= scaf.cols() + 1) && (j == 1 || scaf.checkerAt(j - 1, i) != color)) {
				int count = 1;
				int t_j = j + 1;
				if (count == this->n) {
					//	cerr << "End is at " << t_j - 1 << "," << i << endl;
					return true;
				}
				while (scaf.checkerAt(t_j, i) == color) {
					t_j++;
					count++;
					if (count == this->n) {
						//		cerr << "End is at " << t_j - 1 << "," << i << endl;
						return true;
					}
				}
			}

			//Look down if haven't already examined this pathway before
			if ((i >= this->n) && (i == scaf.levels() || scaf.checkerAt(j, i + 1) != color)) {
				int count = 1;
				int t_i = i - 1;
				if (count == this->n) {
					//	cerr << "End is at " << j << ", " << t_i + 1 << endl;
					return true;
				}
				while (scaf.checkerAt(j, t_i) == color) {
					t_i--;
					count++;
					if (count == this->n) {
						//		cerr << "End is at " << j << ", " << t_i + 1 << endl;
						return true;
					}
				}

			}


			//Look diagonally downwards to the right if haven't already examined this pathway before
			if (j + this->n <= scaf.cols() + 1 && i >= this->n && ((i == scaf.levels() || j == 1) || scaf.checkerAt(j - 1, i + 1) != color)) {
				int count = 1;
				int t_i = i - 1;
				int t_j = j + 1;
				if (count == this->n) {
					//		cerr << "End is at " << t_j - 1 << ", " << t_i + 1 << endl;
					return true;
				}
				while (scaf.checkerAt(t_j, t_i) == color) {
					t_i--;
					t_j++;
					count++;
					if (count == this->n) {
						//	cerr << "End is at " << t_j - 1 << ", " << t_i + 1 << endl;
						return true;
					}
				}
			}

			//Look diagonally downwards to the left if haven't already examined this pathway before
			if (i >= this->n && j >= this->n && ((i == scaf.levels() || j == scaf.cols()) || scaf.checkerAt(j + 1, i + 1))) {
				int count = 1;
				int t_i = i - 1;
				int t_j = j - 1;
				if (count == this->n) {
					//	cerr << "End is at " << t_j + 1 << ", " << t_i + 1 << endl;
					return true;
				}
				while (scaf.checkerAt(t_j, t_i) == color) {
					t_i--;
					t_j--;
					count++;
					if (count == this->n) {
						//		cerr << "End is at " << t_j + 1 << ", " << t_i + 1 << endl;
						return true;
					}
				}
			}

		}
	}

	return false;
}


//TODO: Fix return values
bool GameImpl::takeTurn()
{
	if (scaf.numberEmpty() == 0)
		return false;
	if (gameOver)
		return false;
	 
	if (redTurn) {
		col_new = red->chooseMove(scaf, this->n, RED);
		scaf.makeMove(col_new, RED);
		
	}
	else {
		col_new = black->chooseMove(scaf, this->n, BLACK);
		scaf.makeMove(col_new, BLACK);

	}
	
	redTurn = !redTurn;
	return true;
}

void GameImpl::play()
{
	cout << "Welcome to Connect-" << this->n << "!\n=========================\n";
	int round = 1;
	//bool gameIsOver = false;
	cout << "\nPress Enter to begin Round " << round << endl;
	cin.ignore(INT_MAX, '\n');
	scaf.display();
	int winner;
	do {
		

		
		cout << red->name() << "'s move...\n" << endl;
		takeTurn();
		
		gameOver = completed(winner);
		if (gameOver) {
			break;
		}
		
		scaf.display();
		cout << black->name() << "'s move...\n" << endl;
		takeTurn();
		gameOver = completed(winner);
		if (gameOver) {
			break;
		}
		scaf.display();

		round++;

		cout << "\nPress Enter to begin Round " << round << endl;
		cin.ignore(INT_MAX, '\n');
	} while (!gameOver);

	scaf.display();

	
	switch (winner) {
	case RED:
		cout << "And the winner is... " << red->name() << "!" << endl;
		break;
	case BLACK:
		cout << "And the winner is... " << black->name() << "!" << endl;
		break;
	case TIE_GAME:
		cout << "It's a tie!" << endl;

	}
	//gameOver = true;
	redTurn = true;
}

int GameImpl::checkerAt(int c, int r) const
{
	return scaf.checkerAt(c, r);
}

//******************** Game functions *******************************

// These functions simply delegate to GameImpl's functions.
// You probably don't want to change any of this code.

Game::Game(int nColumns, int nLevels, int N, Player* red, Player* black)
{
	m_impl = new GameImpl(nColumns, nLevels, N, red, black);
}

Game::~Game()
{
	delete m_impl;
}

bool Game::completed(int& winner) const
{
	return m_impl->completed(winner);
}

bool Game::takeTurn()
{
	return m_impl->takeTurn();
}

void Game::play()
{
	m_impl->play();
}

int Game::checkerAt(int c, int r) const
{
	return m_impl->checkerAt(c, r);
}
