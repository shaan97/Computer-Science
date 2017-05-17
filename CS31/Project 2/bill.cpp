#include <iostream>
#include <string>
#include <climits>

using namespace std;

int main() {
	const double RES_STAND = 14.95, RES_TIER1 = 4.5, RES_TIER2 = 9.00, RES_TIER3 = 15.0;
	const double BUS_STAND = 19.95, BUS_TIER1 = 7.5, BUS_TIER2 = 15.0, BUS_TIER3 = 20.0;
	const double CUTOFF = 10.0;

	string name, type;
	double power, total;

	cout << "Customer Name: ";
	getline(cin, name);
	if (name == "") {
		cout << "---" << endl << "You must enter a customer name.";
		return 0;
	}

	cout << "Energy Used (in kilowatt hours): ";
	cin >> power;
	if (power < 0) {
		cout << "---" << endl << "The energy usage reading must be nonnegative.";
		return 0;
	}
	
	cout << "Customer Type: ";
	cin.ignore(INT_MAX, '\n');
	getline(cin, type);
	if (type != "Residential" && type != "Business") {
		cout << "---" << endl << "The customer type is not valid.";
		return 0;
	}

	cout << "---" << endl;

	//Uses customer type to determine appropriate constants
	//Inner if-else if statements find range of power and do appropriate calculation
	if (type == "Residential") {
		total = RES_STAND;
		if (power <= CUTOFF)
			total += (power * RES_TIER1);
		else if (power > CUTOFF && power <= (2 * CUTOFF))
			total += (((power - CUTOFF) * RES_TIER2) + (CUTOFF * RES_TIER1));
		else if (power > (2 * CUTOFF))
			total += (((power - (2 * CUTOFF)) * RES_TIER3) + (CUTOFF * (RES_TIER2 + RES_TIER1)));

	}
	else if (type == "Business") {
		total = BUS_STAND;
		if (power <= CUTOFF)
			total += (power * BUS_TIER1);
		else if (power > CUTOFF && power <= (2 * CUTOFF))
			total += (((power - CUTOFF) * BUS_TIER2) + (CUTOFF * BUS_TIER1));
		else if (power > (2 * CUTOFF))
			total += (((power - (2 * CUTOFF)) * BUS_TIER3) + (CUTOFF * (BUS_TIER2 + BUS_TIER1)));

	}

	cout.setf(ios::fixed);
	cout.setf(ios::showpoint);
	cout.precision(2);

	cout << "The bill for " << name << " is $" << total << endl;
	return 0;
}