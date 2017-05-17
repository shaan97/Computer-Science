#include "Set.h"

Set::Set() {	// Create an empty set.
	this->numItems = 0;
}

bool Set::insert(const ItemType& value) {
	if (numItems < DEFAULT_MAX_ITEMS && !contains(value)) {
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
	for (int i = 0; i < numItems; i++) {
		if (found) {
			set[i - 1] = set[i];	//shifts values to account for deletion of one member of the set
		}else if (set[i] == value) {
			found = true;
		}
	}

	if (found) {
		numItems--;
		return true;
	}
	else {
		return false;
	}
}
// Remove the value from the set if present.  Return true if the
// value was removed; otherwise, leave the set unchanged and
// return false.

bool Set::contains(const ItemType& value) const {
	for (int i = 0; i < numItems; i++) {
		if (set[i] == value)
			return true;
	}

	return false;
}
// Return true if the value is in the set, otherwise false.

bool Set::get(int i, ItemType& value) const {
	if (i >= 0 && i < numItems) {
		value = set[i];
		return true;
	}

	return false;
}
// If 0 <= i < size(), copy into value an item in the set and
// return true.  Otherwise, leave value unchanged and return false.
// (See below for details about this function.)

void Set::swap(Set& other) {
	int temp = numItems;
	numItems = other.numItems;
	other.numItems = temp;

	for (int i = 0; i < numItems; i++) {
		ItemType temp = set[i];
		set[i] = other.set[i];
		other.set[i] = temp;
	}
}
// Exchange the contents of this set with the other one.