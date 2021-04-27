import java.util.Scanner;
//This program generates a simble addtion  questions as asks the user for an answer
public class QuizProgram {
        public static void main(String args[]){
            int num1, num2, randsign, answer, playerAnswer, score;

            score = 0;

            for (int i =1; i< 10; i++){
                randsign = (int) ((1-0 +1) * Math.random() + 0);
                num1 = (int) ((99-0 +1) * Math.random() + 0);
                num2 = (int) ((99-0 +1) * Math.random() +0 );

                if (randsign == 0){
                    answer = num1 + num2;

                    System.out.println("What is your answer to " + num1 + " + " + num2 + " = " );
                    playerAnswer = new Scanner(System.in) .nextInt();

                    if(playerAnswer == answer){
                        System.out.println("Your are correct");
                        score +=1;
                    }
                    else{
                        System.out.println("Sorry, the correct answer is "+ answer);
                    }
                }
                else{
                    answer = num1 - num2;

                    System.out.println("What is your answer to" + num1 + " - " + num2 + " = " );
                    playerAnswer = new Scanner(System.in) .nextInt();

                    if(playerAnswer == answer){
                        System.out.println("Your are correct");
                        score += 1;
                    }
                    else{
                        System.out.println("Sorry, the correct answer is "+ answer);
                    }
                }
            }
            score = score*10;
            System.out.println("You scored "+ score+ " on the quiz");


        }

}
