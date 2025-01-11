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

// Step 1: Open the browser and navigate to the HomePage
WebUI.openBrowser('http://127.0.0.1:5500/')
WebUI.maximizeWindow()

// Delay to observe the page
WebUI.delay(3)

// Step 2: Click on the promotion button
WebUI.click(findTestObject('Object Repository/Filter_Product/btn_Promotion'))

// Step 3: Select the "Discount" filter
WebUI.click(findTestObject('Object Repository/Filter_Product/btn_Discount'))

TestObject lastProductElement = findTestObject('Object Repository/Filter_Product/div_ListProduct')
WebUI.scrollToElement(lastProductElement, 10)

// Step 5: Check if there are any products with a discount
def discountProductList = WebUI.findWebElements(findTestObject('Object Repository/Filter_Product/div_ListProduct'), 10)

if (discountProductList.size() > 0) {
	WebUI.comment('There are products displayed with a discount.')
} else {
	WebUI.comment('No products are displayed with a discount.')
}

// Step 6: Check the visibility of the "Clear Filter" and "Discount" buttons
boolean clearFilterVisible = WebUI.verifyElementVisible(findTestObject('Object Repository/Filter_Product/btn_ClearFilter'))
boolean discountClearVisible = WebUI.verifyElementVisible(findTestObject('Object Repository/Filter_Product/btn_DiscountClear'))

if (clearFilterVisible && discountClearVisible) {
	WebUI.comment('Both "Clear Filter" and "Discount" buttons are visible.')
} else {
	WebUI.comment('There is an issue with the visibility of filter buttons.')
}

