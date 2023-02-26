package scripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.Baseclass;
import com.ObjectRepo.ImdbMovieDetailsPage;
import com.ObjectRepo.WikipediaMovieDetailsPage;

@Listeners(com.GenericUtilities.ListenerImplementation.class)

public class MovieDataComparisonTest extends Baseclass{

	@Test
	public void movieDataComparisonTest()
	{
		//Navigate to imdb portal
		try {
			String imdbUrl = fu.getPropertyKeyValue("imdburl");
			driver.get(imdbUrl);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		wb.waitForElementInDOM(driver);
		
		//Scroll to particular element in imdb
		ImdbMovieDetailsPage imdb = new ImdbMovieDetailsPage(driver);
		wb.ScrollToParticularElement(driver, imdb.getDate());
							
		//Fetch Data from imdb
		String imdbCountry = imdb.getCountry().getText();
		String imdbDate = imdb.getDate().getText();
		
		//Navigate to Wikipedia portal
		try {
			String wikiUrl = fu.getPropertyKeyValue("wurl");
			driver.get(wikiUrl);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		wb.waitForElementInDOM(driver);
		
		//Scroll to particular element in wikipedia
		WikipediaMovieDetailsPage wiki = new WikipediaMovieDetailsPage(driver);
		wb.ScrollToParticularElement(driver, wiki.getDate());
		
		
		//Fetch Data from wikipedia 
		String wikiCountry = wiki.getCountry().getText();
		String wikiDate = wiki.getDate().getText();
		
		//Validation
		Assert.assertEquals(imdbCountry, wikiCountry);
		Assert.assertEquals(imdbDate, wikiDate);
		
	}
}
