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
        //System.out.println(inputArrayString);

        System.out.println("Sortierrichtung? ('auf' oder 'ab'):");
        String sortDirection = scanner.nextLine();

        if(sortDirection == "auf" || sortDirection == "ab"){
            //alle daten sind da

            
        }



    }

    private static int[] bubbleSort( int[] array ){

        boolean sorted = false;
        while(sorted != true){
            sorted = true;

            for(int i = 0; i < array.length-1; i++){

                if(array[i] > array[i+1]){

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