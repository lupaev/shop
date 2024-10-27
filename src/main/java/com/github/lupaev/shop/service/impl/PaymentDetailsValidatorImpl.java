package com.github.lupaev.shop.service.impl;

import com.github.lupaev.shop.entity.PaymentDetails;
import com.github.lupaev.shop.exception.InvalidPaymentDetailsException;
import com.github.lupaev.shop.service.PaymentDetailsValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

        // Удаляем все пробелы и дефисы
        creditCardNumber = creditCardNumber.replaceAll("[\\s-]", "");

        // Проверяем, что номер состоит только из цифр
        if (!creditCardNumber.matches("\\d+")) {
            log.error("Credit card number must contain only digits: {}", creditCardNumber);
            throw new InvalidPaymentDetailsException("Credit card number must contain only digits");
        }

        // Проверяем длину номера карты
        if (creditCardNumber.length() < 13 || creditCardNumber.length() > 19) {
            log.error("Credit card number must be between 13 and 19 digits: {}", creditCardNumber);
            throw new InvalidPaymentDetailsException("Credit card number must be between 13 and 19 digits");
        }

        // Проверка по алгоритму Луна
        if (!isValidLuhn(creditCardNumber)) {
            log.error("Invalid credit card number: {}", creditCardNumber);
            throw new InvalidPaymentDetailsException("Invalid credit card number");
        }

        log.debug("Credit card number is valid");
    }

    private boolean isValidLuhn(String creditCardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = creditCardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(creditCardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return sum % 10 == 0;
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

    private void validateExpirationDate(LocalDate expirationDate) {
        log.debug("Validating expiration date: {}", expirationDate);

        if (expirationDate == null) {
            log.error("Expiration date is required");
            throw new InvalidPaymentDetailsException("Expiration date is required");
        }

        LocalDate currentDate = LocalDate.now();

        if (expirationDate.isBefore(currentDate)) {
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
