# Tic-Tac-Toe-Game
### A client-server java application:
#### the client application has three mode
* One player mode to play aganist computer
* Two player mode to play with another player locally
* online mode to play with another player through the network 
#### the server application:
* Handle requests
* Store the users data in database
* Send data from one user to another

these applications are developed by students of ITI intake#43, Native Mobile Application Development track.

## Installation
we created two javafx projects TicTacToeGame, and GameServer
to use it 
1. clone the project by writing these command in your CMD
```bash
git clone https://github.com/AhmedWard-eng/Tic-Tac-Toe-Application.git
```
2. open client and server projects using netbeans IDE.
3. add jar files to projects to be able to run it. you have to add gson jar lib, jdbc lib and jfoenix-8.0.2 jar.

## Usage

you can choose 
* one player mode to play aganist computer with three degree of difficulties 
  * easy
  * meduim
  * hard
* two player mode
* online mode to play through the LAN network.
####
you can record game in all modes and show the records from the home page.
 
![home](https://user-images.githubusercontent.com/83098969/212575412-0b06a3ba-3da7-4ea8-851a-b16db7b47d62.png)


if you choose single mode, you can play against computer and choose the diffuclity level easy, meduim or hard. 

![chooseLevel](https://user-images.githubusercontent.com/83098969/212572784-99a7da9a-09df-48f4-86d2-ebf0331472c6.png)

then, start game.

![gameSingleMode](https://user-images.githubusercontent.com/83098969/212573970-44978f80-d1e1-45c1-b44b-cdd811fd2386.png)


when you choose two player,you can play with friend in the same machine and you can enter your names.

![enter name](https://user-images.githubusercontent.com/83098969/212573806-9966cf3f-4282-4991-b278-9a920ce04d97.png)

if you play online game with friend, you can choose online.
##### 
but first you have to run the GameServer application.
the game server has start and stop buttons to open the server and to close it. 

![server](https://user-images.githubusercontent.com/83098969/212575396-09a74c8e-ec12-4ff4-a6d6-440b0ba9464e.png)

then in the client application to play, you need to create account by signing up and then logining the game.

![loginSinUp](https://user-images.githubusercontent.com/83098969/212574255-7d3217ef-deac-4f19-a983-44e8003bd364.png)

 
 In online mode after loginig ,it show you a list of online players and you can send invitation to a player to play a game with him.
 ###
 the other player has two option 
 1. accept 
 ##### or
 2. refuse. 
 #####
 if the player accept you can start game and if the player refuse you can choose anther player to play with.
 
 ![listOnline](https://user-images.githubusercontent.com/83098969/212574768-e3d92146-cace-445d-ade3-f3dedf70acb4.png)
 
 ![invetation](https://user-images.githubusercontent.com/83098969/212574929-84102680-f9a4-48ef-930c-8ee7d3d5b526.png)
![onlineGame](https://user-images.githubusercontent.com/83098969/212575074-f27ca520-d72e-4375-95c9-150c09a774ba.png)


At the end of the game, the game shows a video to the user

* win video for the winner
* draw video for both while drawing 
* lose video for the loser
 
 ![video](https://user-images.githubusercontent.com/83098969/212575233-c4c6693d-a99d-4bf0-92f3-04845b8d3fa7.png)
 
 ![draw](https://user-images.githubusercontent.com/83098969/212575245-9771f44e-e194-47e4-9f3e-eab675ba1762.png)

 
 ## Contributors

+ Ahmed gamal Ahmed Ward
+ Hossam Ahmed Fadaly 
+ Marina abdelmalak beshara saad 
+ Nada Alsayed hamed 

