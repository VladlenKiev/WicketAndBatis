package com.company;

import com.company.service.Login;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

class LoginApp extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return Login.class; //return default page
	}



}
