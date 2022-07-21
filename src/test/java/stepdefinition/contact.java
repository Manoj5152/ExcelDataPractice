package stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;
import data.Exceldata;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.Contactpage;

public class contact extends BaseClass{
	
		@Given("the user is on the Contact us page")
		public void the_user_is_on_the_contact_us_page() {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\Admin\\Selenium Jar\\Chrome Driver\\chromedriver_win32\\chromedriver.exe");
			 d = new ChromeDriver();
			d.manage().window().maximize();
			d.get("http://automationpractice.com/index.php?controller=contact");	    
		}

		@When("user fills the form from the given sheetname {string} and rownumber {int}")
		public void user_fills_the_form_from_the_given_sheetname_and_rownumber(String SheetName, Integer rownumber) throws Exception {
			
			Exceldata data = new Exceldata();
				List<Map<String,String>> testdata = data.getData
						("C:\\Users\\Admin\\Desktop\\Testing Data\\automationtesting.xlsx", SheetName);
				//String heading = testdata.get(rownumber).get("Subjectheading");
				String email = testdata.get(rownumber).get("Email");
				String Ordernum = testdata.get(rownumber).get("OrderRef");
				String message = testdata.get(rownumber).get("Message");
				pages = new Contactpage(d);	
				pages.Contactform( email, Ordernum, message);
				
		}

		@When("user clicks the send button")
		public void user_clicks_the_send_button() {
		 pages.Button();   
		}

		@Then("it shows a successful message {string}")
		public void it_shows_a_successful_message(String ExpSuccessmessage) {
		   String actual = pages.getmessage();
		Assert.assertEquals(actual, ExpSuccessmessage);
		
		}

}
