#include <iostream>
#include <string>
#include <cassert>
#include "PowerballLottery.h"
#include "PowerballTicket.h"

using namespace std;

bool equals(PowerballTicket t1, PowerballTicket t2);

int main()
{
	// test code
	PowerballTicket ticket(2, 1, 3, 4, 5, 6);
	assert(ticket.getBall1() == 2);
	assert(ticket.getBall2() == 1);
	assert(ticket.getBall3() == 3);
	assert(ticket.getBall4() == 4);
	assert(ticket.getBall5() == 5);
	assert(ticket.getPowerball() == 6);
	PowerballLottery lottery(1, 2, 3, 4, 5, 6);
	assert(lottery.getBall1() == 1);
	assert(lottery.getBall2() == 2);
	assert(lottery.getBall3() == 3);
	assert(lottery.getBall4() == 4);
	assert(lottery.getBall5() == 5);
	assert(lottery.getPowerball() == 6);
	assert(lottery.checkTicket(ticket) == PowerballLottery::WinningPossibility::FIVEPLUSPOWERBALL);
	ticket = PowerballTicket(1, 2, 3, 4, 5, 12);
	assert(lottery.checkTicket(ticket) == PowerballLottery::WinningPossibility::FIVE);
	ticket = PowerballTicket(1, 2, 3, 4, 15, 12);



	PowerballTicket quickPickTicket(1, 2, 3, 4, 5, 6);
	for (int i = 0; i < 100000; i++)
	{
		quickPickTicket = lottery.quickPick();
		// all the ball numbers need to be different...
		assert(quickPickTicket.getBall1() != quickPickTicket.getBall2() &&
			quickPickTicket.getBall1() != quickPickTicket.getBall3() &&
			quickPickTicket.getBall1() != quickPickTicket.getBall4() &&
			quickPickTicket.getBall1() != quickPickTicket.getBall5() &&
			quickPickTicket.getBall2() != quickPickTicket.getBall3() &&
			quickPickTicket.getBall2() != quickPickTicket.getBall4() &&
			quickPickTicket.getBall2() != quickPickTicket.getBall5() &&
			quickPickTicket.getBall3() != quickPickTicket.getBall4() &&
			quickPickTicket.getBall3() != quickPickTicket.getBall5() &&
			quickPickTicket.getBall4() != quickPickTicket.getBall5());
	}


	cout << "All tests passed!" << endl;
	return 0;


}

bool equals(PowerballTicket t1, PowerballTicket t2) {
	return (t1.getBall1() == t2.getBall1()) && (t1.getBall2() == t2.getBall2()) && (t1.getBall3() == t2.getBall3()) && (t1.getBall4() == t2.getBall4());// && (t1.getBall5() == t2.getBall5()) && (t1.getPowerball() == t2.getPowerball());
}