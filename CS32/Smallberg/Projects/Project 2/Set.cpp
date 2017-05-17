#include "Set.h"

//Creates Linked List with no items
Set::Set() : numItems(0), head(nullptr), tail(nullptr) {
	
}

Set::Set(const Set& s) : Set() {

	//inserts all items in s into *this
	Node* itr = s.head;
	while(itr != nullptr){
		insert(itr->data);
		itr = itr->next;
	}
}

Set::~Set() {

	//Moves two pointers down the list, deleting every node. 
	//Terminates when the last Node is deleted and last pointer finds a nullptr
	Node* itr;
	while (head != nullptr) {
		itr = head;
		head = head->next;
		delete itr;
	}
}

//Returns whether the Linked List is empty
bool Set::empty() const {
	return this->numItems == 0;
}

//Returns size of Linked List
int Set::size() const {
	return this->numItems;
}

//Insert ItemType to the end of Linked List
bool Set::insert(const ItemType& value) {
	if (tail == nullptr) {
		// (tail == nullptr) => (head == nullptr) => No items in the Linked List
		head = new Node(value, nullptr, nullptr);
		tail = head;
		numItems++;
		return true;
	}
	else if (tail != nullptr) {
		// (tail != nullptr) => (head != nullptr) => There is at least one item in the Linked List
		bool hasValue = contains(value);
		if (hasValue) {
			return false;
		}
		else {
			//There is more than one item in the Linked List
			
			tail->next = new Node(value, nullptr, tail);
			tail = tail->next;
			numItems++;
			return true;
		}
	}
}
bool Set::erase(const ItemType& value) {
	Node* itr = head;
	while (itr != nullptr && itr->data != value) {
		itr = itr->next;
	}

	//itr == nullptr || itr->data == value
	if (itr == nullptr) {
		//value wasn't in the Set
		return false;
	}
	else {

		//itr->data == value
		if (head == tail) {
			//Only one element in the Linked List
			delete itr;
			head = nullptr;
			tail = nullptr;
			numItems--;
			return true;
		}
		else if (head == itr) {
			//The item is the first in the Linked List
			head = itr->next;
			itr->next->prev = nullptr;
			delete itr;
			numItems--;
			return true;
		}
		else if (tail == itr) {
			//The item is the last in the Linked List
			tail = itr->prev;
			itr->prev->next = nullptr;
			delete itr;
			numItems--;
			return true;
		}
		else {
			//The item is somewhere in the middle of the Linked List
			itr->prev->next = itr->next;
			itr->next->prev = itr->prev;
			delete itr;
			numItems--;
			return true;
		}
	}
	
}

bool Set::contains(const ItemType& value) const {

	//Start iterator from the head, and move on until a value is found or a nullptr is found.
	Node* itr = head;
	while (itr != nullptr) {
		//if data is found, return true
		if (itr->data == value)
			return true;
		itr = itr->next;
	}

	//itr == nullptr, so value was not found
	return false;



}

bool Set::get(int pos, ItemType& value) const {
	if (pos >= this->numItems || pos < 0)
		return false;

	//pos is [0,numItems)
	
	Node* itr = head;

	//move iterator pos indices away from the home
	for (int i = 0; i < pos; itr = itr->next, i++)
		;
	
	value = itr->data;
	return true;

}
void Set::swap(Set& other) {
	//Use temp to swap the head
	Node* temp = this->head;
	this->head = other.head;
	other.head = temp;

	//Use temp to swap the tail
	Node* temp2 = this->tail;
	this->tail = other.tail;
	other.tail = temp2;

	//Use temp to swap the numItems
	int temp3 = this->numItems;
	this->numItems = other.numItems;
	other.numItems = temp3;
}

Set& Set::operator=(const Set& s) {
	//Copy and Swap idiom for the operator= overload
	Set a = s;
	swap(a);
	return *this;
}

//Constructor for a Node
Set::Node::Node(const ItemType& newData, Node* newNext, Node* newPrev) : data(newData) {
	next = newNext;
	prev = newPrev;
}

void unite(const Set& s1, const Set& s2, Set& result) {
	if (&s1 == &s2) {
		if (&s1 == &result) {
			//s1, s2, and result are all the same
			return;
		}
		//s1 and s2 are the same, so their union will be the same as s1/s2
		result = s2;
		return;
	}
	else {
		Set a;
		int s;
		//finds the larger of the two sets
		if (s1.size() > s2.size())
			s = s1.size();
		else
			s = s2.size();
		//gets every piece of data at a particular index and inserts it
		//if index is invalid, get will return a false, in which case nothing will be inserted
		for (int i = 0; i < s; i++) {
			ItemType temp;

			if(s1.get(i, temp))
				a.insert(temp);
			if(s2.get(i, temp))
				a.insert(temp);
		}

		
		result = a;
	}




}

void subtract(const Set& s1, const Set& s2, Set& result) {
	Set a = s1;
	int s = s2.size();

	for (int i = 0; i < s; i++) {
		ItemType temp;
		s2.get(i, temp);
		a.erase(temp);
	}
	result = a;
}