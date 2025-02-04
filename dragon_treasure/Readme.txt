Linus Sidebäck
Oliver Fahlén
Viggo Storäng
Emil Dahlbäck

Antagande och förklaring Dragon Treasure Del 2, 2025-01-10

DragonTreasure:

	Instansvariabler

# startRoom: lagrar ett rum som spelaren ska starta i.

# rooms: lagra de rum vi skapar i setupGame metoden.

Metod

## main metoden ligger i klassen DragonTreasure. I main metoden ropar vi på metoden addPlayer

## addPlayer: Skapar vår spelare. addPlayer ropar på metoden playGame från klassen dungeon i slutet. 

## setupGame: Skapar vi våran spelplan och vi bestämmer också startrummet. I den metoden så skapar vi rooms objekt och door objekt (med hjälp av addDoor metoden som finns i klassen room) som knyter ihop rooms med varandra och berättar var varje door leder. Vi kan även lägga till om rummen har dragon eller treasure när vi skapar rummen. Vi lägger också in alla rooms i en lista. 

## nextRoom: tar två parametrar, den ena parameter är positionen på den dörr du valt, och andra tar vilket rum man är i. I metoden loopar vi igenom våran dörrlista. Själva metoden returnerar vilket nästa rum skall vara.

## EndGame är den metod som berättar för spelaren att hen klarat av vårt spel. Den berättar för spelaren hur mycket guld hen har och att hen klarat spelet.

Dungeon: 
	
Instansvariabler

# WelcomeMessage: En variabel som lagrar en sträng med vårt välkomstmeddelande 
	
Metod

## playGame: hanterar vi navigering och användarens input. Vi har en switch sats med en default. Våran while loop bryts enbart om spelaren väljer att inte spela längre. Några lokala variabler som vi har i playGame metoden är följande: 

# Play: En boolean variabel som vi använder för att bryta våran while loop. 

# Choice, är en char variabel som vi lagrar användar input i. 

# currentRoom, en variabel som vi lagrar nuvarande rummet i.

# nextRoom, en variabel som innehåller nästa rum vi ska till.

# drinkP: En instans av DrinkPotion klassen.

# gameMaster: En instans av DragonTreasure klassen.
     
Room:
	
Instansvariabler

# roomDesc är den variabel som vi lagrar rumsbeskrivningar i.
  
# doors är en arraylist som innehåller alla dörrar.

 	# monsters en ArrayList som innehåller alla monster

# items en ArrayLista som innehåller alla items.
	
	Metoder

## addDoor: en metod för att lägga till en dörr. addDoor lägger till dörren vi skapar i våran door ArrayLista. Tar en parameter.

## seeDoor: en metod för att see dörrar i rummet. Vi returnerar bara en door från metoden eller om metoden inte hittar något så returnerar metoden null. Tar en parameter

## addMonster: en metod för att lägga till monster i ett rum. Tar en parameter.

## removeMonster: en metod för att ta bort monster ur ett rum. Tar en parameter.

## seeMonster: en metod för att see monsterna i rummet. Vi returnerar bara ett monster från metoden eller om metoden inte hittar något så returnerar metoden null. Tar en parameter.

## addItem: en metod för att lägga till item ett rum. Tar en parameter.

## removeItem: en metod för att ta bort item ur ett rum. Tar en parameter.

## seeItems: en metod för att see items i rummet. Vi returnerar bara ett item från metoden eller om metoden inte hittar något så returnerar metoden null. Tar en parameter.

## doNarrative: Här så beskriver vi rummen och hanterar i vilken ordning man interagerar med monster, items och vägbeskrivningar. Vi kollar först om det finns några monster i rummet. Får vi en träff så ropar vi på foundMonster metoden i klassen FoundSomething. sedan loopar vi igenom våran item lista för rummet. Hittar den ett item så ropar den på metoden foundItem från klassen FoundSomething. Efter det loopar metoden igenom alla dörrar och skriver ut åt vilka håll man kan gå åt. Tar en parameter.
	
# foundSomething: En instans av klassen FoundSomething.

Door:
	
Instansvariabler

# Position: Lagrar dörrens position. 

# leadsTo: är vilket rum man kommer till ifall man går igenom en dörr.

# Locked: Används för att låsa en dörr eller öppna en dörr.

Metoder/getters/setters/konstruktorer:

## konstruktorn: Matar vi in position, vilket rum dörren leder till och ifall den är låst eller inte.

## isLocked: kollar vi ifall ett rum är låst eller öppet. -getter

## setLock: används för att ändra en dörrs Locked värde. Tar en parameter. -setter

Player:

Instansvariabler

# Name: Är till för att spara spelarens namn.

# gotTreasure: som är en boolean som kollar ifall spelaren plockat upp skatten. 

# Gold: Lagrar guld som man plockar upp från skatten.

# damage: lagrar skadan som spelaren gör utan ett vapen, den är konstant.

# health: är hur mycket liv som spelaren har när spelet startas, det kan dock ändras 
ifall man blir slagen av draken så tappar man liv och om man dricker potion får man mer liv.

