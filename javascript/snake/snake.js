// https://stackoverflow.com/questions/5596434/clear-canvas-rect-but-keep-background/5600671#5600671
// https://stackoverflow.com/questions/2795269/does-html5-canvas-support-double-buffering
// https://www.html5rocks.com/en/tutorials/canvas/performance/

class Snake
{
    constructor(x, y)
    {
        this.startx = x;
        this.starty = y;
        this.currentSpeed = ONE;
        this.dx = 0;
        this.dy = 0;
        this.rectSize = ONE;
        this.color = 'white';
        this.body =
        [
            {
                x: this.startx,
                y: this.starty,
                width: this.rectSize,
                height: this.rectSize
            }
        ];
    }

    draw()
    {
        ctx.fillStyle = this.color;
        for (const elem of this.body)
        {
            ctx.fillRect(elem.x, elem.y, elem.width, elem.height);
        }
    }

    right()
    {
        this.dx = this.currentSpeed;
        this.dy = 0;
    }
    
    left()
    {
        this.dx = -this.currentSpeed;
        this.dy = 0;
    }
    
    up()
    {
        this.dx = 0;
        this.dy = -this.currentSpeed;
    }
    
    down()
    {
        this.dx = 0;
        this.dy = this.currentSpeed;
    }

    grow()
    {
        let lastElem = this.body[this.body.length-1];
        this.body.push(
            {
                x: lastElem.x,
                y: lastElem.y,
                width: lastElem.width,
                height: lastElem.height
            });
    }

    update()
    {
        let elem = this.body[0];
        let beforeX = elem.x;
        let beforeY = elem.y;
        elem.x += this.dx;
        elem.y += this.dy;

        if (game.gameMode === 'overthewalls')
        {
            if (elem.x >= canvas.width)
            {
                elem.x = 0;
            }
            else if (elem.x < 0)
            {
                elem.x = canvas.width - ONE;
            }
            if (elem.y >= canvas.height)
            {
                elem.y = 0;
            }
            else if (elem.y < 0)
            {
                elem.y = canvas.height - ONE;
            }
        }

        let tmpX, tmpY;
        for (let i = 1, length = this.body.length; i < length; i++)
        {
            elem = this.body[i];
            tmpX = elem.x;
            tmpY = elem.y;
            elem.x = beforeX;
            elem.y = beforeY;
            beforeX = tmpX;
            beforeY = tmpY;
        }
    }
}

class Food
{
    constructor(x, y)
    {
        this.x = x;
        this.y = y;
        this.color = 'lightgreen';
        this.radius = ONE / 2 - 1;

    }

    draw()
    {
        ctx.strokeStyle = this.color;
        ctx.fillStyle = this.color;
        ctx.lineWidth = 1;
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.radius, 0, 2 * Math.PI, false);
        ctx.fill();
        ctx.stroke();
    }
}

class Game
{
    constructor()
    {
        this.snake = new Snake(this.discreteRandom(canvas.width), this.discreteRandom(canvas.height));
        this.food = this.newFood();
        this.stopGame = false;
        this.gameMode = 'overthewalls';
        this.lastTimeOfAction = performance.now();
        this.speed = 1; // 1 - slowest
    }

    discreteRandom(max)
    {
        return Math.round(Math.random() * (max - ONE) / ONE) * ONE;
    }

    clear()
    {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
    }

    update()
    {
        this.snake.update();
        if (this.snakeOnFood())
        {
            this.snake.grow();
            this.food = this.newFood();
        }
    }

    snakeOnFood()
    {
        let onFood = false;
        let x = this.food.x - ONE/2;
        let y = this.food.y - ONE/2;
        for (const elem of this.snake.body) {
            onFood |= (elem.x === x && elem.y === y);
            if (onFood) break;
        }
        return onFood;
    }

    draw()
    {
        this.clear();
        this.snake.draw();
        this.food.draw();
    }
    
    newFood()
    {
        return new Food(this.discreteRandom(canvas.width) + ONE/2, this.discreteRandom(canvas.height) + ONE/2);
    }

    timeToMove()
    {
        let itstime = false;
        let now = performance.now();
        let delta = now - this.lastTimeOfAction;
        if (delta > 100)
        {
            this.lastTimeOfAction = now;
            itstime = true;
        }
        return itstime;
    }

    main()
    {
        requestAnimationFrame(this.main.bind(this));
        if (this.timeToMove() && !this.stopGame)
        {
            this.update();
            this.draw();
        }
        // let start = performance.now();
        // let fps = 30;
        // let mspf = 1000 / fps;
        // sleep(mspf);
        // let delta = performance.now() - start;
        // console.log("waited:");
        // console.log(delta);
    }
}

const ONE = 10;

let canvas = document.getElementById('snakeCanvas');
canvas.height = 40 * ONE;
canvas.width = 30 * ONE;
canvas.addEventListener('click', clickHandler);
let ctx = canvas.getContext('2d');

let game = new Game();
game.main();

function clickHandler(event)
{
    game.stopGame = !game.stopGame;
}

function keyDownHandler(event)
{
    switch (event.key)
    {
        case 'ArrowRight':
            game.snake.right();
            break;
        case 'ArrowLeft':
            game.snake.left();
            break;
        case 'ArrowUp':
            game.snake.up();
            break;
        case 'ArrowDown':
            game.snake.down();
            break;
        case 'Enter':
            game.snake.grow();
            break;
        default:
            console.error("Don't know what to do whit this key: " + event.key);
            break;
    }
}