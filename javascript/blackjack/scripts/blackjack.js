const suites = ['Hearts', 'Clubs', 'Diamonds', 'Spades'];
const values = [
    '2', '3', '4', '5',
    '6', '7', '8', '9',
    '10', 'Jack', 'Queen', 'King', 'Ace'];

function createDeck(){
    let newDeck = [];
    for(let suitIdx = 0; suitIdx < suites.length; suitIdx++){
        for(let valIdx = 0; valIdx < values.length; valIdx++){
            let card = {
                suit: suites[suitIdx],
                value: values[valIdx]
            };
            newDeck.push(card);
        }
    }
    return newDeck;
}

function shuffleDeck(){
    let shuffledDeck = [];
    while(deck.length > 0){
        let randomNum = Math.trunc(Math.random() * deck.length);
        let randomCard = deck.splice(randomNum, 1).pop();
        shuffledDeck.push(randomCard);
    }
    return shuffledDeck;
}

function getNextCard(){
    return deck.pop();
}

function getFirstCard(){
    return deck.shift();
}

function cardToString(card){
    return card.value + ' of ' + card.suit;
}

function printDeck(deck, where){
    for(let i = 0; i < deck.length; i+=4){
        let cardText = '\n\t ' + cardToString(deck[i]) + '\t\t'+ cardToString(deck[i+1]) + '\t\t' + cardToString(deck[i+2]) + '\t\t'+ cardToString(deck[i+3]);
        where.innerText += cardText;
    }
}

function welcomeText(){
    resultArea.innerText = 'Press \'New Game!\' to start playing!';
}

function isCardFigure(card){
    console.log("isCardFigure?", cardToString(card));
    return card.value === 'Ace' ||
            card.value === 'King' ||
            card.value === 'Queen' ||
            card.value === 'Jack';
}

function isBlackJack(cards){
    console.log('isBlackJack?', cards);
    return  isCardFigure(cards[0]) &&
            isCardFigure(cards[1]);
}

function getScore(cards){
    if (cards.length === 2 && isBlackJack(cards)){
        return 21;
    }
    let score = 0;
    for(let i = 0; i < cards.length; i++){
        if (isCardFigure(cards[i])){
            score += (cards[i].value !== 'Ace' || (score < 12)) ? 10 : 1;
        } else {
            score += parseInt(cards[i].value);
        }
    }
    return score;
}

function showStatus(){
    dealerScoreArea.innerText = 'Dealer score [' + dealerScore + ']';
    dealerCardsArea.innerText = 'Dealer has:\n';
    for(let i = 0; i < dealerCards.length; i++){
        dealerCardsArea.innerText += cardToString(dealerCards[i]) + '\n';
    }

    playerScoreArea.innerText = 'Player score [' + playerScore + ']';
    playerCardsArea.innerText = 'Player has:\n';
    for(let i = 0; i < playerCards.length; i++){
        playerCardsArea.innerText += cardToString(playerCards[i]) + '\n';
    }
    //TODO console.
    if (gameOver){
        if (playerWon){
            resultArea.innerText = 'You have won!';
            playerNofWins++;
        } else {
            resultArea.innerText = 'Dealer has won!'
            dealerNofWins++;
        }
        historyArea.innerText = "Player win:" + playerNofWins + "\nDealer win:" + dealerNofWins;
        b_start.style.display = 'inline';
        b_hit.style.display = 'none';
        b_stay.style.display = 'none';
    }
}

function checkForOverFlow(){
    if (playerScore > 21){
        gameOver = true;
        playerWon = false;
    }
}

function checkForEndOfGame(){
    if (dealerScore > 21){
        gameOver = true;
        playerWon = true;
    } else if (dealerScore > playerScore){
        gameOver = true;
        playerWon = false;
    }
}

function computerTurn(){
    let i = 0;
    while (dealerScore <= playerScore || i > 20){
        dealerCards.push(getNextCard());
        dealerScore = getScore(dealerCards);
        i++;
    }
    checkForEndOfGame();
    showStatus();
}

function createConfigPage(){

}

let playerCards = [];
let dealerCards = [];
let dealerScore = 0;
let playerScore = 0;
let playerNofWins = 0;
let dealerNofWins = 0;
let deck = [];

let gameArea = document.getElementById('gameArea');
let playerArea = document.getElementById('playerArea');
let dealerArea = document.getElementById('dealerArea');
let playerScoreArea = document.getElementById('playerScore');
let dealerScoreArea = document.getElementById('dealerScore');
let playerCardsArea = document.getElementById('playerCards');
let dealerCardsArea = document.getElementById('dealerCards');
let resultArea = document.getElementById('resultArea');
let historyArea = document.getElementById('resultHistoryArea');
let b_start = document.getElementById('b_start');
let b_hit = document.getElementById('b_hit');
let b_stay = document.getElementById('b_stay');
let b_config = document.getElementById('b_config');

b_hit.style.display = 'none';
b_stay.style.display = 'none';

let gameOver, playerWon, gameStarted;

welcomeText();

b_config.addEventListener('click', function(){
    createConfigPage();
});

b_start.addEventListener('click', function(){
    gameOver = false;
    playerWon = false;
    gameStarted = true;

    deck = createDeck();
    deck = shuffleDeck();
    dealerCards = [ getNextCard(), getNextCard() ];
    playerCards = [ getNextCard(), getNextCard() ];
    dealerScore = getScore(dealerCards);
    playerScore = getScore(playerCards);

    b_start.style.display = 'none';
    b_hit.style.display = 'inline';
    b_stay.style.display = 'inline';

    resultArea.innerHTML = "Who will win?"
    showStatus();
});

b_hit.addEventListener('click', function(){
    playerCards.push(getNextCard());
    playerScore = getScore(playerCards);
    checkForOverFlow();
    showStatus();
});

b_stay.addEventListener('click', function(){
    computerTurn();
});