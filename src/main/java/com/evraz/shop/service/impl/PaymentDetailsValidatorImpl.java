package com.evraz.shop.service.impl;

import com.evraz.shop.entity.PaymentDetails;
import com.evraz.shop.exception.InvalidPaymentDetailsException;
import com.evraz.shop.service.PaymentDetailsValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.CreditCardValidator;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentDetailsValidatorImpl implements PaymentDetailsValidator {

    @Override
    public void validate(PaymentDetails paymentDetails) {
        log.info("Starting validation for payment details");
        validateCreditCardNumber(paymentDetails.getCreditCardNumber());
        validateCVV(paymentDetails.getCvv());
        validateExpirationDate(paymentDetails.getExpirationDate());
        validateCardholderName(paymentDetails.getCardholderName());
        log.info("Validation completed successfully for payment details");
    }

    private void validateCreditCardNumber(String creditCardNumber) {
        log.debug("Validating credit card number: {}", creditCardNumber);
        if (creditCardNumber == null || creditCardNumber.isEmpty()) {
            log.error("Credit card number is required");
            throw new InvalidPaymentDetailsException("Credit card number is required");
        }

        CreditCardValidator creditCardValidator = new CreditCardValidator(
                CreditCardValidator.AMEX + CreditCardValidator.VISA + CreditCardValidator.MASTERCARD);
        if (!creditCardValidator.isValid(creditCardNumber)) {
            log.error("Invalid credit card number: {}", creditCardNumber);
            throw new InvalidPaymentDetailsException("Invalid credit card number");
        }
        log.debug("Credit card number is valid");
    }

    private void validateCVV(String cvv) {
        log.debug("Validating CVV: {}", cvv);
        if (cvv == null || cvv.isEmpty()) {
            log.error("CVV is required");
            throw new InvalidPaymentDetailsException("CVV is required");
        }

        if (!cvv.matches("\\d{3,4}")) {
            log.error("Invalid CVV: {}", cvv);
            throw new InvalidPaymentDetailsException("Invalid CVV");
        }
        log.debug("CVV is valid");
    }

    private void validateExpirationDate(String expirationDate) {
        log.debug("Validating expiration date: {}", expirationDate);
        if (expirationDate == null || expirationDate.isEmpty()) {
            log.error("Expiration date is required");
            throw new InvalidPaymentDetailsException("Expiration date is required");
        }

        if (!expirationDate.matches("(0[1-9]|1[0-2])/\\d{2}")) {
            log.error("Invalid expiration date format: {}", expirationDate);
            throw new InvalidPaymentDetailsException("Invalid expiration date format");
        }

        String[] parts = expirationDate.split("/");
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]) + 2000;

        java.time.YearMonth currentYearMonth = java.time.YearMonth.now();
        java.time.YearMonth cardYearMonth = java.time.YearMonth.of(year, month);

        if (cardYearMonth.isBefore(currentYearMonth)) {
            log.error("Credit card is expired: {}", expirationDate);
            throw new InvalidPaymentDetailsException("Credit card is expired");
        }
        log.debug("Expiration date is valid");
    }

    private void validateCardholderName(String cardholderName) {
        log.debug("Validating cardholder name: {}", cardholderName);
        if (cardholderName == null || cardholderName.isEmpty()) {
            log.error("Cardholder name is required");
            throw new InvalidPaymentDetailsException("Cardholder name is required");
        }

        if (!cardholderName.matches("^[a-zA-Z\\s]+$")) {
            log.error("Invalid cardholder name: {}", cardholderName);
            throw new InvalidPaymentDetailsException("Invalid cardholder name");
        }
        log.debug("Cardholder name is valid");
    }
}
