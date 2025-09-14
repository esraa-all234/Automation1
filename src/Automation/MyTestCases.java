package Automation;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


                       //inheritance
public class MyTestCases extends MyData{
WebDriver driver = new EdgeDriver();
	
	String myWebSite = "https://automationteststore.com/";
	
	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";
	
String SignOut="https://automationteststore.com/index.php?rt=account/logout";
	
	@BeforeTest
	public void mySetUp()
	{
		driver.get(myWebSite);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


	}
	
	@Test(priority = 1,enabled=false)
	public void Signup() throws InterruptedException
	{
		driver.navigate().to(SignupPage);
	
//		// static 
//		String [] firstNames = {"shatha","zainab","ayham","abdulrahman","ammar","sana"};
//
//		
//		// dynamic 
//		List<String> mycolors = new ArrayList<String>();
//		
//		
//		mycolors.add("green"); 
//		mycolors.add("blue"); 
//
//		
//		
//		System.out.println(firstNames[0]);
//		System.out.println(mycolors.get(0));


		
		
		// Webelements
		
		


		WebElement FirstName = 	driver.findElement(By.id("AccountFrm_firstname"));
		WebElement LastName = 	driver.findElement(By.id("AccountFrm_lastname")); 
		WebElement Email = 	driver.findElement(By.id("AccountFrm_email")); 
		WebElement Telephone = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement TheFax = driver.findElement(By.id("AccountFrm_fax"));
		WebElement AddressOne = driver.findElement(By.id("AccountFrm_address_1"));
		
		WebElement Thecountry = driver.findElement(By.id("AccountFrm_country_id"));
		
		WebElement TheState = driver.findElement(By.id("AccountFrm_zone_id"));
		
		Select mySelectElementForcountry = new Select(Thecountry); 
		Select mySelectElementForState = new Select(TheState); 
//to see the select after we select the country we add thread 
		mySelectElementForcountry.selectByIndex(108);
		Thread.sleep(2000);
		mySelectElementForState.selectByIndex(theSelectStateIndex);

		
		//we user it becuse we need  to find inside the select the options 
		List<WebElement> AlltheStates = TheState.findElements(By.tagName("option"));
                      
		
		//we need to get the text to the select index
		String theCity = AlltheStates.get(theSelectStateIndex).getText();
                    
		
		WebElement TheCityInput = driver.findElement(By.id("AccountFrm_city"));

		WebElement ThePostalCode = driver.findElement(By.id("AccountFrm_postcode"));

		WebElement LoginName = driver.findElement(By.id("AccountFrm_loginname"));

		WebElement ThePassword = driver.findElement(By.id("AccountFrm_password"));
		WebElement TheConfirmPassword = driver.findElement(By.id("AccountFrm_confirm"));

		WebElement AgreeCheckBox = driver.findElement(By.id("AccountFrm_agree"));

		WebElement CountinueButton = driver.findElement(By.xpath("//button[@title='Continue']"));
		
		
		
		// -- Actions --
		FirstName.sendKeys(TheFirstName);
		LastName.sendKeys(TheLastName);
		Email.sendKeys(TheEmail);
		Telephone.sendKeys(TelePhone);
		TheFax.sendKeys(TheFaxNumber);
		AddressOne.sendKeys(TheAddressOne);
		;

		TheCityInput.sendKeys(theCity);

		ThePostalCode.sendKeys(postalCode);

		LoginName.sendKeys(LOGINAME);
		ThePassword.sendKeys(Password);
		TheConfirmPassword.sendKeys(Password);
		AgreeCheckBox.click();
		CountinueButton.click();
		Thread.sleep(5000);
		String ActualSignUpMessage = driver.findElement(By.className("maintext")).getText();

		// test case ( بتقارن القيمة الحقيقة بالمتوقعة وبتشتغل زي ال if )
		Assert.assertEquals(ActualSignUpMessage, ExpectedTextForTheSignUp);

		
		
		
		
		
	}

	@Test(priority = 2 ,enabled=false)
	public void Logout() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.navigate().to(SignOut);
		String ActualSignOutMessage=driver.findElement(By.className("maintext")).getText();
		
