import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

/*
features: camel and player life, losing slows speed
- magic potion moves user or natives forward/back 2% chance lose or win
*/
class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    // Default Values
    int milesTraveled = 0;
    int thirst = 0;
    int fatigue = 0;
    int nativesTraveled = -20;
    int canteen = 3;
    int magicPotion = 1;
    boolean camelExist = true;
    boolean stillPlaying = true;

    while(stillPlaying){
      // Menu
      System.out.println("A) Drink from your canteen");
      System.out.println("B) Ahead at Moderate Speed");
      System.out.println("C) Ahead at Full Speed");
      System.out.println("D) Stop for the night");
      System.out.println("E) Use Magic Teleportation Potion");
      System.out.println("F) Status Check");
      System.out.println("Q) Quit");
      System.out.print("Choose an option from above: ");

      int nativesDistance = rand.nextInt(8) + 7;
      
      String userChoice = scan.nextLine();
      System.out.println();
      
      if(userChoice.equalsIgnoreCase("a")){
        if(canteen == 0){
          System.out.println("You drank air, not water");
        }
        canteen--;
        thirst = 0;
        System.out.println("Canteens: " + canteen);
        }
      if(userChoice.equalsIgnoreCase("b")){
        if(camelExist){
          milesTraveled += rand.nextInt(8) + 5;
        }
        else if(!camelExist){// Triggers when camel dead
          milesTraveled += rand.nextInt(4) + 1;
        }
        
        System.out.println("You have traveled " + milesTraveled + " miles");
        thirst ++;
        fatigue ++;
        nativesTraveled += nativesDistance;
        int goodBad = rand.nextInt(100);
        if(goodBad >= 0 && goodBad <= 14){
          System.out.println("You have arrived at an oasis. Your resources and energy has been fufilled");
          thirst = 0;
          canteen = 3;
          fatigue = 0;
          
        }
        else if(goodBad >= 15 && goodBad <= 35){
          System.out.println("You have run into a sandstorn and lost all your resources");
          canteen = 0;
          magicPotion = 0;
        }
        else if(goodBad >= 36 && goodBad <= 66){
          System.out.println("You have come across a mystery box. You have found additional resources");
          canteen ++;
        }
        else if(goodBad >= 67 && goodBad <= 72){
          if(camelExist){
            System.out.println("You have run into bandits and have stolen your camels and resources");
            canteen = 0;
            camelExist = false;
            magicPotion = 0;
          }
          else{
            System.out.println("Your have run into bandits and have lost your resources but they feel bad for you and give you a camel");
            camelExist = true;
            magicPotion = 0;
            canteen = 0;
          }
          
          
        }
      }

      if(userChoice.equalsIgnoreCase("c")){
        if(camelExist){
          milesTraveled += rand.nextInt(11) + 10;
        }
        else if(!camelExist){
          milesTraveled += rand.nextInt(6) + 5;
        }
        
        System.out.println("You have traveled " + milesTraveled + " miles");
        thirst ++;
        fatigue += rand.nextInt(3) + 1;
        nativesTraveled += nativesDistance;
        int goodBad = rand.nextInt(100);
        if(goodBad >= 0 && goodBad <= 14){
          System.out.println("You have arrived at an oasis. Your resources and energy has been fufilled");
          thirst = 0;
          canteen = 3;
          fatigue = 0;
          
        }
        else if(goodBad >= 15 && goodBad <= 35){
          System.out.println("You have run into a sandstorn and lost all your resources");
          canteen = 0;
          magicPotion = 0;
        }
        else if(goodBad >= 36 && goodBad <= 66){
          System.out.println("You have come across a mystery box. You have found additional resources");
          canteen ++;
        }
        else if(goodBad >= 67 && goodBad <= 72){
          if(camelExist){
            System.out.println("You have run into bandits and have stolen your camels and resources");
            canteen = 0;
            camelExist = false;
            magicPotion = 0;
          }
          else{
            System.out.println("Your have run into bandits and have lost your resources but they feel bad for you and give you a camel");
            camelExist = true;
            magicPotion = 0;
            canteen = 0;
          }
          
          
        }
      }

      if(userChoice.equalsIgnoreCase("d")){
        fatigue = 0;
        if(camelExist){
          System.out.println("Camel fatigue is " + fatigue);
        }
        else if(!camelExist){
          System.out.println("Camel fatigue is " + fatigue);
        }
        
        nativesTraveled += nativesDistance;
      }

      if(userChoice.equalsIgnoreCase("e")){
        if(magicPotion > 0){
          magicPotion -= 1;
          int potionNum = rand.nextInt(101); 
          if(potionNum >= 0 & potionNum <= 24){
            nativesTraveled += 50;
            System.out.println("The Natives have skipped forward ");
            if(nativesTraveled >= milesTraveled){
              System.out.println("The natives caught up. You died");
              stillPlaying = false;
            }
            else{
              System.out.println("The natives are " + (milesTraveled - nativesTraveled) + " miles behind you");
            }
            
          }
          else if(potionNum >= 24 & potionNum <= 48){
            nativesTraveled += -50;
            System.out.println("The natives have Fallen Backwards ");
            if(nativesTraveled >= milesTraveled){
              System.out.println("The natives caught up. You died");
              stillPlaying = false;
            }
            else{
              System.out.println("The natives are " + (milesTraveled - nativesTraveled) + " miles behind you");
            }
          }
            
          else if(potionNum >= 49 & potionNum <= 73){
            milesTraveled += 50;
            System.out.println("You have skipped forward ");
            System.out.println("Miles Traveled: " + milesTraveled);
          }
  
          else if(potionNum >= 74 & potionNum <= 98){
            milesTraveled += 50;
            System.out.println("You have skipped forward ");
            System.out.println("Miles Traveled: " + milesTraveled);
            
          }
  
        else if(potionNum == 99){
          System.out.println("You lose, that was a 1% chance. Sucks for you");
          stillPlaying = false;
        }
  
        else if(potionNum == 100){
          System.out.println("You win, that was a 1% chance. Good for you");
          stillPlaying = false;
        }
          
        }
        else if(magicPotion < 1){
          System.out.println("You don't have any potions left");
        }
        
      }

      if(userChoice.equalsIgnoreCase("f")){
        System.out.println("You have traveled " + milesTraveled + " miles");
        System.out.println("You have " + canteen + " canteens");
        System.out.println("Magic potions: " + magicPotion);
        if(camelExist){
          System.out.println("Camel fatigue is " + fatigue);
        }
        else if(!camelExist){
          System.out.println("Camel fatigue is " + fatigue);
        }
        System.out.println("You are " + (milesTraveled - nativesTraveled) + " miles ahead of the natives");
        
      }

      if(userChoice.equalsIgnoreCase("q")){
        stillPlaying = false;
        System.out.println("GAME OVER");
      }

      if(milesTraveled >= 200){
        stillPlaying = false;
        System.out.println("You won!");
      }
      
      if(thirst >= 4 && thirst <= 6){
        System.out.println("You are thirsty");
      }

      if(thirst > 6){
        stillPlaying = false;
        System.out.println("You died of dehydration!");
      }

      if(fatigue >= 5 && fatigue <= 8){
        if(camelExist){
          System.out.println("The camel is getting tired");
        }
        else if(camelExist){
          System.out.println("You are getting tired");
        }
        
      }

      if(fatigue > 8){
        if(camelExist){
          camelExist = false;
        fatigue = 0;
        System.out.println("Your camel dead. Your speed is now lower");
        }
        else if(!camelExist){
          stillPlaying = false;
          System.out.println("You walked too much so you lose");
        }
        
      }

      if(milesTraveled - nativesTraveled <= 15){
        System.out.println("The natives are getting closer");
      }

      if(nativesTraveled >= milesTraveled){
        stillPlaying = false;
        System.out.println("You died. The natives caught up to you.");
        
      }

      
    }
    System.out.println("You have traveled a total of " + milesTraveled + " miles");
    System.out.println("You have " + canteen + " canteens");
    if(camelExist){
      System.out.println("Camel fatigue is " + fatigue);
        }
    else if(!camelExist){
      System.out.println("Camel fatigue is " + fatigue);
        }
    System.out.println("You were " + (milesTraveled - nativesTraveled) + " miles ahead of the natives");
    
    
  }
}