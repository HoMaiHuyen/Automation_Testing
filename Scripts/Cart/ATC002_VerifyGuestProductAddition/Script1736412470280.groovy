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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Open browser and navigate to the website
WebUI.openBrowser('http://127.0.0.1:5500/')
WebUI.maximizeWindow()


// Select the product "Vivo Y71" and try to add it to the cart
WebUI.click(findTestObject('Object Repository/Cart_page/btn_add'))
WebUI.delay(5)

// Verify that the alert message "Bạn cần đăng nhập để mua hàng !" is displayed
String alertText = WebUI.getAlertText()
WebUI.verifyMatch(alertText, 'Bạn cần đăng nhập để mua hàng !', false)

// Accept the alert (click "OK")
WebUI.acceptAlert()
WebUI.delay(5)

// Verify the login page title is "Chào mừng bạn trở lại!"
WebUI.verifyElementText(findTestObject('Object Repository/Cart_page/lbl_login'), 'Chào mừng bạn trở lại!')


