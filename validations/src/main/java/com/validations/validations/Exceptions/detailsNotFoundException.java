package com.validations.validations.Exceptions;

public class detailsNotFoundException extends RuntimeException {
    private String field;
    private String field2;
    private Object last;

    public detailsNotFoundException(String field, String field2, Object last) {
        super(String.format("%s not found with %s : %s", field, field2, last));
        this.field = field;
        this.field2 = field2;
        this.last = last;
    }

    public detailsNotFoundException(String field, String field2) {
        super(String.format("%s not found %s", field, field2));
        this.field = field;
        this.field2 = field2;
    }
}
