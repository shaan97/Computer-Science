#include <stack>
#include <iostream>
#include <cassert>
using namespace std;


class Coord
{
public:
	Coord(int rr, int cc) : m_r(rr), m_c(cc) {}
	int r() const { return m_r; }
	int c() const { return m_c; }
private:
	int m_r;
	int m_c;
};

bool pathExists(char maze[][10], int sr, int sc, int er, int ec);
// Return true if there is a path from (sr,sc) to (er,ec)
// through the maze; return false otherwise



bool pathExists(char maze[][10], int sr, int sc, int er, int ec) {
	stack<Coord> s;
	s.push(Coord(sr, sc));
	maze[sr][sc] = '%';
	
	while (!s.empty()) {
		Coord c = s.top();
		s.pop();

		if (c.r() == er && c.c() == ec) {
			cerr << "Found at:\t(" << c.r() << "," << c.c() << ")\n";
			return true;

		}
		//Check and push North
		if ((c.r() - 1) < 10 && (c.r() - 1) >= 0 && maze[c.r() - 1][c.c()] != 'X' && maze[c.r() - 1][c.c()] != '%') {
			s.push(Coord(c.r() - 1, c.c()));
			maze[c.r() - 1][c.c()] = '%';
			//cerr << "Pushed:\t(" << c.r() - 1 << "," << c.c() << ")\n";
		}
		//Check and push East
		if ((c.c() + 1) < 10 && (c.c() + 1) >= 0 && maze[c.r()][c.c() + 1] != 'X' && maze[c.r()][c.c() + 1] != '%') {
			s.push(Coord(c.r(), c.c() + 1));
			maze[c.r()][c.c() + 1] = '%';
			//cerr << "Pushed:\t(" << c.r() << "," << c.c() + 1 << ")\n";
		}
		//Check and push South
		if ((c.r() + 1) < 10 && (c.r() + 1) >= 0 && maze[c.r() + 1][c.c()] != 'X' && maze[c.r() + 1][c.c()] != '%') {
			s.push(Coord(c.r() + 1, c.c()));
			maze[c.r() + 1][c.c()] = '%';
			//cerr << "Pushed:\t(" << c.r() + 1 << "," << c.c() << ")\n";
		}
		//Check and push West
		if ((c.c() - 1) < 10 && (c.c() - 1) >= 0 && maze[c.r()][c.c() - 1] != 'X' && maze[c.r()][c.c() - 1] != '%') {
			s.push(Coord(c.r(), c.c() - 1));
			maze[c.r()][c.c() - 1] = '%';
			//cerr << "Pushed:\t(" << c.r() << "," << c.c() - 1 << ")\n";
		}
	}
	return false;
}

