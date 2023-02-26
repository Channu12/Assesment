package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImdbMovieDetailsPage {
	
	public ImdbMovieDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[text()='Release date']/following-sibling::div[@class='ipc-metadata-list-item__content-container']")
	private WebElement date ;

	@FindBy(xpath="//button[text()='Country of origin']/following-sibling::div[@class='ipc-metadata-list-item__content-container']")
	private WebElement country;

	public WebElement getDate() {
		return date;
	}

	public WebElement getCountry() {
		return country;
	}
}



