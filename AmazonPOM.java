package Amazon.in;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AmazonPOM {
	WebDriver driver;
	
	//Method to open Amazon Website....
	public void urlOpen() {
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
	}
	
	//Method to Land in SignIn page....
	public void Login() throws InterruptedException {
		Actions actt =  new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(@id,\"nav-main\")]//child::a//span[starts-with(text(),\"All\")]")).click();
		
		Thread.sleep(2000);
		WebElement signclick = driver.findElement(By.xpath("//div[@id = \"hmenu-content\"]//child::ul//li[25]//a"));
		actt.moveToElement(signclick).click().build().perform();
	}
	
	
//	Method to to SignIn in amazon
	public void signin() throws InterruptedException {
		WebElement userid = driver.findElement(By.xpath("//div[@class = \"a-row a-spacing-base\"]//child::input[@id = \"ap_email\"]"));
		Thread.sleep(2000);
		userid.sendKeys("8860652292");
		driver.findElement(By.xpath("//div[@class = \"a-section\"]//child::span//span//input[@class = \"a-button-input\"]")).click();
		WebElement psswd = driver.findElement(By.xpath("//div[@class = \"a-section a-spacing-large\"]//child::input[@name = \"password\" and @id = \"ap_password\"]"));
		Thread.sleep(2000);
		psswd.sendKeys("Amazon@2022#");
		driver.findElement(By.xpath("//div[@class = \"a-section\"]//child::span//input[@id = \"signInSubmit\"]")).click();
	}
	
	//Method to slideUp and slideDown the page....
	public void sliderRoller() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,-1400)");
	}
	
	//Method to slide Images towards right or left....
	public void nextSlide() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement rightslide =driver.findElement(By.xpath("//div[@class = \"a-carousel-col a-carousel-right celwidget\"]//child::i[@class=\"a-icon a-icon-next-rounded\"]"));
		WebElement leftslide = driver.findElement(By.xpath("//div[@class = \"a-carousel-col a-carousel-left celwidget\"]//child::i[@class=\"a-icon a-icon-previous-rounded\"]"));
		
		Actions action = new Actions(driver);
//		action.moveToElement(nxtslide).click().build().perform()
		int i =1;
		while (i <=3) {
			Thread.sleep(2000);
			rightslide.click();
			i++;
		}
		
		int y =1;
		while (y <=3) {
			Thread.sleep(2000);
			leftslide.click();
			y++;
		}
//		driver.close();
		
	}
	
	
//	Method to pass keyword to search object.
	public void searchBox() throws AWTException, InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']//parent::div//child::input")).sendKeys("Samsung Mobile phones");
		Robot robot = new Robot();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		//driver.findElement(By.xpath("//span[@class = 'nav-icon nav-arrow']")).click();
	}
	
//	All methods are of select the electronic item and add to the cart..
	
//	Method to select the categaries in Amazon...
	public void allCategories() throws AWTException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement sel = driver.findElement(By.xpath("//select[@id = \"searchDropdownBox\" and @name = \"url\"]"));
		Select select = new Select(sel);
		select.selectByVisibleText("Electronics");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
	    //Navigate to the left nav bar....
		driver.findElement(By.xpath("//a[@class = \"a-color-base a-link-normal\"]//span[text()=\"Headphones\"]")).click();
	}
	
//	Method to Filter the product by price (High/Low)....
	public void filterByFeature() throws AWTException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Robot robot = new Robot();
		WebElement path = driver.findElement(By.xpath("//span[@class=\"a-button-inner\"]//span//span[2]"));
		path.click();
//		For price low to high
		WebElement lth = driver.findElement(By.xpath("//div[@class = \"a-popover-inner\"]//child::li[2]//a[text() = \"Price: Low to High\"]"));
//		For price High to Low
		WebElement htl = driver.findElement(By.xpath("//div[@class = \"a-popover-inner\"]//child::li[3]//a[text() = \"Price: High to Low\"]"));
		String Custumerreq = "zzz";
		 if (Custumerreq == "less") {
			lth.click();
		}else {
			htl.click();	
		}
		
		}
	
	
//	Method to select the priority item and add to the cart..
	public void purchaseItem() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement lnk = driver.findElement(By.xpath("//div[@class= \"a-section a-spacing-none a-spacing-top-small s-title-instructions-style\"]//h2//a//span[text()=\"Cambridge Audio Melomania Touch Earbuds, True Wireless Bluetooth 5.0, Hi-Fi Sound, in-Ear Stereo Ear Buds for iPhone and for Android (Black)\"]"));
		action.moveToElement(lnk).click().perform();
//		Click on Add to cart
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,2000)");
		WebElement atocart =driver.findElement(By.xpath("//div[@id=\"add-to-cart-item-1\"]//following-sibling::span//child::span//span[text()=\" Add both to Cart \"]"));
		action.moveToElement(atocart).click().build().perform();
//		Click on Buy Now
		WebElement bnow =driver.findElement(By.xpath("//span[@class = \"a-button-inner\"]//child::div[2][contains(@class,\"sc-with-multicart\")]"));
		action.moveToElement(bnow).click().build().perform();
	}
	
	public void returnHome() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement home = driver.findElement(By.xpath("//div[@id = \"nav-logo\"]//child::a"));
		home.click();
	}
	
	public void searchByBrand() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println("Choices:: 1: Samsung\r\n"
				+ "	2: Motorola \r\n"
				+ "	3: Nokia");
		
		Scanner ask = new Scanner(System.in);
		int Brand = ask.nextInt();
		
		WebElement brand = driver.findElement(By.xpath("(//div[@id = \"brandsRefinements\"]//child::ul//label//i[@class = \"a-icon a-icon-checkbox\"])[1]"));
		brand.click();
	}
	
	public void name() {
		
	}
	
	
	
}
