package com.example;

import java.io.Serializable;
import java.util.ArrayList;

public class PersonList implements Serializable {
	
	private ArrayList<Person> list = new ArrayList<Person>();
	
	public void addPerson(Person p) {
		if (p != null) list.add(p);
	}
	
	public void removePerson(Person p) {
		if (p != null) list.remove(p);
	}

	public ArrayList<Person> getPersonList() {
		return list;
	}

	public void setPersonList(ArrayList<Person> list) {
		this.list = list;
	}
	
	
}
