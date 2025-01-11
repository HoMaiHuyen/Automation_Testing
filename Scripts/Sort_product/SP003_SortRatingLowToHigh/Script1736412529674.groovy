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

WebUI.click(findTestObject('Object Repository/Sort_product/ddl_Sort'))
WebUI.click(findTestObject('Object Repository/Sort_product/btn_sort_by_rating_low_to_high'))

TestObject lastProductElement = findTestObject('Object Repository/Search_product/div_product_list')
WebUI.scrollToElement(lastProductElement, 5)

List<WebElement> products = WebUI.findWebElements(findTestObject('Object Repository/Sort_product/txt_rating'), 30)

// Extract product ratings and verify if they are sorted from low to high
def ratings = []
products.each { product ->
    def ratingText = product.getText().trim()
    
    if (ratingText.isEmpty()) {
        ratings.add(0.0)
    } else {
        ratings.add(Double.parseDouble(ratingText))
    }
}

// Print the initial list of ratings to the console
println("Initial list of ratings: ${ratings}")

// Create a copy of the rating list and sort it in ascending order
def sortedRatings = ratings.clone()
sortedRatings.sort()

// Print the sorted list of ratings to the console
println("Sorted list of ratings: ${sortedRatings}")

// Compare the initial list of ratings with the sorted list
if (ratings == sortedRatings) {
    WebUI.comment("Products are correctly sorted by ratings from low to high.")
    println("RESULT: Products are correctly sorted by ratings from low to high.")
} else {
    WebUI.comment("Products are not correctly sorted. Current ratings: ${ratings}")
    println("RESULT: Products are not correctly sorted. Current ratings: ${ratings}")
    assert false : "The rating list is not in ascending order."
}

WebUI.delay(5)
WebUI.closeBrowser()
