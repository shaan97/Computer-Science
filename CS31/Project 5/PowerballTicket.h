#ifndef POWBALL_TICKET_H
#define POWBALL_TICKET_H

class PowerballTicket {

private:
	int mBall1, mBall2, mBall3, mBall4, mBall5, mPowerball;

public:
	//assumes safe values for balls and powerball
	PowerballTicket(int ball1, int ball2, int ball3, int ball4, int ball5, int powerball);

	//Accessor methods for all private instance variables
	int getBall1() const;
	int getBall2() const;
	int getBall3() const;
	int getBall4() const;
	int getBall5() const;
	int getPowerball() const;
};






#endif