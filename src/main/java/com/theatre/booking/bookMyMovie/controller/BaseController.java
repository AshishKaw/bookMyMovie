package com.theatre.booking.bookMyMovie.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.boot.model.internal.CollectionSecondPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.theatre.booking.bookMyMovie.entity.Discounts;
import com.theatre.booking.bookMyMovie.entity.Partner;
import com.theatre.booking.bookMyMovie.entity.Shows;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import com.theatre.booking.bookMyMovie.dto.BookingRequest;
import com.theatre.booking.bookMyMovie.dto.FilterCriteria;
import com.theatre.booking.bookMyMovie.entity.Bookings;
import com.theatre.booking.bookMyMovie.entity.Customer;
import com.theatre.booking.bookMyMovie.entity.Screen;
import com.theatre.booking.bookMyMovie.entity.Theatre;
import com.theatre.booking.bookMyMovie.entity.Ticket;
import com.theatre.booking.bookMyMovie.entity.Seats;
import com.theatre.booking.bookMyMovie.repo.Booking_Repo;
import com.theatre.booking.bookMyMovie.repo.Customer_Repo;
import com.theatre.booking.bookMyMovie.repo.Discount_Repo;
import com.theatre.booking.bookMyMovie.repo.Partner_Repo;
import com.theatre.booking.bookMyMovie.repo.Screen_Repo;
import com.theatre.booking.bookMyMovie.repo.Seats_Repo;
import com.theatre.booking.bookMyMovie.repo.Show_Repo;
import com.theatre.booking.bookMyMovie.repo.Theatre_Repo;
import com.theatre.booking.bookMyMovie.repo.Ticket_Repo;
import com.theatre.booking.bookMyMovie.util.FilterSepcification;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/booking/api/v1")
public class BaseController {

	@Autowired
	private Partner_Repo partner_repo;

	@Autowired
	private Theatre_Repo theatre_repo;

	@Autowired
	private Screen_Repo screen_repo;

	@Autowired
	private Show_Repo show_repo;

	@Autowired
	private Seats_Repo seat_repo;

	@Autowired
	private Discount_Repo discount_repo;

	@Autowired
	private Customer_Repo customer_repo;

	@Autowired
	private Ticket_Repo ticket_repo;

	@Autowired
	private Booking_Repo booking_repo;

	private Object object;

	@PostConstruct
	void initData() {

		long partners = partner_repo.count();
		if (partners == 0) {
			Partner p = new Partner();
			p.setLast_name("Ashish");
			p.setLast_name("Kaw");
			p.setEmail("test");
			p.setIsActive("1");
			p.setPhone("97897");
			p.setUsername("us1");
			p.setPassword("DND");
			partner_repo.save(p);

			Theatre t = new Theatre();
			t.setBrand("I-MAX");
			t.setName("DLF I-MAX");
			t.setCreated_by("Ashish Kaw");
			t.setAddress("2nd Floor, DLF Mall of Noida");
			t.setCity("Noida");
			t.setLattitude(-39.1980);
			t.setLogitude(10.26008);
			t.setZipcode("206331");
			t.setCountry("India");
			t.setPartner(p);
			theatre_repo.save(t);

			Theatre t2 = new Theatre();
			t2.setBrand("PVR");
			t2.setName("Pacific PVR");
			t2.setCreated_by("Ashish Kaw");
			t2.setPartner(p);
			t2.setAddress("2nd Floor, Pacific Mall");
			t2.setCity("Delhi");
			t2.setLattitude(-38.66980);
			t2.setLogitude(10.22008);
			t2.setZipcode("111002");
			t2.setCountry("India");
			t2.setPartner(p);
			theatre_repo.save(t2);

			Theatre t3 = new Theatre();
			t3.setBrand("I-MAX");
			t3.setName("Crown I-MAX");
			t3.setCreated_by("Ashish Kaw");
			t3.setPartner(p);
			t3.setAddress("Crown Plaza, 2nd Floor Crown Interiorz Mall");
			t3.setCity("Faridabad");
			t3.setLattitude(-39.66980);
			t3.setLogitude(10.66008);
			t3.setZipcode("121002");
			t3.setCountry("India");
			t3.setPartner(p);
			theatre_repo.save(t3);

			Discounts discounts = new Discounts();
			discounts.setDescription("Afternoon Damaka");
			discounts.setDiscount(20);
			discounts.setDiscount_type("PERIOD");
			discounts.setPeriod("AFTERNOON");
			discounts.setUnit("PERCENT");
			discounts.setTheatre(t2);
			discount_repo.save(discounts);

			Discounts discounts1 = new Discounts();
			discounts1.setDescription("3rd Tickt Bonus");
			discounts1.setDiscount(50);
			discounts1.setUnit("PERCENT");
			discounts1.setDiscount_type("BONUS");
			discounts1.setTheatre(t);
			discount_repo.save(discounts1);

			Screen s = new Screen();
			s.setScreen_size("10 X 10");
			s.setName("AUDI-01");
			s.setScreen_type("2D");
			s.setTheatre(t);
			screen_repo.save(s);

			Screen s1 = new Screen();
			s1.setScreen_size("10 X 10");
			s1.setName("AUDI-01");
			s1.setScreen_type("2D");
			s1.setTheatre(t);
			screen_repo.save(s);
			screen_repo.save(s1);

			Shows show = new Shows();
			show.setDate(LocalDate.now());
			show.setStart_time(LocalTime.of(22, 55));
			show.setEnd_time(LocalTime.of(22, 55));
			show.setName("URI");
			show.setPrice(500);
			show.setShow_period("AFTERNOON");
			show.setRating(4.6);
			show.setGenres("Action");
			show.setScreen(s);
			show_repo.save(show);

			Shows show1 = new Shows();
			show1.setDate(LocalDate.of(2024, 6, 28));
			show1.setStart_time(LocalTime.of(22, 55));
			show1.setEnd_time(LocalTime.of(22, 55));
			show1.setName("PATHAN");
			show1.setPrice(500);
			show1.setShow_period("AFTERNOON");
			show1.setRating(4.6);
			show1.setGenres("Action");
			show1.setScreen(s);
			show_repo.save(show1);

			Seats seats = new Seats();
			seats.setAddon_price(100);
			seats.setSeat_number("B29");
			seats.setSeat_category("Classic");
			seats.setScreen(s);
			seat_repo.save(seats);

			Seats seats0 = new Seats();
			seats0.setAddon_price(100);
			seats0.setSeat_number("B29");
			seats0.setSeat_category("Classic");
			seats0.setScreen(s);
			seat_repo.save(seats0);

			Seats seats1 = new Seats();
			seats1.setAddon_price(100);
			seats1.setSeat_number("A29");
			seats1.setSeat_category("EXECUTIVE");
			seats1.setScreen(s1);
			seat_repo.save(seats1);

			Seats seats2 = new Seats();
			seats2.setAddon_price(0);
			seats2.setSeat_number("C29");
			seats2.setSeat_category("EXECUTIVE");
			seats2.setScreen(s);
			seat_repo.save(seats2);

			Customer customer = new Customer();
			customer.setFirst_name("X-First");
			customer.setLast_name("X-Last");
			customer.setEmail("testmyemail@email.com");
			customer.setPhone("+91-8888800999");
			customer.setUsername("x-user");
			customer_repo.save(customer);
			System.out.println("Initial Data Loaded");
		}
	}

