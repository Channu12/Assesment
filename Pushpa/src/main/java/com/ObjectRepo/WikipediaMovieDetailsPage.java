package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.Baseclass;

public class WikipediaMovieDetailsPage extends Baseclass {
	
	public WikipediaMovieDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='Release date']/../following-sibling::td[@class='infobox-data']/div/ul/li")
	private WebElement date;
	
	@FindBy(xpath = "//th[text()='Country']/following-sibling::td")
	private WebElement country;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getCountry() {
		return country;
	}
}
