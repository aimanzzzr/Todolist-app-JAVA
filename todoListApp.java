import java.util.*;
import java.text.*;
import java.io.*;
public class todoListApp{
	public static void main(String[] args)throws IOException{
        todolist todo = new todolist();
        LinkedList<todolist> list = new LinkedList<todolist>();
        if(todo.testFile("todolist.txt")==false){
            System.out.println("dkcndskdfjkdnksjnsxd"); 
            list = todo.readFromFile();    
        }
        Scanner input = new Scanner(System.in);
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
		boolean isCont = false;
		while(isCont==false){
            System.out.println("==================================================================================================================================");
            System.out.println("\t\t\t\t\t\t\tTO DO LIST");
            System.out.println("==================================================================================================================================");
	        displayTodoList(list);		
	       	System.out.println("==================================================================================================================================");
		  	System.out.println("1 - CREATE TASK\n2 - REMOVE TASK\n3 - UPDATE TASK\n4 - EXIT PROGRAM");
		   	int choice = Choice("ENTER YOUR CHOICE: ",1,4);
		   	if(choice == 1){
		   		System.out.println("==================================================================================================================================");
		  		System.out.println("\t\t\t\t\t\t\tCREATE TASK");
		  		System.out.println("==================================================================================================================================");
               	System.out.print("TITLE: ");
               	String todoTitle = input.nextLine();
                System.out.print("DESCRIPTION: ");
                String todoDescription = input.nextLine();
               	System.out.println("DATE CREATED: "+df.format(date));
               	String dateCreated = df.format(date);
               	System.out.println("STATUS: NOT COMPLETED");
               	boolean todoStatus = false;
               	todolist a = new todolist(todoTitle,dateCreated,todoDescription,todoStatus);
               	list.addLast(a);
                todo.writeToFile(list);
            }else if(choice == 2){
                System.out.println("==================================================================================================================================");
                System.out.println("\t\t\t\t\t\t\tREMOVE TASK");
                System.out.println("==================================================================================================================================");
                displayTodoList(list);
                int remove = Choice("ENTER YOUR CHOICE: ",1,list.size());
                list.remove(remove-1);
                System.out.println("THE TASK HAVE BEEN DELETED.");
                System.out.println();
                todo.writeToFile(list);
            }else if (choice == 3){
                System.out.println("==================================================================================================================================");
                System.out.println("\t\t\t\t\t\t\tUPDATE TASK");
                System.out.println("==================================================================================================================================");
                displayTodoList(list);
                int update = Choice("ENTER YOUR CHOICE: ",1,list.size());
                todolist t = list.get(update-1);
                if(t.getTodoStatus()==false){
                    t.setTodoStatus(true);
                }else{
                    t.setTodoStatus(false);
                }
                todo.writeToFile(list);
            }else if (choice == 4){
                isCont = true; 
            }else{
                System.out.println("PLEASE ENTER THE RIGHT KEY.");
                System.out.println();
            }
		}
	}
    private static int Choice(String prompt,int min,int max){//input handling method
        Scanner input = new Scanner(System.in);
        int choice=0;
        boolean error = false;
        do{
            try{
                System.out.print(prompt);
                choice = Integer.parseInt(input.nextLine());
                if(choice<min || choice>max){
                    System.out.println("OUT OF CHOICE RANGE!");
                    error=true;
                }else{
                    error=false;
                }
            }catch(NumberFormatException a){
                System.out.println("NOT A NUMBER!");
                error=true;
            }
        }while(error==true);
        return choice;
    }
    private static void displayTodoList(LinkedList<todolist> list){
        System.out.printf("%-3s%-50s%-50s%-14s%-13s","NO","TITLE","DESCRIPTION","DATE CREATED","STATUS");
        System.out.println();
        System.out.println("==================================================================================================================================");
        if(list.isEmpty()){
            System.out.println("\t\t\t\t\tWow! Such Empty!");
        }else{
            int count = 1;
            todolist t = list.getFirst();
            while(t!=null){
                System.out.print(count+". ");
                t.displayTodoList();
                System.out.println();
                t = list.getNext();
                if(t!=null){
                    count++;
                }
            }
        }
    }
}