
class Creature {
private:
	string n;
	
public:
	Creature(string n1);
	virtual ~Creature();

	string name() const;
	virtual bool isMortal() const = 0;

	virtual string move() const = 0;
};



Creature::Creature(string n1) : n(n1)
{}

Creature::~Creature() {

}

string Creature::name() const {
	return this->n;
}



class Phoenix : public Creature {
public:
	Phoenix(string s);
	virtual ~Phoenix();
	virtual bool isMortal() const override;
	virtual string move() const override;
};

Phoenix::Phoenix(string s) : Creature(s) {
	
}

Phoenix::~Phoenix() {
	cout << "Destroying " << this->name() << " the phoenix." << endl;
}

bool Phoenix::isMortal() const {
	return false;
}

string Phoenix::move() const {
	return "fly";
}

class Giant : public Creature {
private:
	int weight;
public:
	Giant(string n, int weight);
	virtual ~Giant();
	virtual bool isMortal() const override;
	virtual string move() const override;
};

Giant::Giant(string n, int weight) : Creature(n) {
	this->weight = weight;
}

Giant::~Giant() {
	cout << "Destroying " << this->name() << " the giant." << endl;
}

bool Giant::isMortal() const {
	return true;
}

string Giant::move() const {	
	if (this->weight >= 20)
		return "lumber";
	else
		return "tromp";
}

class Centaur : public Creature {
public:
	Centaur(string n);
	virtual ~Centaur();
	virtual bool isMortal() const override;
	virtual string move() const override;
};

Centaur::Centaur(string n) : Creature(n) {

}

Centaur::~Centaur() {
	cout << "Destroying " << this->name() << " the centaur." << endl;
}
bool Centaur::isMortal() const {
	return true;
}

string Centaur::move() const {
	return "trot";
}



