#include "newSet.h"
#include <iostream>
#include <cassert>
using namespace std;

int main()
{
	Set ss;
	ss.insert(1);
	ss.insert(2);
	ss.insert(1);
	ss.insert(3);
	unsigned long all = 0;
	for (int k = 0; k < ss.size(); k++)
	{
		unsigned long x;
		ss.get(k, x);
		all += x;
	}
	assert(all == 6);
	
	Set ss2;
	ss2.insert(69);
	ss2.insert(123456);
	unsigned long s1;
	assert(ss2.get(1, s1) && (s1 == 69 || s1 == 123456));
	unsigned long s2;
	assert(ss2.get(1, s2) && s2 == s1);

	Set ss3;
	ss3.insert(99);
	assert(!ss3.contains(0));
	ss3.insert(2);
	ss3.insert(0);
	ss3.insert(6996);
	assert(ss3.contains(0));
	ss3.erase(6996);
	assert(ss3.size() == 3 && ss3.contains(2) && ss3.contains(99) &&
		ss3.contains(0));

	Set ss4;
	ss4.insert(123);
	Set ss5;
	ss5.insert(321);
	ss5.insert(213);
	ss4.swap(ss5);
	assert(ss4.size() == 2 && ss4.contains(321) && ss4.contains(213) &&
		ss5.size() == 1 && ss5.contains(123));

	Set s;
	assert(s.empty());
	ItemType x = 12389123;
	assert(!s.get(42, x) && x == 12389123); // x unchanged by get failure
	s.insert(8008135);
	assert(s.size() == 1);
	assert(s.get(0, x) && x == 8008135);
	
	Set set;
	assert(set.empty());
	ItemType x2 = 9876543;
	assert(!set.get(42, x2) && x2 == 9876543); // x unchanged by get failure
	set.insert(123456789);
	assert(set.size() == 1);
	assert(set.get(0, x2) && x2 == 123456789);

	Set n(100);
	Set n2(5);
	for (int k = 99; k >= 0; k--) {
		n.insert(k);
	}
	
	for (int i = 0; i < 5; i++) {
		n2.insert(i);
	}

	Set c(n);
	unsigned long a, b;
	assert(c.size() == n.size() && c.size() == 100 && c.get(49,a) && n.get(49,b) && a == b);

	assert(!n.insert(5));
	n = n2;
	assert(n.size() == n2.size() && n.size() == 5);
	int size = n.size();
	for (int i = 0; i < size; i++) {
		unsigned long x, y;
		assert(n.get(i, x) && n2.get(i, y) && x == y);
	}

	Set set1;
	{
		Set a2(5);
		for (int i = 0; i < 5; i++) {
			a2.insert(i);
		}
		set1 = a2;
	}
	
	for (int i = 0; i < 5; i++) {
		unsigned long x, y;
		assert(set1.get(i, x) && x == i);
	}

	Set name(3);
	
	name.insert(1);
	name.insert(2);
	name.insert(3);
	Set name2(name);
	name.erase(1);
	unsigned long temp;
	assert(name2.contains(1) && !name.contains(1));

	




	Set t1;
	assert(t1.size() == 0);
	Set t2(5);
	assert(t2.size() == 0);
	
	for (int i = 0; i < 5; i++) {
		t2.insert(i);
	}

	Set t3(t2);
	assert(t3.size() == t2.size());
	int sizeOfT = 5;
	for (int i = 0; i < sizeOfT; i++) {
		unsigned long tx, ty;
		assert(t3.get(i, tx) && t2.get(i, ty) && tx == ty && i == tx);
	}

	assert(t1.empty());
	t1.insert(1);
	assert(!t1.empty());
	t1.insert(2);
	t1.insert(3);
	assert(t1.size() == 3 && t2.size() == 5 && t3.size() == 5);

	Set t4(10);
	for (int i = 0; i < 9; i++) {
		assert(t4.insert(i));
	}
	assert(!t4.insert(0));
	assert(t4.insert(9));
	assert(!t4.insert(10));

	//Find out about negative values when construting Sets

	assert(t4.erase(0));
	assert(!t4.erase(10));
	assert(t4.insert(10));

	for (int i = 1; i < 11; i++) {
		assert(t4.contains(i));
		unsigned long tx, ty;
		assert(t4.get(i - 1, tx) && t4.get(i - 1, ty) && tx == ty && tx == i);
	}
	assert(!t4.contains(0));

	Set t5(50);
	for (int i = 25; i < 75; i++) {
		assert(t5.insert(i));
	}

	Set t6(25);
	for (int i = 0; i < 25; i++) {
		assert(t6.insert(i));
	}

	t5.swap(t6);

	assert(t6.size() == 50);
	for (int i = 0; i < 50; i++) {
		unsigned long tx, ty;
		assert(t6.get(i, tx));
		assert(t6.get(i, ty));
		assert(tx == ty && tx == (i + 25));
	}

	assert(t5.size() == 25);
	for (int i = 0; i < 25; i++) {
		unsigned long tx, ty;
		assert(t5.get(i, tx) && t5.get(i, ty) && tx == ty && tx == i);
	}

	t5 = t6;
	assert(t5.size() == 50);
	for (int i = 0; i < 50; i++) {
		unsigned long tx, ty;
		assert(t5.get(i, tx));
		assert(t5.get(i, ty));
		assert(tx == ty && tx == (i + 25));
	}

	Set t8;
	{
		Set t7(3);
		t7.insert(1);
		t7.insert(2);
		t7.insert(3);
		t8 = t7;
	}
	unsigned long test;
	assert(t8.size() == 3 && t8.get(0, test) && test == 1 && t8.get(1, test) && test == 2 && t8.get(2, test) && test == 3);













	cout << "Passed all tests (newSet)" << endl;

	return 0;
}