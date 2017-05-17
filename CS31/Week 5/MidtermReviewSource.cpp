#include <iostream>
using namespace std;

double avg(int i1,double d1)
{
    cout << "double avg( int i1, double d1 );" << endl;
    return( 0 );
}

double avg(double d1)
{
    cout << "double avg( double d1 );" << endl;
    return( 0 );
}

double avg(double d1,double d2)
{
    cout << "double avg( double d1, double d2 );" << endl;
    return( 0 );
}


bool hasFiveEs( string s )
{
	int counter = 0;
	for (size_t i = 0; i < s.size( ); i++)
	{
		if (s[ i ] == 'E')
		{
			counter = counter + 1;
		}
	}
	return( counter == 5  );
}



bool isHeads( string s )
{
	int heads(0), tails(0);
	bool result = true;
	size_t i = 0;
	while (i < s.size())
	{
		switch( s[ i ] )
		{
		case 't':
		case 'T':
			tails = tails + 1;
			break;
		case 'h':
		case 'H':
			heads = heads + 1;
			break;
		default:
			break;

		}
		i = i+1;
	}
	result = (heads > tails);
	return( result );
}










int main( )
{
	int i = 0, j = 1;
	avg( i, j );
}

// Project 2
#include <iostream>
#include <string>
#include <climits>  // for INT_MAX
using namespace std;



int mainX( ) {
    string name(""), type("");
    double amount(0.0), cost(0.0);
    // this variables will hold how much power is billed for each of the three tiers
    double firsttier(0.0), secondtier(0.0), thirdtier(0.0);    

    // the customer types
    const string RESIDENTIAL_TYPE = "Residential";
    const string BUSINESS_TYPE = "Business"; 

    // the various billable charges and power rates   
    const double RESIDENTIAL_SERVICE_CHARGE = 14.95;
    const double BUSINESS_SERVICE_CHARGE    = 19.95;
    const double RESIDENTIAL_TIER1 = 4.50;
    const double RESIDENTIAL_TIER2 = 9.00;
    const double RESIDENTIAL_TIER3 = 15.00;
    const double BUSINESS_TIER1 = 7.50;
    const double BUSINESS_TIER2 = 15.00;
    const double BUSINESS_TIER3 = 20.00;    

    cout << "Customer Name: ";
    getline( cin, name );
    cout << "Energy Used (in kilowatt hours): ";
    cin  >> amount;
    cin.ignore( INT_MAX, '\n' );
    cout << "Customer Type: ";
    cin  >> type;
    cin.ignore( INT_MAX, '\n' );

    cout << "---" << endl;
    // Error: no name
    if (name.length() == 0)
    {
        cout << "You must enter a customer name." << endl;
    }
    // Error: bad amount
//    else if (amount < 0)
//    {
//        cout << "The energy usage reading must be nonnegative." << endl;
//    }
    // Error: bad type
    else if (type != BUSINESS_TYPE && type != RESIDENTIAL_TYPE )
    {
        cout << "The customer type is not valid."  << endl;
    }
    else
    {
        // how many kilowatts have been used on the first tier?
		if( amount >= 10 )
        {
            firsttier = 10;
        }
        else
        {
			// amount might be negative
            firsttier = amount;
			if (firsttier < 0)
			{
				firsttier = 0;
			}
        }
        // how many kilowatts have been used on the second tier?
        if (amount >= 20)
        {
            secondtier = 10;
        }
        else
        {
            secondtier = amount - 10;
            if (secondtier < 0)
            {
                secondtier = 0;
            }
        }
        // how many kilowatts have been used on the third tier?
        thirdtier = amount - firsttier - secondtier;
		if (thirdtier < 0)
		{
			thirdtier = 0;
		}
        if (type == RESIDENTIAL_TYPE)
        {
            // calculate the residential bill charges
            cost = RESIDENTIAL_SERVICE_CHARGE;
            cost += firsttier * RESIDENTIAL_TIER1;
            cost += secondtier * RESIDENTIAL_TIER2;
            cost += thirdtier * RESIDENTIAL_TIER3;
        }
        else
        {
            // calculate the business bill charges
            cost = BUSINESS_SERVICE_CHARGE;
            cost += firsttier * BUSINESS_TIER1;
            cost += secondtier * BUSINESS_TIER2;
            cost += thirdtier * BUSINESS_TIER3;
        }
        cout.precision( 2 );
        cout.setf( ios::fixed );
        cout.setf( ios::showpoint );
        cout << "The bill for " << name << " is $" << cost << endl;
		int wholeNumber = static_cast<int>( amount );
    }
    return 0;
}





int countDuplicatesOfTheTarget( string array[ ], 
							    int size, 
								string target )
{
	int result( 0 );
	int i( 0 );
	int counter( 0 );
	do
	{
		if( i < size )
		{
			if (array[ i ] == target)
			{
				counter = counter + 1;
			}
		}
		i = i + 1;
	} while( i < size );
	if (counter != 0)
	{
		result = counter - 1;
	}
	return( result );
}