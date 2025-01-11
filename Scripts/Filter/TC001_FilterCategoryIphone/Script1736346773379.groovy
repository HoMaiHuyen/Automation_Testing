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

// Step 2: Click on the filter button for the iPhone category
WebUI.click(findTestObject('Object Repository/Filter_Product/Btn_CategoryIPhone'))

// Step 3: Wait for the products to be displayed
WebUI.waitForElementVisible(findTestObject('Object Repository/Filter_Product/div_ListProduct'), 10)

// Step 4: Get the list of displayed products
def productList = WebUI.findWebElements(findTestObject('Object Repository/Filter_Product/div_ListProduct'), 10)

// Step 5: Check if all displayed products contain the word "iPhone"
boolean allProductsAreIphones = true
for (def product : productList) {
    // Get the text from the WebElement
    String productName = product.getText()
    if (!productName.toLowerCase().contains('iphone')) {
        allProductsAreIphones = false
        break
    }
}

if (allProductsAreIphones) {
    WebUI.comment('All displayed products are iPhones.')
} else {
    WebUI.comment('There are products in the list that are not iPhones.')
}

// Step 6: Check the visibility of the "Clear Filter" and "Above 2 stars" buttons
boolean clearFilterVisible = WebUI.verifyElementVisible(findTestObject('Object Repository/Filter_Product/btn_ClearFilter'))


