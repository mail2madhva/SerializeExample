package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

public class MainClass {
	
	public static void main(String args[]) {
		
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();
		
		person1.setAge(10);
		person1.setName("Test");
		person1.setEmail("test@test.com");
		
		person2.setAge(12);
		person2.setName("Test2");
		person2.setEmail("test2@test.com");
		
		
		person3.setAge(13);
		person3.setName("Test3");
		person3.setEmail("test3@test.com");
		
		PersonList list = new PersonList();
		
		list.addPerson(person1);
		list.addPerson(person2);
		list.addPerson(person3);
		
		String filename = "data.bin";
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
			os.writeObject(list);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Done writing");
		
		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
			PersonList listRead = (PersonList) is.readObject();
			
			Iterator<Person> it = listRead.getPersonList().iterator();
			
			Person readPerson = null;
			while(it.hasNext()) {
				readPerson = it.next();
				
				System.out.println("Person  name = " + readPerson.getName() + " age = " + readPerson.getAge() 
						
						+ " email = " + readPerson.getEmail());
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
