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

// Step 3: Select "Reviews: High to Low" from the dropdown list
WebUI.click(findTestObject('Object Repository/Sort_product/ddl_Sort'))
WebUI.click(findTestObject('Object Repository/Sort_product/btn_sort_by_review_high_to_low'))

// Step 4: Validate that products are sorted by reviews from highest to lowest
List<WebElement> products = WebUI.findWebElements(findTestObject('Object Repository/Sort_product/txt_review'), 10)
List<Double> reviewScores = new ArrayList<>() 

// Extract review scores from the page
for (WebElement product : products) {
    String reviewText = product.getText().trim(); // Example: "2 đánh giá"
    
    // Extract numeric part using regex
    String numericPart = reviewText.replaceAll("[^0-9.]", ""); // Remove non-numeric characters except '.'
    
    // Safely parse to Double if numericPart is not empty
    if (!numericPart.isEmpty()) {
        reviewScores.add(Double.parseDouble(numericPart))
    }
}

// Verify that the list of review scores is sorted in descending order
boolean isSorted = true
for (int i = 0; i < reviewScores.size() - 1; i++) {
    if (reviewScores.get(i) < reviewScores.get(i + 1)) {
        isSorted = false
        break
    }
}

// Step 5: Check the sorting order
if (isSorted) {
    WebUI.comment('Test Passed: Products are sorted by reviews from high to low')
} else {
    WebUI.comment('Test Failed: Products are not sorted by reviews from high to low')
}


