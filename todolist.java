import java.io.*;
import java.util.*;
public class todolist{
	private String todoTitle;
	private String dateCreated;
	private String todoDescription;
	private boolean todoStatus;//0-not completed,1-completed
	public todolist(){}
	public todolist(String todoTitle,String dateCreated,String todoDescription,boolean todoStatus){
		this.todoTitle = todoTitle;
		this.dateCreated = dateCreated;
		this.todoDescription = todoDescription;
		this.todoStatus = todoStatus;
	}
	public todolist(todolist t){
		this.todoTitle = t.getTodoTitle();
		this.dateCreated = t.getDateCreated();
		this.todoDescription = t.getTodoDescription();
		this.todoStatus = t.getTodoStatus();
	}
	public void setTodoTitle(String todoTitle){this.todoTitle = todoTitle;}
	public void setDateCreated(String dateCreated){this.dateCreated = dateCreated;}
	public void setTodoDescription(String todoDescription){this.todoDescription = todoDescription;}
	public void setTodoStatus(boolean todoStatus){this.todoStatus = todoStatus;}
	public String getTodoTitle(){return todoTitle;}
	public String getDateCreated(){return dateCreated;}
	public String getTodoDescription(){return todoDescription;}
	public boolean getTodoStatus(){return todoStatus;}
	public String toString(){return "To Do Title      : "+todoTitle+
								  "\nDate Created     : "+dateCreated+
								  "\nTo Do Description: "+todoDescription+
								  "\nTo Do Status     : "+todoStatus;}
	public void displayTodoList(){
		if(todoStatus==false){
			System.out.printf("%-50s%-50s%-14s%-13s",todoTitle,todoDescription,dateCreated,"NOT COMPLETED");
		}else{
			System.out.printf("%-50s%-50s%-14s%-13s",todoTitle,todoDescription,dateCreated,"COMPLETED");
		}
	}
	public void writeToFile(LinkedList<todolist>list)throws IOException{
		File FileName = new File("todolist.txt");
        FileWriter fw = new FileWriter(FileName);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        if(!FileName.exists()){
            FileName.createNewFile();   
        }
    	todolist t = list.getFirst();
        while(t!=null){
          out.println(t.getTodoTitle()+","+t.getTodoDescription()+","+t.getDateCreated()+","+t.getTodoStatus()+",");  
          t = list.getNext();
          if(t==null)break;
        }
        out.close();
	}
	public LinkedList<todolist> readFromFile()throws IOException{
		LinkedList<todolist>list = new LinkedList<todolist>();
		String data = null;
        StringTokenizer input = null;
        try{
            BufferedReader din = new BufferedReader(new FileReader("todolist.txt"));
            while((data=din.readLine())!=null){
                input = new StringTokenizer(data,",");
                String todoTitle = input.nextToken();
                String todoDescription = input.nextToken();
                String dateCreated = input.nextToken();
                boolean todoStatus = Boolean.parseBoolean(input.nextToken());
                todolist t = new todolist(todoTitle,dateCreated,todoDescription,todoStatus);
                list.addLast(t);
            }
        }catch(FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
	}
	public boolean testFile(String filename)throws IOException{//testing the file checking for exception
        boolean error = false;
        try{
            BufferedReader sin = new BufferedReader(new FileReader(filename));
            error= false;
        }catch(FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
            error= true;
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
            error= true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            error= true;
        }
        return error;
    }
}
