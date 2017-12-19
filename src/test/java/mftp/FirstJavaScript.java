package mftp;

import javax.script.*;    

import org.python.core.PyFunction;    
import org.python.core.PyInteger;    
import org.python.core.PyObject;    
import org.python.util.PythonInterpreter;    
    
import java.io.*;    
import static java.lang.System.*;    
public class FirstJavaScript    
{    
 public static void main(String args[])    
 {    
      
  PythonInterpreter interpreter = new PythonInterpreter();    
  interpreter.execfile("D:\\java_related\\fund_predict_workspace\\mftp\\src\\test\\java\\mftp\\input.py");    
 }//main    
}  
