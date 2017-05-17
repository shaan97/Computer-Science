#include "StringHash.h"
#include <climits>
#include <cmath>
#include <string>

const int T_SIZE = 10223;

using namespace std;

//@param	t				Text being used to create the hash table with.
StringHash::StringHash(std::string& t) : text(t), tableSize(T_SIZE), table(T_SIZE) {
	if (t.size() < 25000) {
		KEY_SIZE = 1;
		ELEMENT_SIZE = KEY_SIZE;
	}
	else if (t.size() < 80000) {
		KEY_SIZE = 2;
		ELEMENT_SIZE = KEY_SIZE;
	}
	else {
		KEY_SIZE = 3;
		ELEMENT_SIZE = KEY_SIZE;
	}
	//cerr << KEY_SIZE << endl;
	for (unsigned long i = 0; i < t.size(); i += ELEMENT_SIZE) {
		insert(i);
	}

}

//@param	key				The key being used to find the index of the given string in data field std::string& text
//@param	l				Updates parameter so it gives all possible indices for the given key.
//							State of variable unchanged if function returns false.
//@return	bool			If key is possibly found, returns true. Otherwise returns false.
bool StringHash::getIndex(const std::string& key, std::list<unsigned long>& l) const {
	if(key.size() < KEY_SIZE)
		return false;

	unsigned long tableIndex = hash(key) % tableSize;
	if (table[tableIndex].empty())
		return false;

	for (std::list<unsigned long>::const_iterator i = table[tableIndex].begin(); i != table[tableIndex].end(); i++) {
		if (text.substr(*i, KEY_SIZE) == key.substr(0, KEY_SIZE))
			l.push_front(*i);
	}

	if (l.empty())
		return false;

	return true;

}

//@param	key				The key that is being hashed to an index value in data field std::vector<...> 
//							The key must be of at least key.size() == KEY_SIZE.
//@return	unsigned long	The index value that the key hashes to.
unsigned long StringHash::hash(const std::string& key) const {
	return h(key.substr(0, KEY_SIZE));
}

//@param	key				Key that should be inserted into the hash table
//@return	bool			Returns true if successfully inserted. Returns false otherwise.
bool StringHash::insert(int index) {
	std::string key = text.substr(index, ELEMENT_SIZE);
	if (key.size() < KEY_SIZE)
		return false;

	unsigned long tableIndex = hash(key) % tableSize;
	table[tableIndex].push_front(index);
	return true;
}

//@Postcondition			Contents of table are printed			
void StringHash::print() const {
	for (std::vector<list<unsigned long>>::const_iterator i = table.begin(); i != table.end(); i++) {
		if((*i).size() != 0)
			cout << (*i).size() << endl;
	}
}

bool fill(istream& f, std::string& s, int num = -1) {
	if (num == -1) {
		char c;
		while (f.get(c)) {
			s += c;
		}
		return true;
	}
	if (num < 0)
		return false;

	while (f && num != 0) {
		char c;
		f.get(c);
		s += c;
		num--;
	}
	
	return true;
}

bool shouldUseCopy(long index, long num, bool didAdd) {
	int x;
	if (index != 0)
		x = floor(log10(10 * index));
	else
		x = 1;
	
	if (didAdd) {
		int y;
		if (num != 0)
			y = floor(log10(10 * num));
		else
			y = 1;
		return x + y < num - 2;
	}
	else {
		return x < num;
	}
}

