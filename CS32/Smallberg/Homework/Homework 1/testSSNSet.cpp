#include <iostream>
#include "SSNSet.h"
#include <cassert>

using namespace std;

int main() {
	/*SSNSet ssn;
	cerr << "This is a Social Security Database.\n";
	char answer = ' ';
	while (answer != 'q') {
		cerr << "(e) Enter a new SSN\n(p) View current SSN's in Database\n(s) Get number of SSN's in database\n(q) Quit" << endl;
		cin >> answer;
		switch (answer) {
		case 'e':
		{
			unsigned long s = 0;
			cerr << "Submit a SSN:\t";
			cin >> s;
			if (ssn.add(s))
				cerr << "Success!" << endl;
			else
				cerr << "Failure." << endl;

			//cin.ignore(INT_MAX, '\n');
		}
			break;
		case 'p':
			ssn.print();
			break;
		case 's':
			cerr << "There are " << ssn.size() << " SSN in our database" << endl;
			break;
		case 'q':
			cerr << "Goodbye!" << endl;
			return 0;
		default:
			cerr << "Not a valid command! Try again" << endl;
			break;
		}
	}
	*/

	SSNSet s;

	for (int i = 0; i < 100; i++) {
		assert(s.add(i));
		assert(s.size() == i + 1);
	}

	assert(!s.add(100));
	assert(!s.add(0));
	assert(s.size() == 100);

	cout << "All Tests Passed" << endl;
	return 0;
}