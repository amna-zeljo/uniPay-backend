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

    public List<MockUser> getUsers() {
        return dummyUsers.stream()
                .map(this::mapUser).toList();
    }

    public MockUser getUser(String id) {
        for (MockUser user : dummyUsers) {
            if (user.getId().equals(id)) {
                return this.mapUser(user);
            }
        }
        return null;
    }

    public Boolean deleteUser(String id) {
        for (int i = 0; i < dummyUsers.size(); i++) {
            if (dummyUsers.get(i).getId().equals(id)) {
                dummyUsers.remove(dummyUsers.get(i));
                return true;
            }
        }
        return false;
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

    public MockUser updateUser(MockUser mockUser,String id) {
        for (MockUser user : dummyUsers) {
            if (user.getId().equals(id)) {
                if(mockUser.getPassword()!=null){
                    user.setPassword(mockUser.getPassword());

                }

                return this.mapUser(user);
            }
        }
        return null;
    }

    private MockUser mapUser(MockUser mockUser) {
        return new MockUser(mockUser.getId(),mockUser.getEmail(), null);

    }
}
