package org.artemis.db.entities;

import org.artemis.core.ForwardingAddressType;

import java.math.BigInteger;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Defines what's stored in the Database.
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "POINTERS", indexes = {
    //@Index(name = ACCT_REL_IDX, columnList = ACCOUNT_RELATIONSHIP)
})
public class PointerEntity {

    // TODO: Use an integer-based id here in addition to the pointer name.
    // TODO: cap the length of this identifier at some rational length (what's twitter's length?)
    @Id
    private String pointerId;

    // TODO: Need to store the SPSP Url as well as teh Payment pointer


    private ForwardingAddressType destinationType;

    // TODO: Cap this value at some length (at least 1024, but see XRPL addreses.).
    private String destinationAddress;

    private BigInteger balance;

    private String assetCode;

    private int assetScale;

    private BigInteger threshold;

    /**
     * To satisfy Hibernate.
     */
    private PointerEntity() {

    }

//    public PointerEntity(final Pointer pointer) {
//        this.pointerId = pointer.in();
//        this.destinationType = pointer.destinationType();
//        this.destinationAddress = pointer.destinationAddress();
//        this.balance = new BigDecimal(pointer.balance());
//        this.threshold = pointer.threshold();
//        this.assetCode = pointer.assetCode();
//        this.assetScale = pointer.assetScale();
//    }

    public String getPointerId() {
        return pointerId;
    }

    public void setPointerId(String pointerId) {
        this.pointerId = pointerId;
    }

    public ForwardingAddressType getDestinationType() {
        return destinationType;
    }

    public void setDestinationType(ForwardingAddressType destinationType) {
        this.destinationType = destinationType;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

//    public BigDecimal getBalance() {
//        return balance;
//    }
//
//    public void setBalance(BigDecimal balance) {
//        this.balance = balance;
//    }
//
//    public BigDecimal getThreshold() {
//        return threshold;
//    }
//
//    public void setThreshold(BigDecimal threshold) {
//        this.threshold = threshold;
//    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public int getAssetScale() {
        return assetScale;
    }

    public void setAssetScale(int assetScale) {
        this.assetScale = assetScale;
    }
}
