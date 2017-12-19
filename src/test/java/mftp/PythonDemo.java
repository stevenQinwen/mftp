package mftp;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by zhangmingbo on 3/20/17.
 */
public class PythonDemo {

    public static void main(String[] args) throws IOException {

        //Create interpreter
        Properties props = new Properties();
        props.put("python.home", "path to the Lib folder");
        props.put("python.console.encoding", "UTF-8"); // Used to prevent: console: Failed to install '': java.nio.charset.UnsupportedCharsetException: cp0.
        props.put("python.security.respectJavaAccessibility", "false"); //don't respect java accessibility, so that we can access protected members on subclasses
        props.put("python.import.site", "false");

        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);

        PythonInterpreter interp = new PythonInterpreter();

        interp.exec("import sys");
//        interp.exec("sys.path.append('D:/Program Files (x86)/jython2.7.0/Lib')");//jython自己的
//        interp.exec("sys.path.append('D:/Program Files (x86)/jython2.7.0/Lib/site-packages')");//jython自己的
        interp.exec("sys.path.append('C:/Users/xuhao/Loquat')");//我们自己写的

        interp.execfile("D:\\java_related\\fund_predict_workspace\\mftp\\src\\test\\java\\mftp\\complex.py");
        PyFunction func = (PyFunction)interp.get("complex",PyFunction.class);
        int a = 2010, b = 2 ;
        PyObject pyobj = func.__call__(new PyInteger(a), new PyInteger(b));
        System.out.println("anwser = " + pyobj.toString());
        
    }
}
