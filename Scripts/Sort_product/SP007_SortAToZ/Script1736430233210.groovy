import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import com.kms.katalon.core.testobject.TestObject
import java.util.List

// Step 1: Open the page
WebUI.openBrowser('')
WebUI.navigateToUrl('http://127.0.0.1:5500/') // Thay URL bằng URL thực tế của bạn

// Step 2: Click the "Sort" button
WebUI.click(findTestObject('Object Repository/Sort_product/ddl_Sort'))

// Step 3: Select "Name: A to Z" from the list
WebUI.click(findTestObject('Object Repository/Sort_product/btn_sort_by_name_A_to_Z'))

// Step 4: Validate that products are displayed in alphabetical order (A to Z)
List<WebElement> productElements = WebUI.findWebElements(findTestObject('Object Repository/Product_detail/txt_product_name'), 10)
List<String> productNames = new ArrayList<>() 

// Extract product names from the page
for (WebElement productElement : productElements) {
    productNames.add(productElement.getText().trim())
}

// Verify that the product names are in alphabetical order (A to Z)
boolean isSorted = true
for (int i = 0; i < productNames.size() - 1; i++) {
    if (productNames.get(i).compareToIgnoreCase(productNames.get(i + 1)) > 0) {
        isSorted = false
        break
    }
}

// Step 5: Log the result
if (isSorted) {
    WebUI.comment('Test Passed: Products are sorted by name from A to Z')
} else {
    WebUI.comment('Test Failed: Products are not sorted by name from A to Z')
}

// Step 6: Close the browser
WebUI.closeBrowser()
