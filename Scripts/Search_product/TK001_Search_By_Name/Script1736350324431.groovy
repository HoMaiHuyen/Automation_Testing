import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement // Import Selenium WebElement
import com.kms.katalon.core.testobject.TestObject

// 1. Open the browser and access the website
WebUI.openBrowser('')
WebUI.navigateToUrl('http://127.0.0.1:5500/') // Replace the URL with your website's address

// 2. Enter the search keyword into the search box
WebUI.setText(findTestObject('Object Repository/Search_product/input_search_box'), 'iPhone 7')

// 3. Click the search button
WebUI.click(findTestObject('Object Repository/Search_product/btn_search'))

// 4. Scroll down to view the displayed results
TestObject lastProductElement = findTestObject('Object Repository/Search_product/div_product_list') 
WebUI.scrollToElement(lastProductElement, 5)

// 5. Retrieve the list of result elements
List<WebElement> productElements = WebUI.findWebElements(findTestObject('Object Repository/Search_product/txt_product_name'), 10)

boolean isCorrect = true
String keyword = 'iPhone 7'

// 6. Check each product name in the results
for (WebElement productElement : productElements) {
    String productName = productElement.getText()
    if (!productName.toLowerCase().contains(keyword.toLowerCase())) {
        isCorrect = false
        println "Result does not match: $productName"
        break
    }
}

// 7. Confirm the result
assert isCorrect : "There is a product that does not match the search keyword."
