package core.entities;

import core.entities.enums.*;
import core.thirdParty.aftership.enums.StatusTag;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class OmniTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(nullable = false)
    private long accountId;

    @NotNull
    @Column(nullable = false)
    private String apiKey;

    @NotNull
    @Column(nullable = false)
    private SourceEntity sourceEntity;

    private long sourceEntityId;

    @NotNull
    @Column(nullable = false)
    private String orderDate;

    @NotNull
    @Column(nullable = false)
    private boolean insured;

    @NotNull
    @Column(nullable = false)
    private BigDecimal insuranceCostUsd = BigDecimal.ZERO;

    @NotNull
    @Column(nullable = false)
    private BigDecimal suggestedInsurancePriceTerm = BigDecimal.ZERO;

    @NotNull
    @Column(nullable = false)
    private BigDecimal customerPaidInsurancePriceTerm = BigDecimal.ZERO;

    @NotNull
    @Column(nullable = false)
    private BigDecimal customerPaidInsurancePriceUsd = BigDecimal.ZERO;

    @NotNull
    @Column(nullable = false)
    private BigDecimal merchantInsuranceShareUsd = BigDecimal.ZERO;

    private BigDecimal partnerInsuranceShareUsd = BigDecimal.ZERO;

    private long partnerId;

    private BigDecimal routeInsuranceShareUsd = BigDecimal.ZERO;

    @NotNull
    @Column(nullable = false)
    private String suggestedInsuranceCurrency;

    @NotNull
    @Column(nullable = false)
    private BigDecimal exchangeRate = BigDecimal.ZERO;

    private MarkupType markupType;

    private int markupPercent;

    private float markupFixed;

    private String orderId;

    private OrderType orderType;

    @NotNull
    @Column(nullable = false)
    private int totalItems;

    @NotNull
    @Column(nullable = false)
    private BigDecimal orderBaseValueTerm = BigDecimal.ZERO;

    @NotNull
    @Column(nullable = false)
    private BigDecimal orderBaseTotalTerm = BigDecimal.ZERO;

    @NotNull
    @Column(nullable = false)
    private BigDecimal shippingTotalTerm = BigDecimal.ZERO;

    @NotNull
    @Column(nullable = false)
    private BigDecimal handlingTotalTerm = BigDecimal.ZERO;

    @NotNull
    @Column(nullable = false)
    private BigDecimal salesTaxTotalTerm = BigDecimal.ZERO;

    private String orderCurrencyCode;

    @NotNull
    @Column(nullable = false)
    private BigDecimal orderTotalInsuredValueTerm = BigDecimal.ZERO;

    @NotNull
    @Column(nullable = false)
    private BigDecimal orderTotalInsuredValueUsd = BigDecimal.ZERO;

    private PaymentType paymentType;

    private String paymentTypeOther;

    private String cardLastFour;

    private String cardExpireDate;

    @NotNull
    @Column(nullable = false)
    private String first;

    @NotNull
    @Column(nullable = false)
    private String last;

    @NotNull
    @Column(nullable = false)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String phone;

    private String billingAddressOne;

    private String billingAddressTwo;

    private String billingCity;

    private String billingProvince;

    private String billingPostalCode;

    private String billingCountry;

    private boolean billingSameAsShipping;

    @NotNull
    @Column(nullable = false)
    private String shippingAddressOne;

    private String shippingAddressTwo;

    @NotNull
    @Column(nullable = false)
    private String shippingCity;

    @NotNull
    @Column(nullable = false)
    private String shippingProvince;

    @NotNull
    @Column(nullable = false)
    private String shippingPostalCode;

    @NotNull
    @Column(nullable = false)
    private String shippingCountry;

    private long omniTrackingId;

    private String trackingNumber;

    private String shippingCarrierCode;

    private String shippingCarrierName;

    private StatusTag shippingStatusTag;

    private int totalOrderDays;

    private String shippingMethod;

    private String shippedDate;

    private String deliveredDate;

    private boolean shippingNotifications = false;

    private ShippingNotificationType shippingNotificationType = ShippingNotificationType.NONE;

    private String note;

    private String createdByIpAddress;

    private LocalDateTime createdByDateTime;

    private LocalDateTime paidDateTime;

    private TransactionState transactionState;

    public OmniTransaction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public SourceEntity getSourceEntity() {
        return sourceEntity;
    }

    public void setSourceEntity(SourceEntity sourceEntity) {
        this.sourceEntity = sourceEntity;
    }

    public long getSourceEntityId() {
        return sourceEntityId;
    }

    public void setSourceEntityId(long sourceEntityId) {
        this.sourceEntityId = sourceEntityId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public BigDecimal getInsuranceCostUsd() {
        return insuranceCostUsd;
    }

    public void setInsuranceCostUsd(BigDecimal insuranceCostUsd) {
        this.insuranceCostUsd = insuranceCostUsd;
    }

    public BigDecimal getSuggestedInsurancePriceTerm() {
        return suggestedInsurancePriceTerm;
    }

    public void setSuggestedInsurancePriceTerm(BigDecimal suggestedInsurancePriceTerm) {
        this.suggestedInsurancePriceTerm = suggestedInsurancePriceTerm;
    }

    public BigDecimal getCustomerPaidInsurancePriceTerm() {
        return customerPaidInsurancePriceTerm;
    }

    public void setCustomerPaidInsurancePriceTerm(BigDecimal customerPaidInsurancePriceTerm) {
        this.customerPaidInsurancePriceTerm = customerPaidInsurancePriceTerm;
    }

    public BigDecimal getCustomerPaidInsurancePriceUsd() {
        return customerPaidInsurancePriceUsd;
    }

    public void setCustomerPaidInsurancePriceUsd(BigDecimal customerPaidInsurancePriceUsd) {
        this.customerPaidInsurancePriceUsd = customerPaidInsurancePriceUsd;
    }

    public BigDecimal getMerchantInsuranceShareUsd() {
        return merchantInsuranceShareUsd;
    }

    public void setMerchantInsuranceShareUsd(BigDecimal merchantInsuranceShareUsd) {
        this.merchantInsuranceShareUsd = merchantInsuranceShareUsd;
    }

    public BigDecimal getPartnerInsuranceShareUsd() {
        return partnerInsuranceShareUsd;
    }

    public void setPartnerInsuranceShareUsd(BigDecimal partnerInsuranceShareUsd) {
        this.partnerInsuranceShareUsd = partnerInsuranceShareUsd;
    }

    public long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(long partnerId) {
        this.partnerId = partnerId;
    }

    public BigDecimal getRouteInsuranceShareUsd() {
        return routeInsuranceShareUsd;
    }

    public void setRouteInsuranceShareUsd(BigDecimal routeInsuranceShareUsd) {
        this.routeInsuranceShareUsd = routeInsuranceShareUsd;
    }

    public String getSuggestedInsuranceCurrency() {
        return suggestedInsuranceCurrency;
    }

    public void setSuggestedInsuranceCurrency(String suggestedInsuranceCurrency) {
        this.suggestedInsuranceCurrency = suggestedInsuranceCurrency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public MarkupType getMarkupType() {
        return markupType;
    }

    public void setMarkupType(MarkupType markupType) {
        this.markupType = markupType;
    }

    public int getMarkupPercent() {
        return markupPercent;
    }

    public void setMarkupPercent(int markupPercent) {
        this.markupPercent = markupPercent;
    }

    public float getMarkupFixed() {
        return markupFixed;
    }

    public void setMarkupFixed(float markupFixed) {
        this.markupFixed = markupFixed;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public BigDecimal getOrderBaseValueTerm() {
        return orderBaseValueTerm;
    }

    public void setOrderBaseValueTerm(BigDecimal orderBaseValueTerm) {
        this.orderBaseValueTerm = orderBaseValueTerm;
    }

    public BigDecimal getOrderBaseTotalTerm() {
        return orderBaseTotalTerm;
    }

    public void setOrderBaseTotalTerm(BigDecimal orderBaseTotalTerm) {
        this.orderBaseTotalTerm = orderBaseTotalTerm;
    }

    public BigDecimal getShippingTotalTerm() {
        return shippingTotalTerm;
    }

    public void setShippingTotalTerm(BigDecimal shippingTotalTerm) {
        this.shippingTotalTerm = shippingTotalTerm;
    }

    public BigDecimal getHandlingTotalTerm() {
        return handlingTotalTerm;
    }

    public void setHandlingTotalTerm(BigDecimal handlingTotalTerm) {
        this.handlingTotalTerm = handlingTotalTerm;
    }

    public BigDecimal getSalesTaxTotalTerm() {
        return salesTaxTotalTerm;
    }

    public void setSalesTaxTotalTerm(BigDecimal salesTaxTotalTerm) {
        this.salesTaxTotalTerm = salesTaxTotalTerm;
    }

    public String getOrderCurrencyCode() {
        return orderCurrencyCode;
    }

    public void setOrderCurrencyCode(String orderCurrencyCode) {
        this.orderCurrencyCode = orderCurrencyCode;
    }

    public BigDecimal getOrderTotalInsuredValueTerm() {
        return orderTotalInsuredValueTerm;
    }

    public void setOrderTotalInsuredValueTerm(BigDecimal orderTotalInsuredValueTerm) {
        this.orderTotalInsuredValueTerm = orderTotalInsuredValueTerm;
    }

    public BigDecimal getOrderTotalInsuredValueUsd() {
        return orderTotalInsuredValueUsd;
    }

    public void setOrderTotalInsuredValueUsd(BigDecimal orderTotalInsuredValueUsd) {
        this.orderTotalInsuredValueUsd = orderTotalInsuredValueUsd;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentTypeOther() {
        return paymentTypeOther;
    }

    public void setPaymentTypeOther(String paymentTypeOther) {
        this.paymentTypeOther = paymentTypeOther;
    }

    public String getCardLastFour() {
        return cardLastFour;
    }

    public void setCardLastFour(String cardLastFour) {
        this.cardLastFour = cardLastFour;
    }

    public String getCardExpireDate() {
        return cardExpireDate;
    }

    public void setCardExpireDate(String cardExpireDate) {
        this.cardExpireDate = cardExpireDate;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBillingAddressOne() {
        return billingAddressOne;
    }

    public void setBillingAddressOne(String billingAddressOne) {
        this.billingAddressOne = billingAddressOne;
    }

    public String getBillingAddressTwo() {
        return billingAddressTwo;
    }

    public void setBillingAddressTwo(String billingAddressTwo) {
        this.billingAddressTwo = billingAddressTwo;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingProvince() {
        return billingProvince;
    }

    public void setBillingProvince(String billingProvince) {
        this.billingProvince = billingProvince;
    }

    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    public void setBillingPostalCode(String billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public boolean isBillingSameAsShipping() {
        return billingSameAsShipping;
    }

    public void setBillingSameAsShipping(boolean billingSameAsShipping) {
        this.billingSameAsShipping = billingSameAsShipping;
    }

    public String getShippingAddressOne() {
        return shippingAddressOne;
    }

    public void setShippingAddressOne(String shippingAddressOne) {
        this.shippingAddressOne = shippingAddressOne;
    }

    public String getShippingAddressTwo() {
        return shippingAddressTwo;
    }

    public void setShippingAddressTwo(String shippingAddressTwo) {
        this.shippingAddressTwo = shippingAddressTwo;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingProvince() {
        return shippingProvince;
    }

    public void setShippingProvince(String shippingProvince) {
        this.shippingProvince = shippingProvince;
    }

    public String getShippingPostalCode() {
        return shippingPostalCode;
    }

    public void setShippingPostalCode(String shippingPostalCode) {
        this.shippingPostalCode = shippingPostalCode;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public long getOmniTrackingId() {
        return omniTrackingId;
    }

    public void setOmniTrackingId(long omniTrackingId) {
        this.omniTrackingId = omniTrackingId;
    }

    public String getShippingCarrierCode() {
        return shippingCarrierCode;
    }

    public void setShippingCarrierCode(String shippingCarrierCode) {
        this.shippingCarrierCode = shippingCarrierCode;
    }

    public String getShippingCarrierName() {
        return shippingCarrierName;
    }

    public void setShippingCarrierName(String shippingCarrierName) {
        this.shippingCarrierName = shippingCarrierName;
    }

    public StatusTag getShippingStatusTag() {
        return shippingStatusTag;
    }

    public void setShippingStatusTag(StatusTag shippingStatusTag) {
        this.shippingStatusTag = shippingStatusTag;
    }

    public int getTotalOrderDays() {
        return totalOrderDays;
    }

    public void setTotalOrderDays(int totalOrderDays) {
        this.totalOrderDays = totalOrderDays;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(String deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public boolean isShippingNotifications() {
        return shippingNotifications;
    }

    public void setShippingNotifications(boolean shippingNotifications) {
        this.shippingNotifications = shippingNotifications;
    }

    public ShippingNotificationType getShippingNotificationType() {
        return shippingNotificationType;
    }

    public void setShippingNotificationType(ShippingNotificationType shippingNotificationType) {
        this.shippingNotificationType = shippingNotificationType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreatedByIpAddress() {
        return createdByIpAddress;
    }

    public void setCreatedByIpAddress(String createdByIpAddress) {
        this.createdByIpAddress = createdByIpAddress;
    }

    public LocalDateTime getCreatedByDateTime() {
        return createdByDateTime;
    }

    public void setCreatedByDateTime(LocalDateTime createdByDateTime) {
        this.createdByDateTime = createdByDateTime;
    }

    public LocalDateTime getPaidDateTime() {
        return paidDateTime;
    }

    public void setPaidDateTime(LocalDateTime paidDateTime) {
        this.paidDateTime = paidDateTime;
    }

    public TransactionState getTransactionState() {
        return transactionState;
    }

    public void setTransactionState(TransactionState transactionState) {
        this.transactionState = transactionState;
    }
}
