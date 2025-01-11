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

WebUI.openBrowser('')
WebUI.navigateToUrl('http://127.0.0.1:5500/')

// Call Test Case for login
WebUI.callTestCase(findTestCase('Login/LGU_001_VerifySuccessfulLogin'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(5)

// Add a product to the cart
WebUI.click(findTestObject('Object Repository/Cart_page/btn_add'))

// Verify the product quantity in the cart
WebUI.verifyElementText(findTestObject('Object Repository/Cart_page/txt_numberCart'), '1')

// Open the cart
WebUI.click(findTestObject('Object Repository/Cart_page/btn_cart'))

WebUI.delay(2)
// Increase the quantity of the product in the cart
WebUI.click(findTestObject('Object Repository/Cart_page/btn_plus'))

// Add a delay to ensure the cart updates
WebUI.delay(2)

// Verify the product quantity has increased
WebUI.verifyElementText(findTestObject('Object Repository/Cart_page/txt_numberCart'), '2')

// Decrease the quantity of the product in the cart
WebUI.click(findTestObject('Object Repository/Cart_page/btn_minus'))

// Add a delay to ensure the cart updates
WebUI.delay(2)

// Verify the product quantity has decreased
WebUI.verifyElementText(findTestObject('Object Repository/Cart_page/txt_numberCart'), '1')

// Proceed to checkout
WebUI.click(findTestObject('Object Repository/Cart_page/btn_checkout'))
WebUI.acceptAlert()

// Verify the confirmation message for order submission
WebUI.verifyTextPresent('Các sản phẩm đã được gửi vào đơn hàng', false)
WebUI.closeBrowser()





