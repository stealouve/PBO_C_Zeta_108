package com.praktikum.main;

import com.praktikum.user.*;
import com.praktikum.data.*;

public class LoginSystem {
    public static User authenticateUser (String type, String id, String passwordOrNim) {
        for (User  user : DataStore.getUserList()) {
            if ("Admin".equalsIgnoreCase(type) && user instanceof Admin) {
                if (user.login(id, passwordOrNim)) {
                    return user;
                }
            } else if ("Mahasiswa".equalsIgnoreCase(type) && user instanceof Mahasiswa) {
                if (user.login(id, passwordOrNim)) {
                    return user;
                }
            }
        }
        return null;
    }
}
