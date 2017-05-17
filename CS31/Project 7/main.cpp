//
//  main.cpp
//  HandHomework
//
//  Created by Howard Stahl on 4/30/15.
//  Copyright (c) 2015 Howard Stahl. All rights reserved.
//


#include <iostream>
#include <string>
#include "Card.h"
#include "Deck.h"
#include "Game.h"
void clearScreen();

int main(int argc, const char * argv[])
{

    using namespace cs31;
    using namespace std;
    string action;
    
    Game g;
    g.deal();
    clearScreen();
    if (g.playerHasBlackJack() || g.dealerHasBlackJack())
    {
        g.playerStands();
        g.dealerStands();
    }
    else
    {
        do
        {
            g.display( "(h)it (s)tand or (q)uit:" );
            getline( cin, action );
            if (action.size() == 0)
            {
                g.playerStands();
            }
            else
            {
                switch (action[0])
                {
                    default:   // if bad move, nobody moves
                        cout << '\a' << endl;  // beep
                        continue;
                    case 'Q':
                    case 'q':
                        return 0;
                    case 'h':
                    case 'H':
                        g.playerHits();
                        clearScreen();
                        break;
                    case 's':
                    case 'S':
                        g.playerStands();
                        break;
                }
            }
        } while( !g.playerBusted() && !g.playerStood() );
    
        clearScreen();
        g.dealerPlays();
    }
    
    if (g.playerWon())
    {
        g.display( "WON!", true );
    }
    else if (g.playerLost())
    {
        g.display( "LOST!", true );
    }
    else
    {
        g.display( "TIED!", true );
    }
    
 
    
    return 0;
}

///////////////////////////////////////////////////////////////////////////
//  clearScreen implementations
///////////////////////////////////////////////////////////////////////////

// DO NOT MODIFY OR REMOVE ANY CODE BETWEEN HERE AND THE END OF THE FILE!!!
// THE CODE IS SUITABLE FOR VISUAL C++, XCODE, AND g++ UNDER LINUX.

// Note to Xcode users:  clearScreen() will just write a newline instead
// of clearing the window if you launch your program from within Xcode.
// That's acceptable.

#ifdef _MSC_VER  //  Microsoft Visual C++

#include <windows.h>

void clearScreen()
{
    HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
    CONSOLE_SCREEN_BUFFER_INFO csbi;
    GetConsoleScreenBufferInfo(hConsole, &csbi);
    DWORD dwConSize = csbi.dwSize.X * csbi.dwSize.Y;
    COORD upperLeft = { 0, 0 };
    DWORD dwCharsWritten;
    FillConsoleOutputCharacter(hConsole, TCHAR(' '), dwConSize, upperLeft,
                               &dwCharsWritten);
    SetConsoleCursorPosition(hConsole, upperLeft);
}

#else  // not Microsoft Visual C++, so assume UNIX interface

#include <cstring>

void clearScreen()  // will just write a newline in an Xcode output window
{
    using namespace std;
    static const char* term = getenv("TERM");
    if (term == nullptr  ||  strcmp(term, "dumb") == 0)
    {
        cout << endl << endl << endl << endl << endl << endl << endl << endl;;
    }
    else
    {
        static const char* ESC_SEQ = "\x1B[";  // ANSI Terminal esc seq:  ESC [
        cout << ESC_SEQ << "2J" << ESC_SEQ << "H" << flush;
    }
}

#endif 