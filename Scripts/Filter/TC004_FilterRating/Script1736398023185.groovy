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

// Bước 1: Mở trình duyệt và truy cập vào trang HomePage
WebUI.openBrowser('')
WebUI.navigateToUrl('http://127.0.0.1:5500/')



WebUI.click(findTestObject('Object Repository/Filter_Rating/Btn_Rating'))

WebUI.click(findTestObject('Object Repository/Filter_Rating/Btn_Above2Stars'))

TestObject lastProductElement = findTestObject('Object Repository/Filter_Rating/div_List')
WebUI.scrollToElement(lastProductElement, 10)
// Bước 4: Đợi cho các sản phẩm hiển thị
WebUI.waitForElementVisible(findTestObject('Object Repository/Filter_Rating/Btn_Above2StarsClear'), 10)

// Bước 5: Kiểm tra xem có sản phẩm nào trên 2 sao không
def productList = WebUI.findWebElements(findTestObject('Object Repository/Filter_Rating/Btn_Above2StarsClear'), 10)

if (productList.size() > 0) {
	WebUI.comment('Có sản phẩm hiển thị trên 2 sao.')
} else {
	WebUI.comment('Không có sản phẩm nào hiển thị trên 2 sao.')
}

// Bước 6: Kiểm tra sự hiện diện của nút "Xóa bộ lọc" và "Trên 2 sao"
boolean clearFilterVisible = WebUI.verifyElementVisible(findTestObject('Object Repository/Filter_Rating/Btn_ClearFilter'))
boolean above2StarsVisible = WebUI.verifyElementVisible(findTestObject('Object Repository/Filter_Rating/Btn_Above2StarsClear'))

if (clearFilterVisible && above2StarsVisible) {
	WebUI.comment('Cả hai nút "Xóa bộ lọc" và "Trên 2 sao" đều hiển thị.')
} else {
	WebUI.comment('Có vấn đề với việc hiển thị nút lọc.')
}

// Bước 7: Đóng trình duyệt

WebUI.comment('Trình duyệt đã đóng.')