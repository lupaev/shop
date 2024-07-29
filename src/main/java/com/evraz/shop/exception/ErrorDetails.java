package com.evraz.shop.exception;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class ErrorDetails {

    private LocalDate timestamp;
    private String message;
    private String details;



    private ErrorDetails() {}

    public static class Builder {
        private LocalDate timestamp;
        private String message;
        private String details;

        public Builder() {}

        public Builder withTimestamp(LocalDate timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withDetails(String details) {
            this.details = details;
            return this;
        }

        public ErrorDetails build() {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.timestamp = this.timestamp;
            errorDetails.message = this.message;
            errorDetails.details = this.details;
            return errorDetails;
        }
    }
}
