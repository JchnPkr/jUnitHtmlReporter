package jUnitXmlReporter.jUnitElementClasses.testCases;

import org.jdom2.Element;

/**
 * Default testcase implementation
 */
public class SkippedTestCase extends DefaultTestCase
{
	public SkippedTestCase(String name, String message)
	{
		super(name, message);
	}

	public SkippedTestCase(String message)
	{
		super("defaultName", message);
	}
	
	@Override
	public Element getJUnitTestCaseXmlElement()
	{
		Element testCase = new Element("testcase").setAttribute("name", this.name);
		Element skipped = new Element("skipped").addContent(message);
		testCase.addContent(skipped);
		
		return testCase;
	}
}
