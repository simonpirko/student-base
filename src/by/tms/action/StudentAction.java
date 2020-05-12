package by.tms.action;

//import by.tms.service.StudentService;

import by.tms.action.util.Reader;
import by.tms.action.util.Writer;

public class StudentAction {

	public void registration(){
		Writer.write("Enter name");
		String name=Reader.readName();
		if (name==null){
			registration();
		}else{
			Writer.write(name);
		}
	}

}
