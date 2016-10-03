package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {
	//�̱��� : ��ü�� �ϳ��� ����
	private Map<String, Customer> customers;

	private static final CustomerService instance = new CustomerService();
	//final �ѹ� �ʱ�ȭ ���ѳ����� ���� �Ұ�
	// instance ������ CustomerService ��ü�� ���� �ּҰ��� ����
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
