#include "PowerballTicket.h"

//assumes safe values for balls and powerball
PowerballTicket::PowerballTicket(int ball1, int ball2, int ball3, int ball4, int ball5, int powerball) {
	mBall1 = ball1;
	mBall2 = ball2;
	mBall3 = ball3;
	mBall4 = ball4;
	mBall5 = ball5;
	mPowerball = powerball;
}

//Accessor methods for respective instance variables
int PowerballTicket::getBall1() const {
	return mBall1;
}
int PowerballTicket::getBall2() const {
	return mBall2;
}
int PowerballTicket::getBall3() const {
	return mBall3;
}
int PowerballTicket::getBall4() const {
	return mBall4;
}
int PowerballTicket::getBall5() const {
	return mBall5;
}
int PowerballTicket::getPowerball() const {
	return mPowerball;
}





