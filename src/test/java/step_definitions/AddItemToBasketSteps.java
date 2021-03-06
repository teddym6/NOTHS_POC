package step_definitions;


import org.openqa.selenium.WebDriver;

import pages.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.Driver;

public class AddItemToBasketSteps{
	
    public WebDriver driver;
    BaseClass page;
    public AddItemToBasketSteps()
    {
    	driver = Driver.REAL_DRIVER;
    	this.page = new BaseClass(driver); 
    }
    
    @Given("^When I navigate to the \"(.*?)\" page$")
    public void when_I_navigate_to_the_page(String arg1) throws Throwable {
    	
    	page.Navigate().Go("http://www.notonthehighstreet.com" + arg1);
    }
   

    @When("^I change the qty to be (\\d+)$")
    public void i_change_the_qty_to_be(int arg1) throws Throwable {
       
    	page.Addtobasket().AddItemToBasket(false,arg1);
    }
    
    @When("^And I click on Add to basket button$")
    public void and_I_click_on_Add_to_basket_button() throws Throwable {
    	
    	
    	page.Addtobasket().AddItemToBasket();
    	
    }

    @Then("^Item should be added to my basket$")
    public void item_should_be_added_to_my_basket() throws Throwable {
        
    	page.Basket().CheckItemIsAddedIntoBasket(true,1);
    	
    }
    
    @Then("^Item should be added to my basket (\\d+)$")
    public void item_should_be_added_to_my_basket(int arg1) throws Throwable {
    	
    	page.Basket().CheckItemIsAddedIntoBasket(false,arg1);
    	
    }
    
    @Given("^And I click on Add to basket button without having selected any options$")
    public void and_I_click_on_Add_to_basket_button_without_having_selected_any_options() throws Throwable {
      
    	page.Addtobasket().ClickOnAddToBasket();
    	
    }
    
    @Then("^I shoudl see en \"(.*?)\" message$")
    public void i_shoudl_see_en_message(String arg1) throws Throwable {
      
    	page.Addtobasket().AddItemToBasket(arg1);
    	
    }

    
}