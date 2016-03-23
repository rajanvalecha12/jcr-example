package com.training.apps;

import javax.jcr.Credentials;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.core.TransientRepository;

public class FirstHop {

	public static void main(String[] args) {
		Repository repo=new TransientRepository();
		Credentials crd=new SimpleCredentials("admin", "admin".toCharArray());
		Session session=null;
		try {
			session = repo.login(crd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Session created "+session);
		System.out.println("user Id: "+session.getUserID());
		String repName=repo.getDescriptor(Repository.REP_NAME_DESC);
		String repVendor=repo.getDescriptor(Repository.REP_VENDOR_DESC);
		System.out.println("Repo Name:="+repName);
		System.out.println("Repo Name:="+repVendor);
		
	}
}
