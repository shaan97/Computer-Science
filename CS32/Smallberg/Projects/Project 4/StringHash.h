#ifndef STRING_HASH_H
#define STRING_HASH_H

#include <vector>
#include <list>
#include <functional>
#include <iostream>
#include <string>



class StringHash {
private:
	int KEY_SIZE;
	int ELEMENT_SIZE;

	std::vector<std::list<unsigned long>> table;		//This is the hash table (a vector of linked lists)
														//It will hold the index values of the first letter
														//Of each key value

	std::string& text;									//This is a reference to the string of interest
														//We will use PBR (pass by reference) as we expect
														//the strings to be on the range of approximately
														//100,000 characters

	unsigned long tableSize;

	std::hash<std::string> h;							//Provides hash function algorithm from the STL

	//@param	key				The key that is being hashed to an index value in data field std::vector<...> table
	//@return	unsigned long	The index value that the key hashes to.
	unsigned long hash(const std::string& key) const;

	//@param	index			Index of key in data field text
	//@return	bool			Returns true if successfully inserted. Returns false otherwise.
	bool insert(int index);
public:
	//@param	t				Text being used to create the hash table with.
	StringHash(std::string& t);

	//@param	key				The key being used to find the index of the given string in data field std::string& text
	//@param	l				Updates parameter so it gives all possible indices for the given key
	//@return	bool			If key is found, returns true. Otherwise returns false.
	bool getIndex(const std::string& key, std::list<unsigned long>& l) const;

	//@Postcondition			Contents of table are printed			
	void print() const;

	int val() const {
		return this->KEY_SIZE;
	}
	
};



void createDelta(std::istream& oldf, std::istream& newf, std::ostream& deltaf);
bool applyDelta(std::istream& oldf, std::istream& deltaf, std::ostream& newf);



















#endif