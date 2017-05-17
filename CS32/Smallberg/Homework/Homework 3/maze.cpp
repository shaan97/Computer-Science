// Return true if there is a path from (sr,sc) to (er,ec)
// through the maze; return false otherwise
bool pathExists(char maze[][10], int sr, int sc, int er, int ec) {
	maze[sr][sc] = 'X';
	
	if (sr == er && sc == ec) {
		return true;
	}
	else {
		
		if (sr >= 0 && sr < 9 && maze[sr + 1][sc] != 'X')
			if (pathExists(maze, sr + 1, sc, er, ec))
				return true;
		if (sr > 0 && sr <= 9 && maze[sr - 1][sc] != 'X')
			if (pathExists(maze, sr - 1, sc, er, ec))
				return true;
		if (sc >= 0 && sc < 9 && maze[sr][sc + 1] != 'X')
			if (pathExists(maze, sr, sc + 1, er, ec))
				return true;
		if (sc > 0 && sc <= 9 && maze[sr][sc - 1] != 'X')
			if (pathExists(maze, sr, sc - 1, er, ec))
				return true;
	}
	return false;
}
