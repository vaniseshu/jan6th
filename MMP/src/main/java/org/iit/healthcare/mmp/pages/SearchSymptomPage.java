package org.iit.healthcare.mmp.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchSymptomPage {
	WebDriver driver;
	@FindBy(xpath="//span[contains(text(),'  Search Symptoms ')]") private WebElement searchSymptomClick;
	@FindBy(id="search") private WebElement symptomTextBox;
	@FindBy(name="submit") private WebElement searchButton;
	@FindBy(xpath="//table[@class='table']//tr//th[text()='Symptoms']") private WebElement  symptomData;
	@FindBy(xpath="//table[@class='table']//tr//th[text()=' Diagnosis ']") private WebElement  diagnosisData; 
	@FindBy(xpath="//th[contains(text(),'Solutions')]") private WebElement  solutionData; 

	public SearchSymptomPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void searchSymptomClick()
	{
		searchSymptomClick.click();
	}


	public void symptomTextBox( String symtext)
	{
		symptomTextBox.sendKeys(symtext);

	}

	public void searchButton()
	{
		searchButton.click();
	}

	public void searchedData()
	{
		try
		{
			String symptomData= driver.findElement(By.xpath("//table[@class='table']//tbody/tr//td[1]")).getText();
			String diagnosisdata=driver.findElement(By.xpath("//table[@class='table']//tbody/tr//td[2]")).getText();
			String  solutiondata=driver.findElement(By.xpath("//table[@class='table']//tbody/tr//td[3]")).getText();
			HashMap<String,String> s = new HashMap<String,String>();
			s.put("Symptoms",symptomData);
			s.put("Diagnosis", diagnosisdata);
			s.put("solution", solutiondata);
			//		System.out.println(s);
			if(s.containsValue(symptomData) && (s.containsValue(diagnosisdata)))
			{
				System.out.println("printing the fetched data from table" +s);
			}
		} catch(Exception e)
		{
			System.out.println("no data found with this symptom");
		}
	}
}

/*String sym=symptomData.getText();
	//System.out.println(sym);
	String dia =diagnosisData.getText();
	//System.out.println(dia);
	String solu=solutionData.toString();
	//System.out.println(solu);
	if(s == null)
	{System.out.println(s);}
	else
	{System.out.println("symptoms..search make to try new things...");}*/


