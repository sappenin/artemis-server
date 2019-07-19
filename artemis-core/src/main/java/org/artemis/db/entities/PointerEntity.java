package org.artemis.db.entities;

import org.artemis.DestinationAddressType;
import org.artemis.Pointer;

import java.math.BigDecimal;

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

    @Id
    private String pointerId;

    private DestinationAddressType destinationType;

    private String destinationAddress;

    private BigDecimal balance;

    private BigDecimal threshold;

    private String assetCode;

    private int assetScale;

    /**
     * To satisfy Hibernate.
     */
    private PointerEntity() {

    }

    public PointerEntity(final Pointer pointer) {
        this.pointerId = pointer.in();
        this.destinationType = pointer.destinationType();
        this.destinationAddress = pointer.destinationAddress();
        this.balance = BigDecimal.ZERO;
        this.threshold = new BigDecimal(pointer.threshold());
        this.assetCode = pointer.assetCode();
        this.assetScale = pointer.assetScale();
    }

    public String getPointerId() {
        return pointerId;
    }

    public void setPointerId(String pointerId) {
        this.pointerId = pointerId;
    }

    public DestinationAddressType getDestinationType() {
        return destinationType;
    }

    public void setDestinationType(DestinationAddressType destinationType) {
        this.destinationType = destinationType;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getThreshold() {
        return threshold;
    }

    public void setThreshold(BigDecimal threshold) {
        this.threshold = threshold;
    }

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
