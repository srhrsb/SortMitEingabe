import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       sortInput();
    }

    private static void sortInput(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gib die Zahlen, die sortiert werden sollen, mit" +
                          " Komma getrennt ein.");

        String inputArrayString = scanner.nextLine();

        System.out.println("");
        System.out.println("Sortierrichtung? ('auf' oder 'ab'):");

        String sortDirection = scanner.nextLine();

        //validieren(Gültigkeit prüfen
        boolean sortDirectOk = sortDirection.equals("auf") || sortDirection.equals("ab");

        boolean inputArrayStringValid = inputArrayString != ""
                                        && inputArrayString.contains(",");
        if(sortDirectOk && inputArrayStringValid ){
            //alle daten sind da
           inputArrayString.trim();//Leerzeichen entfernen

           //Zeichenkette aufteilen in ein Array, das komma dient als Trenner
           String[] numbersString = inputArrayString.split(",");

           //String Array in ein Integer Array umwandeln
           int[] numbers = new int[numbersString.length];

           for( int i= 0; i< numbersString.length; i++ ){
              numbers[i] = Integer.parseInt(numbersString[i]);
           }

           int[] numbersSorted = bubbleSort( numbers, sortDirection.equals("ab"));

           System.out.println("Hier sind deine sortierten Zahlen:");

           for(int number : numbersSorted){
               System.out.println(number);
           }

           System.out.print("Weiter (j/n)? ");

           String repeat = scanner.nextLine();
           if(repeat.equals("j")){
               sortInput();
           }
        }
    }

    private static int[] bubbleSort( int[] array, boolean down ){

        boolean sorted = false;
        while(sorted != true){
            sorted = true;

            for(int i = 0; i < array.length-1; i++){
                 boolean dir = array[i] > array[i+1];

                 if(down == true)
                     dir = array[i] < array[i+1];

                if(dir){
                    int temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;

                    sorted = false;
                }
            }
        }
        return array;
    }



}