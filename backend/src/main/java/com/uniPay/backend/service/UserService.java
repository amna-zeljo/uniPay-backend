package com.uniPay.backend.service;

import com.uniPay.backend.model.MockUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private final List<MockUser> dummyUsers =new ArrayList<>(Arrays.asList(
        new MockUser("1921","zeljoleale@gmail.com","zeljo"),
        new MockUser("1987","manijaci@gmail.com","manijak")
    )
    );

    public MockUser getUser(String id) {
        for (MockUser user : dummyUsers) {
            if (user.getId().equals(id)) {
                return this.mapUser(user);
            }
        }
        return null;
    }


    public MockUser addUser(MockUser mockUser) {
        for (MockUser user : dummyUsers) {
            if (user.getId().equals(mockUser.getId())) {
                return null;
            }
        }

        this.dummyUsers.add(mockUser);
        return this.mapUser(mockUser);
    }

    private MockUser mapUser(MockUser mockUser) {
        return new MockUser(mockUser.getId(),mockUser.getEmail(), null);

    }
}
