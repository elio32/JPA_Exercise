package org.example.model.dto;
import org.example.model.enums.BoookingStatusEnum;

import java.util.Date;

public class BookingDTO {
    private Long id;
    private Date bookingDate;
    private BoookingStatusEnum status;

    public BookingDTO() {
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

    @Override
    public String toString() {
        return "BookingTDO{" +
                "id=" + id +
                ", bookingDate=" + bookingDate +
                ", status=" + status +
                '}';
    }
}
