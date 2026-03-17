package lt.techin.praktinis;

import java.util.Arrays;

public class ArraysTask {


    public static void main(String[] args) {
        // Įgyvendikite visus metodus (turi pažaliuoti unit testai)
        // Pateiktas masyvas ir pavyzdys programos patikrinimui. Masyvo elementų reikšmes galite keisti.

        int[] arr = {3, 2, 1, 4, 6, 5};

        int[] arrWithRemovedElement = removeElementAndReturnNewArray(arr, 2);
        System.out.println("1 uzduotis:");
        System.out.println(Arrays.toString(arrWithRemovedElement));
        System.out.println("--------------------------------");

        System.out.println("2 uzduotis:");
        int[] generateRandom = generateRandomArray(5, 2, 3);
        System.out.println(Arrays.toString(generateRandom));
        System.out.println("--------------------------------");

        System.out.println("3 uzduotis:");
        int[] addNewElement = insertElementAndReturnNewArray(arr, 2, 3);
        System.out.println(Arrays.toString(addNewElement));
        System.out.println("--------------------------------");

        System.out.println("4 uzduotis:");
        int[] reversedArr = reverseArray(arr);
        System.out.println(Arrays.toString(reversedArr));
        System.out.println("--------------------------------");

        System.out.println("5 uzduotis:");
        reverseInPlace(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------------------------");
    }

   // Parašykite metodą, kuris sukuria nustatyto dydžio sveikųjų skaičių masyvą
   // ir užpildo jį atsitiktinai sugeneruotais skaičiais iš nurodyto intervalo.
    public static int[] generateRandomArray(int size, int min, int max) {
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            int randomNumber = (int)(Math.random() * (max - min + 1)) + min;
            arr[i] = randomNumber;
        }
        return arr;
    }


    //Parašykite metodą, kuris pašalintų masyvo arr[n] k-tąjį elementą (su indeksu k),
    //surašant reikiamus elementus į naują masyvą b[n-1]. Metodas grąžina naują masyvą.
    //Jei k yra už masyvo ribų, metodas grąžina null (teisingiau būtų mesti exception, bet dar nesimokėm)
    public static int[] removeElementAndReturnNewArray(int[] arr, int k) {
        if (k < 0 || k >= arr.length) {
            return null;
        }

        int[] newArr = new int[arr.length - 1];

        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                newArr[i] = arr[i];
            } else if (i > k) {
                newArr[i - 1] = arr[i];
            }
        }
        return newArr;
    }

    //Parašykite metodą, kuris įterptų į masyvą arr[n] prieš k-tąjį elementą reikšmę x,
    //surašant reikiamus elementus į naują masyvą b[n+1]. Metodas grąžina naują masyvą.
    //Jei k yra už masyvo ribų, metodas grąžina null (teisingiau būtų mesti exception, bet dar nesimokėm)
    public static int[] insertElementAndReturnNewArray(int[] arr, int k, int x){
        if (k < 0 || k >= arr.length) {
            return null;
        }

        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                newArr[i] = arr[i];
                newArr[k + 1] = arr[i];
            } else if (i == k) {
                newArr[k] = x;
            } else {
                newArr[i + 1] = arr[i];
            }
        }

        return newArr;
    }

    //Parašykite metodą, kuris grąžintų duoto masyvo apverstą kopija.
    public static int[] reverseArray(int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[arr.length - 1 - i];
        }
        return newArr;
    }

    //Parašykite metodą, kuris apverstu duotą masyvą (nekuriant naujo masyvo)
    public static void reverseInPlace(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }











}
