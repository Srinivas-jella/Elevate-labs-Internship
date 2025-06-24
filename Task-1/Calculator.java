import java.util.Scanner;

class Calculator{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Enter First Number: ");
            double num1 = sc.nextDouble();

            System.out.println("Enter Second Number: ");
            double num2 = sc.nextDouble();
            System.out.println("Choose the Operation to Perform(+,-,*,/): ");
            char operation = sc.next().charAt(0);

            double result = 0;

            switch(operation){
                case '+': result= num1+num2; 
                        break;
                case '-': result= num1-num2; 
                        break;
                case '*': result= num1*num2; 
                        break; 
                case '/': if(num2!=0) result=num1/num2;  
                else {
                        System.out.println("Cannot divide by zero");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Invalid operation");
                    continue;
                }
            System.out.println("result: " + result);

            System.out.println("Do you want to continue? (yes/no): ");
            String ans = sc.next().toLowerCase();
            if (!ans.equals("yes")) break;            
           
        }
        sc.close();
        System.out.println("Closed..");
    }
}