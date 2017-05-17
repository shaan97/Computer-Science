#ifndef POWBALL_LOTTERY_H
#define POWBALL_LOTTERY_H

#include "PowerballTicket.h"

class PowerballLottery {

private:
	int mBall1, mBall2, mBall3, mBall4, mBall5, mPowerball;		//Ball values for lottery as well as powerball

public:
	PowerballLottery();
	PowerballLottery(int ball1, int ball2, int ball3, int ball4, int ball5, int powerball);
	int getBall1() const;
	int getBall2() const;
	int getBall3() const;
	int getBall4() const;
	int getBall5() const;
	int getPowerball() const;
	enum WinningPossibility { POWERBALL, ONEPLUSPOWERBALL, TWOPLUSPOWERBALL, THREE, THREEPLUSPOWERBALL, FOUR, FOURPLUSPOWERBALL, FIVE, FIVEPLUSPOWERBALL, NOTWINNING };
	
	//creates random and valid PowerballTicket
	PowerballTicket quickPick() const;
	//checks ticket to evaluate the appropriate prize
	WinningPossibility checkTicket(PowerballTicket ticket);
	//checks if ticket has @param num as a ball 1-6 value
	bool hasNum(int num, PowerballTicket ticket);
	//prints appropriate prize for given ticket
	void printWhatHappened(PowerballTicket ticket);

};




#endif