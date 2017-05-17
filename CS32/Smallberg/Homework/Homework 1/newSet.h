#ifndef NEWSET_H
#define NEWSET_H

#include <string>

const int DEFAULT_MAX_ITEMS = 100;

typedef unsigned long ItemType;

class Set
{
private:
	ItemType* set;
	int numItems;
	int max;
public:
	Set();         // Create an empty set.
	Set(int size);
	~Set();
	Set(const Set& s);
	bool empty() const {  // Return true if the set is empty, otherwise false.
		return this->numItems == 0;
	}

	int size() const {    // Return the number of items in the set.
		return this->numItems;
	}

	bool insert(const ItemType& value);
	// Insert value into the set if it is not already present.  Return
	// true if the value was actually inserted.  Leave the set unchanged
	// and return false if the value was not inserted (perhaps because it
	// is already in the set or because the set has a fixed capacity and
	// is full).

	bool erase(const ItemType& value);
	// Remove the value from the set if present.  Return true if the
	// value was removed; otherwise, leave the set unchanged and
	// return false.

	bool contains(const ItemType& value) const;
	// Return true if the value is in the set, otherwise false.

	bool get(int i, ItemType& value) const;
	// If 0 <= i < size(), copy into value an item in the set and
	// return true.  Otherwise, leave value unchanged and return false.
	// (See below for details about this function.)

	void swap(Set& other);
	// Exchange the contents of this set with the other one.

	Set& operator=(const Set& s);
};











#endif