		Assert.assertEquals(ActualSignOutMessage, ExpectedTextForTheLogout);

System.out.println(ActualSignOutMessage);		
	}
	
	@Test (priority = 3,enabled=false)
	public void LogoutTest() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Logo")).click();;
		
		 //we use it for get all html page
		//System.out.println(driver.getPageSource());
		                                                     //its boolean (ture,false)
		boolean ActualValueForLogout = driver.getPageSource().contains(TheLogoutMessage);
		
		Assert.assertEquals(ActualValueForLogout, true);
	}

@Test(priority = 4 ,enabled=false)
	
	public void Login() throws InterruptedException {
		
		//driver.findElement(By.partialLinkText("Login or ")).click();;
		
		
		//driver.findElement(By.xpath("//a[@href='https://automationteststore.com/index.php?rt=account/login']")).click();
		
		
		driver.findElement(By.cssSelector("ul[id='customer_menu_top'] li a")).click();
		
		WebElement LoginNameInput = driver.findElement(By.id("loginFrm_loginname"));
		
		WebElement LoginPasswordInput = driver.findElement(By.id("loginFrm_password"));
		WebElement LoginButton =driver.findElement(By.cssSelector("button[title='Login']"));

		
		
		LoginNameInput.sendKeys(LOGINAME);
		LoginPasswordInput.sendKeys(Password);
		
		Thread.sleep(5000);
		
		LoginButton.click();
		                                //search if the page comtains welcone msg (getpagesourse = html page)
		boolean ActualVlaue = driver.getPageSource().contains(welcomemessage);
		boolean Expectedvalue = true ; 
		
		Assert.assertEquals(ActualVlaue, Expectedvalue);;
		
	}
	
@Test(priority = 5,enabled=false)
public void AddItemToThecart() {

    driver.navigate().to(myWebSite);
//we but it in list 
    List<WebElement> AllItems = driver.findElements(By.className("prdocutname"));
 //to click in any random  item 
    
    
    int RandomIndexForTheItem = rand.nextInt(AllItems.size());
//we use get to ge the items when click go to the item
    //   نضغط على عنصر عشوائي
    AllItems.get(RandomIndexForTheItem).click();

    WebElement clickAdd = driver.findElement(By.cssSelector(".cart"));

    // URL الحالي
 String currentURL = driver.getCurrentUrl();

 
 
//find the size options 
 List<WebElement> Options = driver.findElements(By.xpath("//label[normalize-space()='UK size']/following-sibling::div//input[@type='radio']"));
   
    if (!Options.isEmpty()) {
    	// if i have  options hw will select one of them randomly 
        Random rand = new Random();
        WebElement Size = Options.get(rand.nextInt(Options.size()));
        Size.click();
    }

    // نضغط Add to Cart
    clickAdd.click();
}


@Test(priority = 6)
public void AddItemToThecart1() {

    driver.navigate().to(myWebSite);

    List<WebElement> AllItems = driver.findElements(By.className("prdocutname"));
    int RandomIndexForTheItem = new Random().nextInt(AllItems.size());
    AllItems.get(RandomIndexForTheItem).click();

    WebElement clickAdd = driver.findElement(By.cssSelector(".cart"));

    // جلب URL الحالي
    String actualURL = driver.getCurrentUrl();
    String expectedURL = "https://automationteststore.com/index.php?rt=product/product&product_id=116";

    // إذا الـ URL الحالي هو المتوقع
    if(actualURL.equals(expectedURL)) {

        // نفحص إذا فيه خيارات الحجم داخل الصفحة
        List<WebElement> sizeOptions = driver.findElements(
            By.xpath("//label[normalize-space()='UK size']/following-sibling::div//input[@type='radio']")
        );

        if(!sizeOptions.isEmpty()) {
            // اختيار حجم عشوائي
            WebElement randomSize = sizeOptions.get(new Random().nextInt(sizeOptions.size()));
            randomSize.click();
            System.out.println("Selected size: " + randomSize.getAttribute("value"));
        }
    }

    // الضغط على Add to Cart سواء كان فيه حجم أو لا
    clickAdd.click();
}

	
	

	
	@AfterTest
	public void AfterMyTest() {
		//close one tab
	//	driver.close();
		//close all tabs
		//driver.quit();
	}

}
