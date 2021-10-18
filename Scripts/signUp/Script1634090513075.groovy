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

//open browser
WebUI.openBrowser("https://www.phptravels.net/");
WebUI.maximizeWindow();
// if home page is displayed
if (accion.present("//a[contains(text(),'Home')]")) {
	accion.agregarPuntoDeVerificacion("Home page is displayed", true, true);
	// click on sign up 
	if(accion.present("//a[@class='theme-btn theme-btn-small waves-effect']")) {
		accion.click("//a[@class='theme-btn theme-btn-small waves-effect']");
		// fill sign up form
		if(accion.present("//input[@name='first_name']")) {
			accion.click("//button[@id='cookie_stop']");
			accion.setText("//input[@name='first_name']", "Jerfish");
			accion.setText("//input[@name='last_name']", "Morillo");
			accion.setText("//input[@name='phone']", "8098796011");
			accion.setText("//input[@name='email']", "manuela83@gmail.com");
			accion.setText("//input[@name='password']", "Manolo02");
			WebUI.sendKeys(accion.makeTestObjectFromXpath("//input[@name='first_name']"), Keys.chord(Keys.PAGE_DOWN));
			
			WebUI.delay(5);
			accion.click("//span[contains(text(), 'Signup')]");
			
			accion.agregarPuntoDeVerificacion("Sign up succesfully", true, true);
			
			//login
			if(accion.present("//input[@placeholder='Email']")) {
				accion.setText("//input[@placeholder='Email']", "manuela83@gmail.com");
				accion.setText("//input[@placeholder='Password']", "Manolo02");
				WebUI.delay(5);
				accion.click("//span[contains(text(),'Login')]");
				
				accion.agregarPuntoDeVerificacion("login succesfully", true, true);
				
			}else {
				accion.agregarPuntoDeVerificacion("login failed", true, true);
				
			}
		}else {
			accion.agregarPuntoDeVerificacion("Sign up failed", true, true);
			
		}
	}
}else {
	accion.agregarPuntoDeVerificacion("Home page is not displayed", true, true);
	
}