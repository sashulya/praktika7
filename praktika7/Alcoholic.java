import java.util.ArrayDeque;
import java.util.Scanner;

public class Alcoholic {
    public static void main(String[] args) {
        System.out.println("Enter: ");
        ArrayDeque<Integer> first = new ArrayDeque<Integer>();
        ArrayDeque<Integer> second = new ArrayDeque<Integer>();

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 5; i++)
            first.add(scan.nextInt());

        for (int i = 0; i < 5; i++)
            second.add(scan.nextInt());

        int game_counter = 0;

        while(true && game_counter != 106 && !first.isEmpty() && !second.isEmpty()) {

            int fCard = first.poll();
            int sCard = second.poll();

            if(fCard < sCard || (sCard == 0 && fCard == 9)) {
                second.add(fCard);
                second.add(sCard);
            }
            else if(fCard > sCard || (fCard == 0 && sCard == 9)) {
                first.add(fCard);
                first.add(sCard);
            }
            ++game_counter;
        }

        if(game_counter == 106)
            System.out.println("botva");
        else if(first.isEmpty())
            System.out.println("second " + game_counter);
        else if(second.isEmpty())
            System.out.println("first " + game_counter);
    }
}
