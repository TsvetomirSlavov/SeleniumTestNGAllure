package base.listeners;

import base.BaseTest;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class OnFailure extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        BaseTest.makeScreenshot();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        BaseTest.makeScreenshot();
    }
}
