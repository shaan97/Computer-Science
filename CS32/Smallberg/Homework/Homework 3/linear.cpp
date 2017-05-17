// Return false if the somePredicate function returns false for at
// least one of the array elements; return true otherwise.
bool allTrue(const string a[], int n)
{

	if (n <= 0)
		return true;
	if (somePredicate(a[n - 1]))
		return allTrue(a, n - 1);
	else
		return false;
}

// Return the number of elements in the array for which the
// somePredicate function returns false.
int countFalse(const string a[], int n)
{

	if (n <= 0)
		return 0;
	else {
		if (!somePredicate(a[n - 1]))
			return 1 + countFalse(a, n - 1);
		else
			return countFalse(a, n - 1);
	}
}

// Return the subscript of the first element in the array for which
// the somePredicate function returns false.  If there is no such
// element, return -1.
int firstFalse(const string a[], int n)
{
	if (n <= 0)
		return -1;
	else if (!somePredicate(a[0]))
		return 0;
	else {
		int x = firstFalse(a + 1, n - 1);
		if (x != -1)
			return x + 1;
		else
			return x;
	}
}

// Return the subscript of the least string in the array (i.e.,
// the smallest subscript m such that a[m] <= a[k] for all
// k from 0 to n-1).  If the array has no elements to examine,
// return -1.
int indexOfLeast(const string a[], int n)
{
	if (n <= 0)
		return -1;
	else if (n == 1)
		return 0;
	else {

		if (a[0] <= a[n - 1])
			return 0 + indexOfLeast(a, n - 1);
		else {
			return 1 + indexOfLeast(a + 1, n - 1);
		}
	}
}

// If all n2 elements of a2 appear in the n1 element array a1, in
// the same order (though not necessarily consecutively), then
// return true; otherwise (i.e., if the array a1 does not include
// a2 as a not-necessarily-contiguous subsequence), return false.
// (Of course, if a2 is empty (i.e., n2 is 0), return true.)
// For example, if a1 is the 7 element array
//    "stan" "kyle" "cartman" "kenny" "kyle" "cartman" "butters"
// then the function should return true if a2 is
//    "kyle" "kenny" "butters"
// or
//    "kyle" "cartman" "cartman"
// and it should return false if a2 is
//    "kyle" "butters" "kenny"
// or
//    "stan" "kenny" "kenny"
bool includes(const string a1[], int n1, const string a2[], int n2)
{
	if (n2 <= 0)
		return true;
	else if (n1 <= 0)
		return false;
	else {
		if(a1[0] == a2[0])
			return includes(a1 + 1, n1 - 1, a2 + 1, n2 - 1);
		else {
			return includes(a1 + 1, n1 - 1, a2, n2);
		}
	}

}
