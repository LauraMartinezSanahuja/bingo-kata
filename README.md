# Bingo kata

Bingo is a game of chance played using cards with numbers printed on them, which are marked off of the card as the caller reads out some manner of random numbers. Play usually ceases once a certain pattern is achieved on a card, where the winner will shout out "Bingo!" in order to let the caller and the room know that there may be a winner.

There are lots of different variations of Bingo, each with their own specific rules. Classic US Bingo is perhaps the most well known, where the game is played using a 5x5 grid of numbers between 1 and 75, with a FREE space in the middle. There is also a UK version of Bingo, which uses a 9x3 grid of spaces containing numbers between 1 and 90, of which five spaces on each row are filled in.

More info: https://agilekatas.co.uk/katas/Bingo-Kata

## How to run the code

I used Eclipse IDE to develop the code, so I'll write the steps for this editor, but any other will work the same way.

1. Clone or download the latest version of this project.
2. Open the project or import it in Eclipse.
3. Right-click the project and execute Maven>Update Project...
    1. If you don't have Maven option in the selector, execute the following command per console: `mvn clean install`
    2. It is possible you don't have maven installed in your computer. You can do it with Homebrew for MacOS systems (`brew install maven`), check how to do it for other OS.
4. Right-click the project and execute Run As>Maven test
5. Right-click the project and execute Run As>JUnit Test
6. Check all BDD features and scenarios pass correctly
