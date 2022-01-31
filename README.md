# Java 14 New Features

### Method fillSearchInputWithNumber refactor to lambda switch case

```shell
FROM

public GoogleSearchPage fillSearchInputWithNumber(int number) {
        String romanNumerals = "";
        switch (number) {
            case 1: {
                romanNumerals = "Ⅰ";
                break;
            }
            case 2: {
                romanNumerals = "ⅠⅠ";
                break;
            }
            case 3: {
                romanNumerals = "ⅠⅠⅠ";
                break;
            }
            case 4: {
                romanNumerals = "Ⅳ";
                break;
            }
            default: {
                break;
            }
        }
        searchInput.sendKeys("History of " + romanNumerals + " century");
        return this;
    }

TO

public GoogleSearchPage fillSearchInputWithNumber(int number) {
        String romanNumerals = "";
        switch (number) {
            case 1 -> {
                romanNumerals = "Ⅰ";
            }
            case 2 -> {
                romanNumerals = "ⅠⅠ";
            }
            case 3 -> {
                romanNumerals = "ⅠⅠⅠ";
            }
            case 4 -> {
                romanNumerals = "Ⅳ";
            }
        }
        searchInput.sendKeys("History of " + romanNumerals + " century");
        return this;
    }
```

<p>Refactor switch case from 8 to 14 version</p>

### Test checkFirstFoundLinkIsWikipediaWithNullInstance Output

<p>Added -XX:+ShowCodeDetailsInExceptionMessages to JVM option to see wider stacktrace</p>

```shell
java.lang.NullPointerException: Cannot invoke "GoogleSearchPage.open()" because the return value of "GoogleSearchPage.getNullInstance()" is null

	at GoogleSearchPageTest.checkFirstFoundLinkIsWikipediaWithNullInstance(GoogleSearchPageTest.java:26)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:133)
	at org.testng.internal.TestInvoker.invokeMethod(TestInvoker.java:598)
	at org.testng.internal.TestInvoker.invokeTestMethod(TestInvoker.java:173)
	at org.testng.internal.MethodRunner.runInSequence(MethodRunner.java:46)
	at org.testng.internal.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:824)
	at org.testng.internal.TestInvoker.invokeTestMethods(TestInvoker.java:146)
	at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:146)
	at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:128)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at org.testng.TestRunner.privateRun(TestRunner.java:794)
	at org.testng.TestRunner.run(TestRunner.java:596)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:377)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:371)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:332)
	at org.testng.SuiteRunner.run(SuiteRunner.java:276)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:53)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:96)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1212)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1134)
	at org.testng.TestNG.runSuites(TestNG.java:1063)
	at org.testng.TestNG.run(TestNG.java:1031)
	at com.intellij.rt.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:66)
	at com.intellij.rt.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:109)
```