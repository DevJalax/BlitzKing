package com.superapp.BlitzKing.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superapp.BlitzKing.Entity.Booking;
import com.superapp.BlitzKing.Repo.BookingRepository;

@Service
public class BookingService {
	
    private final BookingRepository bookingRepository;
    
    private final InventoryService inventoryService;
    
    private final PaymentService paymentService;

    @Autowired
    public BookingService(BookingRepository bookingRepository, InventoryService inventoryService, PaymentService paymentService) {
        this.bookingRepository = bookingRepository;
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
    }

    public Booking createBooking(BookingRequest bookingRequest) {
        // Lock inventory temporarily
        inventoryService.lockInventory(bookingRequest);

        // Process payment
        paymentService.processPayment(bookingRequest);

        // Create booking
        Booking booking = new Booking();
        booking.setStartDate(bookingRequest.getStartDate());
        booking.setEndDate(bookingRequest.getEndDate());
        booking.setCustomerName(bookingRequest.getCustomerName());
        booking.setCustomerEmail(bookingRequest.getCustomerEmail());
        booking.setTotalAmount(bookingRequest.getTotalAmount());
        booking.setStatus(BookingStatus.CONFIRMED);

        return bookingRepository.save(booking);
    }

    // Other service methods
}