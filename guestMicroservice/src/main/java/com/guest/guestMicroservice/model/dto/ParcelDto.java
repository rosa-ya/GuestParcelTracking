package com.guest.guestMicroservice.model.dto;

/**
 * @author Rose
 */

public class ParcelDto {

    private long guestId;
    private String parcelCode;
    private boolean delivered;

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public String getParcelCode() {
        return parcelCode;
    }

    public void setParcelCode(String parcelCode) {
        this.parcelCode = parcelCode;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
