#include "SSNSet.h"
#include <iostream>

SSNSet::SSNSet() {          // Create an empty SSN set.

}

bool SSNSet::add(unsigned long ssn) {
	return this->ssn.insert(ssn);
}
// Add an SSN to the SSNSet.  Return true if and only if the SSN
// was actually added.

int SSNSet::size() const {  // Return the number of SSNs in the SSNSet.
	return this->ssn.size();
}

void SSNSet::print() const {
	int s = size();
	for (int i = 0; i < s; i++) {
		ItemType s;
		this->ssn.get(i, s);
		std::cout << s << std::endl;
	}
}
// Write every SSN in the SSNSet to cout exactly once, one per
// line.  Write no other text.