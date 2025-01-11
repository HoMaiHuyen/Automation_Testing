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
import groovy.json.JsonSlurper

// Open browser and navigate to the application
WebUI.openBrowser('http://127.0.0.1:5500/')
WebUI.maximizeWindow()
// Retrieve user info from Local Storage before login
String storedUserInfo = WebUI.executeJavaScript("return window.localStorage.getItem('ListUser')", null)
if (storedUserInfo != null && !storedUserInfo.isEmpty()) {
    WebUI.comment("User info found in Local Storage: " + storedUserInfo)
} else {
    WebUI.comment("No user info found in Local Storage. Proceeding to check login.")
}

// User input for login
String inputUsername = 'Anh'

// Perform login actions
WebUI.click(findTestObject('Object Repository/Login_page/btn_account'))
WebUI.setText(findTestObject('Object Repository/Login_page/txt_username'), inputUsername)
WebUI.setEncryptedText(findTestObject('Object Repository/Login_page/txt_password'),'vfo/SdGHQ3g=')
WebUI.click(findTestObject('Object Repository/Login_page/btn_login'))

// Retrieve updated user info from Local Storage after login
String updatedUserInfo = WebUI.executeJavaScript("return window.localStorage.getItem('ListUser')", null)

// Parse the stored and updated user info JSON
JsonSlurper jsonSlurper = new JsonSlurper()

// Parse the stored user info as an array, since it's a list (ArrayList) not a Map
List storedUserList = storedUserInfo ? jsonSlurper.parseText(storedUserInfo) : []
List updatedUserList = updatedUserInfo ? jsonSlurper.parseText(updatedUserInfo) : []

// Assuming the list contains at least one user object
if (!storedUserList.isEmpty()) {
    Map storedUserMap = storedUserList[0]
    Map updatedUserMap = updatedUserList.isEmpty() ? [:] : updatedUserList[0]

    // Check if the stored user info matches the input
    if (storedUserMap['username'] == inputUsername && storedUserMap['pass'] == 'Anh1234') {
        WebUI.comment("User info matches Local Storage. Login successful.")
    } else {
        WebUI.comment("User info does not match Local Storage. Login failed.")
        assert false : "Invalid login credentials or mismatched Local Storage data."
    }
} else {
    WebUI.comment("No user info found in Local Storage.")
    assert false : "No user data in Local Storage."
}


