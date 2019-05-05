#include <algorithm>
#include <cstdlib>
#include <iostream>

#include "highscore.h"

using namespace std;

HighScore::HighScore(string theName)
{
    name = theName;
    lastLetter = 'A';
    usedLetters.resize(name.length(), 0);
    cursorMove = 0;
    lastLetterLoc = -1;
}

int HighScore::computeCostToEnterName()
{
    int totalCost = 0;

    for (int i = 0; i < name.length(); i++)
    {
        totalCost = totalCost + findClosestLetter();
    }

    return totalCost + cursorMove;
}

int HighScore::findDistance(char a, char b)
{
    int aValue, bValue, forwardDist, backwardDist;

    aValue = int(a);
    bValue = int(b);

    //cout << "First letter is " << a << " Second letter is " << b << endl;

    forwardDist = abs(aValue - bValue);
    backwardDist = 26 - forwardDist;

    //cout << "Forward Dist is " << forwardDist << " and Backward Dist is " << backwardDist << endl;

    if (forwardDist < backwardDist)
    {
        return forwardDist;
    }
    else
    {
        return backwardDist;
    }
}

int HighScore::findClosestLetter()
{
    int closestLetter = 0;
    int currentDistance = 0;
    int nextDistance = 0;

    currentDistance = 26;

    for (int i = 0; i < usedLetters.size(); i++)
    {
        if (usedLetters[i] == 0)
        {
            nextDistance = findDistance(lastLetter, name[i]);

            if (nextDistance < currentDistance)
            {
                if (i - lastLetterLoc != 1)
                {

                }

                currentDistance = nextDistance;
                closestLetter = i;
            }
        }
    }

    if (lastLetterLoc != -1)
    {
        if (lastLetterLoc > closestLetter)
        {
            cursorMove++;
        }
    }

    usedLetters[closestLetter] = 1;
    lastLetter = name[closestLetter];
    lastLetterLoc = closestLetter;
    //cout << "The next closest letter is " << lastLetter << " with a distance of " << currentDistance << endl;
    return currentDistance + 1;
}

