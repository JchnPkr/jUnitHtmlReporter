package jUnitXmlReporter.jUnitElementClasses.testCases;

import org.jdom2.Element;

/**
 * Default testcase implementation
 */
public class FailureTestCase extends DefaultTestCase
{
	public FailureTestCase(String name, String message)
	{
		super(name, message);
	}

	@Override
	public Element getJUnitTestCaseXmlElement()
	{
		Element testCase = new Element("testcase").setAttribute("name", this.name);
		Element fail = new Element("failure").addContent(message);
		testCase.addContent(fail);
			
		return testCase;
	}
}
