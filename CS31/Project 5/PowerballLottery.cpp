#include "PowerballLottery.h"
#include "RandomNumber.h"
#include <iostream>

using namespace std;

PowerballLottery::PowerballLottery() {
	RandomNumber r(1, 69);
	int arr[5] = { 0 };

	//Sets arr[i] to a random value in domain [1,69]. Checks arr[j] for  0 <= j < i to see if that value has already been assigned
	for (int i = 0; i < 5; i++) {
		arr[i] = r.random();
		for (int j = 0; j < i; j++) {
			if (arr[i] == arr[j]) {
				i--;
				break;
			}
		}
	}

	//assigns array values accordingly
	mBall1 = arr[0];
	mBall2 = arr[1];
	mBall3 = arr[2];
	mBall4 = arr[3];
	mBall5 = arr[4];

	//powerball can be any value in domain [1, 26]
	RandomNumber rPow(1, 26);
	mPowerball = rPow.random();
}

//Assumes ball values and powerball values are good values
PowerballLottery::PowerballLottery(int ball1, int ball2, int ball3, int ball4, int ball5, int powerball) {
	mBall1 = ball1;
	mBall2 = ball2;
	mBall3 = ball3;
	mBall4 = ball4;
	mBall5 = ball5;
	mPowerball = powerball;
}

//Accessor methods return respective ball values
int PowerballLottery::getBall1() const {
	return mBall1;
}

int PowerballLottery::getBall2() const {
	return mBall2;
}

int PowerballLottery::getBall3() const {
	return mBall3;
}

int PowerballLottery::getBall4() const {
	return mBall4;
}

int PowerballLottery::getBall5() const {
	return mBall5;
}

int PowerballLottery::getPowerball() const {
	return mPowerball;
}

//Returns a random, valid powerball ticket
PowerballTicket PowerballLottery::quickPick() const {
	RandomNumber r(1, 69);
	int arr[5] = { 0 };

	//Sets arr[i] to a random value. Checks arr[j] for  0 <= j < i to see if that value has already been assigned
	for (int i = 0; i < 5; i++) {
		arr[i] = r.random();
		for (int j = 0; j < i; j++) {
			if (arr[i] == arr[j]) {
				i--;
				break;
			}
		}
	}
	int b1 = arr[0];
	int b2 = arr[1];
	int b3 = arr[2];
	int b4 = arr[3];
	int b5 = arr[4];

	RandomNumber rPow(1, 26);
	int pow = rPow.random();

	PowerballTicket t(b1, b2, b3, b4, b5, pow);

	return t;
}

//Checks a ticket and evaluates appropriate prize
PowerballLottery::WinningPossibility PowerballLottery::checkTicket(PowerballTicket ticket) {
	int numBalls = 0;
	bool hasPowBall = false;

	if (hasNum(mBall1, ticket))
		numBalls++;
	if (hasNum(mBall2, ticket))
		numBalls++;
	if (hasNum(mBall3, ticket))
		numBalls++;
	if (hasNum(mBall4, ticket))
		numBalls++;
	if (hasNum(mBall5, ticket))
		numBalls++;
	if (ticket.getPowerball() == mPowerball)
		hasPowBall = true;

	switch (numBalls) {
	case 0:
		if (hasPowBall)
			return POWERBALL;
		else
			return NOTWINNING;
		break;
	case 1:
		if (hasPowBall)
			return ONEPLUSPOWERBALL;
		else
			return NOTWINNING;
		break;
	case 2:
		if (hasPowBall)
			return TWOPLUSPOWERBALL;
		else
			return NOTWINNING;
		break;
	case 3:
		if (hasPowBall)
			return THREEPLUSPOWERBALL;
		else
			return THREE;
		break;
	case 4:
		if (hasPowBall)
			return FOURPLUSPOWERBALL;
		else
			return FOUR;
		break;
	case 5:
		if (hasPowBall)
			return FIVEPLUSPOWERBALL;
		else
			return FIVE;
		break;
	default:
		return NOTWINNING;
	}
}

//checks if ticket has @param num as a ball value
bool PowerballLottery::hasNum(int num, PowerballTicket ticket) {
	if (num == ticket.getBall1())
		return true;
	else if (num == ticket.getBall2())
		return true;
	else if (num == ticket.getBall3())
		return true;
	else if (num == ticket.getBall3())
		return true;
	else if (num == ticket.getBall4())
		return true;
	else if (num == ticket.getBall5())
		return true;
	else
		return false;
}

//prints appropriate message for appropriate prize
void PowerballLottery::printWhatHappened(PowerballTicket ticket) {
	switch (checkTicket(ticket)) {
	case POWERBALL:
		cout << "You matched just the powerball.  Congratulations!" << endl;
		break;
	case ONEPLUSPOWERBALL:
		cout << "You matched one ball plus the powerball.  Congratulations!" << endl;
		break;
	case TWOPLUSPOWERBALL:
		cout << "You matched two balls plus the powerball.  Congratulations!" << endl;
		break;
	case THREE:
		cout << "You matched three balls but not the powerball.  Congratulations!" << endl;
		break;
	case THREEPLUSPOWERBALL:
		cout << "You matched three balls plus the powerball.  Congratulations!" << endl;
		break;
	case FOUR:
		cout << "You matched four balls but not the powerball.  Congratulations!" << endl;
		break;
	case FOURPLUSPOWERBALL:
		cout << "You matched four balls plus the powerball.  Congratulations!" << endl;
		break;
	case FIVE:
		cout << "You matched five balls but not the powerball.  Congratulations!" << endl;
		break;
	case FIVEPLUSPOWERBALL:
		cout << "You won the jackpot - all balls plus the powerball.  Congratulations!" << endl;
		break;
	case NOTWINNING:
		cout << "You didn't win anything.  Please buy another ticket!" << endl;
		break;
	default:
		cout << "You didn't win anything.  Please buy another ticket!" << endl;
		break;
	}


}
