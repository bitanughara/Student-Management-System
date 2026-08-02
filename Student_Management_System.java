import java.util.*;
public class Student_Management_System{
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        String name[]=new String[1000];
        String [] regNo = new String[1000];
        int ben[] = new int[1000];
        int eng[] = new int[1000];
        int phy[] = new int[1000];
        int chem[] = new int[1000];
        int math[] = new int[1000];
        int opt[] = new int[1000];
        int marks[] = new int[1000];
        int total=0;
        int choice;
        do{
            System.out.println("--------------------------------");
            System.out.println("    STUDENT MANAGEMENT SYSTEM");
            System.out.println("--------------------------------");
            System.out.println("1. Add Student.");
            System.out.println("2. View Student.");
            System.out.println("3. Search Student.");
            System.out.println("4. Delete Student.");
            System.out.println("5. Calculate only HS Result.");
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
                    System.out.print("\nEnter Student's Result Subject-wise : \n");
                    System.out.print("Enter Bengali Marks : ");
                    ben[total] = sc.nextInt();
                    System.out.print("Enter English Marks : ");
                    eng[total] = sc.nextInt();
                    System.out.print("Enter Physics Marks : ");
                    phy[total] = sc.nextInt();
                    System.out.print("Enter Chemistry Marks : ");
                    chem[total] = sc.nextInt();
                    System.out.print("Enter Mathematics Marks : ");
                    math[total] = sc.nextInt();
                    System.out.print("Enter Optional Elective Subject Marks : ");
                    opt[total] = sc.nextInt();
                    boolean fail = false;
                    if (ben[total] < 33 || eng[total] < 33 || phy[total] < 33 || chem[total] < 33 
                        || math[total] < 33 || opt[total]<33) {
                        fail = true;
                        if(fail==true){
                        System.out.println("Student is Fail !");
                        System.out.println(" But");
                        }
                    }
                    if(ben[total] < 0 || ben[total] > 100 || eng[total] <0 || eng[total] >100 
                    || phy[total] < 0 || phy[total] > 100 || chem[total] < 0 || chem[total] > 100 
                    || math[total] < 0 || math[total] > 100 || opt[total]< 0 || opt[total] > 100){
                        System.out.println("Invalid Marks !");
                        break;
                    }
                    int min=phy[total];
                    if(math[total]<min){
                        min = math[total];
                    }
                    if(chem[total]<min){
                        min = chem[total];
                    }
                    if(opt[total]<min){
                        min = opt[total];
                    }
                    
                    marks[total] = (ben[total] + eng[total] + phy[total] + chem[total] + math[total] + opt[total])-min;
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
                            System.out.println((i+1)+"."+" "+name[i]+"  ||  "+"Registration No - "+regNo[i]+"  ||  "
                            +"Obtain Marks = "+marks[i]);
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
                            System.out.println("\nStudent Found..!\n");
                            System.out.println(name[i]+"  ||  "+"Registration No - "+regNo[i]+"  ||  "+"Obtain Marks = "+marks[i]);
                            found=true;
                            break;
                        }
                    }
                    if (!found){
                        System.out.println("Student Not Found.\n");
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
                    int b=sc.nextInt();
                    System.out.print("Enter your English Marks :");
                    int e=sc.nextInt();
                    System.out.print("Enter your Physics Marks :");
                    int p=sc.nextInt();
                    System.out.print("Enter your Chemistry Marks :");
                    int c=sc.nextInt();
                    System.out.print("Enter your Mathemaics Marks :");
                    int m=sc.nextInt();
                    System.out.print("Enter your Optional Subject Marks :");
                    int optl=sc.nextInt();
                    if(b < 0 || b > 100 || e<0 || e>100 
                    || p < 0 || p > 100 || c < 0 || c > 100 
                    || m < 0 || m > 100 || optl < 0 || optl > 100){
                    System.out.println("Invalid Marks!");
                    continue;
                    }
                    boolean faill = false;
                    if (b < 30 || e < 30 || p < 30 || c < 30 || m < 30 || optl<30) {
                        fail = true;
                    }
                    int minn = p;
                    if(c < minn) minn = c;
                    if(m < minn) minn = m;
                    if(optl < minn) minn = optl;
                    int obtMarks = (b+e+p+c+m+optl)-minn;
                    System.out.println("\n=== Your Result ===\n");
                    System.out.println("Your total Marks is ="+" "+obtMarks);
                    double percent = (obtMarks/500.0)*100;
                    System.out.println("Percentage = "+" "+percent+"%");
                    if(faill){
                        System.out.println("Grade : F");
                        System.out.println("Result : Fail !\n");
                    }
                    else if(obtMarks>=400 && obtMarks<=500){
                        System.out.println("Grade : A+");
                        System.out.println("Result : Excellent !\n");
                    }
                    else if(obtMarks>=300){
                        System.out.println("Grade : A");
                        System.out.println("Result : First Division !\n");
                    }
                    else if(obtMarks>=225){
                        System.out.println("Grade : B");
                        System.out.println("Result : Second Division !\n");
                    }
                    else if(obtMarks>=150){
                        System.out.println("Grade : C");
                        System.out.println("Result : Pass !\n");
                    }
                    else if(obtMarks>=0 && obtMarks<150){
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
