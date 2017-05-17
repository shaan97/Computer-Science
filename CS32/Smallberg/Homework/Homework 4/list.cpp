void listAll(string path, const File* f)  // two-parameter overload
{
	path += "/" + f->name();
	cout << path << endl;
	if (f->files() == NULL) {
		//File is a PlainFile
		return;
	}
	//File is not a PlainFile => File is a Directory
	for (int i = 0; i < f->files()->size(); i++) {
		listAll(path, f->files()->at(i));
	}
}