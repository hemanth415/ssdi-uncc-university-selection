package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.controller.LoginContoller;

public class LoginContollerTest extends Mockito{
	LoginContoller loginContoller;

	@Before
	public void setUp() throws Exception {
		loginContoller = new LoginContoller();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() {
		HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        //request.getSession(false);
        when(request.getParameter("userName")).thenReturn("siva123@gmail.com");
        when(request.getParameter("userPassword")).thenReturn("123");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("welcome.jsp")).thenReturn(requestDispatcher);
        try {
        	loginContoller.doPost(request, response);
			verify(requestDispatcher).forward(request,response);
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
        
        verify(request, atLeast(1)).getParameter("userName");
	}

}
