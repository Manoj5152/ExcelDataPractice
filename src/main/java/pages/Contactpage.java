package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Contactpage {
	 WebDriver d;
		public Contactpage(WebDriver d) {
			this.d = d ;
			PageFactory.initElements(d, this);
		}
		
		@FindBy(xpath = "//select[@id='id_contact']")
		WebElement DropDown;
		
		@FindBy(id = "email")
		WebElement Email;
		
		@FindBy(id = "id_order")
		WebElement OrderRef;
		
		@FindBy(id = "message")
		WebElement Message;
		
		
		public void Contactform(String email, String Ordernum, String message) throws Exception {
			Thread.sleep(5000);
		Select drop = new Select(DropDown);
			drop.selectByIndex(1);
				Thread.sleep(2000);
				Email.sendKeys(email);
				OrderRef.sendKeys(Ordernum);
				Message.sendKeys(message);
						
		}
		@FindBy(id = "submitMessage")
		WebElement Sendbutton;
		
		public void Button() {
			Sendbutton.click();
		}
		
		@FindBy(css = "#center_column > p")
		WebElement Successmsg;
		
		public String getmessage() {
			return Successmsg.getText();
			
		}
}
