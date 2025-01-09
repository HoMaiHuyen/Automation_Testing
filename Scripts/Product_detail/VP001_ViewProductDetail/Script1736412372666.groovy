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

WebUI.openBrowser('')
WebUI.navigateToUrl('http://127.0.0.1:5500/')


//Select a product from the list
WebUI.click(findTestObject('Object Repository/Product_detail/div_product_item'))

//Verify the product detail page is displayed
boolean isDetailPageDisplayed = WebUI.verifyElementVisible(findTestObject('Object Repository/Product_detail/div_product_detail_page'))
assert isDetailPageDisplayed : "Product detail page is not displayed"

//Verify product details are displayed correctly
boolean isProductNameDisplayed = WebUI.verifyElementVisible(findTestObject('Object Repository/Product_detail/txt_product_name'))
assert isProductNameDisplayed : "Product name is not displayed"

boolean isProductImageDisplayed = WebUI.verifyElementVisible(findTestObject('Object Repository/Product_detail/img_product_image'))
assert isProductImageDisplayed : "Product image is not displayed"

boolean isProductPriceDisplayed = WebUI.verifyElementVisible(findTestObject('Object Repository/Product_detail/txt_product_price'))
assert isProductPriceDisplayed : "Product price is not displayed"

boolean isAddToCartButtonDisplayed = WebUI.verifyElementVisible(findTestObject('Object Repository/Product_detail/btn_add_to_cart'))
assert isAddToCartButtonDisplayed : "Add to Cart button is not displayed"

//Print success message to the console
println("Test Case VP-001: Verify user can view product details successfully - PASSED")

//Close browser
WebUI.closeBrowser()