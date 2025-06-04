import java.util.*;
public class User {
    static HashMap<String, Integer> hs = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    public static void  menu(){
        hs.put("Idly", 10);
        hs.put("Pori", 20);
        hs.put("Dosa", 30);
        hs.put("Pongal",40);
        hs.put("Upma", 50);
        int choice=0;
        while (choice!= 3) {

            System.out.println("\n1. Display Menu\n2. Select Items\n3. Exit");
            System.out.print("Enter your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayItem();
                    break;
                case 2:
                    selectItem();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
    public static void displayItem() {
        for (String key : hs.keySet()) {
            System.out.println(key + "-" +"Rs "+ hs.get(key));
        }

    }

    public static void selectItem () {
        int totalSum = 0;
        System.out.println("No of Items");
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the item");
            String item = sc.next();
            if (hs.containsKey(item)) {
                int cost = hs.get(item);
                System.out.println("Enter the quantity");
                int quantity = sc.nextInt();
                int sum = cost * quantity;
                totalSum += sum;

            } else {
                System.out.println("Not available");
            }
        }
        System.out.println("TotalBill"+"-"+totalSum);


    }

}






