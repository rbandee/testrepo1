//http://html5doctor.com/an-introduction-to-the-canvas-2d-api/
//https://www.w3schools.com/html/html5_canvas.asp
//https://www.w3schools.com/graphics/canvas_intro.asp
//https://www.w3schools.com/graphics/svg_rect.asp
//https://www.w3schools.com/graphics/game_canvas.asp

//canvas tutorial
//https://www.youtube.com/watch?v=EO6OkltgudE
//https://www.html5canvastutorials.com/

//https://caniuse.com/#feat=high-resolution-time

//https://www.youtube.com/watch?v=yq2au9EfeRQ

let canvas = document.getElementById('baseCanvas');
canvas.width = window.innerWidth;
canvas.height = window.innerHeight;

canvas.addEventListener("click", onClick, false);

let context2d = canvas.getContext('2d');

//draw rectangle
context2d.fillStyle = 'blue';
context2d.fillRect(10, 20, 200, 100);

//draw line
context2d.strokeStyle = 'red';
context2d.lineWidth = 2;
context2d.beginPath();
context2d.moveTo(50, 200);
context2d.lineTo(100, 250);
context2d.lineTo(200, 400);
context2d.stroke();

//draw arc
// context2d.strokeStyle = '#fa00ff';
// context2d.lineWidth = 4;
// context2d.lineCap = 'round';
// for (let index = 0; index < 10; index++) {
//     let radius = Math.random() * 100;
//     let x = Math.random() * (window.innerWidth - 2 * radius) + radius;
//     let y = Math.random() * (window.innerHeight - 2 * radius) + radius;
//     context2d.beginPath();
//     context2d.arc(x, y, radius, degree2rad(0), degree2rad(360), false);
//     context2d.stroke();
// }


class Circle {
    constructor() {
        this.radius = Math.random() * 100;
        this.x = Math.random() * (window.innerWidth - 2 * this.radius) + this.radius;
        this.y = Math.random() * (window.innerHeight - 2 * this.radius) + this.radius;
        this.strokeStyle = 'blue';
        this.lineWidth = 4;
        this.dx = Math.random() * (-10) + 15;
        this.dy = Math.random() * (-10) + 15;
    }
    
    static degree2rad(degree) {
        return degree * Math.PI / 180;
    }

    draw() {
        context2d.strokeStyle = this.strokeStyle;
        context2d.lineWidth = this.lineWidth;
        context2d.beginPath();
        context2d.arc(this.x, this.y, this.radius, Circle.degree2rad(0), Circle.degree2rad(360), false);
        context2d.stroke();
    }

    update(){
        if (this.x + this.dx > window.innerWidth - this.radius || this.x + this.dx < this.radius){
            this.dx = -this.dx;
        }
        if (this.y + this.dy > window.innerHeight - this.radius || this.y + this.dy < this.radius){
            this.dy = -this.dy;
        }

        this.x += this.dx;
        this.y += this.dy;
    }
}

let circles = [];
for (let index = 0; index < 20; index++) {
    let circle = new Circle();
    circles.push(circle);
    circle.draw();
}

let startTime = window.performance.now();
let stopEvent = false; //TODO: if mousepressed then true

function onClick(e) {
    console.log('CLICK');
    stopEvent = !stopEvent;
    console.log(stopEvent);
    main();
}

function main(){
    let delta = window.performance.now() - startTime;
    if (delta < 1000 || !stopEvent) {
        requestAnimationFrame(main);
    }
    
    context2d.clearRect(0, 0, window.innerWidth, window.innerHeight);
    for (const circle of circles) {
        circle.update();
        circle.draw();
    }
}

main();

