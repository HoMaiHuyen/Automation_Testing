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
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Call the Test Case for login
WebUI.callTestCase(findTestCase('Login/LGU_001_VerifySuccessfulLogin'), [:], FailureHandling.STOP_ON_FAILURE)

// Retrieve the current product name
String productName = WebUI.getText(findTestObject('Object Repository/Cart_page/txt_productName'))

// Add the product to the cart 3 times
for (int i = 1; i <= 3; i++) {
    WebUI.click(findTestObject('Object Repository/Cart_page/btn_add'))
    WebUI.waitForPageLoad(5)
}
// Verify the product quantity in the cart
String cartQuantity = WebUI.getText(findTestObject('Object Repository/Cart_page/txt_numberCart'))
WebUI.verifyEqual(cartQuantity, '3') 

// Open the cart to verify the product name
WebUI.click(findTestObject('Object Repository/Cart_page/btn_cart'))

// Verify the product name in the cart
String cartProductName = WebUI.getText(findTestObject('Object Repository/Cart_page/txt_ProductNameInCart'))
WebUI.verifyEqual(cartProductName, productName)

// Close the browser
WebUI.closeBrowser()
