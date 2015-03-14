package org.codefx.lab.elvis;

import static org.codefx.lab.elvis.Elvis.*;
import java.util.Optional;

public class ElvisDemo {

	private String getStreetName_NPE(Order order) {
		// this can cause NullPointerExceptions if one of the getters returns null
		return order.getCustomer().getAddress().getStreetName();
	}

	private String getStreetName_LanguageLevelElvis(Order order) {
		// this doesn't work in Java... (yet?)
		return order?.getCustomer()?.getAddress()?.getStreetName();
	}

	private String getStreetName_If(Order order) {

		// this is a verbose way to deal with the problem;
		// probably the most common solution

		if (order == null)
			return null;

		Customer customer = order.getCustomer();
		if (customer == null)
			return null;

		Address address = customer.getAddress();
		if (address == null)
			return null;

		return address.getStreetName();
	}

	private String getStreetName_Ternary(Order order) {
		// a slightly less verbose but also less readable way to solve the problem
		Customer customer = order == null ? null : order.getCustomer();
		Address address = customer == null ? null : customer.getAddress();
		return address.getStreetName();
	}

	private String getStreetName_Optional(Order order) {
		// this solution uses Optional; I'd say it is the most intention revealing so far
		return Optional.ofNullable(order)
				.map(Order::getCustomer)
				.map(Customer::getAddress)
				.map(Address::getStreetName)
				.orElse(null);
	}

	private String getStreetName_LibraryElvis(Order order) {
		// using the null coalescing function application written in 'Elvis'
		return applyNullCoalescing(order, Order::getCustomer, Customer::getAddress, Address::getStreetName);
	}

	/*
	 * INNER CLASSES
	 */

	private static final class Order {

		private final Customer customer;

		public Order(Customer customer) {
			this.customer = customer;
		}

		public Customer getCustomer() {
			return customer;
		}

	}

	private static class Customer {

		private final Address address;

		public Customer(Address address) {
			this.address = address;
		}

		public Address getAddress() {
			return address;
		}

	}

	private static class Address {

		private final String streetName;

		public Address(String streetName) {
			this.streetName = streetName;
		}

		public String getStreetName() {
			return streetName;
		}

	}

}
