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

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement // Import lớp WebElement
import java.util.List // Import lớp List nếu cần

// Open the browser
WebUI.openBrowser('')

// Navigate to the homepage
WebUI.navigateToUrl('http://127.0.0.1:5500/')

// Check the sort menu and select "Price: Low to High"
WebUI.click(findTestObject('Object Repository/Sort_product/ddl_Sort'))
WebUI.click(findTestObject('Object Repository/Sort_product/btn_sort_by_price_high_to_low'))

TestObject lastProductElement = findTestObject('Object Repository/Search_product/div_product_list')
WebUI.scrollToElement(lastProductElement, 5)

// Retrieve the list of product price elements
List<WebElement> products = WebUI.findWebElements(findTestObject('Object Repository/Sort_product/txt_price'), 30)

// Extract the product prices and verify if they are sorted from low to high
def prices = []
products.each { product ->
	// Get the text value and remove unnecessary characters
	def priceText = product.getText().replace('.', '').replace('₫', '').trim()
	prices.add(Integer.parseInt(priceText)) // Add the price (as a number) to the list
}

// Compare the price list with ascending order
def sortedPrices = prices.sort() // Sort the price list
assert prices == sortedPrices // Check if the original list is already sorted from low to high


