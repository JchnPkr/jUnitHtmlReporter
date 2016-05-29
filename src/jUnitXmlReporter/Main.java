package jUnitXmlReporter;

import java.security.spec.InvalidParameterSpecException;

import jUnitXmlReporter.observerClasses.ReportObserver;
import jUnitXmlReporter.reportClasses.JUnitXmlReportCreator;
import usageDemoClasses.TestedClass;
import usageDemoClasses.TestingClass;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("---- Starting test run of JUnitXmlRepoter programm ----");

		ReportObserver reportObserver = new ReportObserver();
		TestingClass testingClass = new TestingClass();	
		testingClass.registerReportObserver(reportObserver);
		
		TestedClass testSubject1 = new TestedClass("firstSubjectToTest", new String[]{"Aibohphobia", "openSource"});
		TestedClass testSubject2 = new TestedClass("secondSubjectToTest", new String[]{"foof", "observe"});

		testingClass.testContainsCapital(testSubject1);
		testingClass.testIsNotPalindrome(testSubject1);
		testingClass.testContainsCapital(testSubject2);
		testingClass.testIsNotPalindrome(testSubject2);
		
		try
		{
			JUnitXmlReportCreator reporter = new JUnitXmlReportCreator("./testReportDir", "report.xml", "testApplication");
			reporter.createJUnitReport(reportObserver.getTestSuiteMap());
		}
		catch (InvalidParameterSpecException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("---- Finished test run of JUnitXmlRepoter programm ----");
	}
}
