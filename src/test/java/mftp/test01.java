package mftp;

import java.util.Properties;

import org.junit.Test;
import org.python.antlr.ast.List;
import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

public class test01 {
	
	
	@Test
	public void test() {
		
		PythonInterpreter interpreter = new PythonInterpreter();  
		
			interpreter.exec("days=('mod','Tue','Wed','Thu','Fri','Sat','Sun'); ");  
			interpreter.exec("print days[1];");  
			interpreter.exec("print days[2];");  
			interpreter.exec("print ('fdsfdsafds')"); 
	  
	}
	
	
	@Test
	public void test02() {
		
		PythonInterpreter interpreter = new PythonInterpreter(); 
		PySystemState sys = Py.getSystemState();
		Properties props = new Properties();
		props.put("python.console.encoding", "UTF-8"); // Used to prevent: console: Failed to install '': java.nio.charset.UnsupportedCharsetException: cp0.
		props.put("python.security.respectJavaAccessibility", "false"); //don't respect java accessibility, so that we can access protected members on subclasses
		props.put("python.import.site","false");
		Properties preprops = System.getProperties();
		PythonInterpreter.initialize(preprops, props, new String[0]);
		PythonInterpreter interp = new PythonInterpreter();
		interp.exec("import sys");
		interp.exec("sys.path.append('D: \\python_related\\jython-installer-2.7.0\\Lib')");//jython自己的
		interp.exec("sys.path.append('D:\\python_related\\jython-installer-2.7.0\\Lib\\site-packages')");//jython自己的
		
		interpreter.execfile("D:\\java_related\\fund_predict_workspace\\mftp\\src\\main\\resources\\pyscript\\my_util.py");  
		PyFunction func = (PyFunction) interpreter.get("adder", PyFunction.class);  
		
		int a = 2010, b = 6; 
		
		PyObject pyobj = func.__call__(new PyInteger(a), new PyInteger(b));  
		
		System.out.println("anwser = " + pyobj.toString());  
		
	}
	
	
	@Test
	public void test03() {
		
		  PythonInterpreter interpreter = new PythonInterpreter();  
		  interpreter.exec("days=('mod','Tue','Wed','Thu','Fri','Sat','Sun'); ");  
		  interpreter.exec("print days[1];");  
		    
		    
		 }//main  
		
	

		
	}
	
	
	

