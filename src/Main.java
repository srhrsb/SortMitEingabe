import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       //Aufruf der Methode, die die Funktionen startet
        sortInput();
    }

    private static void sortInput(){

        //Object für Tastatureingabe instanziieren
        Scanner scanner = new Scanner(System.in);

        //Eingabeaufforderung an Nutzer, Zahlen einzugeben
        System.out.println("Bitte gib die Zahlen, die sortiert werden sollen, mit" +
                          " Komma getrennt ein.");

        //Eingegebene Zeile holen
        String inputArrayString = scanner.nextLine();

        System.out.println("");
        //Aufforderung zur Eingabe der Sortierrichtung
        System.out.println("Sortierrichtung? ('auf' oder 'ab'):");

        //Tastatureingabe für Sortierrichtung holen
        String sortDirection = scanner.nextLine();

        //validieren(Gültigkeit der Eingaben prüfen)------------------
        //die Variable sortDirectOk wird wahr, wenn auf oder ab eingegeben wurde
        boolean sortDirectOk = sortDirection.equals("auf") || sortDirection.equals("ab");

        //ist die Eingabe der Zahlen nicht leer und enthält mindestens ein Komma?
        boolean inputArrayStringValid = !inputArrayString.isEmpty()
                                        && inputArrayString.contains(",");


        if(sortDirectOk && inputArrayStringValid ){
            //alle Daten sind da und richtig

            //Leerzeichen entfernen
           inputArrayString.trim();

           //Zeichenkette aufteilen in ein Array, das komma dient als Trenner
           String[] numbersString = inputArrayString.split(",");

           //String Array in ein Integer Array umwandeln-------------
            //deklarieren eines integer Arrays
           int[] numbers = new int[numbersString.length];

           //durchlaufen des String-Arrays mit den Zahlen
           for( int i= 0; i< numbersString.length; i++ ){
              //übertragen der in Integer konvertierten Strings in das Zahlen-Array
              numbers[i] = Integer.parseInt(numbersString[i]);
           }

           //übergabe der Zahlen an BubbleSort mit Angabe der Sortierrichtung
           int[] numbersSorted = bubbleSort( numbers, sortDirection.equals("ab"));

           //Ausgabe der sortierten Zahlen an den Benutzer
           System.out.println("Hier sind deine sortierten Zahlen:");

           //Sortierte Zahlen(Array) durchlaufen und ausgeben
           for(int number : numbersSorted){
               System.out.println(number);
           }

            //Nachfrage, ob weiter machen
           System.out.print("Weiter (j/n)? ");

           String repeat = scanner.nextLine();
           if(repeat.equals("j")){
               sortInput();
           }
        }
    }

    private static int[] bubbleSort( int[] array, boolean down ){

        //merken, das nocht sortiert ist
        boolean sorted = false;

        //solange durch Array laufen, wie sorted = false (nicht sortiert)
        while(sorted != true){
            //das würde bedeuten, das die Schleife nicht nochmal aufgerufen würde
            sorted = true;
            //durchlaufen des Arrays
            for(int i = 0; i < array.length-1; i++){
                 boolean dir = array[i] > array[i+1];

                 if(down == true)
                     dir = array[i] < array[i+1];

                if(dir){ //je nach Sortierung Nachfolger und Vorgänger tauschen
                    int temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;

                    //da sortiert wurde, soll die while-Schleife weiter laufen
                    //deshalb sorted auf false setzen
                    sorted = false;
                }
            }
        }
        return array;
    }



}