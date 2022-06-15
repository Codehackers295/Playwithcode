package Amazon.in;

import java.awt.AWTException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonMain {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		AmazonPOM amz = new AmazonPOM();
//		Open the Amazon website.
		amz.urlOpen();
		
//		Slide the webpage up and Down.
//		amz.sliderRoller();
		
//		click on Sign In button from left navigation dropdown.
		amz.Login();
		
//		Pass Userid and psswd to login in Amazon.
		amz.signin();
		
//		To move the images towards left and right 3 times
		amz.nextSlide();
		
//		Select one category from dropdown.
//		amz.allCategories();
		
//		Select the price range.
//		amz.filterByFeature();
		
//		Add to the cart selected items.
//		amz.purchaseItem();
		
//		Return to the home page of amazon
//		amz.returnHome();
		
		
		amz.searchBox();
		amz.searchByBrand();
	}

}
