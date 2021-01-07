package org.iit.healthcare.mmp.tests;

import org.iit.healthcare.mmp.baseclass.TestBaseClass;
import org.iit.healthcare.mmp.pages.LoginPage;
import org.iit.healthcare.mmp.pages.RegistrationPage;
import org.iit.healthcare.mmp.pages.SearchSymptomPage;
import org.testng.annotations.Test;

public class SymptomValidation extends TestBaseClass {
	@Test(description="010 Search Symptoms" ,priority=0)
	public void searchSymptomvalidation() throws InterruptedException 
	{
		String uname="ria1";
		String pword="Ria12345";
		String symtext="xyz";
		
		launchApplication("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		RegistrationPage rp= new RegistrationPage(driver);
		rp.patienLoginButton();
		Thread.sleep(4000);
		rp.ploginButton();
		LoginPage lp= new LoginPage(driver);
		lp.login(uname, pword);
		
		SearchSymptomPage sp= new SearchSymptomPage(driver);
		sp.searchSymptomClick();
		Thread.sleep(4000);
		
		sp.symptomTextBox(symtext);
		sp.searchButton();
		sp.searchedData();
		



	}

}
