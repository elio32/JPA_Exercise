package org.example.model.entity;

import java.util.Date;
import java.util.List;

import org.example.model.enums.BoookingStatusEnum;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "allBookings", query = "SELECT e from Booking e"),
        @NamedQuery(name = "findByBookingDate",query = "SELECT e from Booking e where e.bookingDate = :bookingDate")
})
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private Long id;
    @Column(name = "booking_date",nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date bookingDate;
    @Column(name = "status",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BoookingStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "booking_flight",
            joinColumns = @JoinColumn(name = "booking_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id",referencedColumnName = "id")
    )
    private List<Flight> flights;

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BoookingStatusEnum getStatus() {
        return status;
    }

    public void setStatus(BoookingStatusEnum status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingDate=" + bookingDate +
                ", status=" + status +
                ", user=" + user +
                ", flights=" + flights +
                '}';
    }
}
