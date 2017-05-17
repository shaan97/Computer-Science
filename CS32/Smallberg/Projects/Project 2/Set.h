#ifndef SET_H
#define SET_H

#include <string>

typedef std::string ItemType;

class Set
{
private:
	struct Node {
		ItemType data;
		Node* next;
		Node* prev;

		Node(const ItemType& newData, Node* newNext, Node* newPrev);
	};

	
	Node* head;
	Node* tail;
	int numItems;
public:
	Set();
	// Create an empty set.
	
	~Set();
	// Destructs a set.

	Set(const Set& s);
	// Copies a Set into a new set

	bool empty() const;
	// Return true if the set is empty, otherwise false.

	int size() const;
	// Return the number of items in the set.

	bool insert(const ItemType& value);
	// Insert value into the set if it is not already present.  Return
	// true if the value was actually inserted.  Leave the set unchanged
	// and return false if the value was not inserted (perhaps because it
	// is already in the set).

	bool erase(const ItemType& value);
	// Remove the value from the set if present.  Return true if the
	// value was removed; otherwise, leave the set unchanged and
	// return false.

	bool contains(const ItemType& value) const;
	// Return true if the value is in the set, otherwise false.

	bool get(int pos, ItemType& value) const;
	// If 0 <= i < size(), copy into value an item in the set and
	// return true.  Otherwise, leave value unchanged and return false.
	// (See below for details about this function.)

	void swap(Set& other);
	// Exchange the contents of this set with the other one.

	Set& operator=(const Set& s);
	// Assignment operator overload to assign values of s over to this
};


void unite(const Set& s1, const Set& s2, Set& result);
// result should result as a union of two sets, without duplicates
void subtract(const Set& s1, const Set& s2, Set& result);
// result should result as s1 without the values of s2










#endif