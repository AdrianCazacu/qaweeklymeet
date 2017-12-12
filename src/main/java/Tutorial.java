import java.util.Scanner;

/**
 * Created by pc on 11/16/2016.
 */


class Person {

    String name;
    int age = 89;

    public void setName(String newName){
        name = newName;
        //this.name = newName;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }



}

//class Android {
//
//    public void name(String name){
//        System.out.println("My name is "+name);
//    }
//
//    public void distance(int distance){
//
//        System.out.println("I can walk "+distance + " meters without getting tired");
//    }
//
//    public void location(String location, double coordinates1, double coordinates2){
//
//        System.out.println("I'm currently in "+location + " and you can find me using the coordinates: "+coordinates1+" , "+coordinates2);
//    }



public class Tutorial {

    public static void main(String args[]) {


Person person1 = new Person();
        person1.name = "David";
        person1.age = 27;

        person1.setName("Blabla");

     person1.setAge(67);



        System.out.println(person1.getAge());


//        Person person1 = new Person();
//        person1.walking();
//        person1.name();
//
//
//        Android android1 = new Android();
//        android1.name("Ema");
//
//        for(int i=0;i<5;i++){
//            android1.distance(i);
//        }
//        android1.distance(123123123);
//        android1.location("Cluj-Napoca",45.2345,23.34545);



//        int[][] grid = {
//
//                {4,5,6},
//                {4,123,456},
//
//                {34,37}
//        };
//
//        System.out.println(grid[0][1]);
//
//        for(int row=0;row<grid.length;row++){
//            for (int col=0;col<grid[row].length;col++){
//                System.out.println(grid[row][col] + "\t");
//            }
//        }



    }


       // Person person1 = new Person();
       // person1.name = "Joe";
       // person1.age = 30;

       // Person person2 = new Person();


    }


