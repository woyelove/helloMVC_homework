package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {
	//싱글톤 : 객체가 하나만 존재
	private Map<String, Customer> customers;

	private static final CustomerService instance = new CustomerService();
	//final 한번 초기화 시켜놓으면 변경 불가
	// instance 변수는 CustomerService 객체에 대한 주소값을 가짐
	private CustomerService(){
		customers = new HashMap<String, Customer>();
	}
	
	public static CustomerService getInstance(){
		return instance;
	}
	
	
	public void addCustomer(Customer customer){
		customers.put(customer.getId(), customer);
	}
	
	public Customer findCustomer(String id){
		if(id != null)
			return(customers.get(id.toLowerCase()));
		else
			return null;
	}
	
	public Customer login(String id, String password){
		if(customers.get(id.toLowerCase()).getPassword().equals(password))
			return customers.get(id);
		else
			return null;
	}

}
