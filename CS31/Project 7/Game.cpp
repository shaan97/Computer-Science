//
//  Game.cpp
//  HandHomework
//
//  Created by Howard Stahl on 12/6/15.
//  Copyright © 2015 Howard Stahl. All rights reserved.
//

#include "Game.h"
#include <iostream>

// CS 31 Students need to complete this class.
// Please read over the assignment and the TODO comments in the accompanying
// implementation file for further instructions.
namespace cs31
{

Game::Game()
{
    //		  set the outcome of the game initially
    //        set the player's turn is not yet over
	this->mOutcome = NOOUTCOME;
	this->mPlayerStood = false;
}
 
Game::Game( Player player, Player dealer ) : Game()
{
    this->mPlayer = player;
    this->mDealer = dealer;
	//		  set the outcome of the game initially
    //        set the player's turn is not yet over
	
}

// did the Player win?
bool Game::playerWon()
{
    return( mOutcome == PLAYERWON );
}
    
// did the Player lose?
bool Game::playerLost()
{
    return( mOutcome == PLAYERLOST );
}
    
// did the Player and the Dealer tie?
bool Game::playerTied( )
{
    return( mOutcome == TIED );
}
    
void Game::deal()
{
    //		  shuffle deck
    //        deal two cards to the player and two to the dealer
	this->mDeck.shuffleDeck();
	playerHits();
	playerHits();
	dealerHits();
	dealerHits();
}
    
void Game::playerHits( )
{
    //	deal another card to the player
	this->mPlayer.acceptCard(this->mDeck.dealCard());
}
    
// let the Game know that the Player's turn is over
void Game::playerStands()
{
    mPlayerStood = true;
}
 
// has the Player's turn ended?
bool Game::playerStood() const
{
    return( mPlayerStood );
}

void Game::dealerHits( )
{
    // deal another card to the dealer
	this->mDealer.acceptCard(this->mDeck.dealCard());
}
    
void Game::dealerStands( )
{
    //		  since the game is now over, determine the outcome
    //        store the outcome in the member mOutcome
	int playerCards = this->mPlayer.handcount();
	int dealerCards = this->mDealer.handcount();

	if (dealerBusted())
		this->mOutcome = PLAYERWON;
	else if (playerBusted())
		this->mOutcome = PLAYERLOST;
	else if (dealerBusted() && playerBusted())
		this->mOutcome = TIED;
	else if (playerCards > dealerCards)		//implied that both are < 21
		this->mOutcome = PLAYERWON;
	else if (playerCards < dealerCards)		//implied that both are < 21
		this->mOutcome = PLAYERLOST;
	else
		this->mOutcome = TIED;
}
    
bool Game::dealerBusted( ) const
{
    //	 did the dealer go over 21?
	return mDealer.handcount() > 21;
}
    
bool Game::playerBusted( ) const
{
    //	 did the player go over 21?
	return mPlayer.handcount() > 21;
}
    
void Game::dealerPlays()
{
    //		  if the player hasn't busted,
    //        play the dealer's hand by taking cards until the
    //        dealer's cards total 17 or more or the dealer busts
	if (!playerBusted()) {
		while (this->mDealer.handcount() < 17) {
			dealerHits();
		}
	}

    // let the Game know that play has ended
    dealerStands();
}
    
bool Game::playerHasBlackJack( ) const
{
    //  does the player have blackjack?
	return this->mPlayer.hasBlackJack();
}
    
bool Game::dealerHasBlackJack( ) const
{
    //  does the dealer have blackjack?
	return this->mDealer.hasBlackJack();
}
    
//
// ALL THE CODE BELOW THIS POINT SHOULD NOT BE CHANGED!
//
void Game::display( std::string s , bool allCards )
{
    // when allCards is true  --> show all dealer cards
    // otherwise just show the one turned up dealer card
    // and then display the passed message at the bottom of the screen, if supplied
    using namespace std;
    int dealerCount = mDealer.handcount();
    int playerCount = mPlayer.handcount();
    cout << "DEALER'S HAND:" << endl;
    if (allCards)
    {
        cout << mDealer << endl;
    }
    else
    {
        cout << mDealer.getCard(0) << endl;
    }
    if (dealerBusted())
    {
        cout << "          --->dealer busted!" << endl;
    }
    else if (allCards)
    {
        cout << "          --->" << dealerCount << endl;
    }
    cout << endl;
    cout << "PLAYER'S HAND:" << endl;
    cout << mPlayer << endl;
    if (playerBusted())
    {
        cout << "          --->player busted!" << endl;
    }
    else if (allCards)
    {
        cout << "          --->" << playerCount << endl;
    }

    if (s != "")
        cout << s << endl;
}
    


    
}