package com.company.service;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * Class {@code = Login} is sub page for LoginForm.
 *
 * @author V.Mankivskiy
 * @see org.apache.wicket.markup.html.WebPage
 * @since 1.0.1
 */
public class Login extends WebPage {

    private static final long serialVersionUID = 1L;

    public Login(final PageParameters parameters) {
        add(new Label("message", "service World, LOGIN"));
    }

    public Login() {
        this(new PageParameters());
        add(new LoginForm("loginForm"));
    }
}
