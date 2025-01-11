import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import com.kms.katalon.core.testobject.TestObject
import java.util.List 

WebUI.openBrowser('http://127.0.0.1:5500/')
WebUI.maximizeWindow()
WebUI.delay(5)

// Check the sort menu and select "Price: Low to High"
WebUI.click(findTestObject('Object Repository/Sort_product/ddl_Sort'))
WebUI.click(findTestObject('Object Repository/Sort_product/btn_sort_by_price_low_to_high'))

TestObject lastProductElement = findTestObject('Object Repository/Search_product/div_product_list')
WebUI.scrollToElement(lastProductElement, 5)

// Get the list of product price elements
List<WebElement> products = WebUI.findWebElements(findTestObject('Object Repository/Sort_product/txt_price'), 30)

// Extract product prices and check if they are sorted from low to high
def prices = []
products.each { product ->
    def priceText = product.getText().replace('.', '').replace('₫', '').trim()
    prices.add(Integer.parseInt(priceText))
}

// Print the initial list of prices to the console
println("Initial price list: ${prices}")

// Create a copy of the price list and sort it in ascending order
def sortedPrices = prices.clone() 
sortedPrices.sort()

// Print the sorted price list to the console
println("Sorted price list: ${sortedPrices}")

// Compare the initial price list with the sorted price list
if (prices == sortedPrices) {
    WebUI.comment("The products are correctly sorted from low to high.")
    println("RESULT: The products are correctly sorted from low to high.")
} else {
    WebUI.comment("The products are not sorted correctly. Current prices: ${prices}")
    println("RESULT: The products are not sorted correctly. Current prices: ${prices}")
    assert false : "The price list is not in ascending order."
}
WebUI.delay(3)
WebUI.closeBrowser()