void createDelta(istream& oldf, istream& newf, ostream& deltaf) {
	
	
	string oldText;
	fill(oldf, oldText);

	//Old file is now finished being inserted into string

	StringHash h(oldText);
	int BYTE_SIZE = h.val();
	//h.print();
	string newText;
	fill(newf, newText);
	

	//New file is now finished being inserted into string

	list<char> add;
//	int complete = -1;
	for (unsigned long i = 0; i < newText.size(); ) {
		if (i == 125)
			cerr << "Here" << endl;
		std::list<unsigned long> indices;
		unsigned long max = 0;
		unsigned long maxIndex = -1;
		long leftShift = 0;
		if (h.getIndex(newText.substr(i, BYTE_SIZE), indices)) {

			//Find what we need to Copy
			for (std::list<unsigned long>::const_iterator k = indices.begin(); k != indices.end(); k++) {
				unsigned long index = i + BYTE_SIZE;			//Index right after current byte (newText)
				long index_r = i;
				unsigned long deltaRight = (*k) + BYTE_SIZE;	//Index right after current byte (oldText)
				long deltaLeft = (*k);
				//if deltaRight is out of bounds, it has to be at "index" : oldText.size()

				while (index < newText.size() && deltaRight < oldText.size() && oldText[deltaRight] == newText[index]) {
					deltaRight++;
					index++;
				}

				long temp = deltaLeft;
				long num = add.size();
				if (num != 0) {
					while (num > 0 && index_r > 0 && temp > 0 && oldText[temp - 1] == newText[index_r - 1]) {
						temp--;
						index_r--;
						num--;
					}
				}

				//deltaRight >= newText.size() || deltaRight >= oldText.size() || deltaRight is at index right after complete match (RHS)
				
				if (deltaRight - (temp) > max) {
					max = deltaRight - (*k);
					leftShift = (*k) - (temp);
					maxIndex = (*k);
				}
				
				
			}

			//Now insert the add instruction and copy instruction

			//Add instruction
			bool didAdd = false;
			int left = leftShift;
			bool useCopy;
			if (add.size() != 0)
			{
				
				useCopy = shouldUseCopy(maxIndex - leftShift, max + leftShift, true);
				int t = leftShift;
				while (t > 0) {
					add.pop_back();
					t--;
				}
				if (!useCopy) {
					for (int x = maxIndex - leftShift, y = 0; y < max + leftShift; y++, x++) {
						//cerr << oldText[x] << endl;
						add.push_back(oldText[x]);
					}
					i += max;
					continue;
				}

				
				didAdd = true;
				
				if (!add.empty()) {
					deltaf << "A" << add.size() << ":";
					while (add.size() != 0) {
						deltaf << add.front();
						add.pop_front();
					}
				}
			}
			else {
				useCopy = shouldUseCopy(maxIndex - leftShift, max + leftShift, false);
			}

			//Copy instruction
			if(useCopy)
				deltaf << "C" << max + left << "," << (maxIndex - left);
			else {
				for (int x = maxIndex - left, y = 0; y < max + left; y++, x++) {
					add.push_back(oldText[x]);
				}
			}
			i += max;
		}
		else {
			add.push_back(newText[i]);
			i++;
		}

		

	}
	//Add instruction
	if (add.size() != 0)
	{
		deltaf << "A" << add.size() << ":";
		while (add.size() != 0) {
			deltaf << add.front();
			add.pop_front();
		}
	}
	
}

bool getInt(istream& inf, int& n)
{
	char ch;
	if (!inf.get(ch) || !isascii(ch) || !isdigit(ch))
		return false;
	inf.unget();
	inf >> n;
	return true;
}

bool getCommand(istream& inf, char& cmd, int& length, int& offset)
{
	if (!inf.get(cmd) || (cmd == '\n'  &&  !inf.get(cmd)))
	{
		cmd = 'x';  // signals end of file
		return true;
	}
	char ch;
	switch (cmd)
	{
	case 'A':
		return getInt(inf, length) && inf.get(ch) && ch == ':';
	case 'C':
		return getInt(inf, length) && inf.get(ch) && ch == ',' && getInt(inf, offset);
	}
	return false;
}

bool applyDelta(istream& oldf, istream& deltaf, ostream& newf) {
	string oldText;
	fill(oldf, oldText);

	while (deltaf) {
		char cmd;
		int length;
		int offset;
		if (!getCommand(deltaf, cmd, length, offset))
			return false;
		//cerr << cmd << " " << length << " " << offset << endl;
		switch (cmd) {
		case 'A':
			for (int i = 0; i < length; i++) {
				char c;
				deltaf.get(c);
				if (c < 0)
					cerr << "WHAT" << endl;
				else
					newf << c;
			}
			
			break;
		case 'C':
			for (int i = offset; i < offset + length; i++) {
				if (oldText[i] < 0)
					cerr << "WHAT" << endl;
				else
					newf << oldText[i];
			}
			break;
		case 'x':
			return true;
		default:
			return false;
		}

	}
	return true;
}