	@GetMapping("/partners")
	@ResponseBody
	Iterable<Partner> getAllPartners() {

		return partner_repo.findAll();
	}

	@GetMapping("/theatres")
	@ResponseBody
	Iterable<Theatre> getAllTheatres() {

		return theatre_repo.findAll();
	}

	@GetMapping("/screens")
	@ResponseBody
	Iterable<Screen> getScreens() {

		return screen_repo.findAll();
	}

	@GetMapping("/customers")
	@ResponseBody
	Iterable<Customer> getCustomers() {

		return customer_repo.findAll();
	}

	@GetMapping("/search")
	@ResponseBody
	Iterable<Shows> findShows(@RequestBody FilterCriteria filtercriteria) {

		return show_repo.findAll(new FilterSepcification(filtercriteria));
	}

	@PostMapping("/bookTickect")
	@ResponseBody
	Bookings createBooking(@RequestBody BookingRequest bookingRequest) {

		AtomicInteger totalPrice = new AtomicInteger();
		Bookings booking = new Bookings();

		if (bookingRequest != null && bookingRequest.getTotal_tickets() == bookingRequest.getSeats().size()) {
			booking.setCustomer(bookingRequest.getCustomer());
			booking.setTotal_tickets(bookingRequest.getSeats().size());
			Set<Ticket> total_tickets = new HashSet<>();
			bookingRequest.getSeats().forEach(seat -> {
				Ticket ticket = new Ticket();
				ticket.setSeat(seat);
				ticket.setShow(bookingRequest.getShow());
				totalPrice.addAndGet(ticket.getPrice());
				ticket_repo.save(ticket);
				total_tickets.add(ticket);
			});
			booking.setTickets(total_tickets);
			// discount calculation
			Set<Discounts> discountlist = bookingRequest.getShow().getScreen().getTheatre().getDiscounts();
			if (discountlist.size() > 0) {
				List<Discounts> discountArraytList = new ArrayList<>();
				discountArraytList.addAll(discountlist);
				
				Discounts discount = discountArraytList.get(0);
				if (discount.getDiscount_type()!=null && discount.getDiscount_type().equals("PERIOD")
						&& bookingRequest.getShow().getShow_period().equalsIgnoreCase(discount.getPeriod())) {
					int discount_ammount = (discount.getDiscount() / 100) * totalPrice.get();
					booking.setTotal_price(totalPrice.get() - discount_ammount);
					booking.setTotal_discount(discount_ammount);
					booking.setDiscounts(discount);
				}else if (discount.getDiscount_type()!=null && discount.getDiscount_type().equals("BONUS") && bookingRequest.getSeats().size() > 2) {
					int discount_ammount = (discount.getDiscount() / 100) * totalPrice.get();
					booking.setTotal_price(totalPrice.get() - discount_ammount);
					booking.setTotal_discount(discount_ammount);
					booking.setDiscounts(discount);
				}else {
					booking.setTotal_price(totalPrice.get());
				}
			}

			booking.setPayment_mode(bookingRequest.getPayment_mode());
			/*
			 * Verify Payment With Gateway using FutureComple booking.setPayment_status() to
			 * success to be done by payment Gateway
			 */
			booking.setPayment_status("SUCCESS");
			booking.setBooking_status("Confirmed");
			booking_repo.save(booking);
			return booking;
		} else {
			throw new RuntimeException("Invalid Booking Request");
		}
	}
}
