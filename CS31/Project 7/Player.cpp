//
//  Hand.cpp
//  HandHomework
//
//  Created by Howard Stahl on 4/30/15.
//  Copyright (c) 2015 Howard Stahl. All rights reserved.
//

#include "Player.h"
#include <stdexcept>

// CS 31 Students need to complete this class.
// Please read over the assignment and the TODO comments in the accompanying
// implementation file for further instructions.
namespace cs31
{

Player::Player( )
{
    // The Player has no Cards in his hand
    myNumberOfCards = 0;
}
    
std::ostream& operator <<( std::ostream& outs, const Player & p )
{
    // print out all the actual cards in the array myCards
	for (int i = 0; i < p.myNumberOfCards; i++) {
		std::cout << p.myCards[i] << std::endl;
	}
    return( outs );
}
    
void Player::acceptCard(Card c)
{
    //		  as long as there is space in the array myCards, place Card c into myCards
    //        if there is not enough space for another card, throw an exception
	if (myNumberOfCards < MAXCARDS) {
		myCards[myNumberOfCards] = c;
		myNumberOfCards++;
	}
	else {
		std::logic_error fullHandException("FullHandException: Hand is Full");
		throw fullHandException;
	}
}
    
Card Player::getCard( int index ) const
{
    //		  return the requested card
    //        if the index is bad, throw an exception
	if (index < myNumberOfCards) {
		return myCards[index];
	}
	else {
		std::logic_error invalidIndex("IndexOutOfBoundsException: Requested Index is invalid");
		throw invalidIndex;
	}
}
    
int  Player::handcount( ) const
{
    //		  total up the points in this player's hand
    //        you will need to figure out how to handle Ace's that might be worth 1 or 11
	bool foundAce = false; //Wouldn't make sense to want 2 Ace's both valued at 11. We only need to consider once
	int total = 0;
	for (int i = 0; i < myNumberOfCards; i++) {
		if (!foundAce && myCards[i].getFace() == ACE) {
			foundAce = true;
		}
		else {
			total += myCards[i].count();
		}
	}

	if (foundAce && total <= 10)		//should only count that Ace as 11 if it won't bust player
		total += 11;
	else if(foundAce)				//otherwise count it as 1
		total += 1;

	return total;
}
   
int Player::cardCount() const {
	return myNumberOfCards;
}
    
bool Player::hasBlackJack( ) const
{
    bool result = false;
    if (myNumberOfCards == 2 && handcount() == 21)
    {
        result = true;
    }
    return( result );
}
    
}