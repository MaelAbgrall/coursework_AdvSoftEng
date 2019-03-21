package tests;

import java.util.Queue;

import controllers.*;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import models.*;

public class StepDef {
	Controller cont ;
	
	
	
	@Given("^a user run the application$")
	public void a_user_run_the_application() throws Throwable {
		cont = new Controller();
		cont.load("/home/msc/aaa50/Desktop/coursework_AdvSoftEng/CoffeShop/Data/menu.csv", "/home/msc/aaa50/Desktop/coursework_AdvSoftEng/CoffeShop/Data/order1.csv");
	   
	}

	@Then("^all completed order need to be printed$")
	public void all_completed_order_need_to_be_printed() throws Throwable {
		Queue<Order> completed = cont.getCompleted();
		System.out.println("The completed order IDs as following:");
		for (Order ord : completed){
			System.out.println(ord.getId());
					}
		
	  
	}

	@Then("^all pending order need to be printed$")
	public void all_pending_order_need_to_be_printed() throws Throwable {
		Queue<Order> pending = cont.getPending();
		System.out.println("The pending order IDs as following:");
		for (Order ord : pending){
			System.out.println(ord.getId());
					}
	}

	@Then("^all waiting order need to be printed$")
	public void all_waiting_order_need_to_be_printed() throws Throwable {
		Queue<Order> waiting = cont.getCompleted();
		System.out.println("The Waiting order IDs as following:");
		for (Order ord : waiting){
			System.out.println(ord.getId());
					}
	}
	
	
	
	
}
