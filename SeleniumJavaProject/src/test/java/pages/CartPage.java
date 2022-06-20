package pages;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import automation.automationpractice;

public class CartPage {			
		
	@FindBy(xpath="//*[@id=\"homefeatured\"]/li[4]/div/div[1]/div/a[1]/img")	
	WebElement item;
	@FindBy(xpath="//*[@id=\"homefeatured\"]/li[4]/div/div[2]/div[2]/a[2]")	
	WebElement btnMore;
	@FindBy(xpath="//*[@id=\"quantity_wanted\"]")
	WebElement inputQuantity;
	@FindBy(xpath="//*[@id=\"group_1\"]")
	WebElement selectSize;
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button")
	WebElement btnAddToCart;
	@FindBy(css="div#layer_cart a > span")
	WebElement btnCheckout;
	@FindBy(xpath="//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")
	WebElement cartText;	
	
	automationpractice commercesite;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
		
		List<WebElement> priceElements = driver.findElements(By.xpath("//*[@id=\"homefeatured\"]/li/div/div[2]/div[1]/span[@class='price product-price']"));	
		
		HashMap<Integer, String> hm = new HashMap<Integer,String>();
		int j=0;
		int max=0;
		for (int i=0; i<priceElements.size(); i++) {		
			j=i+1;
				hm.put(Integer.parseInt(priceElements.get(i).getText().replaceAll("[^0-9]", "")), "//*[@id=\"homefeatured\"]/li["+j+"]/div/div[1]/div/a[1]/img");		
									
		}
		
		int q=0;
		HashMap<Integer, String> hm1 = new HashMap<Integer,String>();
		for (int p=0; p<priceElements.size(); p++) {		
			q=p+1;
				hm1.put(Integer.parseInt(priceElements.get(p).getText().replaceAll("[^0-9]", "")), "//*[@id=\"homefeatured\"]/li["+q+"]/div/div[2]/div[2]/a[2]");		
									
		}
			
		ArrayList <Integer> al = new ArrayList<Integer>();
		System.out.println("Total Price Elements are - " +priceElements.size());		
		for(int i=0;i<priceElements.size();i++) {			
			al.add(i,Integer.parseInt(priceElements.get(i).getText().replaceAll("[^0-9]", "")));			
		}
		Collections.sort(al);
		max = al.get(al.size()-1);
		System.out.println("The highest Price is - "+max);		
		System.out.println("The highest Price Item is - "+hm.get(max));	
		System.out.println("The highest Price Item more button element is - "+hm1.get(max));	
		
		
		commercesite = new automationpractice();
	}
	
	public boolean validateCart(WebDriver driver) {
		commercesite.performMouseOver(item, driver);
		commercesite.click(btnMore);
		commercesite.clear(inputQuantity);
		commercesite.setText("1", inputQuantity);
		commercesite.selectByVisibleText(selectSize, "S");
		commercesite.click(btnAddToCart);
		commercesite.btnClkJavaScriptExecutor(btnCheckout, driver);
		commercesite.refresh(driver);	
		return commercesite.validateText(driver, cartText, "1");
	}

	
}
