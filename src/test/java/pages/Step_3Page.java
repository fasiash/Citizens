package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



import Ext_Excl.Ext_1;
import utils.Common_Methods;
import utils.Excel_Util;
import utils.Extent_Reports;

public class Step_3Page {
	public 	WebDriver driver;
	public WebDriverWait wait;
	public	Extent_Reports e = new Extent_Reports(driver);
	public	Excel_Util data = new Excel_Util();	
	Common_Methods C = new Common_Methods();
	Ext_1 Test = new Ext_1();

	public Step_3Page(WebDriver driver, Extent_Reports e) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.e = e;
	}

	@FindBy(xpath="//ion-item/ion-label[.='No']/following-sibling::ion-radio[@value='false']")
	WebElement noRadioBtn;

	@FindBy(xpath = "(//ion-row/ion-col/ion-button[starts-with(@class, 'md button')])[8]")
	WebElement NextStep3;

	@FindBy(xpath = "//ion-item/ion-label[.='Yes']/following-sibling::ion-radio[@role='radio']")
	WebElement step3_Yes;

	@FindBy(xpath = "//ion-item/ion-label[.='No']/following-sibling::ion-radio[@role='radio']")
	WebElement step3_No;
	
	@FindBy(xpath = "(//ion-item/ion-label[.='No']/following-sibling::ion-radio[@role='radio'])[2]")
	WebElement step3_2_No;

	@FindBy(xpath = "//form[@class='ng-untouched ng-pristine ng-invalid']//div[@class='block-info-app']")
	WebElement Error_ProposedOWner_Message;

	@FindBy(xpath = "//ion-input[@formcontrolname='BeneficiaryFirstName']/input")
	WebElement BenificiaryFirstname;

	public void Policy_Owner_Information() throws Exception {
		String Mandatory_Error = "Please enter a value.";
//		C.W_C1(driver, wait, NextStep3, e, Test.Case3(9), Test.Exp3(9));
		
		C.Fields(driver, step3_No, e, Test.Case3(3), Test.Exp3(3));
		C.Fields(driver, step3_No, e, Test.Case3(4), Test.Exp3(4));
		
		C.Mandate_Click(driver, NextStep3, e, Test.Case3(9), Test.Exp3(9));

		C.Empty_Input(driver, Error_ProposedOWner_Message, Mandatory_Error, e, Test.Case3(8), Test.Exp3(8));

		C.Fields(driver, step3_Yes, e, Test.Case3(10), Test.Exp3(10));
	
		C.C2(driver, step3_Yes, step3_No, e, Test.Case3(1), Test.Exp3(1));
		Thread.sleep(1000);
		C.Fields(driver, step3_No, e, Test.Case3(5), Test.Exp3(5));
		C.Fields(driver, step3_No, e, Test.Case3(6), Test.Exp3(6));
		C.Fields(driver, step3_No, e, Test.Case3(11), Test.Exp3(11));
		Thread.sleep(1000);
		C.Fields(driver, step3_No, e, Test.Case3(2), Test.Exp3(2));
//		try {
//			C.Mandate_Click(driver,step3_2_No, e, Test.Case3(1), Test.Exp3(1));
//		} catch (Exception e) {
//			System.out.println("No second question in the thrid step");
//		}
		
//		driver.findElement(By.xpath())
		C.Fields(driver, step3_No, e, Test.Case3(7), Test.Exp3(7));
//		C.Mandate_Click(driver, NextStep3, e, Test.Case3(5), Test.Exp3(5));
		NextStep3.click();
		Thread.sleep(2000);
	
	}
}
