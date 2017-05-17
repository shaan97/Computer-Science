#include "newSet.h"

Set::Set() {     // Create an empty set.
	this->set = new ItemType[DEFAULT_MAX_ITEMS];
	this->numItems = 0;
	this->max = DEFAULT_MAX_ITEMS;
}

Set::Set(int size) {
	this->set = new ItemType[size];
	this->numItems = 0;
	this->max = size;
}

Set::Set(const Set& s) {
	set = new ItemType[s.max];
	for (int i = 0; i < s.numItems; i++) {
		set[i] = s.set[i];
	}

	max = s.max;
	numItems = s.numItems;
}

Set::~Set() {
	delete[] set;
}

Set& Set::operator=(const Set& s) {
	if (this != &s) {
		Set temp = s;
		swap(temp);
	}

	return *this;
}




bool Set::insert(const ItemType& value) {
	if (numItems < this->max && !contains(value)) {
		this->set[numItems] = value;
		numItems++;
		return true;
	}

	return false;
}
// Insert value into the set if it is not already present.  Return
// true if the value was actually inserted.  Leave the set unchanged
// and return false if the value was not inserted (perhaps because it
// is already in the set or because the set has a fixed capacity and
// is full).

bool Set::erase(const ItemType& value) {
	bool found = false;
	for (int i = 0; i < this->numItems; i++) {
		if (found) {
			set[i - 1] = set[i];
		}else if (set[i] == value) {
			found = true;
		}
	}

	if (found) {
		numItems--;
		return true;
	}
	else
		return false;
}
// Remove the value from the set if present.  Return true if the
// value was removed; otherwise, leave the set unchanged and
// return false.

bool Set::contains(const ItemType& value) const {
	for (int i = 0; i < this->numItems; i++) {
		if (set[i] == value)
			return true;
	}

	return false;
}
// Return true if the value is in the set, otherwise false.

bool Set::get(int i, ItemType& value) const {
	if (i >= 0 && i < this->numItems) {
		value = set[i];
		return true;
	}

	return false;
}
// If 0 <= i < size(), copy into value an item in the set and
// return true.  Otherwise, leave value unchanged and return false.
// (See below for details about this function.)

void Set::swap(Set& other) {
	int tempNumItems = numItems;
	numItems = other.numItems;
	other.numItems = tempNumItems;

	int tempMax = max;
	max = other.max;
	other.max = tempMax;

	ItemType* temp = set;
	set = other.set;
	other.set = temp;

}
// Exchange the contents of this set with the other one.