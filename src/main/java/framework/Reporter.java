package framework;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Reporter {
    private static Date date = new Date();

//    private static Map<Long, ExtentTest> testThread = new HashMap<Long, ExtentTest>();
    private static File pathToReporter = new File("./src/test/reports/Report.html");
    private static ExtentHtmlReporter reporter;

    private synchronized static ExtentHtmlReporter getReporter() {
        if (reporter == null) {
            reporter = new ExtentHtmlReporter(pathToReporter.getAbsolutePath());
        }
        reporter.setStartTime(date);
        return reporter;
    }

//    public synchronized static Map<Long, ExtentTest> startTest(String testName, String testdescription){
//        Long threadId = Thread.currentThread().getId();
//        ExtentTest test = getReporter().startTest(testName, testdescription);
////        test.assignCategory(group);
//        testThread.put(threadId, test);
//        return testThread;
//    }

//    @BeforeSuite
//    public void startReporting(Method method) {
//
//        getReporter().start();
//    }

    public void closeTest() {
        getReporter().stop();
    }

    @AfterSuite(alwaysRun = true)
    public void closeReporter(){
        getReporter().flush();
    }




    @AfterMethod(alwaysRun = true)
    public void stopReporting(ITestResult result) {
        closeTest();
        int res = result.getStatus();
        switch (res) {
            case 1:
                System.out.println("[INFO] Test method finished with status: PASSED");
                break;
            case 2:
                System.out.println("[FAILED] Test method finished with status: FAILED");
                break;
            case 3:
                System.out.println("[INFO] Test method finished with status: SKIPED");
                break;
        }
    }
}
