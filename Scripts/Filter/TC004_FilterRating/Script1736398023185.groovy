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

// Step 1: Open the browser and navigate to the HomePage
WebUI.openBrowser('http://127.0.0.1:5500/')
WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Filter_Product/Btn_Rating'))

WebUI.click(findTestObject('Object Repository/Filter_Product/Btn_Above2Stars'))

TestObject lastProductElement = findTestObject('Object Repository/Filter_Product/div_ListProduct')
WebUI.scrollToElement(lastProductElement, 10)

// Step 4: Wait for the products to be displayed
WebUI.waitForElementVisible(findTestObject('Object Repository/Filter_Product/Btn_Above2StarsClear'), 10)

// Step 5: Check if there are any products above 2 stars
def productList = WebUI.findWebElements(findTestObject('Object Repository/Filter_Product/Btn_Above2StarsClear'), 10)

if (productList.size() > 0) {
	WebUI.comment('There are products displayed above 2 stars.')
} else {
	WebUI.comment('No products are displayed above 2 stars.')
}

// Step 6: Check the visibility of the "Clear Filter" and "Above 2 Stars" buttons
boolean clearFilterVisible = WebUI.verifyElementVisible(findTestObject('Object Repository/Filter_Product/btn_ClearFilter'))
boolean above2StarsVisible = WebUI.verifyElementVisible(findTestObject('Object Repository/Filter_Product/Btn_Above2StarsClear'))

if (clearFilterVisible && above2StarsVisible) {
	WebUI.comment('Both "Clear Filter" and "Above 2 Stars" buttons are visible.')
} else {
	WebUI.comment('There is an issue with the visibility of filter buttons.')
}