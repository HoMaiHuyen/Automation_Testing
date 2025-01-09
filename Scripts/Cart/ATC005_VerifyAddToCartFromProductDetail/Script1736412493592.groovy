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

// Click on the product name to open its detail page
WebUI.click(findTestObject('Object Repository/Cart_page/img_product'))

// Initialize the expected quantity
int expectedQuantity = 0

// Loop to click the "Add to Cart" button multiple times
for (int i = 1; i <= 3; i++) {
	// Click the "Add to Cart" button on the product detail page
	WebUI.click(findTestObject('Object Repository/Cart_page/btn_addToCartButtonProductDetail'))

	// Increment the expected quantity
	expectedQuantity++

	// Wait briefly to ensure the cart updates
	WebUI.delay(2)

	// Retrieve the current cart quantity displayed
	String actualQuantity = WebUI.getText(findTestObject('Object Repository/Cart_page/txt_numberCart'))

	// Verify the displayed cart quantity matches the expected quantity
	WebUI.verifyEqual(actualQuantity, expectedQuantity.toString())
}

// Close the browser
WebUI.closeBrowser()
