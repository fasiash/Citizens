package utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.asserts.SoftAssert;


public class Common_Methods {

	SoftAssert soft = new SoftAssert();
	public String yellow = "arguments[0].setAttribute('style','background: aqua; border: 2px solid red');";
	public String orginal = "arguments[0].style.backgroundColor = '';arguments[0].style.border = '';";

	public void Mandate_Click(WebDriver driver, WebElement Element,Extent_Reports e,String info, String pass ) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			js.executeScript(orginal, Element);
			Element.click();
			e.test.pass(pass);
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		 catch (NoSuchWindowException wde ) {
//		        // Handling WebDriverException for browser closure or interruption
//		        String exceptionMessage = wde.getMessage().toLowerCase();
//		        System.out.println("Exceptionmsg"+exceptionMessage);
//		        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
//		            // If browser is closed intentionally or interrupted, skip the test
		            e.test.skip("Test case skipped: Browser closure or interruption");
//		            
		        } 
//		else {
//		            // If it's another WebDriverException, fail the test
//		            e.test.fail("Fail: " + wde);
//		            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
//		            TestExecutionManager.stopExecution();
//		        }
//		 }
		catch (Exception e2) {
			e.test.fail("Fail"+e2);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}
	public void Mandate_Click1(WebDriver driver, Actions act, WebElement Element,Extent_Reports e,
			String info,String pass ) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(1000);
			act.moveToElement(Element).build().perform();
			js.executeScript(yellow, Element);
			Thread.sleep(1000);
			js.executeScript(orginal, Element);
			Element.click();
			e.test.pass(pass);
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
//	        String exceptionMessage = wde.getMessage().toLowerCase();
//	        System.out.println("Exceptionmsg"+exceptionMessage);
//	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
//	            // If browser is closed intentionally or interrupted, skip the test
	        	  e.test.skip("Test case skipped: Browser closure or interruption."+wde);
//	        } else {
//	            // If it's another WebDriverException, fail the test
//	            e.test.fail("Fail: " + wde);
//	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
//	            TestExecutionManager.stopExecution();
//	        }
	 }
		catch (Exception e2) {
			e.test.fail("Fail"+e2);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}
	public void Mandate_Click2(WebDriver driver, Actions act, WebElement Element,WebElement element,Extent_Reports e,
			String info,String pass ) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Thread.sleep(2000);
			act.moveToElement(Element).build().perform();
			Thread.sleep(2000);
			js.executeScript(orginal, Element);
			Element.click();
			Thread.sleep(2000);
			js.executeScript(yellow, element);
			act.scrollToElement(element).build().perform();
			js.executeScript(orginal, element);
			e.test.pass(pass);
		
	}
	catch (SkipException se) {
        // If the test case is intentionally skipped
        e.test.skip("Test case skipped: " + se.getMessage());
	}
		catch (NoSuchWindowException wde) {
//	        // Handling WebDriverException for browser closure or interruption
//	        String exceptionMessage = wde.getMessage().toLowerCase();
//	        System.out.println("Exceptionmsg"+exceptionMessage);
//	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
//	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } 
//		else {
//	            // If it's another WebDriverException, fail the test
//	            e.test.fail("Fail: " + wde);
//	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
//	            TestExecutionManager.stopExecution();
//	        }
//	 }
		catch (Exception e2) {
			e.test.fail("Fail"+e2);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();
		}
		
	}

	public void Selection(WebDriver driver, Actions act, WebElement Element,String data,Extent_Reports e,
			String info, String pass)throws Exception {

		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Thread.sleep(1000);
			Select selectgender =new Select(Element);
			selectgender.selectByVisibleText(data);
			js.executeScript(orginal, Element);
			e.test.pass(pass);
		} 
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println("Exceptionmsg"+exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();
		}
	}
	public void Send_verify_Valid(WebDriver driver,WebElement Element, Extent_Reports e ,
			String name,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {if (TestExecutionManager.isExecutionStopped()) {
            throw new SkipException("Further execution is stopped. Skipping this test case.");
        }
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.sendKeys(name);
			Thread.sleep(1000);
			js.executeScript(orginal, Element);
			String value = Element.getAttribute("value");
			if(value.contains(name)) {
				e.test.pass(value+"----"+pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		} 
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();
		}
	}

	public void Send_verify_Valid_C(WebDriver driver,WebElement Element, Extent_Reports e ,
			String name,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.clear();
			Element.sendKeys(name);
			Thread.sleep(1000);
			js.executeScript(orginal, Element);
			String value = Element.getAttribute("value");
			if(value.contains(name)) {
				e.test.pass(value+"----"+pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
			
		} catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();
		}
	}

	

	public void Cl_Ck_Send(WebDriver driver,WebElement Element,WebElement element, Extent_Reports e ,
			String name,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.click();
			js.executeScript(orginal, Element);
			js.executeScript(yellow, element);
			element.clear();
			element.sendKeys(name);
			js.executeScript(orginal, element);
			Thread.sleep(1000);
			String value = element.getAttribute("value");
			if(value.contains(name)) 
			{
				e.test.pass(value+"----"+pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
			
		} 
		 catch (SkipException se) {
		        // If the test case is intentionally skipped
		        e.test.skip("Test case skipped: " + se.getMessage());
			}
		catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();
		}
	}

	public void Ck_Cl_Send(WebDriver driver,WebElement Element,WebElement element, Extent_Reports e ,
			String name,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.click();
			js.executeScript(orginal, Element);
			js.executeScript(yellow, element);
			element.clear();
			element.sendKeys(name);
			Thread.sleep(1000);
			js.executeScript(orginal, element);
			String value = Element.getAttribute("value");
			if(value.contains(name)) {
				e.test.pass(value+"----"+pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		} 
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}


	public void Attribute_Value(WebDriver driver,WebElement Element,Extent_Reports e,
			String name,String info,String pass)throws Exception{
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Thread.sleep(1000);
			String value = Element.getAttribute("value");
			js.executeScript(orginal, Element);
			if(value.contains(name)) {
				e.test.pass(value+"----"+pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} 
		catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Attribute_Valu(WebDriver driver,WebElement Element,WebElement Value_Element, Extent_Reports e ,
			String name,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.click();
			js.executeScript(orginal, Element);
			js.executeScript(yellow, Value_Element);
			Value_Element.click();
			js.executeScript(orginal, Value_Element);
			Thread.sleep(3000);
			String value = Element.getText();
			if(value.contains(name)) {
				System.out.println(value+"----"+pass);
				e.test.pass(value);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Click_2_V(WebDriver driver,WebElement Element,WebElement element,WebElement Err_element, 
			Extent_Reports e ,String name,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.click();
			js.executeScript(orginal, Element);
			js.executeScript(yellow, element);
			element.click();
			js.executeScript(orginal, element);
			Thread.sleep(3000);
			js.executeScript(yellow, Err_element);
			String value = Err_element.getText();
			js.executeScript(orginal, Err_element);
			if(value.contains(name)) {
				System.out.println(value+"----"+pass);
				e.test.pass(value);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        }
	        else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		
		catch (Exception ex) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Clk_Is_Enabled(WebDriver driver, WebElement Element, Extent_Reports e ,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.click();
			js.executeScript(orginal, Element);
			if(Element.isEnabled()){
				e.test.pass(pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		} catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Is_Displayed(WebDriver driver, WebElement Element, Extent_Reports e ,String info, 
			String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			if(Element.isDisplayed()){
				js.executeScript(orginal, Element);
				e.test.pass(pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} 
		catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Click_Displayed(WebDriver driver,WebElement element, WebElement Element, Extent_Reports e ,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, element);
			element.click();
			Thread.sleep(2000);
			js.executeScript(orginal, Element);
			js.executeScript(yellow, Element);
			if(Element.isDisplayed()){
				js.executeScript(orginal, Element);
				e.test.pass(pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		} catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} 
		catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void G_Displayed(WebDriver driver,WebElement element, Extent_Reports e ,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, element);
			Thread.sleep(1000);
			String value = element.getText();
			js.executeScript(orginal, element);
			if(value.contains(value)){
				e.test.pass(pass+"------"+value);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		} catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Click_NotDisplayed(WebDriver driver,WebElement Element, WebElement element, Extent_Reports e ,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.click();
			Thread.sleep(2000);
			js.executeScript(orginal, Element);
			js.executeScript(yellow, element);
			if(!element.isDisplayed()){
				js.executeScript(orginal, Element);
				e.test.pass(pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		} 
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}


	public void DOB_(WebDriver driver, WebElement Element,String data,Extent_Reports e,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.sendKeys(data);
			Thread.sleep(1000);
			js.executeScript(orginal, Element);
			e.test.pass(pass);
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ec) {
			e.test.fail("Fail"+ec);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}

	}

	public void Get_Verify(WebDriver driver,WebElement Element,String data, Extent_Reports e , 
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {if (TestExecutionManager.isExecutionStopped()) {
            throw new SkipException("Further execution is stopped. Skipping this test case.");
        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			if(Element.getText().contains(data)){
				js.executeScript(orginal, Element);
				e.test.pass(pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ec) {
			e.test.fail("Fail"+ec);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Max_Char(WebDriver driver,WebElement Element,WebElement Error_Element,String name, String data,
			Extent_Reports e,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {if (TestExecutionManager.isExecutionStopped()) {
            throw new SkipException("Further execution is stopped. Skipping this test case.");
        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Thread.sleep(1000);
			Element.clear();
			Element.sendKeys(name);
			Thread.sleep(1500);
			js.executeScript(orginal, Element);
			js.executeScript(yellow, Error_Element);
			soft.assertTrue(Error_Element.isDisplayed());
			String value = Error_Element.getText();
			js.executeScript(orginal, Error_Element);
			System.out.println(value);
			if(value.contains(data)) {
				Thread.sleep(1000);
				e.test.pass(value+"----"+pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ec) {
			e.test.fail("Fail"+ec);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Max_Char_C(WebDriver driver,WebElement Element,WebElement Error_Element,WebElement element,String name, 
			String data,Extent_Reports e,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {if (TestExecutionManager.isExecutionStopped()) {
            throw new SkipException("Further execution is stopped. Skipping this test case.");
        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Thread.sleep(1000);
			Element.clear();
			Element.sendKeys(name);
			js.executeScript(orginal, element);
			element.click();
			Thread.sleep(2000);
			js.executeScript(yellow, Error_Element);
			soft.assertTrue(Error_Element.isDisplayed());
			String value = Error_Element.getText();
			js.executeScript(orginal, Error_Element);
			System.out.println(value);
			if(value.contains(data)) {
				Thread.sleep(1000);
				e.test.pass(value+"----"+pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}	catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ec) {
			e.test.fail("Fail"+ec);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Max_Char_Act(WebDriver driver,Actions act, WebElement Element,WebElement Error_Element,String name, 
			String data,Extent_Reports e,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.clear();
			Element.sendKeys(name);
			Thread.sleep(1000);
			js.executeScript(orginal, Element);
			js.executeScript(yellow, Error_Element);
			act.moveToElement(Error_Element).build().perform();
			soft.assertTrue(Error_Element.isDisplayed());
			String value = Error_Element.getText();
			js.executeScript(orginal, Error_Element);
			System.out.println(value);
			if(value.contains(data)) {
				Thread.sleep(3000);
				e.test.pass(value+"----"+pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} 
		catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ec) {
			e.test.fail("Fail"+ec);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}
	public void Max_Char_sc2(WebDriver driver,Actions act, WebElement Element,WebElement element,WebElement Error_Element,
			String name,String data,Extent_Reports e,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.clear();
			Element.sendKeys(name);
			Thread.sleep(1000);
			js.executeScript(orginal, Element);
			js.executeScript(yellow, element);
			act.moveToElement(element).build().perform();
			js.executeScript(orginal, element);
			js.executeScript(yellow, Error_Element);
			act.moveToElement(Error_Element).build().perform();
			soft.assertTrue(Error_Element.isDisplayed());
			String value = Error_Element.getText();
			js.executeScript(orginal, Error_Element);
			System.out.println(value);
			if(value.contains(data)) {
				Thread.sleep(1000);
				e.test.pass(value+"----"+pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ec) {
			e.test.fail("Fail"+ec);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Max_Char_Scroll(WebDriver driver,Actions act, WebElement Element,WebElement Scroll,WebElement Error_Element,
			String name,String data,Extent_Reports e,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.clear();
			Thread.sleep(1500);
			Element.sendKeys(name);
			Thread.sleep(1500);
			js.executeScript(orginal, Element);
			js.executeScript(yellow, Scroll);
			act.moveToElement(Scroll).build().perform();
			js.executeScript(orginal, Scroll);
			Scroll.click();
			js.executeScript(yellow, Error_Element);
			soft.assertTrue(Error_Element.isDisplayed());
			String value = Error_Element.getText();
			js.executeScript(orginal, Error_Element);
			System.out.println(value);
			if(value.contains(data)) {
				Thread.sleep(1000);
				e.test.pass(value+"----"+pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ec) {
			e.test.fail("Fail"+ec);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}
	
	public void MX_SC(WebDriver driver,Actions act, WebElement Element,WebElement Scrolll,WebElement Scroll2,WebElement Error_Element,
			String name,String data,Extent_Reports e,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			Element.clear();
			Element.sendKeys(name);
			Thread.sleep(1500);
			scrollTo(driver, Scrolll);
			Scrolll.click();
			Thread.sleep(1500);
			scrollTo(driver, Scroll2);
			Thread.sleep(1500);
			soft.assertTrue(Error_Element.isDisplayed());
			String value = Error_Element.getText();
			System.out.println(value);
			if(value.contains(data)) {
				Thread.sleep(1000);
				e.test.pass(value+"----"+pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ec) {
			e.test.fail("Fail"+ec);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}
	
	public void MX_SC2(WebDriver driver,Actions act, WebElement Element,WebElement Scroll2,WebElement Error_Element,
			String name,String data,Extent_Reports e,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			scrollTo(driver, Element);
			Thread.sleep(1000);
			Element.clear();
			Element.sendKeys(name);
			Thread.sleep(1500);
			scrollTo(driver, Scroll2);
			Thread.sleep(1500);
			Scroll2.click();
			scrollTo(driver, Element);
			Thread.sleep(2000);
			soft.assertTrue(Error_Element.isDisplayed());
			String value = Error_Element.getText();
			System.out.println(value);
			if(value.contains(data)) {
				Thread.sleep(1000);
				e.test.pass(value+"----"+pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ec) {
			e.test.fail("Fail"+ec);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}


	public void SC_C_Send(WebDriver driver,Actions act, WebElement Element,WebElement element,WebElement Error_Element,
			String name,String data,Extent_Reports e,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try{
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			act.scrollToElement(Element).build().perform();
			js.executeScript(orginal, Element);
			Element.click();
			js.executeScript(yellow, element);
			element.clear();
			element.sendKeys(name);
			Thread.sleep(1000);
			js.executeScript(orginal, element);
			Element.click();
			js.executeScript(yellow, Error_Element);
			soft.assertTrue(Error_Element.isDisplayed());
			String value = Error_Element.getText();
			js.executeScript(orginal, Error_Element);
			if(value.contains(data)) {
				Thread.sleep(1000);
				e.test.pass(value+"----"+pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Unable to select plan"+"------------"+ex);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}
	
	public void S_Send_S(WebDriver driver,Actions act, WebElement Element,WebElement Scroll,
			String name,Extent_Reports e,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try{
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			
			scrollTo(driver, Element);
			Element.clear();
			Element.sendKeys(name);
			Thread.sleep(1000);
			scrollTo(driver, Scroll);
			Scroll.click();
			e.test.pass(pass);
	}catch (SkipException se) {
        // If the test case is intentionally skipped
        e.test.skip("Test case skipped: " + se.getMessage());
	} catch (NoSuchWindowException wde) {
        // Handling WebDriverException for browser closure or interruption
        String exceptionMessage = wde.getMessage().toLowerCase();
        System.out.println(exceptionMessage);
        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
            // If browser is closed intentionally or interrupted, skip the test
            e.test.skip("Test case skipped: Browser closure or interruption.");
        } else {
            // If it's another WebDriverException, fail the test
            e.test.fail("Fail: " + wde);
            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
            TestExecutionManager.stopExecution();
        }
 }
		catch (Exception ex) {
		e.test.fail("Unable to select plan"+"------------"+ex);
		e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
		TestExecutionManager.stopExecution();

	}
}

	public void Error_Verify(WebDriver driver,WebElement Error_Element, String name, Extent_Reports e ,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			if(Error_Element.getText().contains(name)) {
				e.test.pass(pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		} catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}
	
	public void C_Send_C(WebDriver driver, WebElement Element,WebElement element,WebElement Error_Element,String name,
			String data,Extent_Reports e,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try{
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.click();
			js.executeScript(orginal, Element);
			js.executeScript(yellow, element);
			element.clear();
			element.sendKeys(name);
			Thread.sleep(1000);
			js.executeScript(orginal, element);
			Element.click();
			js.executeScript(yellow, Error_Element);
			soft.assertTrue(Error_Element.isDisplayed());
			String value = Error_Element.getText();
			js.executeScript(orginal, Error_Element);
			if(value.contains(data)) {
				Thread.sleep(1000);
				e.test.pass(value+"----"+pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Unable to select plan"+"------------"+ex);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Empty_Input(WebDriver driver,WebElement Element, String data, Extent_Reports e,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			soft.assertTrue(Element.isDisplayed());
			String value = Element.getText();
			js.executeScript(orginal, Element);
			System.out.println(value);
			if(value.contains(data)) {
				e.test.pass(value+"----"+pass);

			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Unable to select plan"+"------------"+ex);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}
	
	public void Empty_Input2(WebDriver driver,WebElement Element,WebElement Error_Element, String data, Extent_Reports e,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Element.clear();
			Thread.sleep(1500);
			js.executeScript(yellow, Error_Element);
			soft.assertTrue(Error_Element.isDisplayed());
			String value = Error_Element.getText();
			js.executeScript(orginal, Error_Element);
			System.out.println(value);
			if(value.contains(data)) {
				e.test.pass(value+"----"+pass);

			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Unable to select plan"+"------------"+ex);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Sc_Empty_Input(WebDriver driver, Actions act,WebElement Element, String data, Extent_Reports e,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			act.scrollToElement(Element).build().perform();
			soft.assertTrue(Element.isDisplayed());
			String value = Element.getText();
			js.executeScript(orginal, Element);
			System.out.println(value);
			if(value.contains(data)) {
				e.test.pass(value+"----"+pass);

			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Unable to select plan"+"------------"+ex);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Dropdown_Verify(WebDriver driver,WebElement Element,WebElement Value_element, WebElement Error_Element, 
			String data, Extent_Reports e,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.click();
			Thread.sleep(1000);
			js.executeScript(orginal, Element);
			js.executeScript(yellow, Value_element);
			Value_element.click();
			Thread.sleep(2000);
			js.executeScript(orginal, Value_element);
			Element.click();
			Thread.sleep(1000);
			js.executeScript(yellow, Error_Element);
			soft.assertTrue(Error_Element.isDisplayed());
			String value = Error_Element.getText();
			js.executeScript(orginal, Error_Element);
			System.out.println(value);
			if(value.contains(data)) {
				e.test.pass(value+"----"+pass);

			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Unable to select plan"+"------------"+ex);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void page_Navigation(WebDriver driver,Actions act,WebElement element, WebElement D_Element, 
			Extent_Reports e,String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, element);
			act.moveToElement(element).build().perform();
			element.click();
			js.executeScript(orginal, element);
			Thread.sleep(2000);
			js.executeScript(yellow, D_Element);
			if(D_Element.isDisplayed()) {
				js.executeScript(orginal, D_Element);
				e.test.pass(pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ex) {
			e.test.fail("Unable to select plan"+"------------"+ex);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void W_C2(WebDriver driver,WebDriverWait wait, WebElement Element, WebElement element,Extent_Reports e,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			wait.until(ExpectedConditions.visibilityOf(Element)).click();
			js.executeScript(orginal, Element);
			js.executeScript(yellow, element);
			wait.until(ExpectedConditions.visibilityOf(element)).click();
			js.executeScript(orginal, element);
			e.test.pass(pass);
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		} catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ec) {
			e.test.fail("Fail"+ec);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void W_C1(WebDriver driver,WebDriverWait wait, WebElement Element,Extent_Reports e,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Thread.sleep(1000);
			js.executeScript(orginal, Element);
			wait.until(ExpectedConditions.visibilityOf(Element)).click();
			e.test.pass(pass);
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}catch (NoSuchWindowException wde) {
//	        // Handling WebDriverException for browser closure or interruption
//	        String exceptionMessage = wde.getMessage().toLowerCase();
//	        System.out.println(exceptionMessage);
//	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
//	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption."+wde);
	        } 
//		else {
//	            // If it's another WebDriverException, fail the test
//	            e.test.fail("Fail: " + wde);
//	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
//	            TestExecutionManager.stopExecution();
//	        }
//	 }
		catch (Exception ec) {
			e.test.fail("Fail"+ec);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			 TestExecutionManager.stopExecution();
		}
	}

	public void W_S(WebDriver driver,WebDriverWait wait, WebElement Element,String data,Extent_Reports e,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			wait.until(ExpectedConditions.visibilityOf(Element)).sendKeys(data);
			js.executeScript(orginal, Element);
			e.test.pass(pass);
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ec) {
			e.test.fail("Fail"+ec);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();
		}
	}
	
	

	public void C2(WebDriver driver, WebElement Element, WebElement element,Extent_Reports e,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.click();
			Thread.sleep(1000);
			element.click();
			Thread.sleep(1000);
			js.executeScript(orginal, Element);
			e.test.pass(pass);
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}catch (NoSuchWindowException wde) {
	        // Handling WebDriverException for browser closure or interruption
	        String exceptionMessage = wde.getMessage().toLowerCase();
	        System.out.println(exceptionMessage);
	        if (exceptionMessage.contains("target window already closed") || exceptionMessage.contains("no such window")) {
	            // If browser is closed intentionally or interrupted, skip the test
	            e.test.skip("Test case skipped: Browser closure or interruption.");
	        } else {
	            // If it's another WebDriverException, fail the test
	            e.test.fail("Fail: " + wde);
	            e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
	            TestExecutionManager.stopExecution();
	        }
	 }
		catch (Exception ec) {
			e.test.fail("Fail"+ec);
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void step_5_(WebDriver driver,WebElement Element, WebElement element, WebElement Visible_element,
			Extent_Reports e,String info,String pass) throws Exception {

		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			Element.click();
			js.executeScript(orginal, Element);
			js.executeScript(yellow, element);
			element.click();
			Thread.sleep(2000);
			js.executeScript(orginal, element);
			js.executeScript(yellow, Visible_element);
			if(Visible_element.isDisplayed()) {
				js.executeScript(orginal, Visible_element);
				e.test.pass(pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (Exception e2) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	//Step 6
	public void Health_Question_M(WebDriver driver,Actions act,WebElement Element,String data, Extent_Reports e,
			String info, String pass) throws Exception {

		e.test = e.verifying(info);
		try {if (TestExecutionManager.isExecutionStopped()) {
            throw new SkipException("Further execution is stopped. Skipping this test case.");
        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			act.scrollToElement(Element).build().perform();
			Thread.sleep(2000);
			soft.assertTrue(Element.isDisplayed());
			String value = Element.getText();
			js.executeScript(orginal, Element);
			if(value.contains(data)) {
				System.out.println(value);
				e.test.pass(value+"----"+pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (Exception e2) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}
	//Step 6
	public void Health_Question_C(WebDriver driver,Actions act,WebElement Element,String c, Extent_Reports e,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			act.scrollToElement(Element).build().perform();
			Element.click();
			Thread.sleep(1500);
			js.executeScript(orginal, Element);
			e.test.pass(pass+c);
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (Exception e2) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}

	}

	//for step -8
	public void Signature(WebDriver driver,Actions act,WebElement Element1,WebElement Element2,WebElement Element3,
			WebElement Element4,int a,int b, int c, int d, int e, int f, int g,int h,int i, int j, int k, int l, 
			int m, int n,int o,int p, int q, int r, Extent_Reports er,String info, String pass) throws Exception {
		er.test = er.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element1);
			Element1.click();
			Thread.sleep(1000);
			js.executeScript(orginal, Element1);
			act.clickAndHold(Element2).moveByOffset(a, b).moveByOffset(c, d).moveByOffset(e, f).moveByOffset(g, h)
			.moveByOffset(i, j).moveByOffset(k, l).moveByOffset(m,n).moveByOffset(o, p).moveByOffset(q, r)
			.release().build().perform();
			js.executeScript(yellow,Element3);
			Element3.click();
			Thread.sleep(2000);
			js.executeScript(yellow, Element4);
			if(Element4.isDisplayed()) {
				er.test.pass(pass);
			}else {
				er.test.fail("Fail");
				er.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}	
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        er.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (Exception e2) {
			er.test.fail("Fail"+e2);
			er.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	//step 8
	public void act_scroll1(WebDriver driver,Actions act,WebElement Element,Extent_Reports e,String info,
			String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element);
			act.scrollToElement(Element).build().perform();
			js.executeScript(orginal, Element);
			if(Element.isDisplayed()) {
				e.test.pass(pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (Exception ec) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void act_scroll2(WebDriver driver,Actions act,WebElement Element1,WebElement Element2,Extent_Reports e,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {if (TestExecutionManager.isExecutionStopped()) {
            throw new SkipException("Further execution is stopped. Skipping this test case.");
        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element1);
			act.scrollToElement(Element1).build().perform();
			Thread.sleep(2000);
			js.executeScript(orginal, Element1);
			js.executeScript(yellow, Element2);
			act.scrollToElement(Element2).build().perform();
			if(Element2.isDisplayed()) {
				js.executeScript(orginal, Element2);
				e.test.pass(pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (Exception ec) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Scroll_C_scroll2(WebDriver driver,Actions act,WebElement Element1,WebElement Element2,Extent_Reports e,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element1);
			act.scrollToElement(Element1).build().perform();
			Element1.click();
			js.executeScript(orginal, Element1);
			js.executeScript(yellow, Element2);
			act.scrollToElement(Element2).build().perform();
			js.executeScript(orginal, Element2);
			if(Element2.isDisplayed()) {
				e.test.pass(pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (Exception ec) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	//step 8
	public void Click_Scroll(WebDriver driver,Actions act,WebElement Element1,WebElement Element2,Extent_Reports e,
			String info, String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element1);
			Element1.click();
			js.executeScript(orginal, Element1);
			js.executeScript(yellow, Element2);
			act.scrollToElement(Element2).build().perform();
			if(Element2.isDisplayed()) {
				js.executeScript(orginal, Element2);
				e.test.pass(pass);
			}else {
				e.test.fail("Fail");
				e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			}
		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (Exception ec) {
			e.test.fail("Fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Scroll_Click(WebDriver driver,WebDriverWait wait,Actions act,WebElement Element1,Extent_Reports e,
			String info,String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(yellow, Element1);
			act.scrollToElement(Element1).build().perform();
			wait.until(ExpectedConditions.visibilityOf(Element1)).click();
			Thread.sleep(2000);
			e.test.pass(pass);
		}
		catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (Exception ec) {
			e.test.fail("Unable to Scroll to element");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Fields(WebDriver driver,WebElement Element1,Extent_Reports e,String info,String pass) throws Exception {
		e.test = e.verifying(info);
		try {
			if (TestExecutionManager.isExecutionStopped()) {
	            throw new SkipException("Further execution is stopped. Skipping this test case.");
	        }
			e.test.pass(pass);

		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (Exception ec) {
			e.test.fail("fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void Frames(WebDriver driver,Extent_Reports e,String info,String pass) throws Exception {
		e.test = e.verifying(info);
		try {if (TestExecutionManager.isExecutionStopped()) {
            throw new SkipException("Further execution is stopped. Skipping this test case.");
        }
			Thread.sleep(3000);
			driver.switchTo().frame(0);
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			Thread.sleep(1000);
			e.test.pass(pass);

		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (Exception ec) {
			e.test.fail("fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}

	public void scrollTo(WebDriver driver, WebElement element,Extent_Reports e,String info,String pass) throws Exception {
		e.test = e.verifying(info);
		try {if (TestExecutionManager.isExecutionStopped()) {
            throw new SkipException("Further execution is stopped. Skipping this test case.");
        }
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);

			e.test.pass(pass);

		}catch (SkipException se) {
	        // If the test case is intentionally skipped
	        e.test.skip("Test case skipped: " + se.getMessage());
		}
		catch (Exception ec) {
			e.test.fail("fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
			TestExecutionManager.stopExecution();

		}
	}
	public void scrollTo(WebDriver driver, WebElement element) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void switchToNewWindow(WebDriver driver, WebDriverWait wait, String url, Extent_Reports e, String info, String pass ) throws Exception {
		e.test = e.verifying(info);
		try {
			Thread.sleep(2000);
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(url);
			e.test.pass(pass);
		}catch(Exception ec){
			e.test.fail("fail");
			e.test.addScreenCaptureFromPath(Extent_Reports.capturescreenshot(driver));
		}
	}

	

}
//	public void clickByJavaScript(WebDriver driver, WebDriverWait wait, WebElement element, Extent_Reports e, String info, String pass) {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		 WebElement ele = (WebElement) js.executeScript(element);
//		open_file.click();
//	}
