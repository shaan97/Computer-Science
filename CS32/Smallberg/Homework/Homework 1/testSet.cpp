#include <iostream>
#include <cassert>
#include "Set.h"

using namespace std;

int main() {
	Set s;
	assert(s.empty());
	assert(s.insert(0) && !s.empty());

	Set ss;
	assert(ss.insert(1));
	assert(ss.insert(2));
	assert(ss.insert(3));
	assert(!ss.insert(1));
	unsigned long all = 0;
	for (int k = 0; k < ss.size(); k++)
	{
		unsigned long x;
		ss.get(k, x);
		all += x;
	}

	assert(all == 6);

	Set ss2;
	ss2.insert(1);
	ss2.insert(2);
	unsigned long s1;
	assert(ss.get(1, s1) && (s1 == 1 || s1 == 2));
	unsigned long s2;
	assert(ss.get(1, s2) && s2 == s1);

	Set ss3;
	ss3.insert(1);
	assert(!ss.contains(0));
	ss.insert(2);
	ss.insert(0);
	ss.insert(3);
	assert(ss.contains(0));
	ss.erase(1);
	assert(ss.size() == 3 && ss.contains(3) && ss.contains(2) &&
		ss.contains(0));

	Set ss4;
	ss4.insert(2);
	Set ss5;
	ss5.insert(69);
	ss5.insert(9);
	ss4.swap(ss5);
	assert(ss4.size() == 2 && ss4.contains(69) && ss4.contains(9) &&
		ss5.size() == 1 && ss5.contains(2));
	Set test;
	assert(test.empty());
	test.insert(0);
	assert(!test.empty());
	assert(test.size() == 1);
	for (int i = 1; i < DEFAULT_MAX_ITEMS; i++) {
		assert(test.insert(i));
	}
	assert(test.size() == DEFAULT_MAX_ITEMS);
	assert(!test.insert(100));

	Set test2;
	assert(test2.insert(0));
	assert(!test2.insert(0));
	assert(test2.erase(0));
	assert(!test2.erase(0));
	assert(test2.empty());
	assert(!test2.contains(0));
	assert(test2.insert(0) && test2.contains(0));
	assert(test2.insert(1) && test2.insert(2) && test2.insert(69) && test2.contains(1) && test2.contains(0) && test2.contains(2) && test2.contains(69) && !test2.contains(-1));

	Set test3;
	for (int i = 0; i < DEFAULT_MAX_ITEMS; i++) {
		assert(test3.insert(i));
	}
	for (int i = 0; i < DEFAULT_MAX_ITEMS; i++) {
		unsigned long check1, check2;
		assert(test3.get(i, check1) && test3.get(i, check2) && check1 == check2);
	}

	unsigned long check1;
	assert(!test3.get(DEFAULT_MAX_ITEMS, check1) && !test3.get(-1, check1));

	Set a, b;
	for (int i = 0; i < DEFAULT_MAX_ITEMS; i++) {
		assert(a.insert(i));
		assert(b.insert(i + 1));
	}
	a.swap(b);
	for (int i = 0; i < DEFAULT_MAX_ITEMS; i++) {
		unsigned long check3;
		assert(a.get(i, check3) && check3 == i + 1);
		assert(b.get(i, check3) && check3 == i);
	}
	assert(a.size() == a.size());
	a.swap(b);
	for (int i = 0; i < DEFAULT_MAX_ITEMS; i++) {
		unsigned long check3;
		assert(a.get(i, check3) && check3 == i);
		assert(b.get(i, check3) && check3 == i + 1);
	}

	b = a;
	for (int i = 0; i < DEFAULT_MAX_ITEMS; i++) {
		unsigned long check3, check4;
		assert(a.get(i, check3) && b.get(i, check4) && check3 == check4);
	}

	a.swap(a);
	for (int i = 0; i < DEFAULT_MAX_ITEMS; i++) {
		unsigned long check3, check4;
		assert(a.get(i, check3) && b.get(i, check4) && check3 == check4);
	}
















	cout << "All Tests Passed" << endl;
	return 0;
}