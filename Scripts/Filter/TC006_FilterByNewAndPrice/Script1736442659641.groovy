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

// Mở trình duyệt và điều hướng đến trang web
WebUI.openBrowser('http://127.0.0.1:5500/')
WebUI.maximizeWindow()

// Nhấp vào nút "Khuyến mãi"
WebUI.click(findTestObject('Object Repository/Filter_Product/btn_Oppo'))

// Nhấp vào nút "Giá tiền"
WebUI.click(findTestObject('Object Repository/Filter_Product/btn_price'))

// Chọn giá "Từ 7 - 13 triệu"
WebUI.click(findTestObject('Object Repository/Filter_Product/btn_7-13milion'))

// Xác minh các sản phẩm trong kết quả hiển thị đúng theo tiêu chí lọc
List<WebElement> productResults = WebUI.findWebElements(findTestObject('Object Repository/Filter_Product/list_Products'), 10)

for (WebElement product : productResults) {
	// Lấy giá sản phẩm
	String priceText = product.findElement(By.xpath('.//div[@class="price"]//strong')).getText() // Sửa xpath cho đúng vị trí
	int price = Integer.parseInt(priceText.replaceAll('[^\\d]', '')) // Loại bỏ ký tự không phải số
	
	// Lấy thông tin khuyến mãi
   String promotionText = product.findElement(By.xpath("//h3[normalize-space()='Oppo F9']")).getText()
	
	// Kiểm tra giá trong phạm vi 2 - 4 triệu
	WebUI.verifyGreaterThanOrEqual(price, 7000000, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyLessThanOrEqual(price, 13000000, FailureHandling.CONTINUE_ON_FAILURE)
	
	// Kiểm tra khuyến mãi "Mới ra mắt"
	WebUI.verifyMatch(promotionText, 'Oppo F9', false, FailureHandling.CONTINUE_ON_FAILURE)
}
// Đóng trình duyệt sau khi hoàn thành
WebUI.closeBrowser()