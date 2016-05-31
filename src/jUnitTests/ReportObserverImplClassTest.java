package jUnitTests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import jUnitXmlReporter.jUnitElementClasses.testCases.ErrorTestCase;
import jUnitXmlReporter.jUnitElementClasses.testSuite.ReportTestSuite;
import jUnitXmlReporter.jUnitElementClasses.testSuite.ReportTestSuiteImpl;
import jUnitXmlReporter.observerClasses.ReportObserver;
import jUnitXmlReporter.observerClasses.ReportObserverImpl;

public class ReportObserverImplClassTest
{
	private ReportObserver reportObserver;

	@Before
	public void setUp() throws Exception
	{
		this.reportObserver = new ReportObserverImpl();
	}

	@Test
	public void testReportObserverImpl()
	{
		assertNotNull(reportObserver);
	}

	@Test
	public void testGetTestSuiteMap()
	{
		assertNotNull(reportObserver.getTestSuiteMap());
	}

	@Test
	public void testUpDate()
	{
		ReportTestSuite ts = new ReportTestSuiteImpl("reportTestSuite");
		ts.addTestCase(new ErrorTestCase("errorTestCaseName", "errorTestCaseMessage"));

		this.reportObserver.upDate(ts);
		
		HashMap<String, ReportTestSuite> testSuiteMap = reportObserver.getTestSuiteMap();
		ReportTestSuite expectedTs = testSuiteMap.get("reportTestSuite");

		assertEquals(ts, expectedTs);
	}
}
