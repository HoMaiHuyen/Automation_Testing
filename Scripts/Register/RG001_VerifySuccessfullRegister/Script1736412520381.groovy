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

WebUI.openBrowser('http://127.0.0.1:5500/')
WebUI.maximizeWindow()
WebUI.click(findTestObject('Object Repository/Register_Page/btn_Account'))
WebUI.click(findTestObject('Object Repository/Register_Page/btn_Register'))
WebUI.setText(findTestObject('Object Repository/Register_Page/txt_Lastname'), 'Nguyen')
WebUI.setText(findTestObject('Object Repository/Register_Page/txt_Name'), 'Van A')
WebUI.setText(findTestObject('Object Repository/Register_Page/txt_Email'), 'nguyenvana@gmail.com')
WebUI.setText(findTestObject('Object Repository/Register_Page/txt_Firstname'), 'Nguyen Van A')
WebUI.setEncryptedText(findTestObject('Object Repository/Register_Page/txt_Password'), 'K4e+gJ45OmwIQIe+G9tXrQ==') 
WebUI.click(findTestObject('Object Repository/Register_Page/btn_Continue'))
WebUI.acceptAlert()
WebUI.verifyElementText(findTestObject('Object Repository/Register_Page/lbl_Account'), 'Nguyen Van A')
