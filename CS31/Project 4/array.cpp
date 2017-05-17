#include <iostream>
#include <string>
#include <cassert>

using namespace std;

int locateMinimum(const string array[], int n);
int findLastOccurrence(const string array[], int n, string target);
int flipAround(string array[], int  n);
bool hasNoDuplicates(const string array[], int  n);
void unionWithNoDuplicates(const string array1[], int n1, const string array2[], int n2, string resultingString[], int& resultingSize);
void addWithoutDuplicates(const string array1[], int n1, string resultingString[], int& count);
bool contains(const string array[], const int& size, const string& target);
int shiftRight(string array[], int n, int amount, string placeholderToFillEmpties);
bool isInIncreasingOrder(const string array[], int  n);

int main() {
	string a[6] = { "alpha", "beta", "gamma", "gamma", "beta", "delta" };
	string a1[6] = { "alpha", "beta", "gamma", "gamma", "yamma", "zeta" };
	string b[6] = { "delta", "gamma", "beta", "alpha", "beta", "alpha" };
	string h[7] = { "samwell", "jon", "margaery", "daenerys", "", "tyrion", "margaery" };
	int answer;


	string output[6] = { " ", " ", " ", " ", " ", " " };
	int outputSize = 6;

	assert(locateMinimum(a, 3) == 0);
	assert(locateMinimum(b, 3) == 2);

	assert(findLastOccurrence(a, 5, "beta") == 4);
	assert(findLastOccurrence(b, 3, "beta") == 2);

	assert(hasNoDuplicates(a, 3) == true);
	assert(hasNoDuplicates(a, 6) == false);

	assert(isInIncreasingOrder(a, 3) == true);
	assert(isInIncreasingOrder(a1, 6) == false);

	unionWithNoDuplicates(a, 6, b, 2, output, outputSize);
	assert(outputSize == 4);
	assert(output[0] == "alpha");

	answer = shiftRight(h, 6, 1, "foobar");
	assert(answer == 5);
	assert(h[0] == "foobar");

	assert(flipAround(b, 3) == 1);
	assert(flipAround(b, 4) == 2);

	cout << "All tests succeeded" << endl;
	
	return(0);
}


int locateMinimum(const string array[], int n) {
	if (n <= 0)
		return -1;
	//Starts from the end of the array so that last updated value of min will be the first instance of that value
	int min = n - 1;
	for (int i = n - 2; i >= 0; i--) {
		if (array[i] <= array[min])
			min = i;
	}

	return min;
}

int findLastOccurrence(const string array[], int n, string target) {
	//Starts from the end of the array so it can quickly return as soon as target is found
	for (int i = (n - 1); i >= 0; i--) {
		if (array[i] == target)
			return i;
	}

	return -1;

}

int flipAround(string array[], int n) {
	int count = 0;
	//index serves as distance from each end of array. Values at same distance are swapped
	for (int i = 0; i < n/2; i++) {
		string temp = array[i];
		array[i] = array[n - 1 - i];
		array[n - 1 - i] = temp;
		count++;
	}

	return count;
}

bool hasNoDuplicates(const string array[], int  n) {
	if (n < 0)
		return false;
	//Checks values against values in front of it. Does not check behind because previous iterations already check it
	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			if (array[i] == array[j]) 				
				return false;
			
		}
	}

	return true;
}

void unionWithNoDuplicates(const string array1[], int n1, const string array2[], int n2, string resultingString[], int& resultingSize) {
	if (n1 <= 0 || n2 <= 0)
		resultingSize = -1;
	else {
		resultingSize = 0;
		//Adds to resultingString without duplicates and updates resultingSize
		addWithoutDuplicates(array1, n1, resultingString, resultingSize);
		addWithoutDuplicates(array2, n2, resultingString, resultingSize);
	}
	
}

void addWithoutDuplicates(const string array1[], int n1, string resultingString[], int& count) {
	for (int i = 0; i < n1; i++) {
		if (!contains(resultingString, count, array1[i])) {
			resultingString[count] = array1[i];
			count++;
		}

	}
}

bool contains(const string array[], const int& size, const string& target) {
	for (int i = 0; i < size; i++) {
		if (array[i] == target)
			return true;
	}

	return false;
}

int shiftRight(string array[], int n, int amount, string placeholderToFillEmpties) {
	if (amount < 0 || amount > n)
		return -1;

	//shifts values by updating the right end of the array with values a distance amount away
	int count = 0;
	for (int i = (n - 1 - amount); i > -1; i--) {
		array[i + amount] = array[i];
		count++;
	}
	
	//updates values from left end of array to a distance amount to placeholderToFillEmpties
	for (int i = 0; i < amount; i++) {
		array[i] = placeholderToFillEmpties;
	}

	return count;
}

bool isInIncreasingOrder(const string array[], int  n) {
	if (n < 0)
		return false;
	else if (n == 0 || n == 1)
		return true;

	//If array[i] is greater than or equal to the next string, returns false immediately. No need to check i = n-1
	for (int i = 0; i < n - 1; i++) {
		if (array[i] >= array[i + 1])
			return false;
	}
	
	return true;
}

