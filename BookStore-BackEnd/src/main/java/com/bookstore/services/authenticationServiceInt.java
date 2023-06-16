package com.bookstore.services;

import com.bookstore.models.users;

public interface authenticationServiceInt {
    public users signInAndReturnJWT(users signInRequest);
}
