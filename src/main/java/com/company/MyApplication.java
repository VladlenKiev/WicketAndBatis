package com.company;

import com.company.service.Login;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import com.company.service.Hello;

/**
 * Class {@code MyApplication} is entered point for App.
 *
 * @author V.Mankivskiy
 * @see com.company.MyApplication
 * @since 1.0.1
 */

public class MyApplication extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        /*
		* return default page
		 */
        return Hello.class;
    }

    @Override
    protected void init() {
        mountBookmarkablePage("login", Login.class);
    }

}
