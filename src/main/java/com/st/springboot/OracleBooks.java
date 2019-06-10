package com.st.springboot;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope(scopeName="prototype")
public class OracleBooks implements Books  {

	public OracleBooks() {
		System.out.println("OracleBooks created!");
	}
	@Override
	public List<String> getBooks() {
		return null;
	}
	

}
