import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import utileria.accion as accion


WebUI.callTestCase(findTestCase("signUp"), [:], FailureHandling.STOP_ON_FAILURE);

WebUI.navigateToUrl("https://www.phptravels.net/");

if(accion.present("//a[contains(text(),'flights')]")) {
	//home page displayed
	accion.agregarPuntoDeVerificacion("Home page is displayed", true, true);
	
	//click on flight
	accion.click("//a[contains(text(),'flights')]");
	
	
	//clicking on airline
	WebUI.sendKeys(accion.makeTestObjectFromXpath("//a[contains(text(),'flights')]"), Keys.chord(Keys.PAGE_DOWN));
	
		WebUI.delay(5);
		accion.click("//h6[contains(text(),'Emirates Airlines')]");
		
		//select price
		if(accion.present("//button[@type='submit']//strong[contains(text(), 'USD 199')]")) {
			WebUI.delay(4);
			accion.click("//button[@type='submit']//strong[contains(text(), 'USD 199')]");
			
			accion.agregarPuntoDeVerificacion("Flight price was selected", true, true);
						
//				
				//giving traveller info
				if(accion.present("//h3[contains(text(), 'Your Personal Information')]")) {
					WebUI.scrollToElement(accion.makeTestObjectFromXpath("//input[@name='firstname_1']"), 3);
					WebUI.delay(3);
					accion.setText("//input[@name='firstname_1']", "Jaime");
					accion.setText("//input[@name='lastname_1']", "Martinez");
					
					//nationality
					accion.click("//select[@name='nationality_1']");
					accion.click("//select[@name='nationality_1']/option[@value='BM']")
//					
					// date of birth
					accion.click("//select[@name='dob_month_1']");
					accion.click("//select[@name='dob_month_1']/option[@value='02']");
					
					accion.setText("//input[@name='dob_day_1']", "18");
					accion.setText("//input[@name='dob_year_1']", "1995");
					
					//id number
					accion.setText("//input[@name='passport_1']", "9155527484538");
					
					//expire date
					accion.click("//select[@name='passport_month_1']");
					accion.click("//select[@name='passport_month_1']/option[@value='02']");
					
					accion.setText("//input[@name='passport_day_1']", "18");
					accion.setText("//input[@name='passport_year_1']", "2022");
					
					accion.click("//h3[contains(text(),'Payment Method')]");
					
					//selecting payment method
					accion.click("//strong[contains(text(), 'paypal')]");
					
					WebUI.delay(3)
					
					WebUI.scrollToElement(accion.makeTestObjectFromXpath("//button[@id='booking']"), 3);
					
					
					
					//agree terms and conditions
					accion.click("//label[@for='agreechb']");
					
					
					WebUI.delay(5);
					
					//confirm booking
					accion.click("//button[@id='booking']");
					
					accion.agregarPuntoDeVerificacion("form was fill", true, true);
				}else {
					accion.agregarPuntoDeVerificacion("form wasn't fill", true, true);
									}

		}else {
			accion.agregarPuntoDeVerificacion("Flight price wasn't selected", true, true);
			
		}
	
}else {
	accion.agregarPuntoDeVerificacion("Home page wasn't displayed", true, true);
	
}