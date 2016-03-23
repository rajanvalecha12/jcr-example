package com.training.apps;

import javax.jcr.Credentials;
import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.Value;

import org.apache.jackrabbit.core.TransientRepository;

public class SecondHop {

	public static void main(String[] args) {
		Repository repo=new TransientRepository();
		Credentials crd=new SimpleCredentials("admin", "admin".toCharArray());
		Session session=null;
		try {
			session = repo.login(crd);
			Node rootNode =session.getRootNode();
			Node node1=rootNode.addNode("Chapter1");
			Node node2=rootNode.addNode("Chapter2");
			
			node1.setProperty("What is java", "Java OOP Lang");
			node2.setProperty("What is an object", "Instance of a class");
			session.save();
			
			Node foundNode=rootNode.getNode("Chapter1");
			System.out.println("Path"+foundNode.getPath());
			System.out.println(foundNode.toString());
			Value val=foundNode.getProperty("What is java").getValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
