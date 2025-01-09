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

// Bước 1: Mở trình duyệt và truy cập vào trang HomePage
WebUI.openBrowser('')
WebUI.navigateToUrl('http://127.0.0.1:5500/')

// Delay để có thời gian quan sát
WebUI.delay(3)

// Bước 2: Click vào nút khuyến mãi
WebUI.click(findTestObject('Object Repository/Filter_Promotion/btn_Promotion'))

// Bước 3: Chọn bộ lọc "Giảm giá"
WebUI.click(findTestObject('Object Repository/Filter_Promotion/btn_Discount'))


TestObject lastProductElement = findTestObject('Object Repository/Filter_Rating/div_List')
WebUI.scrollToElement(lastProductElement, 10)
// Bước 5: Kiểm tra xem có sản phẩm nào giảm giá không
def discountProductList = WebUI.findWebElements(findTestObject('Object Repository/Filter_Promotion/div_List'), 10)

if (discountProductList.size() > 0) {
	WebUI.comment('Có sản phẩm hiển thị với giảm giá.')
} else {
	WebUI.comment('Không có sản phẩm nào hiển thị với giảm giá.')
}

// Bước 6: Kiểm tra sự hiện diện của nút "Xóa bộ lọc" và "Giảm giá"
boolean clearFilterVisible = WebUI.verifyElementVisible(findTestObject('Object Repository/Filter_Promotion/btn_ClearFilter'))
boolean discountClearVisible = WebUI.verifyElementVisible(findTestObject('Object Repository/Filter_Promotion/btn_DiscountClear'))

if (clearFilterVisible && discountClearVisible) {
	WebUI.comment('Cả hai nút "Xóa bộ lọc" và "Giảm giá" đều hiển thị.')
} else {
	WebUI.comment('Có vấn đề với việc hiển thị nút lọc.')
}

// Bước 7: Đóng trình duyệt
WebUI.closeBrowser()