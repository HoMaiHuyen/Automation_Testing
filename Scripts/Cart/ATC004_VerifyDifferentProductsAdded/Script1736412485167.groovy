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

// Call the Test Case for login with valid information
WebUI.callTestCase(findTestCase('Login/LGU_001_VerifySuccessfulLogin'), [:], FailureHandling.STOP_ON_FAILURE)

// Select the products "Vivo Y71" and "Xiaomi Redmi 5 Plus 4GB" and add them to the cart
WebUI.click(findTestObject('Object Repository/Cart_page/btn_add'))
WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Object Repository/Cart_page/btn_add1'))
WebUI.waitForPageLoad(5)

// Verify that both products have been added to the cart
WebUI.click(findTestObject('Object Repository/Cart_page/btn_cart'))

// Verify the presence of both products in the cart
WebUI.verifyTextPresent('Nokia black future', false)
WebUI.verifyTextPresent('Huawei Nova 2i', false)

// Close the browser
WebUI.closeBrowser()
