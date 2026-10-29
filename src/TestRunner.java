import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        
        XmlSuite suite = new XmlSuite();
        suite.setName("MyTestSuite");
        suite.setParallel("none"); // run sequentially
        
        // Login Tests
        XmlTest loginTest = new XmlTest(suite);
        loginTest.setName("LoginTests");
        List<XmlClass> loginClasses = new ArrayList<XmlClass>();
        loginClasses.add(new XmlClass("Tests.loginTestNG"));
        loginTest.setXmlClasses(loginClasses);   
        
        // Checkbox Tests
        XmlTest checkboxTest = new XmlTest(suite);
        checkboxTest.setName("CheckboxTests");
        List<XmlClass> checkboxClasses = new ArrayList<XmlClass>();
        checkboxClasses.add(new XmlClass("Tests.checkboxTestNG"));
        checkboxTest.setXmlClasses(checkboxClasses);
        
        // Run
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        TestNG testng = new TestNG();
        testng.setXmlSuites(suites);
        testng.run();
    }
}