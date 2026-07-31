import java.util.*;
public class Student_Management_Student{
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        String name[]=new String[1000];
        String [] regNo = new String[1000];
        int total=0;
        int choice;
        int marks,ben,e,p,c,m,opt,min;
        double percent;
        do{
            System.out.println("--------------------------------");
            System.out.println("    STUDENT MANAGEMENT SYSTEM");
            System.out.println("--------------------------------");
            System.out.println("1. Add Student.");
            System.out.println("2. View Student.");
            System.out.println("3. Search Student.");
            System.out.println("4. Delete Student.");
            System.out.println("5. Calculate HS Result.");
            System.out.println("6. Exit.");
            System.out.print("\nEnter Your Choice (1-6) : ");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Student's Name : ");
                    sc.nextLine();
                    name[total]=sc.nextLine();
                    System.out.print("Enter Student's Registration Number : ");
                    regNo[total]=sc.nextLine();
                    total++;
                    System.out.println("\nStudent Added Successfully..!\n");
                    break;
                case 2:
                    if(total == 0){
                        System.out.println("\nNo Student Found!\n");
                    }
                    else{
                        System.out.println("\nStudent List : ");
                        for(int i=0;i<total;i++){
                            System.out.println((i+1)+"."+" "+name[i]+"          "+"Registration No. "+regNo[i]);
                    }
                    }
                    break;
                case 3:
                    System.out.print("Enter Student's Name : ");
                    sc.nextLine();
                    String search=sc.nextLine();
                    boolean found=false;
                    for(int i=0;i<total;i++){
                        if(name[i].equalsIgnoreCase(search)){
                            System.out.println("Student Found..!");
                            System.out.println(name[i]+"     "+regNo[i]);
                            found=true;
                            break;
                        }
                    }
                    if (!found){
                        System.out.println("Student Not Found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Name to Delete: ");
                    sc.nextLine();
                    String del = sc.nextLine();
                    boolean deleted = false;
                    for (int i = 0; i < total; i++) {
                        if (name[i].equalsIgnoreCase(del)) {
                            for (int j = i; j < total - 1; j++) {
                                name[j] = name[j + 1];
                                regNo[j] = regNo[j + 1];
                            }
                            total--;
                            deleted = true;
                            System.out.println("\nStudent Deleted.\n");
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("\nStudent Not Found.\n");
                    }
                    break;
                case 5:
                    System.out.println("\n    Higher Secondary Result");
                    System.out.println("          Calculator");
                    System.out.println("--------------------------------");
                    System.out.print("Enter your Bengali Marks :");
                    ben=sc.nextInt();
                    System.out.print("Enter your English Marks :");
                    e=sc.nextInt();
                    System.out.print("Enter your Physics Marks :");
                    p=sc.nextInt();
                    System.out.print("Enter your Chemistry Marks :");
                    c=sc.nextInt();
                    System.out.print("Enter your Mathemaics Marks :");
                    m=sc.nextInt();
                    System.out.print("Enter your Optional Subject Marks :");
                    opt=sc.nextInt();
                    if(ben < 0 || ben > 100 || e<0 || e>100 
                    || p < 0 || p > 100 || c < 0 || c > 100 
                    || m < 0 || m > 100 || opt < 0 || opt > 100){
                    System.out.println("Invalid Marks!");
                    continue;
                    }
                    boolean fail = false;
                    if (ben < 30 || e < 30 || p < 30 || c < 30 || m < 30) {
                        fail = true;
                    }
                    min = p;
                    if(c < min) min = c;
                    if(m < min) min = m;
                    if(opt < min) min = opt;
                    marks = (ben+e+p+c+m+opt)-min;
                    System.out.println("\n=== Your Result ===\n");
                    System.out.println("Your total Marks is ="+" "+marks);
                    percent = (marks/500.0)*100;
                    System.out.println("Percentage = "+" "+percent+"%");
                    if(marks>=400 && marks<=500){
                        System.out.println("Grade : A+");
                        System.out.println("Result : Excellent !\n");
                    }
                    else if(marks>=300){
                        System.out.println("Grade : A");
                        System.out.println("Result : First Division !\n");
                    }
                    else if(marks>=225){
                        System.out.println("Grade : B");
                        System.out.println("Result : Second Division !\n");
                    }
                    else if(marks>=150){
                        System.out.println("Grade : C");
                        System.out.println("Result : Pass !\n");
                    }
                    else if(marks>=0 && marks<150){
                        System.out.println("Grade : F");
                        System.out.println("Result : Fail !\n");
                    }
                    else if(fail){
                        System.out.println("Grade : F");
                        System.out.println("Result : Fail !\n");
                    }
                    else{
                        System.out.println("Invalid Marks !\n");
                    }
                    break;
                    case 6:
                        System.out.println("\nThank You !\n");
                        break;
                    default:System.out.println("\nInvalid Choice !\n");
                    break;
                }
        }
        while(choice!=6);
        sc.close();
    }
}