# maxHealth: det är alltså ett max på hur mycket liv man kan ha och i vårt fall är det 10, den är konstant.

# items: en arraylist där det sparas vilka items man har i sitt inventory.

Metoder/getters/setters/konstruktorer:

## Konstruktorn tar en parameter och det är namnet på spelaren.
 
## Vi använder getters och setters för gottreasusers för att kolla ifall spelaren plockat upp skatten eller inte.

Map

# Vi tyckte det skulle underlätta ifall vi hade en map så att man kunde navigera sig enklare mellan rummen som finns. Vi kollar i vilket rum som spelaren befinner sig i och sedan skriver vi ut den map som stämmer överens med index.

Metoder

## checkCurrentRomm: visar nuvarande rummets karta. Metoden tar två parametrar.

Kompass

# Vi skapade en kompass för att komplettera mapen så att man vet vilken riktning man ska klicka för att gå åt rätt håll. 

Metod

##showCompas: Visar en kompas så man lättare kan navigera sig.

Potion

	Instansvariabler

# nameP = är namnet på item och den är en konstant

# itemID = är unikt för alla items och den är en konstant

# itemPic = är en bild som visas när spelare stöter på en potion och den är en konstant

	Metoder

# Potion ärver från item där vi lägger till att den ska ge spelaren mer hp ifall den har tappat efter att den har slagits mot draken. 

# När vi skapar rummen anger vi hur mycket den healar och i vilket rum den finns i.
	
getter/setter

# Vi har getter för att få healing

Treasure

Instansvariabler

# goldValue = är hur mycket guld som finns i skatten och det bestäms när man 
skapar skatten

# TreasureID = är ett unikt id för just skatten och den är en konstant

# nameT =  är namnet på skatten och den är en konstant

# itemDesc = är en bild på skatten och den är en konstant

Getter/setter

## En get metod för att få guldvärdet på skatten

Sword

## Vi skapade ett svärd som spelaren kan välja att plocka upp, eller inte plocka upp. Om spelaren väljer att plocka upp svärdet så kommer spelaren kunna göra mer skada. Om spelaren väljer att inte plocka upp svärdet så kan spelaren fortfarande göra skada, men inte lika mycket. 

Key

# Key är en klass vi skapat som ärver av superklassen Item 

Instans variabler

# name = Är nyckelns namn och den är en konstant

# itemId = Är nyckelns item id och är en konstant

# desc är en konstant
 	
# i superklassen finns beskrivningen av Key och dess “itemId”

Item

	Instansvariabler

# varje item måste ha ett name, itemDesc och itemId för att det ska skapas.

# Item används för att skapa svärd och potion som kan finnas ute på mapen. 

# de läggs till i en array lista där vi ger de ett unikt id 

	getter/setter

# Vi har get metoder för att kunna veta vilket id, namn och beskrivning en viss item har.

FoundSomething

Metoder

## FoundItem är en metod som hanterar item och spelar interaktion. Med andra ord så tillåter metoden att spelaren kan plocka upp item från ett rum. Om en spelare tar upp ett item så tas det bort från rummet. Tar tre parametrar.

## FoundMonster är en metod som hanterar monster och spelar interaktion. FoundMonster hanterar mer specifikt olika typer av battles. Om spelaren dödar monstret så tas det bort från rummet. Tar tre parametrar.

DrinkPotion 

Metoder

## drinkPotion en metod som hanterar interaktionen mellan potion och spelare. Den här metoden tillåter spelaren att välja ifall hen vill dricka sin potion eller inte. Tar två parametrar.

Monster

	Instansvariabler

# name = vilket namn som monstret ska ha.

# damage = hur mycket skada man tar från monstret. 

# healthPoints = hur mycket liv monstret har

# monsterDesc = är en liten förklaring eller bild på monstret.

# monsterId = ett unikt id för varje monster.

	Metoder:

## Konstruktorn tar 5 parametrar: name, damage, healthPoints, monsterDesc, monsterId.

Dragon

	Instansvariabler

# MonsterID = är unikt för just draken och den är en konstant

#nameD = är namnet på draken och den är en konstant

#monsterDesc =  är en bild på en drake och den är konstant

Metoder

## Konstruktorn tar två parametrar: Hur mycket skada den gör och hur mycket liv den har.

Goblin 

	Instansvariabler

# monsterDesc = är just nu en bild som ska föreställa ett goblin och den är en konstant

# nameG = namnet på goblin och den är en konstant

# stealGold = är hur mycket guld man tappar om den stjäl och den är en konstant

# monsterId =  är det unika id för klassen och den är en konstant
	
	Metoder

## Konstruktorn tar två parametrar: Hur mycket skada den gör och hur mycket liv den har.
	
## Vi har en getter som heter stealGold som använd ifall goblinen snor guld från spelaren.

Side note.

# Vi har valt att använda switch rule satsen över en vanlig switch sats. Våra switch satser nu breakar efter varje case. Så genom att använda switch rule slipper vi att sätta ut break efter varje vilket minskar risken för slarv fel.


