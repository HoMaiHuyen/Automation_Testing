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
import org.openqa.selenium.WebElement
import org.openqa.selenium.By

// Open the browser and navigate to the website
WebUI.openBrowser('http://127.0.0.1:5500/')
WebUI.maximizeWindow()

// Click on the "Promotion" button
WebUI.click(findTestObject('Object Repository/Filter_Product/btn_promotion'))

// Select "Newly Launched"
WebUI.click(findTestObject('Object Repository/Filter_Product/btn_installment'))

// Click on the "Price" button
WebUI.click(findTestObject('Object Repository/Filter_Product/btn_price'))

// Select the price range "4 - 7 million"
WebUI.click(findTestObject('Object Repository/Filter_Product/btn_4-7milion'))

// Verify that the products in the results meet the filter criteria
List<WebElement> productResults = WebUI.findWebElements(findTestObject('Object Repository/Filter_Product/list_Products'), 10)

for (WebElement product : productResults) {
	// Get the product price
	String priceText = product.findElement(By.xpath('.//div[@class="price"]//strong')).getText()
	int price = Integer.parseInt(priceText.replaceAll('[^\\d]', '')) // Remove non-numeric characters
	
	// Get the promotion information
	String promotionText = product.findElement(By.xpath('//li[1]//a[1]//label[1]')).getText()
	
	// Verify the price is within the range of 4 - 7 million
	WebUI.verifyGreaterThanOrEqual(price, 4000000, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyLessThanOrEqual(price, 7000000, FailureHandling.CONTINUE_ON_FAILURE)
	
	// Verify the promotion is "Newly Launched"
	WebUI.verifyMatch(promotionText, 'Trả góp 0%', false, FailureHandling.CONTINUE_ON_FAILURE)
}
// Close the browser after completing the test
WebUI.closeBrowser()
