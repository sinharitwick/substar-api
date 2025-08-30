package org.project.common.utils;

import io.quarkus.elytron.security.common.BcryptUtil;

public class PasswordUtility {
    public static String hashPassword(String password) {
        return BcryptUtil.bcryptHash(password);
    }

    public static boolean checkPassword(String password, String hashed) {
        return BcryptUtil.matches(password, hashed);
    }
}
